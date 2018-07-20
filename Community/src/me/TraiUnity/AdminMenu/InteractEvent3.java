package me.TraiUnity.AdminMenu;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.TraiUnity.Main;
import me.TraiUnity.Inventare.ServereinstellungsInventar;

public class InteractEvent3 implements Listener {
	
	@EventHandler
	public void onIntEvent3(PlayerInteractEvent e){
	
		Player p = e.getPlayer();
				
	    if (p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
	    	try {
	    		if(!(e.getAction() != Action.RIGHT_CLICK_BLOCK)) {
	    			if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
	    				String loc = e.getClickedBlock().getLocation().toString();
	    				if(FileManager3.Button3.getString(loc) != null){
	    					ServereinstellungsInventar.openServEInv1(p);
	    				}
	    			}
	    		}
	    	}catch(Exception ex) {}
	    }
	    
	    if (!p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner")) {	    
	    	try {
	    		if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
	    			String loc = e.getClickedBlock().getLocation().toString();
	    			if(FileManager3.Button3.getString(loc) != null){
    					p.sendMessage(Main.commip + "§cDu benötigst mindestens den §9SrModerator §cRang,");
    					p.sendMessage(Main.commip + "§cum diesen §fKnopf §cbenutzen zu dürfen.");
    					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1F, 1F);
	    			}
	    		}
	    	}catch(Exception ex) {}
	    }
	}
}