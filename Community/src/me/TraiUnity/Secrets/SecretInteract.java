package me.TraiUnity.Secrets;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.TraiUnity.Main;
import me.TraiUnity.EffekteMenu.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class SecretInteract implements Listener {

	@EventHandler
	public void onSecretInter(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(Secret.secretExists(e.getClickedBlock().getLocation())){			
				if(e.getClickedBlock().getType().equals(Material.SKULL) || e.getClickedBlock().getType().equals(Material.SKULL_ITEM)){
					if(!Secret.playerHasFoundSecret(p.getUniqueId().toString(), e.getClickedBlock().getLocation())){
						Secret.addFoundSecret(p.getUniqueId().toString(), e.getClickedBlock().getLocation());
						p.sendMessage(Main.secret + "§aDu hast ein §eSecret §agefunden!");
						Random r = new Random();
						Particle par = new Particle(EnumParticle.VILLAGER_HAPPY, e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5), true, r.nextFloat(), r.nextFloat(), r.nextFloat(), 0, 15);
						par.sendPlayer(p);
					}else{
						p.sendMessage(Main.secret + "§cDu hast dieses §eSecret §cbereits gefunden!");
						Random r = new Random();
						Particle par = new Particle(EnumParticle.VILLAGER_ANGRY, e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5), true, r.nextFloat(), r.nextFloat(), r.nextFloat(), 0, 15);
						par.sendPlayer(p);
					}
				}
			}
		}
	}
}