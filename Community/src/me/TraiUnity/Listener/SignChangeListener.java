package me.TraiUnity.Listener;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.TraiUnity.Main;
import me.TraiUnity.WarpSystem.WarpCommand;

public class SignChangeListener implements Listener {

	public static Main p;
	public static WarpCommand wa;
	
	@EventHandler
	public void onBlockBuild(BlockPlaceEvent e){
		
		Player p = e.getPlayer();
		
		if (p.getName().equalsIgnoreCase("Enrique123D")) {
			if (e.getBlock().getType() == Material.SKULL) {
				
				String rank = "";
				
				Skull skull = (Skull) e.getBlock().getState();
				if (skull.getOwner() != null) {
					rank = skull.getOwner();
					
					if (rank.equalsIgnoreCase("Premium+") | rank.equalsIgnoreCase("Traidio") | rank.equalsIgnoreCase("YouTuber") | rank.equalsIgnoreCase("Builder") | rank.equalsIgnoreCase("Supporter") | rank.equalsIgnoreCase("Moderator") | rank.equalsIgnoreCase("SrModerator") | rank.equalsIgnoreCase("Developer") | rank.equalsIgnoreCase("Admin")) {
						List<String> heads = Main.ranking.getStringList("Heads." + rank);
						heads.add(e.getBlock().getWorld().getName() + "," + Double.valueOf(e.getBlock().getLocation().getX()) + "," + Double.valueOf(e.getBlock().getLocation().getY()) + "," + Double.valueOf(e.getBlock().getLocation().getZ()));
						Main.ranking.set("Heads." + rank, heads);
	
						try {
							Main.ranking.save(Main.rank);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						
						skull.setOwner("MHF_Question");
						skull.update();
	
						p.sendMessage(Main.commip + "§7Du hast einen §eKopf §7für den Rang §e" + rank + " §7erstellt.");
					} else {
						e.getBlock().breakNaturally();
						p.sendMessage(Main.commip + "§cDer Rang §e" + rank + " §cexistiert nicht.");
					}
				}
			}
		}
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onSign(org.bukkit.event.block.SignChangeEvent e){
	
		Player p = e.getPlayer();
		
		if(e.getLine(0).contains("&")){
			String Line1 = e.getLine(0);
			Line1 = Line1.replace("&", "§");
			e.setLine(0, Line1);
		}
		if(e.getLine(1).contains("&")){
			String Line2 = e.getLine(1);
			Line2 = Line2.replace("&", "§");
			e.setLine(1, Line2);
		}
		if(e.getLine(2).contains("&")){
			String Line2 = e.getLine(2);
			Line2 = Line2.replace("&", "§");
			e.setLine(2, Line2);
		}
		if(e.getLine(3).contains("&")){
			String Line3 = e.getLine(3);
			Line3 = Line3.replace("&", "§");
			e.setLine(3, Line3);
		}
		
		if (p.getName().equalsIgnoreCase("Enrique123D")) {
			if (e.getLines()[0].equalsIgnoreCase("[RankSign]")) {
				
				String rank = e.getLines()[1];
				
				if (rank.equalsIgnoreCase("Premium+") | rank.equalsIgnoreCase("Traidio") | rank.equalsIgnoreCase("YouTuber") | rank.equalsIgnoreCase("Builder") | rank.equalsIgnoreCase("Supporter") | rank.equalsIgnoreCase("Moderator") | rank.equalsIgnoreCase("SrModerator") | rank.equalsIgnoreCase("Developer") | rank.equalsIgnoreCase("Admin")) {
					List<String> signs = Main.ranking.getStringList("Signs." + rank);
					signs.add(e.getBlock().getWorld().getName() + "," + Double.valueOf(e.getBlock().getLocation().getX()) + "," + Double.valueOf(e.getBlock().getLocation().getY()) + "," + Double.valueOf(e.getBlock().getLocation().getZ()));
					Main.ranking.set("Signs." + rank, signs);

					try {
						Main.ranking.save(Main.rank);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					
					e.setLine(0, null);
					e.setLine(1, null);
					e.setLine(2, null);
					e.setLine(3, null);

					p.sendMessage(Main.commip + "§7Du hast ein §eSchild §7für den Rang §e" + rank + " §7erstellt.");
				} else {
					e.getBlock().breakNaturally();
					p.sendMessage(Main.commip + "§cDer Rang §e" + rank + " §cexistiert nicht.");
				}
			}
		}
		
		if ((p.hasPermission("lobby.administrator")) && (e.getLine(0).equalsIgnoreCase("[Warp]"))){
			String line1 = e.getLine(1);
				if (wa.warpExists(line1)){
					e.setLine(0, "§8§m---------------");
					e.setLine(1, "§8● §bWarp §8●");
					e.setLine(2, "§a" + line1);
					e.setLine(3, "§8§m---------------");
					p.sendMessage(Main.commip + "§7Schild für den Warp §e" + line1 + " §7erfolgreich §aerstellt§7.");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
	  	      	}else{
	  	      		p.sendMessage(Main.commip + "§cDer Warp §6" + line1 + " §cexistiert nicht.");
	  	      		e.getBlock().breakNaturally();
	  	      		p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1F, 1F);
	  	      	}
	  	 }
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Warps")) {
				e.setLine(0, "*                 *");
				e.setLine(1, "§4§lWarp");
				e.setLine(2, "§4§lListe");
				e.setLine(3, "*                 *");	
			}
		}
	    
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("JnRs")){	
				e.setLine(0, "*                 *");
				e.setLine(1, "§4§lJumpAndRun");
				e.setLine(2, "§4§lListe");
				e.setLine(3, "*                 *");	
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Effekte")){				
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §bEffekte §8●");
				e.setLine(2, "§8┃ §7Rechtsklick §8┃");
				e.setLine(3, "§8§m---------------");				
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Musik")){
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §eMusik §8●");
				e.setLine(2, "§8┃ §7Rechtsklick §8┃");
				e.setLine(3, "§8§m---------------");
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Admin")){				
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §4Admin §8●");
				e.setLine(2, "§8┃ §7Rechtsklick §8┃");
				e.setLine(3, "§8§m---------------");				
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Team")){				
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §9Teamübersicht §8●");
				e.setLine(2, "§8┃ §7Rechtsklick §8┃");
				e.setLine(3, "§8§m---------------");				
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Enrique123D")){
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §4Owner §8●");
				e.setLine(2, "§8┃ §4Enrique123D §8┃");
				e.setLine(3, "§8§m---------------");
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("F222")){
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §4Co-Owner §8●");
				e.setLine(2, "§8┃ §4F222 §8┃");
				e.setLine(3, "§8§m---------------");
			}
		}
		
		if(p.hasPermission("lobby.administrator")){
			if(e.getLine(0).equalsIgnoreCase("Mr_Happy_212")){
				e.setLine(0, "§8§m---------------");
				e.setLine(1, "§8● §4Co-Owner §8●");
				e.setLine(2, "§8┃ §4Mr_Happy_212 §8┃");
				e.setLine(3, "§8§m---------------");
			}
		}
	}
	
	static boolean isNumeric(String s){
		try{
			BigInteger.valueOf(Long.parseLong(s));
			return true;
	    }catch (NumberFormatException localNumberFormatException) {}
	    return false;
	}
}
