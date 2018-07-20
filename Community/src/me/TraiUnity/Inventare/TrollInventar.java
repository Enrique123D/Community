package me.TraiUnity.Inventare;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

public class TrollInventar {

	public static void openTrollInv1(Player p){
		
		Inventory troll1 = Bukkit.createInventory(null, 54, "§8● §fTroll-Menü §8● §7Seite§8: §a1");
		
		troll1.setItem(0, getItem("§7Blindheit §8(§e15s§8)", Arrays.asList(new String[] { "§7Probleme die man nicht sieht sind nicht da" }), Material.POTION));
		troll1.setItem(1, getItem("§7Freeze §8(§e15s§8)", Arrays.asList(new String[] { "§7Fühl dich wie ein Eismonster und schockfroste die Spieler" }), Material.PACKED_ICE));
		troll1.setItem(2, getItem("§7Feuer", Arrays.asList(new String[] { "§7Zündet alle Spieler an ._." }), Material.FLINT_AND_STEEL));
				
		ItemStack N3 = new ItemStack(Material.ARROW, 1);
		ItemMeta N3M = N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zur Seite §a2");
		N3.setItemMeta(N3M);
			troll1.setItem(53, N3);
		
		p.openInventory(troll1);
	}
	
	public static void openTrollInv2(Player p){
		
		Inventory troll2 = Bukkit.createInventory(null, 54, "§8● §fTroll-Menü §8● §7Seite§8: §a2");
		
		
		
		
		
		
		
		
		
		
		ItemStack N3 = new ItemStack(Material.ARROW, 1);
		ItemMeta N3M = N3.getItemMeta();
		N3M.setDisplayName("§8» §7Zur Seite §a1");
		N3.setItemMeta(N3M);
			troll2.setItem(45, N3);
				
		p.openInventory(troll2);
	}
	
	public static ItemStack getDisabled(String name){
		
		ItemStack Aus = new Dye(DyeColor.GRAY).toItemStack();
		ItemMeta AusM = Aus.getItemMeta();
		Aus.setAmount(1);
		AusM.setDisplayName("§cDeaktiviert §8● §b" + name);
		Aus.setItemMeta(AusM);
		return Aus;
	}
	
	public static ItemStack getEnabled(String name){

		ItemStack An = new Dye(DyeColor.LIME).toItemStack();
		ItemMeta AnM = An.getItemMeta();
		An.setAmount(1);
		AnM.setDisplayName("§aAktiviert §8● §b" + name);
		An.setItemMeta(AnM);
		return An;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack getItem(String name, List lore, Material material){
	
		ItemStack IS = new ItemStack(material);
		ItemMeta ISM = IS.getItemMeta();
		IS.setAmount(1);
		ISM.setDisplayName("§e" + name);
		ISM.setLore(lore);
		IS.setItemMeta(ISM);
		return IS;			
	}
}
