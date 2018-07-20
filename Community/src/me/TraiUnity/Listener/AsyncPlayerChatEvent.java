package me.TraiUnity.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AsyncPlayerChatEvent implements Listener {
	
	@EventHandler
	public void onAsyncPlayerChat(org.bukkit.event.player.AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();

		String message = e.getMessage().replaceAll("%", "%%");
		
		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			message = ChatColor.translateAlternateColorCodes('&', message);
		}
		
		e.setFormat("§aSpieler §8┃ §a" + p.getName() + " §8● §7" + message);
		
		if(p.hasPermission("Rangsystem.Premium")){
			e.setFormat("§6Premium §8┃ §6" + p.getName() + " §8● §7" + message);
		}		
		if(p.hasPermission("Rangsystem.Premium+")){
			e.setFormat("§ePremium§c+ §8┃ §e" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Freund")){
			e.setFormat("§cFreund §8┃ §c" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Streamer")){
			e.setFormat("§5Streamer §8┃ §5" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Youtuber")){
			e.setFormat("§5YouTuber §8┃ §5" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Builder")){
			e.setFormat("§2Builder §8┃ §2" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.ProbeSupporter")){
			e.setFormat("§3Probe-Supporter §8┃ §3" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Supporter")){
			e.setFormat("§3Supporter §8┃ §3" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Moderator")){
			e.setFormat("§9Moderator §8┃ §9" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.SrModerator")){
			e.setFormat("§9SrModerator §8┃ §9" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Content")){
			e.setFormat("§bContent §8┃ §b" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.JrDeveloper")){
			e.setFormat("§bJrDeveloper §8┃ §b" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Developer")){
			e.setFormat("§bDeveloper §8┃ §b" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.SrDeveloper")){
			e.setFormat("§bSrDeveloper §8┃ §b" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Administrator")){
			e.setFormat("§4Admin §8┃ §4" + p.getName() + " §8● §7" + message);
		}
		if(p.hasPermission("Rangsystem.Owner")){
			e.setFormat("§4Owner §8┃ §4" + p.getName() + " §8● §7" + message);
		}
	}
}
