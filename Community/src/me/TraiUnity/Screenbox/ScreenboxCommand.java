package me.TraiUnity.Screenbox;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class ScreenboxCommand implements CommandExecutor{

	public static File ScrB = Main.sbn;
	public static FileConfiguration ScrBox = Main.sben;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		for(Screenbox box : Main.boxen.values()){
			if(box.isInWarteschlange(p)){
				box.removeFromWarteschlange(p);
				p.sendMessage(Main.screenb + "§7Du wurdest aus der Warteschlange von §e" + box.getInbox().getPlayerListName() + " §7entfernt.");
				return false;
			}
			if(box.getInbox() == p){
				box.removeInbox(false);
				return false;
			}
		}

		if(!p.hasPermission("Rangsystem.Owner")){
			p.sendMessage(Main.unknowncmd);
			return false;
		}
		
		if(args.length == 0){
			p.sendMessage("");
			p.sendMessage(Main.screenb + "§7Einrichtung der §5Screenboxen");
			p.sendMessage("");
			p.sendMessage("");
		}
		
		if(args.length == 2){
			int i = 0;
			
			try{
				i = Integer.parseInt(args[1]);
			}catch(Exception e){				
				p.sendMessage(Main.screenb + "§cBitte gebe eine Zahl ein!");
				return false;
			}
			
			if(!ScrBox.contains("Box"+i)){
				ScrBox.createSection("Box"+i);
			}
			
			ConfigurationSection section = ScrBox.getConfigurationSection("Box"+i);
			if(args[0].equalsIgnoreCase("Knopf")){
				section.set("KnopfX." + i, p.getLocation().getBlockX());
				section.set("KnopfY." + i, p.getLocation().getBlockY());
				section.set("KnopfZ." + i, p.getLocation().getBlockZ());
				
				try {
					ScrBox.save(ScrB);
					p.sendMessage(Main.screenb + "§7Knopf für §5Screenbox §8(§e" + i + "§8) §7gesetzt.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(args[0].equalsIgnoreCase("PasteLocation")){
				section.set("PasteX." + i, p.getLocation().getBlockX());
				section.set("PasteY." + i, p.getLocation().getBlockY());
				section.set("PasteZ." + i, p.getLocation().getBlockZ());
				
				try {
					ScrBox.save(ScrB);
					p.sendMessage(Main.screenb + "§7Paste-Location für §5Screenbox §8(§e" + i + "§8) §7gesetzt.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(args[0].equalsIgnoreCase("SpawnInnen")){
				section.set("SpawnIX." + i, p.getLocation().getBlockX()+0.5);
				section.set("SpawnIY." + i, p.getLocation().getBlockY());
				section.set("SpawnIZ." + i, p.getLocation().getBlockZ()+0.5);
				section.set("SpawnIYaw." + i, Double.valueOf(p.getLocation().getYaw()));
				section.set("SpawnIPitch." + i, Double.valueOf(p.getLocation().getPitch()));

				try {
					ScrBox.save(ScrB);
					p.sendMessage(Main.screenb + "§7SpawnInnen für §5Screenbox §8(§e" + i + "§8) §7gesetzt.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(args[0].equalsIgnoreCase("SpawnAußen")){
				section.set("SpawnAX." + i, p.getLocation().getBlockX()+0.5);
				section.set("SpawnAY." + i, p.getLocation().getBlockY());
				section.set("SpawnAZ." + i, p.getLocation().getBlockZ()+0.5);
				section.set("SpawnAYaw." + i, Double.valueOf(p.getLocation().getYaw()));
				section.set("SpawnAPitch." + i, Double.valueOf(p.getLocation().getPitch()));
				
				try {
					ScrBox.save(ScrB);
					p.sendMessage(Main.screenb + "§7SpawnAußen für §5Screenbox §8(§e" + i + "§8) §7gesetzt.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(args[0].equalsIgnoreCase("Holo")){
				section.set("HoloX." + i, p.getLocation().getBlockX()+0.5);
				section.set("HoloY." + i, p.getLocation().getBlockY());
				section.set("HoloZ." + i, p.getLocation().getBlockZ()+0.5);
				
				try {
					ScrBox.save(ScrB);
					p.sendMessage(Main.screenb + "§7Holo für §5Screenbox §8(§e" + i + "§8) §7gesetzt.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
		if(args.length == 3){
			if(args[0].equalsIgnoreCase("Rotate")){
				int i = 0;
				int i2 = 0;
				
				try{
					i = Integer.parseInt(args[1]);
					i2 = Integer.parseInt(args[2]);
				}catch(Exception e){				
					p.sendMessage(Main.screenb + "§cBitte gebe eine Zahl ein!");
					return false;
				}
				if(i2 != 0 && i2 != 90 && i2 != 180 && i2 != 270 && i2 != 360){
					p.sendMessage(Main.screenb + "§cGebe eine gültige Gradzahl ein! §8(§e0§8, §e90§8, §e180§8, §e270§8, §e360§8)");
					return false;
				}
				ConfigurationSection section = ScrBox.getConfigurationSection("Box"+i);
				section.set("Rotate." + i, i2);
				
				try {
					ScrBox.save(ScrB);
					p.sendMessage(Main.screenb + "§7Rotation für §5Screenbox §8(§e" + i + "§8) §7gesetzt.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
		return false;
	}
}
