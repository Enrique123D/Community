package me.TraiUnity.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TraiUnity.Main;

public class RenameCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			if ((p.getItemInHand().getTypeId() != 0) | (p.getItemInHand() != null)) {
				if (args.length >= 1) {

					ItemStack i = p.getItemInHand();
					String msg = "";
					for (int o = 0; o < args.length; o++) {
						msg = msg + args[o] + " ";
					}
					ItemMeta m = i.getItemMeta();
					msg = ChatColor.translateAlternateColorCodes('&', msg);
					m.setDisplayName(msg);
					i.setItemMeta(m);
					p.sendMessage(Main.commip + "§7Item wurde errfolgreich umbenannt.");
				} else {
					p.sendMessage(Main.commip + "§cBenutze §e/rename §8(§7Name§8)");
				}
			} else {
				p.sendMessage(Main.commip + "§cDu musst ein Item in der Hand haben.");
			}
		} else {
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
