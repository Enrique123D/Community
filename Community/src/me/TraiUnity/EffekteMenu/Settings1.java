package me.TraiUnity.EffekteMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;

import me.TraiUnity.ItemBuilder1;

public class Settings1 implements Listener {

	public static File File1 = FileManager1.File1;
	public static YamlConfiguration Settings1 = FileManager1.Settings1;
	
	public static boolean Lasershow;
	public static boolean Explosion;
	public static boolean Blitze;
	public static boolean Nebel;
	public static boolean Konfetti;
	public static boolean Flammenwerfer;
	public static boolean Stroboskop;
	public static boolean Feuerwerk;
	public static boolean welle;
	public static boolean heartcannon;
	public static boolean spiralen;
	public static boolean flammen;
	public static boolean rauch;

	public static boolean DiscoBootsTeammitglieder;
	public static boolean DiscoBootsAlle;

	public static boolean MehrLaser;
	
	public static void loadFile(){
	
		if(!File1.exists()){
			
			Settings1.addDefault("Config.Lasershow", "");
			Settings1.addDefault("Config.Explosion", "");
			Settings1.addDefault("Config.Blitze", "");
			Settings1.addDefault("Config.Nebel", "");
			Settings1.addDefault("Config.Konfetti", "");
			Settings1.addDefault("Config.Fire Shots", "");
			Settings1.addDefault("Config.Stroboskop", "");
			Settings1.addDefault("Config.Feuerwerk", "");		
			Settings1.addDefault("Config.Welle", "");
			Settings1.addDefault("Config.Heartcannon", "");
			Settings1.addDefault("Config.Spiralen", "");
			Settings1.addDefault("Config.Flammen", "");
			Settings1.addDefault("Config.Rauch", "");

			Settings1.addDefault("Config.DiscoschuheTeammitglieder", "");
			Settings1.addDefault("Config.DiscoschuheAlle", "");
			
			
			
			Settings1.set("Config.Lasershow", "false");
			Settings1.set("Config.Explosion", "false");
			Settings1.set("Config.Blitze", "false");
			Settings1.set("Config.Nebel", "false");
			Settings1.set("Config.Konfetti", "false");
			Settings1.set("Config.Fire Shots", "false");
			Settings1.set("Config.Stroboskop", "false");
			Settings1.set("Config.Feuerwerk", "false");		
			Settings1.set("Config.Welle", "false");
			Settings1.set("Config.Heartcannon", "false");
			Settings1.set("Config.Spiralen", "false");
			Settings1.set("Config.Flammen", "false");
			Settings1.set("Config.Rauch", "false");

			Settings1.set("Config.DiscoschuheTeammitglieder", "false");
			Settings1.set("Config.DiscoschuheAlle", "false");
			
			try{
				Settings1.save(File1);
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			
			if(Settings1.get("Config.Lasershow") == null){
				Settings1.set("Config.Lasershow", "false");
			}
			if(Settings1.get("Config.Explosion") == null){
				Settings1.set("Config.Explosion", "false");
			}
			if(Settings1.get("Config.Blitze") == null){
				Settings1.set("Config.Blitze", "false");
			}
			if(Settings1.get("Config.Nebel") == null){
				Settings1.set("Config.Nebel", "false");
			}
			if(Settings1.get("Config.Konfetti") == null){
				Settings1.set("Config.Konfetti", "false");
			}
			if(Settings1.get("Config.Fire Shots") == null){
				Settings1.set("Config.Fire Shots", "false");
			}
			if(Settings1.get("Config.Stroboskop") == null){
				Settings1.set("Config.Stroboskop", "false");
			}
			if(Settings1.get("Config.Feuerwerk") == null){
				Settings1.set("Config.Feuerwerk", "false");
			}
			if(Settings1.get("Config.Welle") == null){
				Settings1.set("Config.Welle", "false");
			}
			if(Settings1.get("Config.Heartcannon") == null){
				Settings1.set("Config.Heartcannon", "false");
			}
			if(Settings1.get("Config.Spiralen") == null){
				Settings1.set("Config.Spiralen", "false");
			}
			if(Settings1.get("Config.Flammen") == null){
				Settings1.set("Config.Flammen", "false");
			}
			if(Settings1.get("Config.Rauch") == null){
				Settings1.set("Config.Rauch", "false");
			}
			
			if(Settings1.get("Config.DiscoschuheTeammitglieder") == null){
				Settings1.set("Config.DiscoschuheTeammitglieder", "false");
			}
			if(Settings1.get("Config.DiscoschuheAlle") == null){
				Settings1.set("Config.DiscoschuheAlle", "false");
			}
			try{
				Settings1.save(File1);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void openInv(){	
		for(Player all : Bukkit.getOnlinePlayers()){		
			if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){				
				Inventory inv = Bukkit.createInventory(null, 54, "§bEffekte §8● §7Seite§8: §a1");
				
				ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
				ItemMeta PH4M = PH4.getItemMeta();
				PH4M.setDisplayName("§4✖");
				PH4.setItemMeta(PH4M);
				
				for(int i = 0; i < inv.getSize(); i++){
					inv.setItem(i, PH4);
				}
				
				if(Lasershow){					
					ArrayList<String> EinstellungLasershow = new ArrayList<>();
					EinstellungLasershow.add("§8» §7Einstellungen für die §eLasershow");
					
					ItemStack lasers = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
					ItemMeta laser = lasers.getItemMeta();
					laser.setDisplayName("§4Einstellungen §8(§eLasershow§8)");
					laser.setLore(EinstellungLasershow);
					lasers.setItemMeta(laser);
					
					inv.setItem(18, lasers);					
					inv.setItem(9, getEnabled("Lasershow"));
				}else{
					inv.setItem(18, PH4);					
					inv.setItem(9, getDisabled("Lasershow"));
				}
				
				if(Explosion){
					inv.setItem(10, getEnabled("Explosion"));
				}else{				
					inv.setItem(10, getDisabled("Explosion"));						
				}
				
				if(Blitze){
					inv.setItem(11, getEnabled("Blitze"));		
				}else{
					inv.setItem(11, getDisabled("Blitze"));
				}
				
				if(Nebel){
					inv.setItem(13, getEnabled("Nebel"));
				}else{
					inv.setItem(13, getDisabled("Nebel"));
				}
				
				if(Konfetti){
					inv.setItem(15, getEnabled("Konfetti"));
				}else{
					inv.setItem(15, getDisabled("Konfetti"));
				}
				
				if(Flammenwerfer){
					ArrayList<String> EinstellungFlammenwerfer = new ArrayList<>();
					EinstellungFlammenwerfer.add("§8» §7Einstellungen für die §eFlammenwerfer");
					
					ItemStack flammenwerfer = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
					ItemMeta flammenwerferm = flammenwerfer.getItemMeta();
					flammenwerferm.setDisplayName("§4Einstellungen §8(§eFlammenwerfer§8)");
					flammenwerferm.setLore(EinstellungFlammenwerfer);
					flammenwerfer.setItemMeta(flammenwerferm);
					
					if(all.hasPermission("Rangsystem.SrModerator") || all.hasPermission("Rangsystem.Administrator") || all.hasPermission("Rangsystem.Owner")){
						inv.setItem(25, flammenwerfer);
					}
					inv.setItem(16, getEnabled("Fire Shots"));
				}else{
					inv.setItem(16, getDisabled("Fire Shots"));
				}
				
				if(Stroboskop){
					inv.setItem(17, getEnabled("Stroboskop"));
				}else{
					inv.setItem(17, getDisabled("Stroboskop"));
				}
				
				if(Feuerwerk){					
					ArrayList<String> EinstellungFeuerwerk = new ArrayList<>();
					EinstellungFeuerwerk.add("§8» §7Einstellungen für die §eFeuerwerke");
					
					ItemStack feuerw = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
					ItemMeta feuer = feuerw.getItemMeta();
					feuer.setDisplayName("§4Einstellungen §8(§eFeuerwerk§8)");
					feuer.setLore(EinstellungFeuerwerk);
					feuerw.setItemMeta(feuer);
					
					inv.setItem(45, feuerw);
							
					inv.setItem(36, getEnabled("Feuerwerk"));
				}else{
					inv.setItem(45, PH4);					
					inv.setItem(36, getDisabled("Feuerwerk"));
				}
				
				if(welle){
					inv.setItem(37, getEnabled("Welle"));
				}else{
					inv.setItem(37, getDisabled("Welle"));
				}
				
				if(heartcannon){
					inv.setItem(38, getEnabled("Herzkannone"));
				}else{
					inv.setItem(38, getDisabled("Herzkannone"));
				}
				
				if(spiralen){
					inv.setItem(40, getEnabled("Spiralen"));
				}else{
					inv.setItem(40, getDisabled("Spiralen"));
				}
				
				if(flammen){
					inv.setItem(42, getEnabled("Flammen"));
				}else{
					inv.setItem(42, getDisabled("Flammen"));
				}
				
				if(rauch){
					inv.setItem(43, getEnabled("Rauch"));
				}else{
					inv.setItem(43, getDisabled("Rauch"));
				}
				
				ArrayList<String> I2E = new ArrayList<>();
				I2E.add(0, "");
				I2E.add(1, "§8► §7Damit kannst du das §eMusik §7Inventar öffnen");
				
				ItemStack I2 = new ItemStack(Material.RECORD_4, 1);
				ItemMeta I2M = I2.getItemMeta();
				I2M.setDisplayName("§eMusik");
				I2M.setLore(I2E);
				I2.setItemMeta(I2M);
				
				ArrayList<String> I3E = new ArrayList<>();
				I3E.add(0, "");
				I3E.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
				
				ArrayList<String> I3E1 = new ArrayList<>();
				I3E1.add(0, "");
				I3E1.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
				I3E1.add(2, "");
				I3E1.add(3, "§8➟ §cFeature§8: §eRechtsklick §7um alle §5Effekte §7zu §aaktivieren");
				
				ItemStack I3 = new ItemStack(Material.REDSTONE_BLOCK, 1);
				ItemMeta I3M = I3.getItemMeta();
				I3M.setDisplayName("§cAlle aktiven Effekte deaktivieren");
				if(!all.hasPermission("Rangsystem.SrModerator") && !all.hasPermission("Rangsystem.Administrator") && !all.hasPermission("Rangsystem.Owner")){
					I3M.setLore(I3E);
				}else{
					I3M.setLore(I3E1);
				}
				I3.setItemMeta(I3M);
		
				ArrayList<String> S = new ArrayList<>();
				S.add("§8» §7Rechts-/Linksklick um das Inventar zu schließen");
				
				ItemStack InvS = new ItemStack(Material.BARRIER);
				ItemMeta InvSM = InvS.getItemMeta();
				InvSM.setDisplayName("§4Schließen");
				InvSM.setLore(S);
				InvS.setItemMeta(InvSM);
				
				inv.setItem(48, I3);
				inv.setItem(49, InvS);
				inv.setItem(50, I2);
				
				ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
				SkullMeta N1M = (SkullMeta) N1.getItemMeta();
				N1M.setDisplayName("§8» §7Zur Seite §a2");
				N1M.setOwner("MHF_ArrowRight");
				N1.setItemMeta(N1M);
					inv.setItem(53, N1);
				
				inv.setItem(0, getItem("Lasershow", Arrays.asList(new String[] { "§7Aktiviert die Lasershow aus den Bühnenlichtern" }), Material.REDSTONE_LAMP_OFF));
				inv.setItem(1, getItem("Feuerwerk Explosion", Arrays.asList(new String[] { "§7Feuerwerk Explosionen rechts und links" }), Material.FIREBALL));
				inv.setItem(2, getItem("Blitze", Arrays.asList(new String[] { "§7Einschlagende Blitze erscheinen im Bühnenbereich" }), Material.NETHER_STAR));
				inv.setItem(4, getItem("Nebel", Arrays.asList(new String[] { "§7Der Bühnenbereich wird von Nebel geflutet" }), Material.SULPHUR));
				inv.setItem(6, ItemBuilder1.createItemWithLore(Material.GLOWSTONE_DUST, 1, "§eKonfetti", ItemBuilder1.getNewStringArray(new String[]{
						"§7In der Luft erscheint Konfetti",
				})));			
				inv.setItem(7, ItemBuilder1.createItemWithLore(Material.FLINT_AND_STEEL, 1, "§eFire Shots", ItemBuilder1.getNewStringArray(new String[]{
						"§7Flammenwerfer auf der Bühne",
						"",
						"§8(§4Achtung! §cFPS-Lastig§8)"
				})));
				inv.setItem(8, getItem("Stroboskop", Arrays.asList(new String[] { "§7Ändert periodisch die Helligkeit im Bühnenbereich abwechelnd" }), Material.REDSTONE_TORCH_ON));
				inv.setItem(27, getItem("Feuerwerk", Arrays.asList(new String[] { "§7Es erscheinen alle 5 Sekunden Feuerwerke vor der Bühne" }), Material.FIREWORK));
				inv.setItem(28, getItem("Welle", Arrays.asList(new String[] { "§7Es erscheinen alle 3 Sekunden Wellen vor der Bühne" }), Material.STRING));
				inv.setItem(29, getItem("Herzkannone", Arrays.asList(new String[] { "§7Es fliegen Herz-TNT's auf die Spieler" }), Material.TNT));
				inv.setItem(31, getItem("Spiralen", Arrays.asList(new String[] { "§7Spiralen um die Flammenwerfer" }), Material.REDSTONE));
				inv.setItem(33, getItem("Flammen", Arrays.asList(new String[] { "§7Flammen schießen aus dem Boden" }), Material.LAVA_BUCKET));
				inv.setItem(34, getItem("Rauch", Arrays.asList(new String[] { "§7Rauch taucht im Bühnenbereich auf" }), Material.COAL));

				all.openInventory(inv);
			}
		}
	}
	
	public static void openInv1(Player p){
				
		Inventory inv = Bukkit.createInventory(null, 54, "§bEffekte §8● §7Seite§8: §a1");
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§4✖");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < inv.getSize(); i++){
			inv.setItem(i, PH4);
		}
		
		if(Lasershow){			
			ArrayList<String> EinstellungLasershow = new ArrayList<>();
			EinstellungLasershow.add("§8» §7Einstellungen für die §eLasershow");
			
			ItemStack lasers = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
			ItemMeta laser = lasers.getItemMeta();
			laser.setDisplayName("§4Einstellungen §8(§eLasershow§8)");
			laser.setLore(EinstellungLasershow);
			lasers.setItemMeta(laser);
			
			inv.setItem(18, lasers);			
			inv.setItem(9, getEnabled("Lasershow"));
		}else{					
			inv.setItem(18, PH4);			
			inv.setItem(9, getDisabled("Lasershow"));
		}
		
		if(Explosion){
			inv.setItem(10, getEnabled("Explosion"));
		}else{				
			inv.setItem(10, getDisabled("Explosion"));						
		}
		
		if(Blitze){
			inv.setItem(11, getEnabled("Blitze"));		
		}else{
			inv.setItem(11, getDisabled("Blitze"));
		}
		
		if(Nebel){
			inv.setItem(13, getEnabled("Nebel"));
		}else{
			inv.setItem(13, getDisabled("Nebel"));
		}
		
		if(Konfetti){
			inv.setItem(15, getEnabled("Konfetti"));
		}else{
			inv.setItem(15, getDisabled("Konfetti"));
		}
		
		if(Flammenwerfer){
			ArrayList<String> EinstellungFlammenwerfer = new ArrayList<>();
			EinstellungFlammenwerfer.add("§8» §7Einstellungen für die §eFlammenwerfer");
			
			ItemStack flammenwerfer = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
			ItemMeta flammenwerferm = flammenwerfer.getItemMeta();
			flammenwerferm.setDisplayName("§4Einstellungen §8(§eFlammenwerfer§8)");
			flammenwerferm.setLore(EinstellungFlammenwerfer);
			flammenwerfer.setItemMeta(flammenwerferm);
			
			if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
				inv.setItem(25, flammenwerfer);
			}
			inv.setItem(16, getEnabled("Fire Shots"));
		}else{
			inv.setItem(16, getDisabled("Fire Shots"));
		}
		
		if(Stroboskop){
			inv.setItem(17, getEnabled("Stroboskop"));
		}else{
			inv.setItem(17, getDisabled("Stroboskop"));
		}
		
		if(Feuerwerk){		
			ArrayList<String> EinstellungFeuerwerk = new ArrayList<>();
			EinstellungFeuerwerk.add("§8» §7Einstellungen für §eFeuerwerk");
			
			ItemStack feuerw = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
			ItemMeta feuer = feuerw.getItemMeta();
			feuer.setDisplayName("§4Einstellungen §8(§eFeuerwerk§8)");
			feuer.setLore(EinstellungFeuerwerk);
			feuerw.setItemMeta(feuer);
			
			inv.setItem(45, feuerw);					
			inv.setItem(36, getEnabled("Feuerwerk"));
		}else{
			inv.setItem(45, PH4);			
			inv.setItem(36, getDisabled("Feuerwerk"));
		}
		
		if(welle){
			inv.setItem(37, getEnabled("Welle"));
		}else{
			inv.setItem(37, getDisabled("Welle"));
		}
		
		if(heartcannon){
			inv.setItem(38, getEnabled("Herzkannone"));
		}else{
			inv.setItem(38, getDisabled("Herzkannone"));
		}
		
		if(spiralen){
			inv.setItem(40, getEnabled("Spiralen"));
		}else{
			inv.setItem(40, getDisabled("Spiralen"));
		}
		
		if(flammen){
			inv.setItem(42, getEnabled("Flammen"));
		}else{
			inv.setItem(42, getDisabled("Flammen"));
		}
		
		if(rauch){
			inv.setItem(43, getEnabled("Rauch"));
		}else{
			inv.setItem(43, getDisabled("Rauch"));
		}
		
		ArrayList<String> I2E = new ArrayList<>();
		I2E.add(0, "");
		I2E.add(1, "§8► §7Damit kannst du das §eMusik §7Inventar öffnen");
		
		ItemStack I2 = new ItemStack(Material.RECORD_4, 1);
		ItemMeta I2M = I2.getItemMeta();
		I2M.setDisplayName("§eMusik");
		I2M.setLore(I2E);
		I2.setItemMeta(I2M);
		
		ArrayList<String> I3E = new ArrayList<>();
		I3E.add(0, "");
		I3E.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
		
		ArrayList<String> I3E1 = new ArrayList<>();
		I3E1.add(0, "");
		I3E1.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
		I3E1.add(2, "");
		I3E1.add(3, "§8➟ §cFeature§8: §eRechtsklick §7um alle §5Effekte §7zu §aaktivieren");
		
		ItemStack I3 = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta I3M = I3.getItemMeta();
		I3M.setDisplayName("§cAlle aktiven Effekte deaktivieren");
		if(!p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner")){
			I3M.setLore(I3E);
		}else{
			I3M.setLore(I3E1);
		}
		I3.setItemMeta(I3M);

		ArrayList<String> S = new ArrayList<>();
		S.add("§8» §7Rechts-/Linksklick um das Inventar zu schließen");
		
		ItemStack InvS = new ItemStack(Material.BARRIER);
		ItemMeta InvSM = InvS.getItemMeta();
		InvSM.setDisplayName("§4Schließen");
		InvSM.setLore(S);
		InvS.setItemMeta(InvSM);
		
		inv.setItem(48, I3);
		inv.setItem(49, InvS);
		inv.setItem(50, I2);
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zur Seite §a2");
		N1M.setOwner("MHF_ArrowRight");
		N1.setItemMeta(N1M);
			inv.setItem(53, N1);
		
		inv.setItem(0, getItem("Lasershow", Arrays.asList(new String[] { "§7Aktiviert die Lasershow aus den Bühnenlichtern" }), Material.REDSTONE_LAMP_OFF));
		inv.setItem(1, getItem("Feuerwerk Explosion", Arrays.asList(new String[] { "§7Feuerwerk Explosionen rechts und links" }), Material.FIREBALL));
		inv.setItem(2, getItem("Blitze", Arrays.asList(new String[] { "§7Einschlagende Blitze erscheinen im Bühnenbereich" }), Material.NETHER_STAR));
		inv.setItem(4, getItem("Nebel", Arrays.asList(new String[] { "§7Der Bühnenbereich wird von Nebel geflutet" }), Material.SULPHUR));
		inv.setItem(6, ItemBuilder1.createItemWithLore(Material.GLOWSTONE_DUST, 1, "§eKonfetti", ItemBuilder1.getNewStringArray(new String[]{
				"§7In der Luft erscheint Konfetti",
		})));			
		inv.setItem(7, ItemBuilder1.createItemWithLore(Material.FLINT_AND_STEEL, 1, "§eFire Shots", ItemBuilder1.getNewStringArray(new String[]{
				"§7Flammenwerfer auf der Bühne",
				"",
				"§8(§4Achtung! §cFPS-Lastig§8)"
		})));
		inv.setItem(8, getItem("Stroboskop", Arrays.asList(new String[] { "§7Ändert periodisch die Helligkeit im Bühnenbereich abwechelnd" }), Material.REDSTONE_TORCH_ON));
		inv.setItem(27, getItem("Feuerwerk", Arrays.asList(new String[] { "§7Es erscheinen alle 5 Sekunden Feuerwerke vor der Bühne" }), Material.FIREWORK));
		inv.setItem(28, getItem("Welle", Arrays.asList(new String[] { "§7Es erscheinen alle 3 Sekunden Wellen vor der Bühne" }), Material.STRING));
		inv.setItem(29, getItem("Herzkannone", Arrays.asList(new String[] { "§7Es fliegen Herz-TNT's auf die Spieler" }), Material.TNT));
		inv.setItem(31, getItem("Spiralen", Arrays.asList(new String[] { "§7Spiralen um die Flammenwerfer" }), Material.REDSTONE));
		inv.setItem(33, getItem("Flammen", Arrays.asList(new String[] { "§7Flammen schießen aus dem Boden" }), Material.LAVA_BUCKET));
		inv.setItem(34, getItem("Rauch", Arrays.asList(new String[] { "§7Rauch taucht im Bühnenbereich auf" }), Material.COAL));

		p.openInventory(inv);
	}
	
	public static void openInv22(){	
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a2")){				
				Inventory inv = Bukkit.createInventory(null, 54, "§bEffekte §8● §7Seite§8: §a2");
				
				ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
				ItemMeta PH4M = PH4.getItemMeta();
				PH4M.setDisplayName("§4✖");
				PH4.setItemMeta(PH4M);
				
				for(int i = 0; i < inv.getSize(); i++){
					inv.setItem(i, PH4);
				}
					
				ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
				SkullMeta N1M = (SkullMeta) N1.getItemMeta();
				N1M.setDisplayName("§8» §7Zur Seite §a1");
				N1M.setOwner("MHF_ArrowLeft");
				N1.setItemMeta(N1M);
					inv.setItem(53, N1);
				
				ArrayList<String> I2E = new ArrayList<>();
				I2E.add(0, "");
				I2E.add(1, "§8► §7Damit kannst du das §eMusik §7Inventar öffnen");
				
				ItemStack I2 = new ItemStack(Material.RECORD_4, 1);
				ItemMeta I2M = I2.getItemMeta();
				I2M.setDisplayName("§eMusik");
				I2M.setLore(I2E);
				I2.setItemMeta(I2M);
				
				ArrayList<String> I3E = new ArrayList<>();
				I3E.add(0, "");
				I3E.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
				
				ArrayList<String> I3E1 = new ArrayList<>();
				I3E1.add(0, "");
				I3E1.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
				I3E1.add(2, "");
				I3E1.add(3, "§8➟ §cFeature§8: §eRechtsklick §7um alle §5Effekte §7zu §aaktivieren");
				
				ItemStack I3 = new ItemStack(Material.REDSTONE_BLOCK, 1);
				ItemMeta I3M = I3.getItemMeta();
				I3M.setDisplayName("§cAlle aktiven Effekte deaktivieren");
				if(!all.hasPermission("Rangsystem.SrModerator") && !all.hasPermission("Rangsystem.Administrator") && !all.hasPermission("Rangsystem.Owner")){
					I3M.setLore(I3E);
				}else{
					I3M.setLore(I3E1);
				}
				I3.setItemMeta(I3M);
		
				ArrayList<String> S = new ArrayList<>();
				S.add("§8» §7Rechts-/Linksklick um das Inventar zu schließen");
				
				ItemStack InvS = new ItemStack(Material.BARRIER);
				ItemMeta InvSM = InvS.getItemMeta();
				InvSM.setDisplayName("§4Schließen");
				InvSM.setLore(S);
				InvS.setItemMeta(InvSM);
				
				inv.setItem(48, I3);
				inv.setItem(49, InvS);
				inv.setItem(50, I2);
				
				all.openInventory(inv);
			}
		}
	}
	
	public static void openInv2(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 54, "§bEffekte §8● §7Seite§8: §a2");
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§4✖");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < inv.getSize(); i++){
			inv.setItem(i, PH4);
		}
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zur Seite §a1");
		N1M.setOwner("MHF_ArrowLeft");
		N1.setItemMeta(N1M);
			inv.setItem(53, N1);
			
		ArrayList<String> I2E = new ArrayList<>();
		I2E.add(0, "");
		I2E.add(1, "§8► §7Damit kannst du das §eMusik §7Inventar öffnen");
		
		ItemStack I2 = new ItemStack(Material.RECORD_4, 1);
		ItemMeta I2M = I2.getItemMeta();
		I2M.setDisplayName("§eMusik");
		I2M.setLore(I2E);
		I2.setItemMeta(I2M);
		
		ArrayList<String> I3E = new ArrayList<>();
		I3E.add(0, "");
		I3E.add(1, "§8► §7Damit kannst du alle §aaktiven §bEffekte §7deaktivieren");
		
		ItemStack I3 = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta I3M = I3.getItemMeta();
		I3M.setDisplayName("§cAlle aktiven Effekte deaktivieren");
		I3M.setLore(I3E);
		I3.setItemMeta(I3M);

		ArrayList<String> S = new ArrayList<>();
		S.add("§8» §7Rechts-/Linksklick um das Inventar zu schließen");
		
		ItemStack InvS = new ItemStack(Material.BARRIER);
		ItemMeta InvSM = InvS.getItemMeta();
		InvSM.setDisplayName("§4Schließen");
		InvSM.setLore(S);
		InvS.setItemMeta(InvSM);
		
		inv.setItem(48, I3);
		inv.setItem(49, InvS);
		inv.setItem(50, I2);
	
		if(DiscoBootsTeammitglieder){
			if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
				inv.setItem(43, getEnabled("DiscoschuheTeammitglieder"));
			}
		}else{
			if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
				inv.setItem(43, getDisabled("DiscoschuheTeammitglieder"));
			}
		}
		
		if(DiscoBootsAlle){
			if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
				inv.setItem(44, getEnabled("DiscoschuheAlle"));
			}
		}else{
			if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
				inv.setItem(44, getDisabled("DiscoschuheAlle"));
			}
		}
			
		if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
			
			ArrayList<String> Lore1 = new ArrayList<>();
			Lore1.add("§eDisco-Schuhe §7für §aalle §7Teammitglieder");
			
			ItemStack LB1 = new ItemStack(Material.LEATHER_BOOTS, 1);
			ItemMeta LB1Meta = LB1.getItemMeta();
			LB1Meta.setDisplayName("§eDisco-Schuhe §8» §cTeammitglieder");
			LB1Meta.setLore(Lore1);
			LB1.setItemMeta(LB1Meta);
			
			ArrayList<String> Lore2 = new ArrayList<>();
			Lore2.add("§eDisco-Schuhe §7für §aalle §7Spieler");
			
			ItemStack LB2 = new ItemStack(Material.LEATHER_BOOTS, 1);
			ItemMeta LB2Meta = LB2.getItemMeta();
			LB2Meta.setDisplayName("§eDisco-Schuhe §8» §aAlle");
			LB2Meta.setLore(Lore2);
			LB2.setItemMeta(LB2Meta);
			
			inv.setItem(34, LB1);
			inv.setItem(35, LB2);			

		}
		
		p.openInventory(inv);
	}
	
	public static void loadConfig(Player p){
	
		try{
			Settings1.load(File1);
		}catch(IOException e){
			e.printStackTrace();
		}catch(InvalidConfigurationException e){
			e.printStackTrace();
		}
		
		if(Settings1.getString("Config.Lasershow").equals("true")){
			Lasershow = true;
		}else{
			Lasershow = false;
		}
		
		if(Settings1.getString("Config.Explosion").equals("true")){
			Explosion = true;
		}else{
			Explosion = false;
		}		
		
		if(Settings1.getString("Config.Blitze").equals("true")){
			Blitze = true;
		}else{
			Blitze = false;
		}		
		
		if(Settings1.getString("Config.Nebel").equals("true")){
			Nebel = true;
		}else{
			Nebel = false;
		}		
		
		if(Settings1.getString("Config.Konfetti").equals("true")){
			Konfetti = true;
		}else{
			Konfetti = false;
		}		
		
		if(Settings1.getString("Config.Fire Shots").equals("true")){
			Flammenwerfer = true;
		}else{
			Flammenwerfer = false;
		}
		
		if(Settings1.getString("Config.Stroboskop").equals("true")){
			Stroboskop = true;
		}else{
			Stroboskop = false;
		}	
		
		if(Settings1.getString("Config.Feuerwerk").equals("true")){
			Feuerwerk = true;
		}else{
			Feuerwerk = false;
		}
		
		if(Settings1.getString("Config.Welle").equals("true")){
			welle = true;
		}else{
			welle = false;
		}
		
		if(Settings1.getString("Config.Heartcannon").equals("true")){
			heartcannon = true;
		}else{
			heartcannon = false;
		}
		
		if(Settings1.getString("Config.Spiralen").equals("true")){
			spiralen = true;
		}else{
			spiralen = false;
		}
		
		if(Settings1.getString("Config.Flammen").equals("true")){
			flammen = true;
		}else{
			flammen = false;
		}
		
		if(Settings1.getString("Config.Rauch").equals("true")){
			rauch = true;
		}else{
			rauch = false;
		}
		
		if(Settings1.getString("Config.DiscoschuheTeammitglieder").equals("true")){
			DiscoBootsTeammitglieder = true;
		}else{
			DiscoBootsTeammitglieder = false;
		}
		
		if(Settings1.getString("Config.DiscoschuheAlle").equals("true")){
			DiscoBootsAlle = true;
		}else{
			DiscoBootsAlle = false;
		}
		
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
