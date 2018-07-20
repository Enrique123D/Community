package me.TraiUnity.Secrets;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.TraiUnity.Main;
import me.TraiUnity.MySQL;

public class SecretJoin implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSecretJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		if(MySQL.isConnected()){
			new BukkitRunnable() {
				
				@Override
				public void run() {
					for(Block b : Secret.getFoundedSecrets(p.getUniqueId().toString())){
						p.sendBlockChange(b.getLocation(), Material.BANNER, (byte)0);
					}				
				}
			}.runTaskLater(Main.plugin, 20);
		}
	}
}
