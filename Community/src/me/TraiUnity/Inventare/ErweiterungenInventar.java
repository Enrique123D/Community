package me.TraiUnity.Inventare;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ErweiterungenInventar {

	public static void OpenErweiterungen1(Player p) {
				
		Inventory erweiterungen2 = Bukkit.createInventory(null, 27, "§8● §aErweiterungen §8●"); 
		
		ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta PH4M = PH4.getItemMeta();
		PH4M.setDisplayName("§4✖");
		PH4.setItemMeta(PH4M);
		
		for(int i = 0; i < erweiterungen2.getSize(); i++){
			erweiterungen2.setItem(i, PH4);
		}
		
		ArrayList<String> ServerE = new ArrayList<String>();
		ServerE.add(0, "");
		ServerE.add(1, "§7Hier kannst du Einstellungen");
		ServerE.add(2, "§7des Server vornehmen");
		
		ItemStack SE = new ItemStack(Material.COMMAND);
		ItemMeta SEM = SE.getItemMeta();
		SEM.setDisplayName("§8» §eServereinstellungen");
		SEM.setLore(ServerE);
		SE.setItemMeta(SEM);
		
		erweiterungen2.setItem(10, SE);
		
		ArrayList<String> SetLoc = new ArrayList<String>();
		SetLoc.add(0, "");
		SetLoc.add(1, "§7Hier kannst du alle Möglichen");
		SetLoc.add(2, "§7Spawnpunkte setzen");
		
		ItemStack SetL = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta SetLoM = SetL.getItemMeta();
		SetLoM.setDisplayName("§8» §eLocations setzen");
		SetLoM.setLore(SetLoc);
		SetL.setItemMeta(SetLoM);
		
		erweiterungen2.setItem(12, SetL);
		
		ArrayList<String> Schild = new ArrayList<String>();
		Schild.add(0, "");
		Schild.add(1, "§7Mit diesem Item kannst");
		Schild.add(2, "§7du einen §5Schutz §7um dich bilden");
		
		ItemStack SchutzS = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta SchutzSM = SchutzS.getItemMeta();
		SchutzSM.setDisplayName("§8» §5Schutzschild");
		SchutzSM.setLore(Schild);
		SchutzS.setItemMeta(SchutzSM);
		
		erweiterungen2.setItem(14, SchutzS);
		
		ArrayList<String> Troll = new ArrayList<String>();
		Troll.add(0, "");
		Troll.add(1, "§7Mit diesem Item kannst");
		Troll.add(2, "§7du ein §fTroll-Inventar §7öffnen");
		
		ItemStack Trolli = new ItemStack(Material.COOKIE);
		ItemMeta TrolliM = Trolli.getItemMeta();
		TrolliM.setDisplayName("§8» §fTroll-Menü");
		TrolliM.setLore(Troll);
		Trolli.setItemMeta(TrolliM);
		
		erweiterungen2.setItem(16, Trolli);
		
		ArrayList<String> Entf = new ArrayList<String>();
		Entf.add(0, "");
		Entf.add(1, "§7Entfernt das §eItem §7auf §cSlot 9");
		
		ItemStack entfernen = new ItemStack(Material.TNT, 1);
		ItemMeta entfernenM = entfernen.getItemMeta();
		entfernenM.setDisplayName("§8» §eItem entfernen");
		entfernenM.setLore(Entf);
		entfernen.setItemMeta(entfernenM);
		
		erweiterungen2.setItem(26, entfernen);
		
		p.openInventory(erweiterungen2);
	}
}
