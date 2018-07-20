package me.TraiUnity.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;

import me.TraiUnity.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class RegionEnterListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onRegionEnter(RegionEnterEvent e) {
						
		if(e.getRegion().getId().equalsIgnoreCase("Buehne_1") || e.getRegion().getId().equalsIgnoreCase("Buehne_2")){
			Player p = e.getPlayer();
			if(!p.hasPermission("Rangsystem.Premium+") && !p.hasPermission("Rangsystem.Freund") && !p.hasPermission("Rangsystem.Streamer") && !p.hasPermission("Rangsystem.Youtuber")
					&& !p.hasPermission("Rangsystem.Builder") && !p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator") 
					&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer") 
					&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner") && !Main.bt.contains(p)){
					p.sendMessage(Main.commip + "§7Du benötigst mindestems den §ePremium§c+ §7Rang,");
					p.sendMessage(Main.commip + "§7um auf die §5Bühne §7zu kommen.");
                
				double x = Main.yt.getDouble("YTB.X");
				double y = Main.yt.getDouble("YTB.Y");
				double z = Main.yt.getDouble("YTB.Z");
				double pitch = Main.yt.getDouble("YTB.Pitch");
				double yaw = Main.yt.getDouble("YTB.Yaw");
				String weltname = Main.yt.getString("YTB.World");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				
				p.teleport(loc);
				p.sendTitle("§c⚠ §4Achtung §c⚠", "§7Zutritt verwehrt");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	
			}else{	
				sendTitle(p, "§8● §5Bühne §8●");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);
			}
		}
		if(e.getRegion().getId().equalsIgnoreCase("Buehne_3")){
			Player p = e.getPlayer();
			if(!p.hasPermission("Rangsystem.Premium+") && !p.hasPermission("Rangsystem.Freund") && !p.hasPermission("Rangsystem.Streamer") && !p.hasPermission("Rangsystem.Youtuber")
					&& !p.hasPermission("Rangsystem.Builder") && !p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator") 
					&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer") 
					&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner") && !Main.bt.contains(p)){
					p.sendMessage(Main.commip + "§7Du benötigst mindestems den §ePremium§c+ §7Rang,");
					p.sendMessage(Main.commip + "§7um auf die §5Bühne §7zu kommen.");

				double x = Main.yt.getDouble("YTB.X");
				double y = Main.yt.getDouble("YTB.Y");
				double z = Main.yt.getDouble("YTB.Z");
				double pitch = Main.yt.getDouble("YTB.Pitch");
				double yaw = Main.yt.getDouble("YTB.Yaw");
				String weltname = Main.yt.getString("YTB.World");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				
				p.teleport(loc);
				p.sendTitle("§c⚠ §4Achtung §c⚠", "§7Zutritt verwehrt");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);				
			}
		}
		if(e.getRegion().getId().equalsIgnoreCase("Teambesprechungssaal")){
			Player p = e.getPlayer();
			if(!p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator") 
					&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer") 
					&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner") && !Main.bt.contains(p)){

				p.sendMessage(Main.commip + "§7Du benötigst mindestems den §3Probe-Supporter §7Rang,");
				p.sendMessage(Main.commip + "§7um auf die §5Bühne §7zu kommen.");
				double x7 = Main.buen.getDouble("Bühne.X");
				double y7 = Main.buen.getDouble("Bühne.Y");
				double z7 = Main.buen.getDouble("Bühne.Z");
				float yaw7 = (float)Main.buen.getDouble("Bühne.Yaw");
				float pitch7 = (float)Main.buen.getDouble("Bühne.Pitch");
				String weltname = Main.buen.getString("Bühne.World");
				Location loc = new Location(Bukkit.getWorld(weltname), x7, y7, z7);
				loc.setYaw((float) yaw7);
				loc.setPitch((float) pitch7);
				
				p.teleport(loc);
				p.sendTitle("§c⚠ §4Achtung §c⚠", "§7Zutritt verwehrt");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	
			}else{
				p.sendTitle("§8● §cTeambesprechung §8●", "§9Nächste§8: §e" + Main.teamb.getString("Datum") + " §7um §e" + Main.teamb.getString("Uhrzeit") + " Uhr");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);
			}
		}
		if(e.getRegion().getId().equalsIgnoreCase("VIP_Bereich")){
			Player p = e.getPlayer();
			if(!p.hasPermission("Rangsystem.Premium") && !p.hasPermission("Rangsystem.Premium+") && !p.hasPermission("Rangsystem.Freund") && !p.hasPermission("Rangsystem.Streamer") && !p.hasPermission("Rangsystem.Youtuber")
					&& !p.hasPermission("Rangsystem.Builder") && !p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator") 
					&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer") 
					&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner") && !Main.bt.contains(p)){

				p.sendMessage(Main.commip + "§7Du benötigst mindestems den §6Premium §7Rang,");
				p.sendMessage(Main.commip + "§7um auf die §5Bühne §7zu kommen.");
				double x = Main.yt.getDouble("YTB.X");
				double y = Main.yt.getDouble("YTB.Y");
				double z = Main.yt.getDouble("YTB.Z");
				double pitch = Main.yt.getDouble("YTB.Pitch");
				double yaw = Main.yt.getDouble("YTB.Yaw");
				String weltname = Main.yt.getString("YTB.World");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				
				p.teleport(loc);
				p.sendTitle("§c⚠ §4Achtung §c⚠", "§7Zutritt verwehrt");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	
			}else{
				sendTitle(p, "§6VIP §8● §6Bereich");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);
				
			}
		}
		
		if(e.getRegion().getId().equalsIgnoreCase("Lounge_1") || e.getRegion().getId().equalsIgnoreCase("Lounge_2")){
			Player p = e.getPlayer();
			if(!p.hasPermission("Rangsystem.Premium+") && !p.hasPermission("Rangsystem.Freund") && !p.hasPermission("Rangsystem.Streamer") && !p.hasPermission("Rangsystem.Youtuber")
					&& !p.hasPermission("Rangsystem.Builder") && !p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator") 
					&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer") 
					&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner") && !Main.bt.contains(p)){

				p.sendMessage(Main.commip + "§7Du benötigst mindestems den §6Premium§c+ §7Rang,");
				p.sendMessage(Main.commip + "§7um auf die §5Bühne §7zu kommen.");
				double x = Main.yt.getDouble("YTB.X");
				double y = Main.yt.getDouble("YTB.Y");
				double z = Main.yt.getDouble("YTB.Z");
				double pitch = Main.yt.getDouble("YTB.Pitch");
				double yaw = Main.yt.getDouble("YTB.Yaw");
				String weltname = Main.yt.getString("YTB.World");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				
				p.teleport(loc);
				p.sendTitle("§c⚠ §4Achtung §c⚠", "§7Zutritt verwehrt");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	
			}else{
				p.sendTitle("§8● §5Bühne §8●", "§8● §eLounge §8●");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);
			
			}
		}
	}
	
	public void sendTitle(Player p, String Nachricht){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(10, 20, 10);


		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
}
