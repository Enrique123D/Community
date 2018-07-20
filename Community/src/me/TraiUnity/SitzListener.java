package me.TraiUnity;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.material.Stairs;
import org.bukkit.scheduler.BukkitRunnable;

public class SitzListener implements Listener {

	public static HashMap<Arrow, Player> sitting = new HashMap<>();
	
	@EventHandler
	public void onVehicleExit(VehicleExitEvent e){
		
	}
	
	@SuppressWarnings("incomplete-switch")
	@EventHandler
	public void onSitzInteract(PlayerInteractEvent e){
	
		Player p = e.getPlayer();
		
		try{
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(e.getClickedBlock().getType().toString().endsWith("STAIRS")){
					Block block = e.getClickedBlock();
										
					if(sitting.get(block) != null){
						e.setCancelled(true);
						p.sendMessage(Main.commip + "§cHier sitzt bereits jemand!");
						return;
					}
					
					if(!block.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getType().equals(Material.AIR)){
						
						Stairs stairs = (Stairs)block.getState().getData();
						
						Location loc = block.getLocation().add(0.5D, 0.2D, 0.5D);
						Arrow a = (Arrow) p.getWorld().spawn(loc, Arrow.class);
						
						Location plocation = p.getLocation();
												
						if(p.getVehicle() != null){
							p.getVehicle().remove();
						}switch (stairs.getDescendingDirection()){
			            	case NORTH: 
			            		plocation.setYaw(180.0F);
			            		break;
			            	case EAST: 
			            		plocation.setYaw(180.0F);
			            		break;
			            	case SOUTH: 
			            		plocation.setYaw(270.0F);
			            		break;
			            	case WEST: 
			            		plocation.setYaw(0.0F);
						}
						sitting.put(a, p);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
					            p.teleport(plocation);
								a.setPassenger(p);
								p.sendMessage(Main.commip + "§aDu sitzt nun!");								
							}
						}.runTaskLater(Main.plugin, 20);
					}
				}
			}
		}catch(Exception ex){}
	}
}
