package me.TraiUnity.Inventare;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SicherInventar {

	public static void openSicher1(Player p) {
		
		Inventory sicher1 = Bukkit.createInventory(null, 9, "§eBist du dir sicher? §8| §a1");
		
		ItemStack N1 = new ItemStack(Material.EMERALD_BLOCK, 1);
		ItemMeta N1M = N1.getItemMeta();
		N1M.setDisplayName("§8» §aJa");
		N1.setItemMeta(N1M);
			sicher1.setItem(1, N1);
			
		ArrayList<String> I1 = new ArrayList<>();
		I1.add(0, "");
		I1.add(1, "§8► §7Möchtest du wirklich den Server stoppen?");
			
		ItemStack N2 = new ItemStack(Material.PAPER, 1);
		ItemMeta N2M = N2.getItemMeta();
		N2M.setDisplayName("§8» §eFrage");
		N2M.setLore(I1);
		N2.setItemMeta(N2M);
			sicher1.setItem(3, N2);
			
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			sicher1.setItem(5, N3);
			
		ItemStack N4 = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta N4M = N4.getItemMeta();
		N4M.setDisplayName("§8» §cNein");
		N4.setItemMeta(N4M);
			sicher1.setItem(7, N4);
		
		p.openInventory(sicher1);
	}
	
	public static void openSicher2(Player p) {
		
		Inventory sicher2 = Bukkit.createInventory(null, 9, "§eBist du dir sicher? §8| §a2");
		
		ItemStack N1 = new ItemStack(Material.EMERALD_BLOCK, 1);
		ItemMeta N1M = N1.getItemMeta();
		N1M.setDisplayName("§8» §aJa");
		N1.setItemMeta(N1M);
			sicher2.setItem(1, N1);
			
		ArrayList<String> I1 = new ArrayList<>();
		I1.add(0, "");
		I1.add(1, "§8► §7Möchtest du wirklich den Server reloaden?");
			
		ItemStack N2 = new ItemStack(Material.PAPER, 1);
		ItemMeta N2M = N2.getItemMeta();
		N2M.setDisplayName("§8» §eFrage");
		N2M.setLore(I1);
		N2.setItemMeta(N2M);
			sicher2.setItem(3, N2);
			
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			sicher2.setItem(5, N3);
			
		ItemStack N4 = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta N4M = N4.getItemMeta();
		N4M.setDisplayName("§8» §cNein");
		N4.setItemMeta(N4M);
			sicher2.setItem(7, N4);
		
		p.openInventory(sicher2);
	}
	
}
