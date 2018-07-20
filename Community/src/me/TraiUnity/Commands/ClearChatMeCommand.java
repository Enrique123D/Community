package me.TraiUnity.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class ClearChatMeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		for (int i = 0; i < 250; i++) {
			p.sendMessage(" ");
		}
		p.sendMessage(Main.commip + "§7Du hast deinen eigenen Chat geleert.");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
		return false;
	}
}
