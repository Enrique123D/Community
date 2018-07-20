package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class CPSCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;		
		
		if(p.hasPermission("Rangsystem.Owner")){
			if(args.length == 1){
				if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))){
					Player target = Bukkit.getPlayer(args[0]);
					p.sendMessage(Main.commip + "§7Klicktest für §e" + target.getName() + " §7aktiviert!");
					Main.pleaseCheckThisPlayer.put(target, Integer.valueOf(10));
				}else{
					p.sendMessage(Main.commip + "§cDer Spieler ist nicht online!");
				}
			}else{
				p.sendMessage(Main.commip + "§cBenutze §e/cps §8(§7Name§8)");
			}
		}	
		return false;
	}
}
