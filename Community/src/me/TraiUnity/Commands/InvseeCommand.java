package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class InvseeCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			if (args.length == 1) {
				String targetplayer = args[0];
				if (Bukkit.getPlayer(targetplayer) != null) {
					Player target = Bukkit.getPlayer(targetplayer);
					p.openInventory(target.getInventory());
				} else {
					p.sendMessage(Main.commip + "§cDieser Spieler ist nicht §aonline§c.");
				}
			} else {
				p.sendMessage(Main.commip + "§cBenutze §e/invsee §8(§7Name§8)");
			}
		} else {
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
