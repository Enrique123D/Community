package me.TraiUnity;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder2 {
	
	private ItemStack item;
	private ItemMeta meta;
	
	public ItemBuilder2(Material mat) {
		item = new ItemStack(mat);
		meta = item.getItemMeta();
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder2(int mat) {
		item = new ItemStack(mat);
		meta = item.getItemMeta();
	}
	
	public ItemBuilder2(Material mat, short sub) {
		item = new ItemStack(mat, 1, sub);
		meta = item.getItemMeta();
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder2(int mat, short sub) {
		item = new ItemStack(mat, 1, sub);
		meta = item.getItemMeta();
	}
	
	public ItemBuilder2(Material mat, int am) {
		item = new ItemStack(mat, am);
		meta = item.getItemMeta();
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder2(int mat, int am) {
		item = new ItemStack(mat, am);
		meta = item.getItemMeta();
	}
	
	public ItemBuilder2(Material mat, int am, short sub) {
		item = new ItemStack(mat, am, sub);
		meta = item.getItemMeta();
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder2(int mat, int am, short sub) {
		item = new ItemStack(mat, am, sub);
		meta = item.getItemMeta();
	}
	
	public ItemBuilder2 setAmount(int am) {
		item.setAmount(am);
		return this;
	}
	
	public ItemBuilder2 setDurability(short am) {
		item.setDurability(am);
		return this;
	}
	
	public ItemBuilder2 addEnchantment(Enchantment ench, int lvl) {
		meta.addEnchant(ench, lvl, true);
		return this;
	}
	
	public ItemBuilder2 removeEnchantment(Enchantment ench) {
		item.removeEnchantment(ench);
		return this;
	}
	
	public ItemBuilder2 unbreakable(boolean set) {
		meta.spigot().setUnbreakable(set);
		return this;
	}
	
	public ItemBuilder2 displayName(String set) {
		meta.setDisplayName(set);
		return this;
	}
	
	public ItemBuilder2 lore(String... set) {
		List<String> l = new ArrayList<>();
		for(String s : set) { l.add(s); }
		meta.setLore(l);
		return this;
	}
	
	public ItemBuilder2 addLore(String... set) {
		List<String> l = meta.getLore();
		for(String s : set) { l.add(s); }
		meta.setLore(l);
		return this;
	}
	
	public ItemBuilder2 removeLore(String... set) {
		List<String> l = meta.getLore();
		for(String s : set) { l.remove(s); }
		meta.setLore(l);
		return this;
	}
	
	public ItemBuilder2 removeLoreAll() {
		meta.setLore(null);
		return this;
	}
	
	public ItemBuilder2 glowing() {
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return this;
	}
	
	public ItemBuilder2 hideFlags(ItemFlag... f) {
		meta.addItemFlags(f);
		return this;
	}
	
	public ItemBuilder2 hideFlagsAll() {
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		return this;
	}
	
	public ItemBuilder2 showFlags(ItemFlag... f) {
		meta.removeItemFlags(f);
		return this;
	}
	
	public ItemBuilder2 showFlagsAll() {
		meta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.removeItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.removeItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.removeItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		return this;
	}
	
	public ItemStack build() {
		item.setItemMeta(meta);
		return item;
	}
	
}
