package me.TraiUnity.WarpSystem;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SchildClickListener implements Listener {

	public static WarpCommand wp;
	
	  @SuppressWarnings({ "static-access", "deprecation" })
	@EventHandler
	  public void onFound(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(2) == null) {
	        return;
	      }
	      String warp = s.getLine(2);
	      warp = warp.replace("§a", "");
	      if (wp.warpExists(warp.toLowerCase()))
	      {
	        Location loc = wp.getWarp(warp.toLowerCase());
	        p.teleport(loc);
	        p.sendTitle("§bWarp §8● §a" + warp, "");
	        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
	      }
	    }
	  }	
}
