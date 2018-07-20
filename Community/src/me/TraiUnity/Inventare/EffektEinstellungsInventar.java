package me.TraiUnity.Inventare;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;

import me.TraiUnity.ItemBuilder1;
import me.TraiUnity.Main;
import me.TraiUnity.EffekteMenu.Effects;

public class EffektEinstellungsInventar {

	public static void openEinstellungenFeuerwerk(Player p){
		
		Inventory feuerwerk = Bukkit.createInventory(null, 36, "§4Einstellungen §8(§eFeuerwerk§8)");
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§4✖");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < feuerwerk.getSize(); i++){
			feuerwerk.setItem(i, PH4);
		}
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zurück");
		N1M.setOwner("MHF_ArrowLeft");
		N1.setItemMeta(N1M);
			feuerwerk.setItem(35, N1);
		
		feuerwerk.setItem(4, ItemBuilder1.createItemWithLore(Material.FIREWORK, 1, "§cAktuell", ItemBuilder1.getNewStringArray(new String[] {
				"§7Flicker§8: §e" + Main.fwke.getConfigurationSection("Aktuell").getString("Flicker"),
				"§7Trail§8: §e" + Main.fwke.getConfigurationSection("Aktuell").getString("Trail"),
				"§7Farbe§8: §e" + Main.fwke.getConfigurationSection("Aktuell").getString("Farbe"),
				"§7Verblassfarbe§8: §e" + Main.fwke.getConfigurationSection("Aktuell").getString("Verblassfarbe"),
				"§7Höhe§8: §e" + Main.fwke.getConfigurationSection("Aktuell").getString("Höhe"),
				"§7Form§8: §e" + Main.fwke.getConfigurationSection("Aktuell").getString("Form")
		})));
			
		for(int i = 0; i < 18; i++){
			feuerwerk.setItem(i + 9, ItemBuilder1.createItemWithLore(Material.FIREWORK, 1, "§cSchnellzugriff " + i, ItemBuilder1.getNewStringArray(new String[] {
					"§7Flicker§8: §e" + Main.fwke.getConfigurationSection("FW." + i).getString("Flicker"),
					"§7Trail§8: §e" + Main.fwke.getConfigurationSection("FW." + i).getString("Trail"),
					"§7Farbe§8: §e" + Main.fwke.getConfigurationSection("FW." + i).getString("Farbe"),
					"§7Verblassfarbe§8: §e" + Main.fwke.getConfigurationSection("FW." + i).getString("Verblassfarbe"),
					"§7Höhe§8: §e" + Main.fwke.getConfigurationSection("FW." + i).getString("Höhe"),
					"§7Form§8: §e" + Main.fwke.getConfigurationSection("FW." + i).getString("Form"),
					"",
					"§8(§7Linksklick = Benutzen §8| §7Rechtsklick = Bearbeiten§8)"
			})));			
		}
		
		if(!Main.fwke.contains(p.getName())){		
			ConfigurationSection fe = Main.fwke.createSection(p.getName());
			
			fe.set("Flicker", "Ja");
			fe.set("Trail", "Ja");
			fe.set("Farbe", "Cyan");
			fe.set("Verblassfarbe", "Gelb");
			fe.set("Höhe", "1");
			fe.set("Form", "Kugel");
			
			try {
				Main.fwke.save(Main.fwe);
			} catch (IOException e) {}
		}
			
		feuerwerk.setItem(31, ItemBuilder1.createItemWithLore(Material.FIREWORK, 1, "§aDein Feuerwerk", ItemBuilder1.getNewStringArray(new String[] {
				"§7Flicker§8: §e" + Main.fwke.getConfigurationSection(p.getName()).getString("Flicker"),
				"§7Trail§8: §e" + Main.fwke.getConfigurationSection(p.getName()).getString("Trail"),
				"§7Farbe§8: §e" + Main.fwke.getConfigurationSection(p.getName()).getString("Farbe"),
				"§7Verblassfarbe§8: §e" + Main.fwke.getConfigurationSection(p.getName()).getString("Verblassfarbe"),
				"§7Höhe§8: §e" + Main.fwke.getConfigurationSection(p.getName()).getString("Höhe"),
				"§7Form§8: §e" + Main.fwke.getConfigurationSection(p.getName()).getString("Form"),
				"",
				"§8(§7Linksklick = Benutzen §8| §7Rechtsklick = Bearbeiten§8)"
		})));
				
		p.openInventory(feuerwerk);
	}
	
	public static void openEinstellungenLasershow(Player p){
		
		Inventory lasershow = Bukkit.createInventory(null, 27, "§4Einstellungen §8(§eLasershow§8)");

		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§4✖");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < lasershow.getSize(); i++){
			lasershow.setItem(i, PH4);
		}
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zurück");
		N1M.setOwner("MHF_ArrowLeft");
		N1.setItemMeta(N1M);
			lasershow.setItem(26, N1);
		
		lasershow.setItem(0, getItem("Mehr Laser §8(§eAktuell§8: §c" + Effects.laserzahl + "§8)", Arrays.asList(new String[] { "§7Konfiguriert die Anzahl der Laser" }), Material.GLOWSTONE_DUST));
			lasershow.setItem(9, getItem("⬆", Arrays.asList(new String[] { "§a+1" }), Material.WOOL, 5));
			lasershow.setItem(18, getItem("⬇", Arrays.asList(new String[] { "§c-1" }), Material.WOOL, 14));
		lasershow.setItem(1, getItem("Bewegungsverzögerung §8(§eAktuell§8: §c" + Effects.laserspeed + "§8)", Arrays.asList(new String[] { "§7Die Laser werden schneller/langsamer" }), Material.BEACON));
			lasershow.setItem(10, getItem("⬆", Arrays.asList(new String[] { "§a+5" }), Material.WOOL, 5));
			lasershow.setItem(19, getItem("⬇", Arrays.asList(new String[] { "§c-5" }), Material.WOOL, 14));
		
		p.openInventory(lasershow);
	}
	
	public static void openEinstellungenFlammenwerfer(Player p){
		
		Inventory flammenwerfer = Bukkit.createInventory(null, 27, "§4Einstellungen §8(§eFlammenwerfer§8)");
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§4✖");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < flammenwerfer.getSize(); i++){
			flammenwerfer.setItem(i, PH4);
		}
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zurück");
		N1M.setOwner("MHF_ArrowLeft");
		N1.setItemMeta(N1M);
			flammenwerfer.setItem(26, N1);
		
		flammenwerfer.setItem(0, getItem("Höhe der Flammenwerfer §8(§eAktuell§8: §c" + Effects.flammenhöhe + "§8)", Arrays.asList(new String[] { "§7Konfiguriert die Höhe der Flammenwerfer" }), Material.FIREWORK));
			flammenwerfer.setItem(9, getItem("⬆", Arrays.asList(new String[] { "§a+1" }), Material.WOOL, 5));
			flammenwerfer.setItem(18, getItem("⬇", Arrays.asList(new String[] { "§c-1" }), Material.WOOL, 14));
		flammenwerfer.setItem(1, getItem("Partikelschnelligkeit §8(§eAktuell§8: §c" + Effects.flammenanzahl + "§8)", Arrays.asList(new String[] { "§7Die Flammen werden mehr/weniger" }), Material.BUCKET));
			flammenwerfer.setItem(10, getItem("⬆", Arrays.asList(new String[] { "§a+1" }), Material.WOOL, 5));
			flammenwerfer.setItem(19, getItem("⬇", Arrays.asList(new String[] { "§c-1" }), Material.WOOL, 14));
			
		
		p.openInventory(flammenwerfer);
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack getItem(String name, List lore, Material material, int sh){
	
		ItemStack IS = new ItemStack(material);
		ItemMeta ISM = IS.getItemMeta();
		IS.setAmount(1);
		IS.setDurability((short)sh);
		ISM.setDisplayName("§e" + name);
		ISM.setLore(lore);
		IS.setItemMeta(ISM);
		return IS;			
	}
}
