package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class DifficultyCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.isOp()) {
			if (args.length == 0) {
				p.sendMessage(Main.commip + "§cBenutze §e/difficulty §8(§70-3§8)");
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("0")) {
					for (World worlds : Bukkit.getWorlds()) {
						worlds.setDifficulty(Difficulty.PEACEFUL);
					}
					p.sendMessage(Main.commip + "§7Schwierigkeit auf §aFriedlich §7gesetzt.");
				} else if (args[0].equalsIgnoreCase("1")) {
					for (World worlds : Bukkit.getWorlds()) {
						worlds.setDifficulty(Difficulty.EASY);
					}
					p.sendMessage(Main.commip + "§7Schwierigkeit auf §aEinfach §7gesetzt.");
				} else if (args[0].equalsIgnoreCase("2")) {
					for (World worlds : Bukkit.getWorlds()) {
						worlds.setDifficulty(Difficulty.NORMAL);
					}
					p.sendMessage(Main.commip + "§7Schwierigkeit auf §aNormal §7gesetzt.");
				} else if (args[0].equalsIgnoreCase("3")) {
					for (World worlds : Bukkit.getWorlds()) {
						worlds.setDifficulty(Difficulty.HARD);
					}
					p.sendMessage(Main.commip + "§7Schwierigkeit auf §aHard §7gesetzt.");
				}
			}
		} else {
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
