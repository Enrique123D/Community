package me.TraiUnity.Inventare;

import java.io.File;
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

public class LocationsInventar {

	@SuppressWarnings("deprecation")
	public static void openLocInv(Player p) {
		
		Inventory locs = Bukkit.createInventory(null, 54, "§8● §eLocations setzen §8●");
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§cKeine weiteren Spawnpunkte gefunden...");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < locs.getSize(); i++){
			locs.setItem(i, PH4);
		}
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zurück");
		N1M.setOwner("MHF_ArrowLeft");
		N1.setItemMeta(N1M);
			locs.setItem(53, N1);
		
	//Spawn	
	
		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add(0, "");
		lore1.add(1, "§7Damit kannst du den Haupt-Spawn setzen");
		lore1.add(2, "");
		
		File locations1 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Spawn.yml");
		
		if(!locations1.exists()) {
			lore1.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
		}else {
			lore1.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
		}
		
		ItemStack I1 = new ItemStack(Material.SLIME_BALL);
		ItemMeta I1M = I1.getItemMeta();
		I1M.setDisplayName("§8» §aSpawn setzen");
		I1M.setLore(lore1);
		I1.setItemMeta(I1M);
		
			locs.setItem(0, I1);
		
	//YouTuber-Buehne
		
			ArrayList<String> lore2 = new ArrayList<String>();
			lore2.add(0, "");
			lore2.add(1, "§7Damit kannst du den YT-Bühnen-Spawn setzen");
			lore2.add(2, "");
			
			File locations2 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "YT-Bühne.yml");
			
			if(!locations2.exists()) {
				lore2.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
			}else {
				lore2.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
			}
			
			ItemStack I2 = new ItemStack(Material.NOTE_BLOCK);
			ItemMeta I2M = I2.getItemMeta();
			I2M.setDisplayName("§8» §aYouTuber-Bühnen Spawn setzen");
			I2M.setLore(lore2);
			I2.setItemMeta(I2M);
			
				locs.setItem(1, I2);
				
	//Screenboxen
			
				ArrayList<String> lore3 = new ArrayList<String>();
				lore3.add(0, "");
				lore3.add(1, "§7Damit kannst du den Screenbox-Spawn setzen");
				lore3.add(2, "");
				
				File locations3 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Screenboxen.yml");
				
				if(!locations3.exists()) {
					lore3.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
				}else {
					lore3.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
				}
				
		        ItemStack I3 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);					
		        SkullMeta I3M = (SkullMeta)I3.getItemMeta();
		        I3M.setOwner("gocodygo");
		        I3M.setDisplayName("§8» §aScreenbox-Spawn setzen");
		        I3M.setLore(lore3);
		        I3.setItemMeta(I3M);
				
					locs.setItem(2, I3);
					
	//JumpAndRuns
					
				ArrayList<String> lore4 = new ArrayList<String>();
				lore4.add(0, "");
				lore4.add(1, "§7Damit kannst du den JumpAndRun-Spawn setzen");
				lore4.add(2, "");
					
				File locations4 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "JumpAndRuns.yml");
				
				if(!locations4.exists()) {
					lore4.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
				}else {
					lore4.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
				}
					
				ItemStack I4 = new ItemStack(Material.GOLD_PLATE);
				ItemMeta I4M = I4.getItemMeta();
				I4M.setDisplayName("§8» §aJumpAndRun Spawn setzen");
				I4M.setLore(lore4);
				I4.setItemMeta(I4M);
					
					locs.setItem(3, I4);
			
	//Premium+UndYTber
					
				ArrayList<String> lore5 = new ArrayList<String>();
				lore5.add(0, "");
				lore5.add(1, "§7Damit kannst du den Premium+ und YouTuber-Spawn setzen");
				lore5.add(2, "");
						
				File locations5 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Premium+UndYouTuber.yml");
					
				if(!locations5.exists()) {
					lore5.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
				}else {
					lore5.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
				}
						
				ItemStack I5 = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta I5M = (LeatherArmorMeta) I5.getItemMeta();
				I5M.setColor(Color.YELLOW);
				I5M.setDisplayName("§8» §aPremium+ und Youtuber Spawn setzen");
				I5M.setLore(lore5);
				I5.setItemMeta(I5M);
						
					locs.setItem(4, I5);
					
	//VIP-Bereich
					
				ArrayList<String> lore6 = new ArrayList<String>();
				lore6.add(0, "");
				lore6.add(1, "§7Damit kannst du den VIP-Bereich-Spawn setzen");
				lore6.add(2, "");
						
				File locations6 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "VIP-Bereich.yml");
					
				if(!locations6.exists()) {
					lore6.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
				}else {
					lore6.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
				}
						
				ItemStack I6 = new ItemStack(Material.GLOWSTONE_DUST);
				ItemMeta I6M = I6.getItemMeta();
				I6M.setDisplayName("§8» §aVIP-Bereich Spawn setzen");
				I6M.setLore(lore6);
				I6.setItemMeta(I6M);
						
					locs.setItem(5, I6);
		
	//Bühne
					
				ArrayList<String> lore7 = new ArrayList<String>();
				lore7.add(0, "");
				lore7.add(1, "§7Damit kannst du den Bühnen-Spawn setzen");
				lore7.add(2, "");
							
				File locations7 = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Bühne.yml");
						
				if(!locations7.exists()) {
					lore7.add(3, "§7Spawnpunkt gesetzt§8: §cNein");
				}else {
					lore7.add(3, "§7Spawnpunkt gesetzt§8: §aJa");
				}
							
				ItemStack I7 = new ItemStack(351, 1, (short)5);
				ItemMeta I7M = I7.getItemMeta();
				I7M.setDisplayName("§8» §aBühnen Spawn setzen");
				I7M.setLore(lore7);
				I7.setItemMeta(I7M);
							
					locs.setItem(6, I7);
							
		p.openInventory(locs);
	}
	
}
