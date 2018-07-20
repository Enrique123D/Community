package me.TraiUnity.Inventare;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ServereinstellungsInventar {

	@SuppressWarnings("deprecation")
	public static void openServEInv1(Player p) {
		
		Inventory ServE1 = Bukkit.createInventory(null, 54, "§eServer §8● §7Seite§8: §a1");
		
		ItemStack N1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta N1M = (SkullMeta) N1.getItemMeta();
		N1M.setDisplayName("§8» §7Zurück");
		N1M.setOwner("MHF_ArrowLeft");
		N1.setItemMeta(N1M);
			ServE1.setItem(52, N1);
		
		ItemStack N = new ItemStack(Material.ARROW, 1);
		ItemMeta NM = N.getItemMeta();
		NM.setDisplayName("§8» §7Zur Seite §a2");
		N.setItemMeta(NM);
			ServE1.setItem(53, N);
		
		ArrayList<String> IA = new ArrayList<>();
		IA.add(0, "");
		IA.add(1, "§8► §7Damit kannst du die §fWhitelist §7anschalten,");
		IA.add(2, "   §7somit werden auch alle §eSpieler §7gekickt,");
		IA.add(3, "   §7die §c§nnicht§7 auf der §fWhitelist §7hinzugefügt sind");
		
		ItemStack I = new ItemStack(Material.WOOL, 1, (short)5);
		ItemMeta IM = I.getItemMeta();
		IM.setDisplayName("§8» §7Whitelist §aAn");
		IM.setLore(IA);
		I.setItemMeta(IM);
			ServE1.setItem(10, I);
		
		ArrayList<String> I1A = new ArrayList<>();
		I1A.add(0, "");
		I1A.add(1, "§8► §7Damit kannst du die §fWhitelist §7ausschalten,");
		I1A.add(2, "   §7somit können alle §eSpieler §7die §5Traiunity");
		I1A.add(3, "   §7wieder betreten");
			
		ItemStack I1 = new ItemStack(Material.WOOL, 1, (short)14);
		ItemMeta I1M = I1.getItemMeta();
		I1M.setDisplayName("§8» §7Whitelist §cAus");
		I1M.setLore(I1A);
		I1.setItemMeta(I1M);
			ServE1.setItem(11, I1);
			
		if(Bukkit.hasWhitelist()) {
			ArrayList<String> Fe = new ArrayList<>();
			Fe.add(0, "");
			Fe.add(1, "§8► §7Hier kannst du sehen, ob die §fWhitelist §7an ist");
					
			ItemStack F = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
			ItemMeta FM = F.getItemMeta();
			FM.setDisplayName("§8» §7Status§8: §aAn");
			FM.setLore(Fe);
			F.setItemMeta(FM);
			
			ServE1.setItem(12, F);
		}else{	
			ArrayList<String> Fe = new ArrayList<>();
			Fe.add(0, "");
			Fe.add(1, "§8► §7Hier kannst du sehen, ob die §fWhitelist §7an ist");
				
			ItemStack F = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
			ItemMeta FM = F.getItemMeta();
			FM.setDisplayName("§8» §7Status§8: §cAus");
			FM.setLore(Fe);
			F.setItemMeta(FM);
			
			ServE1.setItem(12, F);
		}
		
		ArrayList<String> I3A = new ArrayList<>();
		I3A.add(0, "");
		I3A.add(1, "§8► §7Damit kannst du den Server stoppen");
		I3A.add(2, "   §4Achtung! §cDer Server muss dann von einem");
		I3A.add(3, "   §cAdmin/§4Owner §cgestartet werden");
			
		ItemStack I3 = new ItemStack(351, 1, (short)8);
		ItemMeta I3M = I3.getItemMeta();
		I3M.setDisplayName("§8» §7Server stoppen");
		I3M.setLore(I3A);
		I3.setItemMeta(I3M);
			ServE1.setItem(15, I3);
			
		ArrayList<String> I4A = new ArrayList<>();
		I4A.add(0, "");
		I4A.add(1, "§8► §7Damit kannst du den Server §creloaden");
		I4A.add(2, "   §7Mit dem §cReloaden §7des Servers werden");
		I4A.add(3, "   §7alle §aPlugins§7/§fDaten §7neu geladen");
		
		ItemStack I4 = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta I4M = I4.getItemMeta();
		I4M.setDisplayName("§8» §7Server reloaden");
		I4M.setLore(I4A);
		I4.setItemMeta(I4M);
			ServE1.setItem(16, I4);
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		ArrayList<String> I5A = new ArrayList<>();
		I5A.add(0, "");
		I5A.add(1, "§8► §7Hier siehst du alle aktuellen");
		I5A.add(2, "   §7Inventare und deren Funktionen");
		I5A.add(3, "   §7Da sind alle Inventare §8➟");
		
		ItemStack I5 = new ItemStack(Material.PAPER, 1);
		ItemMeta I5M = I5.getItemMeta();
		I5M.setDisplayName("§8» §fInformation");
		I5M.setLore(I5A);
		I5.setItemMeta(I5M);
			ServE1.setItem(45, I5);
			
		ArrayList<String> I6A = new ArrayList<>();
		I6A.add(0, "");
		I6A.add(1, "§8► §7Hiermit kannst du");
		I6A.add(2, "   §7auf das §5Effekte §7Menü zugreifen");
			
		ItemStack I6 = new ItemStack(Material.FIREWORK, 1);
		ItemMeta I6M = I6.getItemMeta();
		I6M.setDisplayName("§8» §5Effekte");
		I6M.setLore(I6A);
		I6.setItemMeta(I6M);
			ServE1.setItem(46, I6);
			
		ArrayList<String> I7A = new ArrayList<>();
		I7A.add(0, "");
		I7A.add(1, "§8► §7Hiermit kannst du");
		I7A.add(2, "   §7auf das §eMusik §7Menü zugreifen");
				
		ItemStack I7 = new ItemStack(Material.RECORD_4, 1);
		ItemMeta I7M = I7.getItemMeta();
		I7M.setDisplayName("§8» §eMusik");
		I7M.setLore(I7A);
		I7.setItemMeta(I7M);
			ServE1.setItem(47, I7);
			
		ArrayList<String> I8A = new ArrayList<>();
		I8A.add(0, "");
		I8A.add(1, "§8► §7Hiermit kannst du");
		I8A.add(2, "   §7auf das §9Teamübersicht §7Menü zugreifen");
				
		ItemStack I8 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta I8M = (SkullMeta) I8.getItemMeta();
		I8M.setDisplayName("§8» §9Teamübersicht");
		I8M.setLore(I8A);
		I8M.setOwner(p.getName());
		I8.setItemMeta(I8M);
			ServE1.setItem(48, I8);

		ArrayList<String> I9A = new ArrayList<>();
		I9A.add(0, "");
		I9A.add(1, "§8► §7Hiermit kannst du");
		I9A.add(2, "   §7die §cSchwierigkeit §7des Servers einstellen");
					
		ItemStack I9 = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta I9M = I9.getItemMeta();
		I9M.setDisplayName("§8» §4Schwierigkeit");
		I9M.setLore(I9A);
		I9.setItemMeta(I9M);
			ServE1.setItem(50, I9);
			
		p.openInventory(ServE1);
		
	}
	
	public static void openServEInv2(Player p) {
		
		Inventory ServE2 = Bukkit.createInventory(null, 54, "§eServer §8● §7Seite§8: §a2");
	
		ItemStack N = new ItemStack(Material.ARROW, 1);
		ItemMeta NM = N.getItemMeta();
		NM.setDisplayName("§8» §7Zur Seite §a1");
		N.setItemMeta(NM);
			ServE2.setItem(45, N);
		
		ItemStack N1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
		ItemMeta N1M = N1.getItemMeta();
		N1M.setDisplayName("§4✖");
		N1.setItemMeta(N1M);
			ServE2.setItem(36, N1);
			ServE2.setItem(37, N1);
			ServE2.setItem(46, N1);
		
		p.openInventory(ServE2);

	}	
}
