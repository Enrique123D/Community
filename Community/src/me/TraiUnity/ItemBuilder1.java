package me.TraiUnity;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder1 {


	public static ItemStack createItem(Material mat, int amount, String name){
		ItemStack Item = new ItemStack(mat, amount);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); Item.setItemMeta(meta);
		return Item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItem(int mat, int amount, String name){
		ItemStack Item = new ItemStack(mat, amount);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); Item.setItemMeta(meta);
		return Item;
	}
	
	public static ItemStack createItemWithShort(Material mat, int amount, String name, int sh){
		ItemStack Item = new ItemStack(mat, amount, (short) sh);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); Item.setItemMeta(meta);
		return Item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItemWithShort(int mat, int amount, String name, int sh){
		ItemStack Item = new ItemStack(mat, amount, (short) sh);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); Item.setItemMeta(meta);
		return Item;
	}
	
	public static ItemStack createItemWithLore(Material mat, int amount, String name, ArrayList<String> lore){
		ItemStack Item = new ItemStack(mat, amount);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); meta.setLore(lore); Item.setItemMeta(meta);
		return Item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItemWithLore(int mat, int amount, String name, ArrayList<String> lore){
		ItemStack Item = new ItemStack(mat, amount);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); meta.setLore(lore); Item.setItemMeta(meta);
		return Item;
	}
	
	public static ItemStack createItemWithShortAndLore(Material mat, int amount, String name, int sh, ArrayList<String> lore){
		ItemStack Item = new ItemStack(mat, amount, (short) sh);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); meta.setLore(lore); Item.setItemMeta(meta);
		return Item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItemWithShortAndLore(int mat, int amount, String name, int sh, ArrayList<String> lore){
		ItemStack Item = new ItemStack(mat, amount, (short) sh);
		ItemMeta meta = Item.getItemMeta(); meta.setDisplayName(name); meta.setLore(lore); Item.setItemMeta(meta);
		return Item;
	}
	
	// Extra
	
	public static ArrayList<String> getNewStringArray(String[] ss){
		ArrayList<String> array = new ArrayList<>();
		  
		for(String s : ss){
			array.add(s);
		}
		  
		return array;
	 }
}	
