package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class LaggClearCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.isOp()) {
			if (args.length == 0) {
				for (World worlds : Bukkit.getWorlds()) {
					for (Entity ent : worlds.getEntities()) {
						if (!(ent instanceof Player)
								&& (!(ent instanceof ArmorStand)
								&& (!(ent instanceof ItemFrame)))) {
								ent.remove();
							}
						}
					}
					p.sendMessage(Main.commip + "§7Entitys wurden erfolgreich §centfernt§7.");
				}
		}
		return false;
	}

}
