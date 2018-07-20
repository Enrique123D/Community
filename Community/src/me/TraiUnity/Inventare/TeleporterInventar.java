package me.TraiUnity.Inventare;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class TeleporterInventar {

	public static void OpenTeleporter(Player p) {
		
		Inventory teleporter = Bukkit.createInventory(null, 45, "§8● §cTeleporter §8●"); 
		
		ArrayList<String> ix = new ArrayList<String>();
		ix.add(0, "");
		ix.add(1, "§c✗ §eDerzeit nicht Verfügbar §c✗");
		
		ItemStack II = new ItemStack(Material.BARRIER);
		ItemMeta IIM = II.getItemMeta();
		IIM.setDisplayName("§8» §4Kommt demnächst");
		IIM.setLore(ix);
		II.setItemMeta(IIM);
		
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add(0, "§8► §7Klicke zum Teleportieren.");
		
        ItemStack I0 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);					
        SkullMeta I0M = (SkullMeta)I0.getItemMeta();
        I0M.setOwner("gocodygo");
        I0M.setDisplayName("§8» §9Screenboxen");
        I0M.setLore(Lore);
        I0.setItemMeta(I0M);
		
		ItemStack I1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta I1M = (SkullMeta) I1.getItemMeta();
		I1M.setOwner("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzNTNmZDBmODYzMTQzNTM4NzY1ODYwNzViOWJkZjBjNDg0YWFiMDMzMWI4NzJkZjExYmQ1NjRmY2IwMjllZCJ9fX0=");
		I1M.setDisplayName("§8» §5YouTuber Bühne");
		I1M.setLore(Lore);
		I1.setItemMeta(I1M);
		
		ItemStack I2 = new ItemStack(Material.SLIME_BALL);
		ItemMeta I2M = I2.getItemMeta();
		I2M.setDisplayName("§8» §aZum Spawn");
		I2M.setLore(Lore);
		I2.setItemMeta(I2M);					
		
		ItemStack I3 = new ItemStack(Material.GOLD_PLATE);
		ItemMeta I3M = I3.getItemMeta();
		I3M.setDisplayName("§8» §3Jump and Runs");
		I3M.setLore(Lore);
		I3.setItemMeta(I3M);
		
		ItemStack I4 = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta I4M = (LeatherArmorMeta) I4.getItemMeta();
		I4M.setColor(Color.YELLOW);
		I4M.setDisplayName("§8» §ePremium§c+ §7und §5YouTuber");
		I4M.setLore(Lore);
		I4.setItemMeta(I4M);
		
		teleporter.setItem(22, I2);
		teleporter.setItem(11, I1);
		teleporter.setItem(15, I0);
		teleporter.setItem(29, I3);
		teleporter.setItem(33, I4);
		
		p.openInventory(teleporter);
	}
}
