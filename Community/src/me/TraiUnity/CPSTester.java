package me.TraiUnity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.TraiUnity.Listener.Actionbar;
import me.TraiUnity.Listener.PlayerInteractListener;

public class CPSTester {

	public static void cps(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				
			@Override
			public void run() {
				if((PlayerInteractListener.playersCps != null) && (!PlayerInteractListener.playersCps.isEmpty())){
					for(PlayerCPS playerCPS : PlayerInteractListener.playersCps){
						
						if((playerCPS.getLeft() >= 16) || (playerCPS.getRight() >= 16) || (Main.pleaseCheckThisPlayer.containsKey(playerCPS.getPlayer()))){
							for(Player p : Bukkit.getOnlinePlayers()){
								if(p.hasPermission("Rangsystem.Owner")){
									Actionbar.sendActionBar(playerCPS.getPlayer(), "§cAutoklicker §8┃ §4" + playerCPS.getLeft() + " §7Links §8┃ §e" + playerCPS.getPlayer().getName() + " §8┃ §7Rechts §4" + playerCPS.getRight());
									p.sendMessage(Main.commip + "§cAutoclicker §8┃ §4" + playerCPS.getLeft() + " §7Links §8┃ §e" + playerCPS.getPlayer().getName() + " §8┃ §7Rechts §4" + playerCPS.getRight());
								}
							}
						}
						if(Main.pleaseCheckThisPlayer.containsKey(playerCPS.getPlayer())){
							int secondsToTry = ((Integer)Main.pleaseCheckThisPlayer.get(playerCPS.getPlayer())).intValue();
							secondsToTry--;
							if(secondsToTry == 0){
								Main.pleaseCheckThisPlayer.remove(playerCPS.getPlayer());
							}
							Main.pleaseCheckThisPlayer.replace(playerCPS.getPlayer(), Integer.valueOf(secondsToTry));
						}
					}
				}
				PlayerInteractListener.playersCps.clear();
			}
		}, 20L, 20L);
	}
}
