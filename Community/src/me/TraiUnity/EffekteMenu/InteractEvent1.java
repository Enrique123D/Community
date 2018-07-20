package me.TraiUnity.EffekteMenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.TraiUnity.Main;

public class InteractEvent1 implements Listener {

	private Settings1 s;
	
	@SuppressWarnings({ "static-access" })
	@EventHandler
	public void onIntEvent1(PlayerInteractEvent e){
	
		Player p = e.getPlayer();
		
	    if (p.hasPermission("Rangsystem.Premium+") || p.hasPermission("Rangsystem.Freund") || p.hasPermission("Rangsystem.Streamer") || p.hasPermission("Rangsystem.Youtuber")
	    		|| p.hasPermission("Rangsystem.Builder") || p.hasPermission("Rangsystem.ProbeSupporter") || p.hasPermission("Rangsystem.Supporter") || p.hasPermission("Rangsystem.Moderator")
	    		|| p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Content") || p.hasPermission("Rangsystem.JrDeveloper") || p.hasPermission("Rangsystem.Developer")
	    		|| p.hasPermission("Rangsystem.SrDeveloper") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
	    	try{
	    		if(!(e.getAction() != Action.RIGHT_CLICK_BLOCK)) {
	    			if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
	    				String loc = e.getClickedBlock().getLocation().toString();
	    				if(FileManager1.Button1.getString(loc) != null){
	    					if((Bukkit.getOnlinePlayers().size()) <= 150) {	    						
    			    			for(Player all1 : Bukkit.getOnlinePlayers()){
    		  			  			InventarClick1Listener.s.loadConfig(all1);	    			    			
    		  			  		}	    						
	    						s.openInv1(p);
	    					}else{
	    						p.closeInventory();
	    						p.sendMessage(Main.commip + "§cFehler! Es sind mehr als §e150 §cSpieler online.");
	    						p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1F, 1F);
	    					}
	    				}
	    			}
	    		}
	    	}catch(Exception npex){}
	    }
	    
	    if (!p.hasPermission("Rangsystem.Premium+") && !p.hasPermission("Rangsystem.Freund") && !p.hasPermission("Rangsystem.Streamer") && !p.hasPermission("Rangsystem.Youtuber")
	    		&& !p.hasPermission("Rangsystem.Builder") && !p.hasPermission("Rangsystem.ProbeSupporter") && !p.hasPermission("Rangsystem.Supporter") && !p.hasPermission("Rangsystem.Moderator")
	    		&& !p.hasPermission("Rangsystem.SrModerator") && !p.hasPermission("Rangsystem.Content") && !p.hasPermission("Rangsystem.JrDeveloper") && !p.hasPermission("Rangsystem.Developer")
	    		&& !p.hasPermission("Rangsystem.SrDeveloper") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner")) {
	    	try{
	    		if(!(e.getAction() != Action.RIGHT_CLICK_BLOCK)) {
	    			if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
	    				String loc = e.getClickedBlock().getLocation().toString();
	    				if(FileManager1.Button1.getString(loc) != null){
	    					p.sendMessage(Main.commip + "§cDu benötigst mindestens den §6Premium§c+ §cRang,");
	    					p.sendMessage(Main.commip + "§cum diesen §fKnopf §cbenutzen zu dürfen.");
	    					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1F, 1F);
	    				}
	    			}
	    		}
	    	}catch(Exception npex){}	    	
	    }	    
	}
}
