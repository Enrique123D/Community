package me.TraiUnity.Listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TraiUnity.CPSTester;
import me.TraiUnity.Main;
import me.TraiUnity.PlayerCPS;
import me.TraiUnity.Inventare.ErweiterungenInventar;
import me.TraiUnity.Inventare.TeleporterInventar;
import me.TraiUnity.Inventare.TrollInventar;
import me.TraiUnity.Screenbox.Screenbox;

public class PlayerInteractListener implements Listener{
		
	public static HashMap<String, Location> Checkpoint = new HashMap<>();
	public static HashMap<String, Integer> x = new HashMap<>();
	public static HashMap<String, Integer> z = new HashMap<>();
	public static HashMap<Player, ItemStack[]> oldinv = new HashMap<>();
    
	public static ArrayList<Player> imRS = new ArrayList<>();	
	public static ArrayList<PlayerCPS> playersCps = new ArrayList<>();
	
	boolean schedulerNotActive = true;
	
	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onInteractItem(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		try {			
			if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK
					|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				boolean playerExist = false;
				
				for(PlayerCPS cps : playersCps){
					if(cps.getPlayer().equals(p)){
						playerExist = true;
						break;
					}
				}
				if(!playerExist){
					PlayerCPS playerCPS = new PlayerCPS(p);
					playersCps.add(playerCPS);
				}
				if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
					for(PlayerCPS pCps : playersCps){
						if(pCps.getPlayer().equals(p)){
							playersCps.remove(pCps);
							pCps.addRight();
							playersCps.add(pCps);
							break;
						}
					}
				}else if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
					for(PlayerCPS pCps : playersCps){
						if(pCps.getPlayer().equals(p)){
							playersCps.remove(pCps);
							pCps.addLeft();
							playersCps.add(pCps);
							break;
						}
					}
				}
				if(schedulerNotActive){
					CPSTester.cps();
					schedulerNotActive = false;
				}
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§fTroll-Menü §8● §7Rechtsklick")) {
					TrollInventar.openTrollInv1(p);
				}
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cBox verlassen §8● §7Rechtsklick")) {
					for(Screenbox box : Main.boxen.values()){
						if(box.isInWarteschlange(p)){
							box.removeFromWarteschlange(p);
							p.sendMessage(Main.screenb + "§7Du wurdest aus der Warteschlange von §e" + box.getInbox().getPlayerListName() + " §7entfernt.");
							return;
						}
						if(box.getInbox() == p){
							box.removeInbox(false);
							return;
						}
					}
				}
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6VIP Bereich §8● §7Rechtsklick")) {
					World w6 = Bukkit.getWorld(Main.vip.getString("VIP.World"));
					double x6 = Main.vip.getDouble("VIP.X");
					double y6 = Main.vip.getDouble("VIP.Y");
					double z6 = Main.vip.getDouble("VIP.Z");
					float yaw6 = (float)Main.vip.getDouble("VIP.Yaw");
					float pitch6 = (float)Main.vip.getDouble("VIP.Pitch");
					Location vip = new Location(w6, x6, y6, z6, yaw6, pitch6);
					
					p.teleport(vip);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
					p.sendTitle("§6VIP §8● §6Bereich", "");
				}				
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Bühne §8● §7Rechtsklick")) {
					World w7 = Bukkit.getWorld(Main.buen.getString("Bühne.World"));
					double x7 = Main.buen.getDouble("Bühne.X");
					double y7 = Main.buen.getDouble("Bühne.Y");
					double z7 = Main.buen.getDouble("Bühne.Z");
					float yaw7 = (float)Main.buen.getDouble("Bühne.Yaw");
					float pitch7 = (float)Main.buen.getDouble("Bühne.Pitch");
					Location buehne = new Location(w7, x7, y7, z7, yaw7, pitch7);
					
					p.teleport(buehne);
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
					p.sendTitle("§8● §5Bühne §8●", "");
				}				
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){		
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeleporter §8● §7Rechtsklick")){				
					TeleporterInventar.OpenTeleporter(p);
				}
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){		
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aErweiterungen §8● §7Rechtsklick")){
						ErweiterungenInventar.OpenErweiterungen1(p);
				}
			}
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle Spieler §8● §7Rechtsklick") | p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Nur VIPs §8● §7Rechtsklick") | p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cKeine Spieler §8● §7Rechtsklick")){
					e.setCancelled(true);
					
					Inventory SpV = Bukkit.createInventory(null, InventoryType.BREWING, "§8● §eSpieler verstecken §8●");
					
					ItemStack I0 = new ItemStack(Material.PAPER, 1);
					ItemMeta I0M = I0.getItemMeta();
					I0M.setDisplayName("§eWen willst du verstecken?");
					I0.setItemMeta(I0M);
					
					ItemStack I1 = new ItemStack(351, 1, (short)10);
					ItemMeta I1M = I1.getItemMeta();
					I1M.setDisplayName("§8» §aAlle Spieler anzeigen");
					I1.setItemMeta(I1M);
					
					ItemStack I2 = new ItemStack(351, 1, (short)5);
					ItemMeta I2M = I2.getItemMeta();
					I2M.setDisplayName("§8» §5Nur VIPs anzeigen");
					I2.setItemMeta(I2M);					
					
					ItemStack I3 = new ItemStack(351, 1, (short)8);
					ItemMeta I3M = I3.getItemMeta();
					I3M.setDisplayName("§8» §cKeine Spieler anzeigen");
					I3.setItemMeta(I3M);					
					
					SpV.setItem(0, I1);
					SpV.setItem(1, I2);
					SpV.setItem(2, I3);
					
					SpV.setItem(3, I0);
					
					p.openInventory(SpV);
					
				}
			}		
		}catch(Exception ex) {}
	}

	public ItemStack createItem(Material m, int anzahl, int shortid, String Displayname){
		ItemStack i = new ItemStack(m, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(Displayname);
		i.setItemMeta(im);
		
		return i;
	}
	
    public static void hacks(Player p, Double str){
        str = (double) (Math.round((int)(str * 100)) / 100);
        
        for(Player online : Bukkit.getOnlinePlayers()){
            if(online.getName().equalsIgnoreCase("Enrique123D")){
                online.sendMessage(Main.commip + p.getDisplayName() + " §7nutzt evtl. §eAutoklicker§7! §cCPS§8: §e" + str);
            }
        }
    }
}
