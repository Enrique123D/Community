package me.TraiUnity.Commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class TeleportCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
			if(args.length == 1){
				String name = args[0];
				
				UUID u = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
				
				if(Bukkit.getPlayer(name) != null){
					Player target = Bukkit.getPlayer(name);
					p.teleport(target);
					p.sendMessage(Main.commip + "§7Du hast dich zu " + target.getDisplayName() + "§7.");
				}else{
					p.sendMessage(Main.commip + "§cDer Spieler §e" + Bukkit.getOfflinePlayer(u).getName() + " §cist nicht online.");
				}
			}else if(args.length == 2){
				String Name1 = args[0];
				String Name2 = args[1];
				Player totarget = Bukkit.getPlayer(Name2);
				Player whotarget = Bukkit.getPlayer(Name1);
				String Dis1 = whotarget.getDisplayName();
				String Dis2 = totarget.getDisplayName();
				totarget.getLocation();
				whotarget.teleport(totarget);
				p.sendMessage(Main.commip + "§7Du hast " + Dis1 + " §7zu " + Dis2 + " §7teleportiert.");
			}
		}else{
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
