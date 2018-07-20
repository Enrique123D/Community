package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class GlobalMuteCommand implements CommandExecutor {

	public static boolean globalmute = false;

	@SuppressWarnings("deprecation")
	public static final void GlobalMuteOn() {

		globalmute = true;

		for (Player all : Bukkit.getOnlinePlayers()) {
			all.sendTitle("§eGlobalmute §8● §aAn", "");
		}
	}

	@SuppressWarnings("deprecation")
	public static final void GlobalMuteOff() {

		globalmute = false;

		for (Player all : Bukkit.getOnlinePlayers()) {
			all.sendTitle("§eGlobalmute §8● §cAus", "");
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		final Player p = (Player) sender;

		try {

			if (p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")) {
				if (args.length == 0) {
					if (globalmute == false) {
						GlobalMuteOn();
					}else{
						GlobalMuteOff();
					}
				}
			}else{
				p.sendMessage(Main.unknowncmd);
			}
		}catch(Exception ex) {}
		return false;
	}
}
