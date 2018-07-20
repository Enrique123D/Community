package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class RideCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){		
			if((args.length == 1) && (Bukkit.getPlayer(args[0]).isOnline())){
				Player target = Bukkit.getPlayer(args[0]);
				
				if(target == p){
					p.sendMessage(Main.commip + "§cDu kannst nicht auf dir selber reiten!");
				}
				target.setPassenger(p);
				p.sendMessage(Main.commip + "§7Du reitest nun §e" + target.getDisplayName() + "§7.");
			}
		}else{
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
