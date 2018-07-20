package me.TraiUnity.MusikMenu;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.TraiUnity.Main;

public class InteractEvent2 implements Listener {

	private Settings2 s2;
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onIntEvent2(PlayerInteractEvent e){
	
		Player p = e.getPlayer();
				
	    if (p.hasPermission("Rangsystem.Premium+") || p.hasPermission("Rangsystem.Freund") || p.hasPermission("Rangsystem.Streamer") || p.hasPermission("Rangsystem.Youtuber")
	    		|| p.hasPermission("Rangsystem.Builder") || p.hasPermission("Rangsystem.ProbeSupporter") || p.hasPermission("Rangsystem.Supporter") || p.hasPermission("Rangsystem.Moderator")
	    		|| p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Content") || p.hasPermission("Rangsystem.JrDeveloper") || p.hasPermission("Rangsystem.Developer")
	    		|| p.hasPermission("Rangsystem.SrDeveloper") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
	    	try {
	    		if(!(e.getAction() != Action.RIGHT_CLICK_BLOCK)) {
	    			if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
	    				String loc = e.getClickedBlock().getLocation().toString();
	    				if(FileManager2.Button2.getString(loc) != null){
	    					s2.openMusik1(p);
	    				}
	    			}
	    		}
	    	}catch(Exception ex) {}
	    }
	    
	    if (!p.hasPermission("Rangsystem.Premium+") && !p.hasPermission("Rangsystem.Freund") && !p.hasPermission("Rangsystem.Streamer") && !p.hasPermission("Rangsystem.Youtuber")
	    		&& !p.hasPermission("Rangsystem.Builder") && !p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator")
	    		&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer")
	    		&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner")) {
	    	try {
	    		if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
	    			String loc = e.getClickedBlock().getLocation().toString();
	    			if(FileManager2.Button2.getString(loc) != null){
    					p.sendMessage(Main.commip + "�cDu ben�tigst mindestens den �6Premium�c+ �cRang,");
    					p.sendMessage(Main.commip + "�cum diesen �fKnopf �cbenutzen zu d�rfen.");
    					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1F, 1F);
	    			}
	    		}
	    	}catch(Exception ex) {}
	    }
	}
}