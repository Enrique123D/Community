package me.TraiUnity.MusikMenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import me.TraiUnity.ItemBuilder1;

public class Settings2 implements Listener {
		
	public static void openMusik1(Player p){

		Inventory inv1 = Bukkit.createInventory(null, 54, "§eMusik §8● §7Seite§8: §a1");
		
		for(int i : Music.songs.keySet()){
			if(i < 36){
				inv1.setItem(i, ItemBuilder1.createItemWithLore(Music.songs.get(i).getMaterial(), 1, "§e" + Music.songs.get(i).getName(), ItemBuilder1.getNewStringArray(new String[]{
						"§8» §7Interpret §8● §e" + Music.songs.get(i).getInterpret(),
						"§8» §7Länge §8● §e" + Music.songs.get(i).getLänge()
				})));
			}
		}
		
		inv1.setItem(50, ItemBuilder1.createItem(Material.NOTE_BLOCK, Music.aktuelle_playlist.size(), "§bPlaylist"));
		
		if(Music.aktuelles_lied != null){		
			inv1.setItem(49, ItemBuilder1.createItemWithLore(Material.NAME_TAG, 1, "§7Aktuelles Lied §8● §a" + Music.aktuelles_lied.getName(), ItemBuilder1.getNewStringArray(new String[]{
					"§8» §7Interpret §8● §e" + Music.aktuelles_lied.getInterpret(),
					"§8» §7Länge §8● §e" + Music.aktuelles_lied.getLänge()
			})));
		}else{
			inv1.setItem(49, ItemBuilder1.createItem(Material.NAME_TAG, 1, "§7Aktuelles Lied §8● §c✖"));
		}
		
		inv1.setItem(45, ItemBuilder1.createItemWithLore(Material.REDSTONE_BLOCK, 1, "§4Schließen", ItemBuilder1.getNewStringArray(new String[]{
				"§8» §7Rechts-/Linksklick um das Inventar zu schließen"
		})));
				
		inv1.setItem(48, ItemBuilder1.createItemWithLore(Material.LAVA_BUCKET, 1, "§4Playlist leeren", ItemBuilder1.getNewStringArray(new String[]{
				"§8» §7Leert die Playlist"
		})));
				
		inv1.setItem(53, ItemBuilder1.createItem(Material.ARROW, 1, "§8» §7Zur Seite §a2"));
				
		inv1.setItem(52, ItemBuilder1.createItemWithLore(Material.FIREWORK, 1, "§8» §5Effekte", ItemBuilder1.getNewStringArray(new String[]{
				"",
				"§8► §7Damit kannst du das §5Effekte §7Inventar öffnen"
		})));
		
		p.openInventory(inv1);
		
	}
	
	public static void openMusik2(Player p){
		
		Inventory inv1 = Bukkit.createInventory(null, 54, "§eMusik §8● §7Seite§8: §a2");
		
		if(Music.songs.size() >= 37){
			for(int i : Music.songs.keySet()){	
				if(i >= 36){
					inv1.setItem(i-36, ItemBuilder1.createItemWithLore(Music.songs.get(i).getMaterial(), 1, "§e" + Music.songs.get(i).getName(), ItemBuilder1.getNewStringArray(new String[]{
							"§8» §7Interpret §8● §e" + Music.songs.get(i).getInterpret(),
							"§8» §7Länge §8● §e" + Music.songs.get(i).getLänge()
					})));	
				}
			}
		}
		
		inv1.setItem(50, ItemBuilder1.createItem(Material.NOTE_BLOCK, Music.aktuelle_playlist.size(), "§bPlaylist"));
		
		if(Music.aktuelles_lied != null){
			inv1.setItem(49, ItemBuilder1.createItemWithLore(Material.NAME_TAG, 1, "§7Aktuelles Lied §8● §a" + Music.aktuelles_lied.getName(), ItemBuilder1.getNewStringArray(new String[]{
					"§8» §7Interpret §8● §e" + Music.aktuelles_lied.getInterpret(),
					"§8» §7Länge §8● §e" + Music.aktuelles_lied.getLänge()
			})));
		}else{
			inv1.setItem(49, ItemBuilder1.createItem(Material.NAME_TAG, 1, "§7Aktuelles Lied §8● §c✖"));
		}
		
		inv1.setItem(45, ItemBuilder1.createItemWithLore(Material.REDSTONE_BLOCK, 1, "§4Schließen", ItemBuilder1.getNewStringArray(new String[]{
				"§8» §7Rechts-/Linksklick um das Inventar zu schließen"
		})));
				
		inv1.setItem(48, ItemBuilder1.createItemWithLore(Material.LAVA_BUCKET, 1, "§4Playlist leeren", ItemBuilder1.getNewStringArray(new String[]{
				"§8» §7Leert die Playlist"
		})));
				
		inv1.setItem(53, ItemBuilder1.createItem(Material.ARROW, 1, "§8» §7Zur Seite §a1"));
				
		inv1.setItem(52, ItemBuilder1.createItemWithLore(Material.FIREWORK, 1, "§8» §5Effekte", ItemBuilder1.getNewStringArray(new String[]{
				"",
				"§8► §7Damit kannst du das §5Effekte §7Inventar öffnen"
		})));
		
		p.openInventory(inv1);
		
	}
	
}
