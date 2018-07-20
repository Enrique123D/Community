package me.TraiUnity.Inventare;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SchwierigkeitsInventar {

	public static void openSchwierigkeit(Player p){
		
		Inventory Schwierigkeit = Bukkit.createInventory(null, 27, "§4Schwierigkeitsgrad");
		
		ItemStack I1 = new ItemStack(Material.LEATHER_BOOTS, 1);
		ItemMeta I1M = I1.getItemMeta();
		I1M.setDisplayName("§8» §aDifficulty 0");
		I1.setItemMeta(I1M);
		
		ItemStack I2 = new ItemStack(Material.GOLD_BOOTS, 2);
		ItemMeta I2M = I2.getItemMeta();
		I2M.setDisplayName("§8» §eDifficulty 1");
		I2.setItemMeta(I2M);
		
		ItemStack I3 = new ItemStack(Material.IRON_BOOTS, 3);
		ItemMeta I3M = I3.getItemMeta();
		I3M.setDisplayName("§8» §6Difficulty 2");
		I3.setItemMeta(I3M);
		
		ItemStack I4 = new ItemStack(Material.DIAMOND_BOOTS, 4);
		ItemMeta I4M = I4.getItemMeta();
		I4M.setDisplayName("§8» §4Difficulty 3");
		I4.setItemMeta(I4M);
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName(" ");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < Schwierigkeit.getSize(); i++){
			Schwierigkeit.setItem(i, PH4);
		}
		
		Schwierigkeit.setItem(10, I1);
		Schwierigkeit.setItem(12, I2);
		Schwierigkeit.setItem(14, I3);
		Schwierigkeit.setItem(16, I4);
		
		p.openInventory(Schwierigkeit);
	}
}
