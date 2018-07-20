package me.TraiUnity.Inventare;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class TeamInventar {

	public static void openTeamInv(Player p) {
		
		Inventory Team = Bukkit.createInventory(null, 36, "§9Teamübersicht §8● §eAuswahl");
			
		ArrayList<String> T1 = new ArrayList<>();
		T1.add(0, "");
		T1.add(1, "§8► §7Hier siehst du eine Übersicht");
		T1.add(2, "   §7der aktuellen §4Administratoren");
			
		ItemStack I1 = new ItemStack(Material.STAINED_CLAY, 1, (short)14);
		ItemMeta I1M = I1.getItemMeta();
		I1M.setDisplayName("§8» §4Administratoren");
		I1M.setLore(T1);
		I1.setItemMeta(I1M);
			Team.setItem(4, I1);

		ArrayList<String> T2 = new ArrayList<>();
		T2.add(0, "");
		T2.add(1, "§8► §7Hier siehst du eine Übersicht");
		T2.add(2, "   §7der aktuellen §bDeveloper");
				
		ItemStack I2 = new ItemStack(Material.STAINED_CLAY, 1, (short)11);
		ItemMeta I2M = I2.getItemMeta();
		I2M.setDisplayName("§8» §bDeveloper");
		I2M.setLore(T2);
		I2.setItemMeta(I2M);
			Team.setItem(13, I2);
			
		ArrayList<String> T3 = new ArrayList<>();
		T3.add(0, "");
		T3.add(1, "§8► §7Hier siehst du eine Übersicht");
		T3.add(2, "   §7der aktuellen §cSrModeratoren");
					
		ItemStack I3 = new ItemStack(Material.STAINED_CLAY, 1, (short)6);
		ItemMeta I3M = I3.getItemMeta();
		I3M.setDisplayName("§8» §cSrModeratoren");
		I3M.setLore(T3);
		I3.setItemMeta(I3M);
			Team.setItem(21, I3);
			
		ArrayList<String> T4 = new ArrayList<>();
		T4.add(0, "");
		T4.add(1, "§8► §7Hier siehst du eine Übersicht");
		T4.add(2, "   §7der aktuellen §cModeratoren");
						
		ItemStack I4 = new ItemStack(Material.STAINED_CLAY, 1, (short)6);
		ItemMeta I4M = I4.getItemMeta();
		I4M.setDisplayName("§8» §cModeratoren");
		I4M.setLore(T4);
		I4.setItemMeta(I4M);
			Team.setItem(23, I4);
			
		ArrayList<String> T5 = new ArrayList<>();
		T5.add(0, "");
		T5.add(1, "§8► §7Hier siehst du eine Übersicht");
		T5.add(2, "   §7der aktuellen §aBuilder");
						
		ItemStack I5 = new ItemStack(Material.STAINED_CLAY, 1, (short)5);
		ItemMeta I5M = I5.getItemMeta();
		I5M.setDisplayName("§8» §aBuilder");
		I5M.setLore(T5);
		I5.setItemMeta(I5M);
			Team.setItem(31, I5);
			
		p.openInventory(Team);
		
	}
	
	public static void openTeamInv1(Player p) {
		
		Inventory Team1 = Bukkit.createInventory(null, 36, "§9Teamübersicht §8● §aBuilder");
		
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			Team1.setItem(35, N3);
		
		p.openInventory(Team1);
	}
	
	public static void openTeamInv3(Player p) {
		
		Inventory Team3 = Bukkit.createInventory(null, 36, "§9Teamübersicht §8● §cMods");
		
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			Team3.setItem(35, N3);
		
		p.openInventory(Team3);
	}
	
	public static void openTeamInv4(Player p) {
		
		Inventory Team4 = Bukkit.createInventory(null, 9, "§9Teamübersicht §8● §cSrMods");
		
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			Team4.setItem(8, N3);
		
		p.openInventory(Team4);
	}
	
	public static void openTeamInv5(Player p) {
		
		Inventory Team5 = Bukkit.createInventory(null, 27, "§9Teamübersicht §8● §bDevs");
		
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			Team5.setItem(26, N3);
		
		p.openInventory(Team5);
	}

	public static void openTeamInv6(Player p) {
		
		Inventory Team6 = Bukkit.createInventory(null, 9, "§9Teamübersicht §8● §4Admins");
		
		ItemStack N3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N3M = (SkullMeta) N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zurück");
		N3M.setOwner("MHF_ArrowLeft");
		N3.setItemMeta(N3M);
			Team6.setItem(8, N3);
			
		p.openInventory(Team6);
	}	
}
