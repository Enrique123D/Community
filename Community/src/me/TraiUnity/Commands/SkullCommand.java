package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.TraiUnity.Main;

public class SkullCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			if (args.length == 1) {
				String name = Bukkit.getOfflinePlayer(args[0]).getName();
				ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				SkullMeta sm = (SkullMeta) is.getItemMeta();
				sm.setOwner(name);
				sm.setDisplayName("§fKopf von " + name);
				is.setItemMeta(sm);
				p.getInventory().addItem(new ItemStack[] { is });
				p.sendMessage(Main.commip + "§7Du hast den Kopf von §c" + name + " §7erhalten.");
			} else {
				p.sendMessage(Main.commip + "§cBenutze §e/skull §8(§7Name§8");
			}
		} else {
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
