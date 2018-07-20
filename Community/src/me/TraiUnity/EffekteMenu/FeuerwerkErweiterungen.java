package me.TraiUnity.EffekteMenu;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.TraiUnity.ItemBuilder1;
import me.TraiUnity.Main;

public class FeuerwerkErweiterungen {

	public static void setAktuellesFeuerwerk(String flicker, String Trail, String Farbe, String VFarbe, String H�he, String Form){
	
		ConfigurationSection ak = Main.fwke.createSection("Aktuell");
		
		ak.set("Flicker", flicker);
		ak.set("Trail", Trail);
		ak.set("Farbe", Farbe);
		ak.set("Verblassfarbe", VFarbe);
		ak.set("H�he", H�he);	
		ak.set("Form", Form);
		
		try {
			Main.fwke.save(Main.fwe);
		} catch (IOException e) {}
	}
	
	public static void openBearbeitungen(String name, Player p){
		
		Inventory bearbeiten = Bukkit.createInventory(null, 18, name);
		
		ItemStack infoflicker = ItemBuilder1.createItemWithLore(Material.BOOK, 1, "�eFlicker", ItemBuilder1.getNewStringArray(new String[] {
			"�7Flackern w�hrend der Explosion"	
		}));
		
		ItemStack infotrail = ItemBuilder1.createItemWithLore(Material.BOOK, 1, "�eTrail", ItemBuilder1.getNewStringArray(new String[] {
			"�7Weg der Rakete"	
		}));
		
		ItemStack infofarbe = ItemBuilder1.createItemWithLore(Material.BOOK, 1, "�eFarbe", ItemBuilder1.getNewStringArray(new String[] {
			"�7Farbe der Explosion"	
		}));
		
		ItemStack infovfarbe = ItemBuilder1.createItemWithLore(Material.BOOK, 1, "�eVerblassfarbe", ItemBuilder1.getNewStringArray(new String[] {
			"�7Farbe w�hrend des Verblassens"	
		}));
		
		ItemStack infoH�he = ItemBuilder1.createItemWithLore(Material.BOOK, 1, "�eH�he", ItemBuilder1.getNewStringArray(new String[] {
			"�7FlugH�he der Rakete"	
		}));
		
		ItemStack infoform = ItemBuilder1.createItemWithLore(Material.BOOK, 1, "�eForm", ItemBuilder1.getNewStringArray(new String[] {
			"�7Form der Explosion"	
		}));
		
		bearbeiten.setItem(0, infoflicker);
		bearbeiten.setItem(1, infotrail);
		bearbeiten.setItem(2, infofarbe);
		bearbeiten.setItem(3, infovfarbe);
		bearbeiten.setItem(4, infoH�he);
		bearbeiten.setItem(5, infoform);
		
		ItemStack flicker = null;
		ItemStack trail = null;
		ItemStack farbe = null;
		ItemStack vfarbe = null;
		ItemStack H�he = null;
		ItemStack form = null;
		
		if(name.startsWith("�cSchnellzugriff")){
			String sz = name.replaceAll("�c", "");
			
			String[] z = sz.split(" ");
			int szz = Integer.parseInt(z[1]);
			
			ConfigurationSection section = Main.fwke.getConfigurationSection("FW." + szz);
			
			if(section.getString("Flicker").equalsIgnoreCase("Ja")){
				flicker = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�aJa", 13);
			}else if(section.getString("Flicker").equalsIgnoreCase("Nein")){
				flicker = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�cNein", 14);
			}
			
			if(section.getString("Trail").equalsIgnoreCase("Ja")){
				trail = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�aJa", 13);
			}else if(section.getString("Trail").equalsIgnoreCase("Nein")){
				trail = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�cNein", 14);
			}
			
			String f = section.getString("Farbe");
			String vf = section.getString("Verblassfarbe");
			
			String fpre = "";
			String vfpre = "";
			
			int fid = 0;
			int vfid = 0;
			
			if(f.equalsIgnoreCase("Orange")){ fid = 1; fpre = "�6"; } if(f.equalsIgnoreCase("Magenta")){ fid = 2; fpre = "�d"; } if(f.equalsIgnoreCase("Hellblau")){ fid = 3; fpre = "�9"; }
			if(f.equalsIgnoreCase("Gelb")){ fid = 4; fpre = "�e"; } if(f.equalsIgnoreCase("HellGr�n")){ fid = 5; fpre = "�a"; } if(f.equalsIgnoreCase("Grau")){ fid = 7; fpre = "�8"; }
			if(f.equalsIgnoreCase("Hellgrau")){ fid = 8; fpre = "�7"; }  if(f.equalsIgnoreCase("Cyan")){ fid = 9; fpre = "�b"; } if(f.equalsIgnoreCase("Lila")){ fid = 10; fpre = "�5"; }
			if(f.equalsIgnoreCase("Blau")){ fid = 11; fpre = "�1"; } if(f.equalsIgnoreCase("Gr�n")){ fid = 13; fpre = "�2"; } if(f.equalsIgnoreCase("Rot")){ fid = 14; fpre = "�c"; }
			if(f.equalsIgnoreCase("Schwarz")){ fid = 15; fpre = "�0"; }
			
			if(vf.equalsIgnoreCase("Orange")){ vfid = 1; vfpre = "�6"; } if(vf.equalsIgnoreCase("Magenta")){ vfid = 2; vfpre = "�d"; } if(vf.equalsIgnoreCase("Hellblau")){ vfid = 3; vfpre = "�9"; }
			if(vf.equalsIgnoreCase("Gelb")){ vfid = 4; vfpre = "�e"; } if(vf.equalsIgnoreCase("HellGr�n")){ vfid = 5;; vfpre = "�a"; } if(vf.equalsIgnoreCase("Grau")){ vfid = 7; vfpre = "�8"; } 
			if(vf.equalsIgnoreCase("Hellgrau")){ vfid = 8; vfpre = "�7"; } if(vf.equalsIgnoreCase("Cyan")){ vfid = 9; vfpre = "�b"; } if(vf.equalsIgnoreCase("Lila")){ vfid = 10; vfpre = "�5"; } 
			if(vf.equalsIgnoreCase("Blau")){ vfid = 11; vfpre = "�1"; } if(vf.equalsIgnoreCase("Gr�n")){ vfid = 13; vfpre = "�2"; } if(vf.equalsIgnoreCase("Rot")){ vfid = 14; vfpre = "�c"; } 
			if(vf.equalsIgnoreCase("Schwarz")){ vfid = 15; vfpre = "�0"; }
			
			farbe = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, fpre+f, fid);
			vfarbe = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, vfpre+vf, vfid);
			
			if(section.getString("H�he").equalsIgnoreCase("1")){ H�he = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�a" + section.getString("H�he"), 13); }
			else if(section.getString("H�he").equalsIgnoreCase("2")){ H�he = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�e" + section.getString("H�he"), 4); }
			else if(section.getString("H�he").equalsIgnoreCase("3")){ H�he = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�c" + section.getString("H�he"), 14); }
			
			if(section.getString("Form").equalsIgnoreCase("Kugel")){ form = ItemBuilder1.createItem(Material.GHAST_TEAR, 1, "�6"+section.getString("Form")); }
			if(section.getString("Form").equalsIgnoreCase("Gro�e Kugel")){ form = ItemBuilder1.createItem(Material.FIREBALL, 1, "�cGro�e Kugel"); }
			if(section.getString("Form").equalsIgnoreCase("Burst")){ form = ItemBuilder1.createItem(Material.SULPHUR, 1, "�f"+section.getString("Form")); }
			if(section.getString("Form").equalsIgnoreCase("Creeper")){ form = ItemBuilder1.createItemWithShort(Material.SKULL_ITEM, 1, "�a"+section.getString("Form"), 4); }
			if(section.getString("Form").equalsIgnoreCase("Stern")){ form = ItemBuilder1.createItem(Material.NETHER_STAR, 1, "�e"+section.getString("Form")); }
			
		}else{
			ConfigurationSection section = Main.fwke.getConfigurationSection(p.getName());
			
			if(section.getString("Flicker").equalsIgnoreCase("Ja")){
				flicker = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�aJa", 13);
			}else if(section.getString("Flicker").equalsIgnoreCase("Nein")){
				flicker = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�cNein", 14);
			}
			
			if(section.getString("Trail").equalsIgnoreCase("Ja")){
				trail = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�aJa", 13);
			}else if(section.getString("Trail").equalsIgnoreCase("Nein")){
				trail = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�cNein", 14);
			}
			
			String f = section.getString("Farbe");
			String vf = section.getString("Verblassfarbe");
			
			String fpre = "";
			String vfpre = "";
			
			int fid = 0;
			int vfid = 0;
			
			if(f.equalsIgnoreCase("Orange")){ fid = 1; fpre = "�6"; } if(f.equalsIgnoreCase("Magenta")){ fid = 2; fpre = "�d"; } if(f.equalsIgnoreCase("Hellblau")){ fid = 3; fpre = "�9"; }
			if(f.equalsIgnoreCase("Gelb")){ fid = 4; fpre = "�e"; } if(f.equalsIgnoreCase("HellGr�n")){ fid = 5; fpre = "�a"; } if(f.equalsIgnoreCase("Grau")){ fid = 7; fpre = "�8"; }
			if(f.equalsIgnoreCase("Hellgrau")){ fid = 8; fpre = "�7"; }  if(f.equalsIgnoreCase("Cyan")){ fid = 9; fpre = "�b"; } if(f.equalsIgnoreCase("Lila")){ fid = 10; fpre = "�5"; }
			if(f.equalsIgnoreCase("Blau")){ fid = 11; fpre = "�1"; } if(f.equalsIgnoreCase("Gr�n")){ fid = 13; fpre = "�2"; } if(f.equalsIgnoreCase("Rot")){ fid = 14; fpre = "�c"; }
			if(f.equalsIgnoreCase("Schwarz")){ fid = 15; fpre = "�0"; }
			
			if(vf.equalsIgnoreCase("Orange")){ vfid = 1; vfpre = "�6"; } if(vf.equalsIgnoreCase("Magenta")){ vfid = 2; vfpre = "�d"; } if(vf.equalsIgnoreCase("Hellblau")){ vfid = 3; vfpre = "�9"; }
			if(vf.equalsIgnoreCase("Gelb")){ vfid = 4; vfpre = "�e"; } if(vf.equalsIgnoreCase("HellGr�n")){ vfid = 5;; vfpre = "�a"; } if(vf.equalsIgnoreCase("Grau")){ vfid = 7; vfpre = "�8"; } 
			if(vf.equalsIgnoreCase("Hellgrau")){ vfid = 8; vfpre = "�7"; } if(vf.equalsIgnoreCase("Cyan")){ vfid = 9; vfpre = "�b"; } if(vf.equalsIgnoreCase("Lila")){ vfid = 10; vfpre = "�5"; } 
			if(vf.equalsIgnoreCase("Blau")){ vfid = 11; vfpre = "�1"; } if(vf.equalsIgnoreCase("Grün")){ vfid = 13; vfpre = "�2"; } if(vf.equalsIgnoreCase("Rot")){ vfid = 14; vfpre = "�c"; } 
			if(vf.equalsIgnoreCase("Schwarz")){ vfid = 15; vfpre = "�0"; }
			
			farbe = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, fpre+f, fid);
			vfarbe = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, vfpre+vf, vfid);
			
			if(section.getString("H�he").equalsIgnoreCase("1")){ H�he = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�a"+section.getString("H�he"), 13); }
			else if(section.getString("H�he").equalsIgnoreCase("2")){ H�he = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�e"+section.getString("H�he"), 4); }
			else if(section.getString("H�he").equalsIgnoreCase("3")){ H�he = ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�c"+section.getString("H�he"), 14); }
			
			if(section.getString("Form").equalsIgnoreCase("Kugel")){ form = ItemBuilder1.createItem(Material.GHAST_TEAR, 1, "�6"+section.getString("Form")); }
			if(section.getString("Form").equalsIgnoreCase("Gro�e Kugel")){ form = ItemBuilder1.createItem(Material.FIREBALL, 1, "�c"+section.getString("Form")); }
			if(section.getString("Form").equalsIgnoreCase("Burst")){ form = ItemBuilder1.createItem(Material.SULPHUR, 1, "�f"+section.getString("Form")); }
			if(section.getString("Form").equalsIgnoreCase("Creeper")){ form = ItemBuilder1.createItemWithShort(Material.SKULL_ITEM, 1, "�a"+section.getString("Form"), 4); }
			if(section.getString("Form").equalsIgnoreCase("Stern")){ form = ItemBuilder1.createItem(Material.NETHER_STAR, 1, "�e"+section.getString("Form")); }
		}
		
		bearbeiten.setItem(9, flicker);
		bearbeiten.setItem(10, trail);
		bearbeiten.setItem(11, farbe);
		bearbeiten.setItem(12, vfarbe);
		bearbeiten.setItem(13, H�he);
		bearbeiten.setItem(14, form);
		
		bearbeiten.setItem(8, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�aFertig", 13));
		bearbeiten.setItem(17, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "�cAbbrechen", 14));
		
		p.openInventory(bearbeiten);
	}
	
	public static void setFeuerwerkEinstellungen(String name, String flicker, String trail, String farbe, String vfarbe, String H�he, String form){
		ConfigurationSection section = Main.fwke.getConfigurationSection(name);
		
		section.set("Flicker", flicker);
		section.set("Trail", trail);
		section.set("Farbe", farbe);
		section.set("Verblassfarbe", vfarbe);
		section.set("H�he", H�he);
		section.set("Form", form);
		
		try {
			Main.fwke.save(Main.fwe);
		} catch (IOException e) {}
	}
	
}
