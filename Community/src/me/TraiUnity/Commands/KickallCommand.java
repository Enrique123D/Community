package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class KickallCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			if (args.length == 1) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					if(!all.hasPermission("Rangsystem.Administrator") && !all.hasPermission("") && !all.isOp()) {
						all.kickPlayer("\n§cDu wurdest von der §5Traiunity §cgekickt.\n\n§eGrund §8● §a" + args[0]);
					}
				}
			}else{
				p.sendMessage(Main.commip + "§cBenutze §e/kickall §8(§7Grund§8)");
			}
		}else{
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
