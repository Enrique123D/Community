package me.TraiUnity.Secrets;

import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.TraiUnity.Main;

public class SecretBuild implements Listener{
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		if(Secret.secretExists(e.getBlock().getLocation())){
			if(e.getBlockPlaced().getType().equals(Material.SKULL) || e.getBlockPlaced().getType().equals(Material.SKULL_ITEM)){
				Skull s = (Skull) e.getBlockPlaced().getState();
				Secret.setSecretOwner(s.getOwner(), e.getBlockPlaced().getLocation());
//				s.setOwner("MHF_Question");
//				s.update();
				e.getPlayer().sendMessage(Main.secret + "§7Secret gesetzt! Owner§8: §e" + s.getOwner());
			}else{
				e.getPlayer().sendMessage(Main.secret + "§cHier ist bereits ein Secret!");
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(Secret.secretExists(e.getBlock().getLocation())){
			if(e.getBlock().getType().equals(Material.SKULL) || e.getBlock().getType().equals(Material.SKULL_ITEM)){
				Secret.removeLocation(e.getBlock().getLocation());
				e.getPlayer().sendMessage(Main.commip + "§cSecret gelöscht!");
			}
		}
	}
}
