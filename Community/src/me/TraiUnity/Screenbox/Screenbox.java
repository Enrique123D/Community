package me.TraiUnity.Screenbox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitUtil;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

import me.TraiUnity.Hologramm;
import me.TraiUnity.ItemBuilder1;
import me.TraiUnity.Main;
import me.TraiUnity.Methoden;
import me.TraiUnity.Listener.Actionbar;

@SuppressWarnings("deprecation")
public class Screenbox {
	
	private Location paste;
	private Location innen;
	private Location außen;
	private Location holo;
	private int rotate = 0;
	private ArmorStand headstand;
	private Hologramm hologramm;
	
	private BukkitTask task;
	private boolean isTask = false;

	private int screentime = 10;
	private int besucherrestzeit = 0;
	private int wartezeit = 0;

	private ArrayList<Player> warteschlange = new ArrayList<>();
	private Player inbox = null;
	private Player besucher = null;
	
	public Screenbox(Location paste, Location innen, Location außen, Location holo, int rotate) {
		this.paste = paste;
		this.innen = innen;
		this.außen = außen;
		this.holo = holo;
		this.rotate = rotate;
		
		this.headstand = holo.getWorld().spawn(holo.add(0, 1.4, 0), ArmorStand.class);
		this.headstand.setGravity(false); 
		this.headstand.setVisible(false);
		this.headstand.setHelmet(ItemBuilder1.createItem(Material.BARRIER, 1, ""));
		
		holo.subtract(0, 1.4, 0);
		
		this.hologramm = new Hologramm(new String[]{
				"§7Aktuell ist diese §5Screenbox §7leer.",
				"§c",
				"§a",
				"§7Gesamte Wartezeit",
				"§c-§8/§c-"
		}, holo);
		
		for(Player all : Bukkit.getOnlinePlayers()){ 
			this.hologramm.showPlayer(all); 
		}
		updateTime();
		startSkullrotSched();
	}
	
	public void startSkullrotSched(){
		new BukkitRunnable() {
			@Override
			public void run() {
				if(inbox != null){
					headstand.teleport(new Location(headstand.getWorld(), headstand.getLocation().getX(),
				    headstand.getLocation().getY(), headstand.getLocation().getZ(), (float) (headstand.getLocation().getYaw()+5), 0));
				}else{
					headstand.teleport(new Location(headstand.getWorld(), headstand.getLocation().getX(),
					headstand.getLocation().getY(), headstand.getLocation().getZ(), rotate, 0));
				}
			}
		}.runTaskTimer(Main.plugin, 0, 2);
	}
	
	public void showHolo(Player p){
		this.hologramm.showPlayer(p);
	}
	
	public void setStandsNull(){
		headstand.remove();
		for(Player all : Bukkit.getOnlinePlayers()){ 
			this.hologramm.hidePlayer(all); 
		}
	}

	public Player getInbox() {
		return inbox;
	}
	
	public void removeInbox(boolean isLeft){
		Location loc = this.paste;
		int rot = this.rotate;
		
		LocalSession ls = Main.plugin.worldedit.getSession(Bukkit.getPlayerExact(inbox.getName()));
		LocalPlayer lp = (LocalPlayer) Main.plugin.worldedit.wrapPlayer(Bukkit.getPlayerExact(inbox.getName()));
		
		try {
			SchematicFormat sf = SchematicFormat.getFormat(new File("plugins/TraidioNET-Traiunity_V3/Screenbox/Boxen", "Standart.schematic"));
			CuboidClipboard cc = sf.load(new File("plugins/TraidioNET-Traiunity_V3/Screenbox/Boxen", "Standart.schematic"));
			cc.rotate2D(rot);
			cc.paste(ls.createEditSession(lp), BukkitUtil.toVector(loc), false);
		} catch (DataException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (MaxChangedBlocksException ex) {
			ex.printStackTrace();
		}
		
		for (World worlds : Bukkit.getWorlds()) {
			for (Entity ent : worlds.getEntities()) {
				if (!(ent instanceof Player)) {
					if (!(ent instanceof ArmorStand)) {
						ent.remove();
					}
				}
			}
		}
		
		for(Player schlange : this.warteschlange){
			Actionbar.sendActionBar(schlange, "§a" + inbox.getDisplayName() + " §chat die Box verlassen.");
		}
		this.warteschlange.clear();
		
		if(this.besucher != null){
			this.besucher.teleport(außen);
			Actionbar.sendActionBar(besucher, "§a" + inbox.getDisplayName() + " §chat die Box verlassen.");
			this.besucher = null;
		}
		
		if(!isLeft){
			inbox.teleport(außen);
			inbox.sendMessage(Main.screenb + "§7Du wurdest aus der §5Screenbox §7entfernt.");
			
			inbox.getInventory().clear();
			Methoden.setItems(inbox);
		}
		inbox = null;
		
		for(Player all : Bukkit.getOnlinePlayers()){ 
			this.hologramm.hidePlayer(all); 
		}
		
		this.hologramm = new Hologramm(new String[]{
				"§7Aktuell ist diese §5Screenbox §7leer.",
				"§c",
				"§a",
				"§7Gesamte Wartezeit",
				"§c-§8/§c-"
		}, holo);
		for(Player all : Bukkit.getOnlinePlayers()){ 
			this.hologramm.showPlayer(all); 
		}		
		this.headstand.setHelmet(ItemBuilder1.createItem(Material.BARRIER, 1, ""));			
	}

	public void removeArmorstand(){
		this.headstand.remove();
	}
	
	private void updateTime(){
		
	    new BukkitRunnable(){
		    	
	      public void run(){
	        if (inbox != null){
	          if (besucher != null) {
	            wartezeit -= 1;
	            besucherrestzeit -= 1;
	          }
	          if (wartezeit < 0) {
	        	  wartezeit = 0;
	          }
	          
	          int std = (int) ((wartezeit+besucherrestzeit) * 0.000278);
	          int min = (int) ((wartezeit+besucherrestzeit) * 0.02);
	          int sec = (wartezeit + besucherrestzeit) - (min * 60);
	          
		  		for(Player all : Bukkit.getOnlinePlayers()){
					hologramm.hidePlayer(all); 
				}
		  		
		  		hologramm = new Hologramm(new String[]{
						"§7Aktuell in der §5Screenbox",
						"§a" + inbox.getDisplayName(),
						"§a",
						"§7Gesamte Wartezeit",
						"§e" + std + " Stunde(n) §e" + min + " Minute(n) §e" + sec + " Sekunde(n)"
				}, holo);
		  				
		  		Actionbar.sendActionBar(inbox, "§9Warteschlange§8: §a" + warteschlange.size() + " Spieler §8┃ §e" + std + " Std. " + min + " Min. " + sec + " Sek.");
		  		
		  		for(Player all : Bukkit.getOnlinePlayers()){
					hologramm.showPlayer(all); 					
				}
		  		
		  		for(Player all : warteschlange){
		  			int ins = (warteschlange.indexOf(all) * screentime) + besucherrestzeit;
			          int h = (int) ((ins+besucherrestzeit) * 0.000278);
			          int m = (int) ((ins+besucherrestzeit) * 0.02);
			          int s = (ins+besucherrestzeit) - (min * 60);
			  		Actionbar.sendActionBar(all, "§9Warteschlange§8: §a" + warteschlange.size() + " Spieler §8┃ §e" + h + " Std. " + m + " Min. " + s + " Sek.");
		  		}
	        }
	      }
	    }.runTaskTimer(Main.plugin, 0L, 20L);
	}
	
	public void setInbox(Player inbox) {
		this.inbox = inbox;
		inbox.teleport(innen);
		
		for(Player all : Bukkit.getOnlinePlayers()){ 
			this.hologramm.hidePlayer(all); 
		}
		
		this.hologramm = new Hologramm(new String[]{
				"§7Aktuell in der §5Screenbox",
				"§a" + inbox.getDisplayName(),
				"§a",
				"§7Gesamte Wartezeit",
				"§e0 Stunde(n) 0 Minute(n) 0 Sekunde(n)"
		}, holo);
		
		for(Player all : Bukkit.getOnlinePlayers()){
			this.hologramm.showPlayer(all); 
		}
						
		ItemStack s = ItemBuilder1.createItemWithShort(Material.SKULL_ITEM, 1, "", 3);
		SkullMeta meta = (SkullMeta) s.getItemMeta();
		meta.setOwner(inbox.getName());
		s.setItemMeta(meta);
		this.headstand.setHelmet(s);			
		
		if(new File("plugins/TraidioNET-Traiunity_V3/Screenbox/Boxen", inbox.getName()+".schematic").exists()){
			Location loc = this.paste;
			int rot = this.rotate;
			
			LocalSession ls = Main.plugin.worldedit.getSession(Bukkit.getPlayerExact(inbox.getName()));
			LocalPlayer lp = (LocalPlayer) Main.plugin.worldedit.wrapPlayer(Bukkit.getPlayerExact(inbox.getName()));

			try {
				SchematicFormat sf = SchematicFormat.getFormat(new File("plugins/TraidioNET-Traiunity_V3/Screenbox/Boxen", inbox.getName()+".schematic"));
				CuboidClipboard cc = sf.load(new File("plugins/TraidioNET-Traiunity_V3/Screenbox/Boxen", inbox.getName()+".schematic"));
				cc.rotate2D(rot);
				cc.paste(ls.createEditSession(lp), BukkitUtil.toVector(loc), false);
			} catch (DataException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (MaxChangedBlocksException ex) {
				ex.printStackTrace();
			}
			
			for (World worlds : Bukkit.getWorlds()) {
				for (Entity ent : worlds.getEntities()) {
					if (!(ent instanceof Player)) {
						if (!(ent instanceof ArmorStand)) {
							ent.remove();
						}
					}
				}
			}
			
			inbox.sendMessage(Main.screenb + "§bDeine eigene Screenbox wird geladen...");
			inbox.sendMessage(Main.screenb + "§aDu bist jetzt in deiner Box!");
		}else{
			inbox.sendMessage(Main.screenb + "§bDu besitzt keine Screenbox!");
			inbox.sendMessage(Main.screenb + "§bEs wird die Standart-Box geladen...");
			inbox.sendMessage(Main.screenb + "§aDu wurdest in die Box teleportiert.");
		}
	}
	
	public boolean isInWarteschlange(Player p){
		return this.warteschlange.contains(p) ? true : false;
	}
	
	public void addToWarteschlange(Player p){
		if(besucher == null)
			checkSched();
		this.warteschlange.add(p);
		wartezeit += 10;
		checkSched();
	}
	
	public void addForcedToWarteschlange(Player p){
		if(besucher == null)
			checkSched();
		this.warteschlange.add(0, p);
		wartezeit += 10;
		checkSched();
	}
	
	public void removeFromWarteschlange(Player p){
		this.warteschlange.remove(p);
		wartezeit -= 10;
		checkSched();
	}
	
	private void startSched(){
		
		this.isTask = true;
		
		this.task = new BukkitRunnable() {
			@Override
			public void run() {
				if(besucher != null){
					besucher.teleport(außen);
					
					Methoden.setItems(besucher);
					
					besucher.sendMessage(Main.screenb + "§cDie §e10 Sekunden §csind vorbei!");
					besucher.sendMessage(Main.screenb + "§cDu wurdest aus der §5Box §cteleportiert.");
										
					besucher = null;
				}else{
					wartezeit -= 10;
				}
				
				if(warteschlange.size() != 0){
					besucherrestzeit += 10;
					besucher = warteschlange.get(0);
					warteschlange.remove(besucher);
					besucher.teleport(innen);
							
					Methoden.setScreenboxBesucherItems(besucher);
					
					besucher.sendMessage(Main.screenb + "§7Du bist nun in der §5Box §7mit §a" + inbox.getDisplayName() + "§7.");
					besucher.sendMessage(Main.screenb + "§7Du hast nun §e10 Sekunden§7.");
				}else{
					this.cancel();
				}
			}
		}.runTaskTimer(Main.plugin, 0, screentime * 20);
		
	}
	
	private void stopSched(){
		this.task.cancel();
		this.isTask = false;
	}
	
	private void checkSched(){
		if(this.warteschlange.size() == 0 && this.isTask){
			stopSched();
		}
		if(this.warteschlange.size() > 0 && !this.isTask){
			startSched();
		}
	}

}
