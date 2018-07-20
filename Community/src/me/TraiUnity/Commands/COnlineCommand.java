package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.TraiUnity.Main;

public class COnlineCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.isOp()) {
			if (args.length == 0) {
				Inventory inv = Bukkit.createInventory(null, 54, "§aSpieler §8(§aOnline§8)");
				for(Player all : Bukkit.getOnlinePlayers()){
					ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
					SkullMeta meta = (SkullMeta)item.getItemMeta();
					meta.setOwner(all.getName());
					meta.setDisplayName(all.getDisplayName());
					item.setItemMeta(meta);
					
					inv.addItem(new ItemStack[] { item });
				}
				p.openInventory(inv);				
			}
		}
		return false;
	}
}
