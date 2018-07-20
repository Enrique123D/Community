package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class SpeedCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

	    if (!(sender instanceof Player)){
	    	sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
	    	return true;
	    }
	    
	    Player p = (Player)sender;
	    if (args.length == 1){
	    	if (!p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner")){
	    	  	p.sendMessage(Main.unknowncmd);
	    	}else if (args[0].equalsIgnoreCase("0")){
	    		p.setWalkSpeed(0.0F);
	    	  	p.setFlySpeed(0.0F);
	    	  	p.sendMessage(Main.commip + "§7Geschwindigkeit auf §e0 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("1")){
	    		p.setWalkSpeed(0.2F);
	    		p.setFlySpeed(0.1F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit auf §e1 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("2")){
	    		p.setWalkSpeed(0.4F);
	    		p.setFlySpeed(0.3F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit auf §e2 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("3")){
	    		p.setWalkSpeed(0.6F);
	    		p.setFlySpeed(0.5F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit auf §e3 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("4")){
	    		p.setWalkSpeed(0.8F);
	    		p.setFlySpeed(0.7F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit auf §e4 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("5")){
	    		p.setWalkSpeed(1.0F);
	    		p.setFlySpeed(0.9F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit auf §e5 §7gesetzt.");
	    	}else{
	    		p.sendMessage(Main.commip + "§cGebe eine Zahl zwischen §e0 §cund §e5 §cein.");
	    	}
	    }else if (args.length == 2){
	    	Player target = Bukkit.getPlayer(args[1]);
	    	if (args[0].equalsIgnoreCase("0")){
	    		target.setWalkSpeed(0.0F);
	    		target.setFlySpeed(0.0F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit von " + target.getDisplayName() + " §7auf §e0 §7gesetzt.");
	    		target.sendMessage(Main.commip + "§7Geschwindigkeit wurde von " + p.getDisplayName() + " §7auf §e0 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("1")){
	    		target.setWalkSpeed(0.2F);
	    		target.setFlySpeed(0.1F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit von " + target.getDisplayName() + " §7auf §e1 §7gesetzt.");
	    		target.sendMessage(Main.commip + "§7Geschwindigkeit wurde von " + p.getDisplayName() + " §7auf §e1 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("2")){
	    		target.setWalkSpeed(0.4F);
	    		target.setFlySpeed(0.3F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit von " + target.getDisplayName() + " §7auf §e2 §7gesetzt.");
	    		target.sendMessage(Main.commip + "§7Geschwindigkeit wurde von " + p.getDisplayName() + " §7auf §e2 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("3")){
	    		target.setWalkSpeed(0.6F);
	    		target.setFlySpeed(0.5F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit von " + target.getDisplayName() + " §7auf §e3 §7gesetzt.");
	    		target.sendMessage(Main.commip + "§7Geschwindigkeit wurde von " + p.getDisplayName() + " §7auf §e3 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("4")){
	    		target.setWalkSpeed(0.8F);
	    		target.setFlySpeed(0.7F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit von " + target.getDisplayName() + " §7auf §e4 §7gesetzt.");
	    		target.sendMessage(Main.commip + "§7Geschwindigkeit wurde von " + p.getDisplayName() + " §7auf §e4 §7gesetzt.");
	    	}else if (args[0].equalsIgnoreCase("5")){
	    		target.setWalkSpeed(1.0F);
	    		target.setFlySpeed(0.9F);
	    		p.sendMessage(Main.commip + "§7Geschwindigkeit von " + target.getDisplayName() + " §7auf §e5 §7gesetzt.");
	    		target.sendMessage(Main.commip + "§7Geschwindigkeit wurde von " + p.getDisplayName() + " §7auf §e5 §7gesetzt.");
	    	}else{
	    		p.sendMessage(Main.commip + "§cGebe eine Zahl zwischen §e0 §cund §e5 §cein.");
	    	}
	    }
		return false;
	}
}
