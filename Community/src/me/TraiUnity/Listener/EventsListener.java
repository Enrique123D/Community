package me.TraiUnity.Listener;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

import me.TraiUnity.Main;
import me.TraiUnity.Commands.VanishCommand;
import me.TraiUnity.EffekteMenu.Effects;
import me.TraiUnity.EffekteMenu.FileManager1;
import me.TraiUnity.EffekteMenu.Particle;
import me.TraiUnity.Screenbox.Screenbox;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class EventsListener implements Listener{

	public static File File1 = FileManager1.File1;
	public static YamlConfiguration Settings11 = FileManager1.Settings1;
	
	static HashMap<Player, LinkedList<Player>> partys = new HashMap<>();
	HashMap<Player, LinkedList<Player>> invites = new HashMap<>();
	static HashMap<Player, LinkedList<Player>> found = new HashMap<>();
	static HashMap<Player, Integer> searcher = new HashMap<>();
	static HashMap<Player, Player> search = new HashMap<>();
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
	
		Player p = e.getPlayer();
		
		e.setQuitMessage(null);
		
		if (VanishCommand.vanished.contains(p)) {
			for(Player all : Bukkit.getOnlinePlayers()){
				if(all.hasPermission("Rangsystem.Owner")){
					all.sendMessage(Main.commip + p.getDisplayName() + " §7hat den §eServer §7im §aVanish §7verlassen!");
				}
			}
		}
		
		p.setWalkSpeed(0.2F);
		p.setFlySpeed(0.1F);
		
		for(Screenbox box : Main.boxen.values()){
			if(box.getInbox() == p){
				box.removeInbox(true);
			}
			box.removeFromWarteschlange(p);
		}
	}
	
	@EventHandler
	public void onRedstone(BlockRedstoneEvent e){
		if(e.getBlock().getType().equals(Material.REDSTONE_LAMP_OFF) || e.getBlock().getType().equals(Material.REDSTONE_LAMP_ON)){
			if(Settings11.getString("Config.Lasershow").equals("true")){
				e.setNewCurrent(15);
			}else{
				e.setNewCurrent(0);
			}
		}
	}
	
	@EventHandler
	public static void onachievements(PlayerAchievementAwardedEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		
		Player p = e.getPlayer();
		
		for (World worlds : Bukkit.getWorlds()){
			for(Entity ent : worlds.getEntities()) {
				if(!(ent instanceof Player)) {
					ent.remove();					
				}
			}
		}
		
		p.setGameMode(GameMode.ADVENTURE);
		
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		
		GregorianCalendar jahr = new GregorianCalendar();
		int aktuellesjahr = jahr.get(GregorianCalendar.YEAR);
		
		p.setLevel(aktuellesjahr);
		p.setExp(0.0F);
		
		p.setFoodLevel(20);

		p.setMaxHealth(20);
		p.setHealth(20);
		
		World w = Bukkit.getWorld(Main.loc.getString("Spawn.World"));
		double x = Main.loc.getDouble("Spawn.X");
		double y = Main.loc.getDouble("Spawn.Y");
		double z = Main.loc.getDouble("Spawn.Z");
		float yaw = (float)Main.loc.getDouble("Spawn.Yaw");
		float pitch = (float)Main.loc.getDouble("Spawn.Pitch");
		Location spawn = new Location(w, x, y, z, yaw, pitch);
		
		spawn.getChunk().load();
	
		e.setRespawnLocation(spawn);
		p.teleport(spawn);
		
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
		
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {

		Player p = e.getPlayer();
		
		String msg = e.getMessage().split(" ")[0];
		
		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		
		if(!p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner") && !p.isOp()){
			if(msg.equalsIgnoreCase("/pex")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/promote")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/demote")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/nocheatplus")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/ncp")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/aac")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/echopet")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/pet")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/petadmin")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/ecupdate")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/signedit")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/bportals")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/holograms")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/hd")){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}
			if(msg.equalsIgnoreCase("/pl") | msg.equalsIgnoreCase("/plugins") | msg.equalsIgnoreCase("/about") | msg.equalsIgnoreCase("/bukkit:about") | msg.equalsIgnoreCase("/bukkit:pl") | msg.equalsIgnoreCase("/bukkit:plugins") | msg.equalsIgnoreCase("/bukkit:timings") | msg.equalsIgnoreCase("/timings")  | msg.equalsIgnoreCase("/ver") | msg.equalsIgnoreCase("/version") | msg.equalsIgnoreCase("/bukkit:ver") | msg.equalsIgnoreCase("/bukkit:version")){
				e.setCancelled(true);
			}
			if(msg.equalsIgnoreCase("/help") | msg.equalsIgnoreCase("/bukkit:help") | msg.equalsIgnoreCase("/bukkit:?") | msg.equalsIgnoreCase("/?") | msg.equalsIgnoreCase("/hilfe")) {
				e.setCancelled(true);
				p.sendMessage(Main.commip + "§7Du spielst auf §dTraidio.net§7!");
			}
			if((!e.isCancelled()) &&
				(topic == null)){
				e.setCancelled(true);
				p.sendMessage(Main.unknowncmd);
			}			
		}
	}
	
	@EventHandler
	public void onBlockPlace1(BlockPlaceEvent e){
		
		Player p = e.getPlayer();
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}	
	}
	
	@EventHandler
	public void onBlockBreak1(BlockBreakEvent e){
		
		Player p = e.getPlayer();
						
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}	
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBedEnter(PlayerBedEnterEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		e.setCancelled(true);
	 }
	  
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		
		if(Effects.tnt.contains(e.getEntity())) {
			Effects.tnt.remove(e.getEntity());
			Random r = new Random();
			
			for(int i = 0; i < 50; i++) {
				Particle p = new Particle(EnumParticle.HEART, e.getLocation(), true, (r.nextFloat() * 1.5F), (r.nextFloat() * 1.5F), (r.nextFloat() * 1.5F), 2, 1);
				p.sendAll();
			}
		}
		
		e.setCancelled(true);
	}

	@EventHandler
	public void onHangingPlace(HangingPlaceEvent e){

		Player p = e.getPlayer();
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}	
	}
	
	@EventHandler
	public void onHangingBreakByEntity(HangingBreakByEntityEvent e){
	
		if(e.getRemover() instanceof Player){
		
			Player p = (Player)e.getRemover();
			
			if(!Main.edit.contains(p)){
				e.setCancelled(true);
				if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
					p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
				}
			}else{
				e.setCancelled(false);
			}				
		}
	}
	
	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerArmorStandManipulte(PlayerArmorStandManipulateEvent e){
	
		Player p = e.getPlayer();
		
		if(!e.getRightClicked().isVisible()){
			e.setCancelled(true);
		}
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}		
	}
	
	@EventHandler
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e){

		Player p = e.getPlayer();
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}			
	}
	
	@EventHandler
	public void onPlayerBucketFill(PlayerBucketFillEvent e){

		Player p = e.getPlayer();
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}			
	}	
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e){
		
		Player p = e.getPlayer();
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
			if(p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")){
				p.sendMessage(Main.commip + "§cDu befindest dich nicht im §eBuildmodus§c. §8(§a/build§8)");
			}
		}else{
			e.setCancelled(false);
		}			
	}
	
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		
		if((e.getRightClicked().getType() == EntityType.ITEM_FRAME) && 
			(!Main.edit.contains(p))){
				e.setCancelled(true);
			}else{
				e.setCancelled(false);
			}
		
			if(e.getRightClicked().getType() == EntityType.VILLAGER){
				if(!Main.edit.contains(p)){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
			}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
	
		if(e.getAction() == Action.LEFT_CLICK_BLOCK | (e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
			(e.getClickedBlock().getType() == Material.DRAGON_EGG)){
				if(!Main.edit.contains(p)){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
		}		
	}
	
	@EventHandler
	public void onPlayerUnleashEntity(PlayerUnleashEntityEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e){
		
		Player p = e.getPlayer();
		
		if(!Main.edit.contains(p)){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
}
