package me.TraiUnity.Listener;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.TraiUnity.Main;
import me.TraiUnity.Commands.VanishCommand;
import me.TraiUnity.EffekteMenu.Settings1;
import me.TraiUnity.Inventare.ErweiterungenInventar;
import me.TraiUnity.Inventare.LocationsInventar;
import me.TraiUnity.Inventare.SchwierigkeitsInventar;
import me.TraiUnity.Inventare.ServereinstellungsInventar;
import me.TraiUnity.Inventare.SicherInventar;
import me.TraiUnity.Inventare.TeamInventar;
import me.TraiUnity.Inventare.TrollInventar;
import me.TraiUnity.MusikMenu.Settings2;

public class InventoryClickListener implements Listener{
	
	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onInvInteract(InventoryClickEvent e) {
			
		try {
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == null){
			e.setCancelled(true);
			return;
		}
		
		if(e.getCurrentItem() == null){
			e.setCancelled(true);
			return;
		}
		
		if(e.getClickedInventory() == p.getInventory() && !Main.edit.contains(p)){
			e.setCancelled(true);
		}
		
		if((e.getClick() == ClickType.NUMBER_KEY) && (!Main.edit.contains(p))){
			e.setCancelled(true);
		}
		
		if((e.getInventory().getTitle().equalsIgnoreCase("§aSpieler §8(§aOnline§8)")) 
				&& (e.getSlot() == e.getRawSlot())
				&& (e.getCurrentItem() != null)
				&& (e.getCurrentItem().hasItemMeta())){
			e.setCancelled(true);
			
			String name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
			Player player = Bukkit.getPlayerExact(name);
			
			if(player != null){
				if(!(VanishCommand.vanished.contains(p))){
					VanishCommand.Vanish(p);
				}
				p.teleport(player.getLocation());
				p.sendMessage(Main.commip + "§7Du hast dich zu " + player.getDisplayName() + " §7teleportiert!");
			}else{
				p.closeInventory();
				p.sendMessage(Main.commip + "§cEs ist ein Fehler aufgetreten!");
			}
		}
		
		if((e.getInventory().getTitle().equalsIgnoreCase("§cTeammitglieder §8(§aOnline§8)")) 
				&& (e.getSlot() == e.getRawSlot())
				&& (e.getCurrentItem() != null)
				&& (e.getCurrentItem().hasItemMeta())){
			e.setCancelled(true);
			
			String name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
			Player player = Bukkit.getPlayerExact(name);
			
			if(player != null){
				if(!(VanishCommand.vanished.contains(p))){
					VanishCommand.Vanish(p);
				}
				p.teleport(player.getLocation());
				p.sendMessage(Main.commip + "§7Du hast dich zu " + player.getDisplayName() + " §7teleportiert!");
			}else{
				p.closeInventory();
				p.sendMessage(Main.commip + "§cEs ist ein Fehler aufgetreten!");
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §fTroll-Menü §8● §7Seite§8: §a1")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a2")){
				TrollInventar.openTrollInv2(p);
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §fTroll-Menü §8● §7Seite§8: §a2")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a1")){
				TrollInventar.openTrollInv1(p);
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§4Einstellungen §8(§eFeuerwerk§8)")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")){
				Settings1.openInv1(p);
			}
		}
				
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §cTeamitglieder §8●")) {
			e.setCancelled(true);
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §eSpieler verstecken §8●")){
			e.setCancelled(true);
							
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aAlle Spieler anzeigen")) {
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!VanishCommand.vanished.contains(all)) {
						p.showPlayer(all);
					}
				}
				
				ItemStack I1 = new ItemStack(351, 1, (short)10);
				ItemMeta I1M = I1.getItemMeta();
				I1M.setDisplayName("§aAlle Spieler §8● §7Rechtsklick");
				I1.setItemMeta(I1M);
				
				p.closeInventory();
				p.getInventory().setItem(7, I1);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Nur VIPs anzeigen")) {
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(all);
				}
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!VanishCommand.vanished.contains(all)) {
						if(p.hasPermission("Rangsystem.Freund") || p.hasPermission("Rangsystem.Streamer") || p.hasPermission("Rangsystem.Youtuber")
								|| p.hasPermission("Rangsystem.Builder") || p.hasPermission("Rangsystem.ProbeSupporter") || p.hasPermission("Rangsystem.Supporter")
								|| p.hasPermission("Rangsystem.Moderator") || p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Content")
								|| p.hasPermission("Rangsystem.JrDeveloper") || p.hasPermission("Rangsystem.Developer") || p.hasPermission("Rangsystem.SrDeveloper")
								|| p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
							p.showPlayer(all);
						}
					}
				}
				
				ItemStack I1 = new ItemStack(351, 1, (short)5);
				ItemMeta I1M = I1.getItemMeta();
				I1M.setDisplayName("§5Nur VIPs §8● §7Rechtsklick");
				I1.setItemMeta(I1M);
				
				p.closeInventory();
				p.getInventory().setItem(7, I1);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cKeine Spieler anzeigen")) {
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(all);
				}
				
				ItemStack I1 = new ItemStack(351, 1, (short)8);
				ItemMeta I1M = I1.getItemMeta();
				I1M.setDisplayName("§cKeine Spieler §8● §7Rechtsklick");
				I1.setItemMeta(I1M);
				
				p.closeInventory();
				p.getInventory().setItem(7, I1);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
				
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §cTeleporter §8●")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aZum Spawn")) {
				World w1 = Bukkit.getWorld(Main.loc.getString("Spawn.World"));
				double x1 = Main.loc.getDouble("Spawn.X");
				double y1 = Main.loc.getDouble("Spawn.Y");
				double z1 = Main.loc.getDouble("Spawn.Z");
				float yaw1 = (float)Main.loc.getDouble("Spawn.Yaw");
				float pitch1 = (float)Main.loc.getDouble("Spawn.Pitch");
				Location spawn = new Location(w1, x1, y1, z1, yaw1, pitch1);
				
				p.teleport(spawn);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5YouTuber Bühne")){
				World w2 = Bukkit.getWorld(Main.yt.getString("YTB.World"));
				double x2 = Main.yt.getDouble("YTB.X");
				double y2 = Main.yt.getDouble("YTB.Y");
				double z2 = Main.yt.getDouble("YTB.Z");
				float yaw2 = (float)Main.yt.getDouble("YTB.Yaw");
				float pitch2 = (float)Main.yt.getDouble("YTB.Pitch");
				Location ytb = new Location(w2, x2, y2, z2, yaw2, pitch2);
				
				p.teleport(ytb);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9Screenboxen")) {
				World w3 = Bukkit.getWorld(Main.scb.getString("SB.World"));
				double x3 = Main.scb.getDouble("SB.X");
				double y3 = Main.scb.getDouble("SB.Y");
				double z3 = Main.scb.getDouble("SB.Z");
				float yaw3 = (float)Main.scb.getDouble("SB.Yaw");
				float pitch3 = (float)Main.scb.getDouble("SB.Pitch");
				Location sb = new Location(w3, x3, y3, z3, yaw3, pitch3);
				
				p.teleport(sb);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3Jump and Runs")) {
				World w4 = Bukkit.getWorld(Main.jnr.getString("JnRs.World"));
				double x4 = Main.jnr.getDouble("JnRs.X");
				double y4 = Main.jnr.getDouble("JnRs.Y");
				double z4 = Main.jnr.getDouble("JnRs.Z");
				float yaw4 = (float)Main.jnr.getDouble("JnRs.Yaw");
				float pitch4 = (float)Main.jnr.getDouble("JnRs.Pitch");
				Location jnrs = new Location(w4, x4, y4, z4, yaw4, pitch4);
				
				p.teleport(jnrs);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §ePremium§c+ §7und §5YouTuber")) {
				World w5 = Bukkit.getWorld(Main.pundyt.getString("PYT.World"));
				double x5 = Main.pundyt.getDouble("PYT.X");
				double y5 = Main.pundyt.getDouble("PYT.Y");
				double z5 = Main.pundyt.getDouble("PYT.Z");
				float yaw5 = (float)Main.pundyt.getDouble("PYT.Yaw");
				float pitch5 = (float)Main.pundyt.getDouble("PYT.Pitch");
				Location pyt = new Location(w5, x5, y5, z5, yaw5, pitch5);
				
				p.teleport(pyt);
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.closeInventory();
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §aErweiterungen §8●")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eServereinstellungen")) {
				ServereinstellungsInventar.openServEInv1(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eLocations setzen")) {
				LocationsInventar.openLocInv(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Schutzschild")) {
				
				ArrayList<String> Schild = new ArrayList<String>();
				Schild.add(0, "");
				Schild.add(1, "§7Mit diesem Item kannst");
				Schild.add(2, "§7du einen §5Schutz §7um dich bilden");
				
				ItemStack schutz = new ItemStack(Material.EYE_OF_ENDER, 1);
				ItemMeta schutzm = schutz.getItemMeta();
				schutzm.setDisplayName("§5Schutzschild §8● §cAus §8● §7Rechtsklick");
				schutzm.setLore(Schild);
				schutz.setItemMeta(schutzm);
				
				p.closeInventory();
				p.getInventory().setItem(8, schutz);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.sendMessage(Main.commip + "§7Du hast das §5Schutzschild §7erhalten. §8(§eSlot 9§8)");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §fTroll-Menü")) {
				
				ArrayList<String> Troll = new ArrayList<String>();
				Troll.add(0, "");
				Troll.add(1, "§7Mit diesem Item kannst");
				Troll.add(2, "§7du ein §fTroll-Inventar §7öffnen");
				
				ItemStack Trolli = new ItemStack(Material.COOKIE);
				ItemMeta TrolliM = Trolli.getItemMeta();
				TrolliM.setDisplayName("§fTroll-Menü §8● §7Rechtsklick");
				TrolliM.setLore(Troll);
				Trolli.setItemMeta(TrolliM);
				
				p.closeInventory();
				p.getInventory().setItem(8, Trolli);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.sendMessage(Main.commip + "§7Du hast das §fTroll-Menü §7erhalten. §8(§eSlot 9§8)");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eItem entfernen")) {
				
				p.closeInventory();
				p.getInventory().setItem(8, null);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.sendMessage(Main.commip + "§7Item auf §eSlot 9 §7wurde §centfernt§7.");
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§8● §eLocations setzen §8●")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aSpawn setzen")) {
				Main.loc.set("Spawn.World", p.getWorld().getName());
				Main.loc.set("Spawn.X", Double.valueOf(p.getLocation().getX()));
				Main.loc.set("Spawn.Y", Double.valueOf(p.getLocation().getY()));				
				Main.loc.set("Spawn.Z", Double.valueOf(p.getLocation().getZ()));
				Main.loc.set("Spawn.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.loc.set("Spawn.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.loc.save(Main.locs);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aYouTuber-Bühnen Spawn setzen")) {
				Main.yt.set("YTB.World", p.getWorld().getName());
				Main.yt.set("YTB.X", Double.valueOf(p.getLocation().getX()));
				Main.yt.set("YTB.Y", Double.valueOf(p.getLocation().getY()));				
				Main.yt.set("YTB.Z", Double.valueOf(p.getLocation().getZ()));
				Main.yt.set("YTB.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.yt.set("YTB.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.yt.save(Main.ytb);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aScreenbox-Spawn setzen")) {
				Main.scb.set("SB.World", p.getWorld().getName());
				Main.scb.set("SB.X", Double.valueOf(p.getLocation().getX()));
				Main.scb.set("SB.Y", Double.valueOf(p.getLocation().getY()));				
				Main.scb.set("SB.Z", Double.valueOf(p.getLocation().getZ()));
				Main.scb.set("SB.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.scb.set("SB.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.scb.save(Main.sb);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aJumpAndRun Spawn setzen")) {
				Main.jnr.set("JnRs.World", p.getWorld().getName());
				Main.jnr.set("JnRs.X", Double.valueOf(p.getLocation().getX()));
				Main.jnr.set("JnRs.Y", Double.valueOf(p.getLocation().getY()));				
				Main.jnr.set("JnRs.Z", Double.valueOf(p.getLocation().getZ()));
				Main.jnr.set("JnRs.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.jnr.set("JnRs.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.jnr.save(Main.jnrs);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aPremium+ und Youtuber Spawn setzen")) {
				Main.pundyt.set("PYT.World", p.getWorld().getName());
				Main.pundyt.set("PYT.X", Double.valueOf(p.getLocation().getX()));
				Main.pundyt.set("PYT.Y", Double.valueOf(p.getLocation().getY()));				
				Main.pundyt.set("PYT.Z", Double.valueOf(p.getLocation().getZ()));
				Main.pundyt.set("PYT.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.pundyt.set("PYT.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.pundyt.save(Main.pyt);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aVIP-Bereich Spawn setzen")) {
				Main.vip.set("VIP.World", p.getWorld().getName());
				Main.vip.set("VIP.X", Double.valueOf(p.getLocation().getX()));
				Main.vip.set("VIP.Y", Double.valueOf(p.getLocation().getY()));				
				Main.vip.set("VIP.Z", Double.valueOf(p.getLocation().getZ()));
				Main.vip.set("VIP.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.vip.set("VIP.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.vip.save(Main.vipb);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aBühnen Spawn setzen")) {
				Main.buen.set("Bühne.World", p.getWorld().getName());
				Main.buen.set("Bühne.X", Double.valueOf(p.getLocation().getX()));
				Main.buen.set("Bühne.Y", Double.valueOf(p.getLocation().getY()));				
				Main.buen.set("Bühne.Z", Double.valueOf(p.getLocation().getZ()));
				Main.buen.set("Bühne.Yaw", Double.valueOf(p.getLocation().getYaw()));
				Main.buen.set("Bühne.Pitch", Double.valueOf(p.getLocation().getPitch()));
				try{
					Main.buen.save(Main.bue);
				}catch (IOException ex){
					ex.printStackTrace();
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				p.closeInventory();
				LocationsInventar.openLocInv(p);
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§eServer §8● §7Seite§8: §a1")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a2")) {
				ServereinstellungsInventar.openServEInv2(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Whitelist §aAn")) {
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!all.hasPermission("Rangsystem.Administrator") && !all.hasPermission("Rangsystem.Owner")) {
						all.kickPlayer(Main.commip + "§cDie §fWhitelist §cder §5Traiunity §cwurde §aaktiviert§c.");
					}
				}
				p.closeInventory();
				Bukkit.setWhitelist(true);
				p.sendMessage(Main.commip + "§7Die §fWhitelist §7wurde §aaktiviert§7.");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Whitelist §cAus")) {
				p.closeInventory();
				Bukkit.setWhitelist(false);
				p.sendMessage(Main.commip + "§7Die §fWhitelist §7wurde §cdeaktiviert§7.");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Server stoppen")) {
				p.closeInventory();
				SicherInventar.openSicher1(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Server reloaden")) {
				p.closeInventory();
				SicherInventar.openSicher2(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Effekte")) {
				Settings1.openInv1(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eMusik")) {
				Settings2.openMusik1(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9Teamübersicht")) {
				TeamInventar.openTeamInv(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §4Schwierigkeit")) {
				SchwierigkeitsInventar.openSchwierigkeit(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}			
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§4Schwierigkeitsgrad")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aDifficulty 0")){
				for(World w : Bukkit.getWorlds()){
					w.setDifficulty(Difficulty.PEACEFUL);
				}
				p.closeInventory();
				p.sendMessage(Main.commip + "§7Schwierigkeit auf §aFriedlich §7gesetzt!");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eDifficulty 1")){
				for(World w : Bukkit.getWorlds()){
					w.setDifficulty(Difficulty.EASY);
				}
				p.closeInventory();
				p.sendMessage(Main.commip + "§7Schwierigkeit auf §eEinfach §7gesetzt!");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Difficulty 2")){
				for(World w : Bukkit.getWorlds()){
					w.setDifficulty(Difficulty.NORMAL);
				}
				p.closeInventory();
				p.sendMessage(Main.commip + "§7Schwierigkeit auf §6Normal §7gesetzt!");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §4Difficulty 3")){
				for(World w : Bukkit.getWorlds()){
					w.setDifficulty(Difficulty.HARD);
				}
				p.closeInventory();
				p.sendMessage(Main.commip + "§7Schwierigkeit auf §4Schwer §7gesetzt!");
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§eBist du dir sicher? §8| §a1")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aJa")) {
				
				p.closeInventory();
				p.sendMessage(Main.commip + "§7Server wird herruntergefahren...");
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e10 Sekunden§7.");
					}
				}, 40);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e9 Sekunden§7.");
					}
				}, 60);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e8 Sekunden§7.");
					}
				}, 80);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e7 Sekunden§7.");
					}
				}, 100);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e6 Sekunden§7.");
					}
				}, 120);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e5 Sekunden§7.");
					}
				}, 140);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e4 Sekunden§7.");
					}
				}, 160);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e3 Sekunden§7.");
					}
				}, 180);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e2 Sekunden§7.");
					}
				}, 200);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server stoppt in §e1ner Sekunde§7.");
						p.sendMessage(Main.commip + "§7Server wird nun herruntergefahren.");
					}
				}, 220);
								
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
					}
				}, 240);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				p.closeInventory();
				ServereinstellungsInventar.openServEInv1(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cNein")) {
				p.closeInventory();
				ServereinstellungsInventar.openServEInv1(p);
				p.playSound(p.getLocation(), Sound.NOTE_BASS, 1F, 1F);
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§eBist du dir sicher? §8| §a2")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aJa")) {
				
				p.closeInventory();
				p.sendMessage(Main.commip + "§7Server wird reloadet...");
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e10 Sekunden§7.");
					}
				}, 40);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e9 Sekunden§7.");
					}
				}, 60);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e8 Sekunden§7.");
					}
				}, 80);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e7 Sekunden§7.");
					}
				}, 100);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e6 Sekunden§7.");
					}
				}, 120);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e5 Sekunden§7.");
					}
				}, 140);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e4 Sekunden§7.");
					}
				}, 160);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e3 Sekunden§7.");
					}
				}, 180);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e2 Sekunden§7.");
					}
				}, 200);
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(Main.commip + "§7Der Server reloadet in §e1ner Sekunde§7.");
						p.sendMessage(Main.commip + "§7Server wird nun reloadet.");
					}
				}, 220);
										
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(Main.achtung + "§cDer Server wird aktuell reloaded...");
						Bukkit.broadcastMessage("");
						Bukkit.reload();
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(Main.achtung + "§aDer Server wurde erfolgreich reloaded.");
						Bukkit.broadcastMessage("");
						
						p.sendMessage(Main.commip + "§7Server wurde erfolgreich reloadet.");
						
						for(World worlds : Bukkit.getWorlds()) {
							for (Entity ent : worlds.getEntities()) {
								if (!(ent instanceof Player)) {
									if (!(ent instanceof ArmorStand)) {
										ent.remove();
									}
								}
							}
							worlds.setDifficulty(Difficulty.PEACEFUL);
						}
					}
				}, 240);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				p.closeInventory();
				ServereinstellungsInventar.openServEInv1(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cNein")) {
				p.closeInventory();
				ServereinstellungsInventar.openServEInv1(p);
				p.playSound(p.getLocation(), Sound.NOTE_BASS, 1F, 1F);
			}
		}
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§eServer §8● §7Seite§8: §a2")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a1")) {
				ServereinstellungsInventar.openServEInv1(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}		
		}
			
		if(e.getInventory().getTitle().equalsIgnoreCase("§9Teamübersicht §8● §eAuswahl")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aBuilder")) {
				TeamInventar.openTeamInv1(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cModeratoren")) {
				TeamInventar.openTeamInv3(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cSrModeratoren")) {
				TeamInventar.openTeamInv4(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §bDeveloper")) {
				TeamInventar.openTeamInv5(p);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §4Administratoren")) {
				TeamInventar.openTeamInv6(p);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§9Teamübersicht §8● §aBuilder")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				TeamInventar.openTeamInv(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§9Teamübersicht §8● §cMods")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				TeamInventar.openTeamInv(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§9Teamübersicht §8● §cSrMods")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				TeamInventar.openTeamInv(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§9Teamübersicht §8● §bDevs")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				TeamInventar.openTeamInv(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§9Teamübersicht §8● §4Admins")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				TeamInventar.openTeamInv(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§eServer §8● §7Seite§8: §a1")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				ErweiterungenInventar.OpenErweiterungen1(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§8● §eLocations setzen §8●")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")) {
				ErweiterungenInventar.OpenErweiterungen1(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
		
		}catch(Exception ex) {}
	}
}
