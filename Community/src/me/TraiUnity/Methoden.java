package me.TraiUnity;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.dave_911.Coins.Coins;
import me.TraiUnity.Commands.VanishCommand;
import me.TraiUnity.Listener.SetBoots;

public class Methoden {
	
	public static HashMap<Player, Integer> animation = new HashMap<>();
	
	public static void setScreenboxItems(Player p){
		
	    ArrayList<String> lore0 = new ArrayList<>();
	    lore0.add("§7Damit kannst du die §5Screenbox §7verlassen");
	    ItemStack TP = new ItemStack(Material.BARRIER, 1);
	    ItemMeta TPMeta = TP.getItemMeta();
	    TPMeta.setDisplayName("§cBox verlassen §8● §7Rechtsklick");
	    TPMeta.setLore(lore0);
	    TP.setItemMeta(TPMeta);	
    		p.getInventory().setItem(0, TP);
	    	p.getInventory().setItem(8, TP);
	}
	
	public static void setScreenboxBesucherItems(Player p){
		p.getInventory().clear();
	}
	
	@SuppressWarnings("deprecation")
	public static void updateScoreboard(Player p){
		
		String name = "§a" + p.getName();
		
		if(p.hasPermission("Rangsystem.Premium")){
			name = "§6" + p.getName();
		}	
		if(p.hasPermission("Rangsystem.Premium+")){
			name = "§e" + p.getName();
		}		
		if(p.hasPermission("Rangsystem.Freund")){
			name = "§cFreund §8┃ §c" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Streamer")){
			name = "§5Stream §8┃ §5" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Youtuber")){
			name = "§5YTber §8┃ §5" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Builder")){
			name = "§2Builder §8┃ §2" + p.getName();
		}
		if(p.hasPermission("Rangsystem.ProbeSupporter")){
			name = "§3P-Sup §8┃ §3" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Supporter")){
			name = "§3Sup §8┃ §3" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Moderator")){
			name = "§9Mod §8┃ §9" + p.getName();
		}
		if(p.hasPermission("Rangsystem.SrModerator")){
			name = "§9SrMod §8┃ §9" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Content")){
			name = "§bContent §8┃ §b" + p.getName();
		}
		if(p.hasPermission("Rangsystem.JrDeveloper")){
			name = "§bJrDev §8┃ §b" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Developer")){
			name = "§bDev §8┃ §b" + p.getName();
		}
		if(p.hasPermission("Rangsystem.SrDeveloper")){
			name = "§bSrDev §8┃ §b" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Administrator")){
			name = "§4Admin §8┃ §4" + p.getName();
		}
		if(p.hasPermission("Rangsystem.Owner")){
			name = "§4Owner §8┃ §4" + p.getName();
		}

		p.setDisplayName(name);
		
		String playerrank = "§aSpieler";

		if (p.hasPermission("Rangsystem.Premium")) {
			playerrank = "§6Premium";
		}
		if (p.hasPermission("Rangsystem.Premium+")) {
			playerrank = "§ePremium" + "§c+";
		}
		if (p.hasPermission("Rangsystem.Freund")) {
			playerrank = "§cFreund";
		}
		if (p.hasPermission("Rangsystem.Streamer")) {
			playerrank = "§5Streamer";
		}
		if (p.hasPermission("Rangsystem.Youtuber")) {
			playerrank = "§5Youtuber";
		}
		if (p.hasPermission("Rangsystem.Builder")) {
			playerrank = "§2Builder";
		}
		if (p.hasPermission("Rangsystem.ProbeSupporter")) {
			playerrank = "§6Probe-Supporter";
		}
		if (p.hasPermission("Rangsystem.Supporter")) {
			playerrank = "§3Supporter";
		}
		if (p.hasPermission("Rangsystem.Moderator")) {
			playerrank = "§9Moderator";
		}
		if (p.hasPermission("Rangsystem.SrModerator")) {
			playerrank = "§9SrModerator";
		}
		if (p.hasPermission("Rangsystem.Content")) {
			playerrank = "§bContent";
		}
		if (p.hasPermission("Rangsystem.JrDeveloper")) {
			playerrank = "§bJrDeveloper";
		}
		if (p.hasPermission("Rangsystem.Developer")) {
			playerrank = "§bDeveloper";
		}
		if (p.hasPermission("Rangsystem.SrDeveloper")) {
			playerrank = "§bSrModerator";
		}
		if (p.hasPermission("Rangsystem.Administrator")) {
			playerrank = "§4Administrator";
		}
		if (p.hasPermission("Rangsystem.Owner")) {
			playerrank = "§4Owner";
		}

		//TODO 1.9 Later wegen Prefix im TAB
		@SuppressWarnings("unused")
		final String playerrank2 = playerrank;
		final String name2 = name;

		Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				p.setPlayerListName(name2);
			}
		}, 1);

		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

		Team spieler = board.getTeam("17-Spieler");
		Team premium = board.getTeam("16-Premium");
		Team premiumplus = board.getTeam("15-Premium+");
		Team freund = board.getTeam("14-Freund");
		Team streamer = board.getTeam("13-Streamer");
		Team youtuber = board.getTeam("12-Youtuber");
		Team builder = board.getTeam("11-Builder");
		Team probesupporter = board.getTeam("10-PSup");
		Team supporter = board.getTeam("09-Supporter");
		Team moderator = board.getTeam("08-Moderator");
		Team srmoderator = board.getTeam("07-SrModerator");
		Team Content = board.getTeam("06-Content");
		Team jrdeveloper = board.getTeam("05-JrDeveloper");
		Team developer = board.getTeam("04-Developer");
		Team srdeveloper = board.getTeam("03-SrDeveloper");
		Team administrator = board.getTeam("02-Administrator");
		Team owner = board.getTeam("01-Owner");
		
		if(spieler == null){
			spieler = board.registerNewTeam("17-Spieler");
			spieler.setPrefix("§a");
		}
		if(premium == null){
			premium = board.registerNewTeam("16-Premium");
			premium.setPrefix("§6");
		}
		if(premiumplus == null){
			premiumplus = board.registerNewTeam("15-Premium+");
			premiumplus.setPrefix("§e");
		}
		if(freund == null){
			freund = board.registerNewTeam("14-Freund");
			freund.setPrefix("§cFreund §8┃ §c");
		}
		if(streamer == null){
			streamer = board.registerNewTeam("13-Streamer");
			streamer.setPrefix("§5Stream §8┃ §5");
		}
		if(youtuber == null){
			youtuber = board.registerNewTeam("12-Youtuber");
			youtuber.setPrefix("§5YTber §8┃ §5");
		}
		if(builder == null){
			builder = board.registerNewTeam("11-Builder");
			builder.setPrefix("§2Builder §8┃ §2");
		}
		if(probesupporter == null){
			probesupporter = board.registerNewTeam("10-PSup");
			probesupporter.setPrefix("§3P-Sup §8┃ §3");
		}
		if(supporter == null){
			supporter = board.registerNewTeam("09-Supporter");
			supporter.setPrefix("§3Sup §8┃ §3");
		}
		if(moderator == null){
			moderator = board.registerNewTeam("08-Moderator");
			moderator.setPrefix("§9Mod §8┃ §9");
		}
		if(srmoderator == null){
			srmoderator = board.registerNewTeam("07-SrModerator");
			srmoderator.setPrefix("§9SrMod §8┃ §9");
		}
		if(Content == null){
			Content = board.registerNewTeam("06-Content");
			Content.setPrefix("§bContent §8┃ §b");
		}
		if(jrdeveloper == null){
			jrdeveloper = board.registerNewTeam("05-JrDeveloper");
			jrdeveloper.setPrefix("§bJrDev §8┃ §b");
		}
		if(developer == null){
			developer = board.registerNewTeam("04-Developer");
			developer.setPrefix("§bDev §8┃ §b");
		}
		if(srdeveloper == null){
			srdeveloper = board.registerNewTeam("03-SrDeveloper");
			srdeveloper.setPrefix("§bSrDev §8┃ §b");
		}
		if(administrator == null){
			administrator = board.registerNewTeam("02-Administrator");
			administrator.setPrefix("§4Admin §8┃ §4");
		}
		if(owner == null){
			owner = board.registerNewTeam("01-Owner");
			owner.setPrefix("§4Owner §8┃ §4");
		}
		
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.getDisplayName().startsWith("§a")){
				spieler.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§6")){
				premium.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§e")){
				premiumplus.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§c")){
				freund.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§5Stream")){
				streamer.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§5YTber")){
				youtuber.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§2Builder")){
				builder.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§3P-Sup")){
				probesupporter.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§3Sup")){
				supporter.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§9Mod")){
				moderator.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§9SrMod")){
				srmoderator.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§bContent")){
				Content.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§bJrDev")){
				jrdeveloper.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§bDev")){
				developer.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§bSrDev")){
				srdeveloper.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§4Admin")){
				administrator.addPlayer(all);
			}
			if(all.getDisplayName().startsWith("§4Owner")){
				owner.addPlayer(all);
			}
		}
		
		p.setScoreboard(board);
		
		Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				Objective objective = board.getObjective("Info");
		
				if (objective == null) {
					objective = board.registerNewObjective("Info", "dummy");
					objective.setDisplayName("§8● §5Community §8●");
					objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				}
				
				Team prefix = board.getTeam("Prefix");

				if (prefix == null) {
					prefix = board.registerNewTeam("Prefix");
					prefix.setPrefix("  §8➥ ");
				}
				
				Team prefix2 = board.getTeam("Prefix-2");

				if (prefix2 == null) {
					prefix2 = board.registerNewTeam("Prefix-2");
					prefix2.setPrefix("  §8➥ §e");
				}
				
				String rank = "§aSpieler";

				if (p.hasPermission("Rangsystem.Premium")) {
					rank = "§6Premium";
				}
				if (p.hasPermission("Rangsystem.Premium+")) {
					rank = "§ePremium" + "§c+";
				}
				if (p.hasPermission("Rangsystem.Freund")) {
					rank = "§cFreund";
				}
				if (p.hasPermission("Rangsystem.Streamer")) {
					rank = "§5Streamer";
				}
				if (p.hasPermission("Rangsystem.Youtuber")) {
					rank = "§5YouTuber";
				}
				if (p.hasPermission("Rangsystem.Builder")) {
					rank = "§2Builder";
				}
				if (p.hasPermission("Rangsystem.ProbeSupporter")) {
					rank = "§3Probe-Supporter";
				}
				if (p.hasPermission("Rangsystem.Supporter")) {
					rank = "§3Supporter";
				}
				if (p.hasPermission("Rangsystem.Moderator")) {
					rank = "§9Moderator";
				}
				if (p.hasPermission("Rangsystem.SrModerator")) {
					rank = "§9SrModerator";
				}
				if (p.hasPermission("Rangsystem.Content")) {
					rank = "§bContent";
				}
				if (p.hasPermission("Rangsystem.JrDeveloper")) {
					rank = "§bJrDeveloper";
				}
				if (p.hasPermission("Rangsystem.Developer")) {
					rank = "§bDeveloper";
				}
				if (p.hasPermission("Rangsystem.SrDeveloper")) {
					rank = "§bSrDeveloper";
				}
				if (p.hasPermission("Rangsystem.Administrator")) {
					rank = "§4Administrator";
				}
				if (p.hasPermission("Rangsystem.Owner")) {
					rank = "§4Owner";
				}
				
				OfflinePlayer oplayer = Bukkit.getServer().getOfflinePlayer(rank);
				
				prefix.addPlayer(oplayer);
					
				int coins = MySQL.isConnected() == true ? Coins.getCoins(p) : 0;
				
				OfflinePlayer oplayer2 = Bukkit.getServer().getOfflinePlayer(String.valueOf(coins) + " ");
				
				prefix2.addPlayer(oplayer2);
				
				OfflinePlayer oplayer5 = Bukkit.getServer().getOfflinePlayer("§c- ");
				
				prefix2.addPlayer(oplayer5);
				
				OfflinePlayer oplayer6 = Bukkit.getServer().getOfflinePlayer("§c-  ");
				
				prefix2.addPlayer(oplayer6);
						
				Score spacer1 = objective.getScore(" ");
				Score rank1 = objective.getScore("§7§oDein Rang");
				Score rank2 = objective.getScore(oplayer);
				Score spacer2 = objective.getScore("  ");
				Score coins1 = objective.getScore("§7§oDeine Coins");
				Score coins2 = objective.getScore(oplayer2);
				Score spacer3 = objective.getScore("   ");
				Score event1 = objective.getScore("§7§oNächstes Event");
				Score event2 = objective.getScore("  §8➥ §e" + Main.eventa.getString("Datum"));
				Score event3 = objective.getScore("  §8➥ §e" + Main.eventa.getString("Uhrzeit") + " Uhr");
				Score spacer4 = objective.getScore("    ");
				
				spacer1.setScore(10);
				rank1.setScore(9);
				rank2.setScore(8);
				spacer2.setScore(7);
				coins1.setScore(6);
				coins2.setScore(5);
				spacer3.setScore(4);
				if(!Main.eventa.getString("Datum").equals("-") && !Main.eventa.getString("Uhrzeit").equals("-")){
					event1.setScore(3);
					event2.setScore(2);
					event3.setScore(1);
					spacer4.setScore(0);
				}
				
				p.setScoreboard(board);
			}
		});
	}
	
	public static void updateScoreboardAll(){
		for(Player all : Bukkit.getOnlinePlayers()){
			updateScoreboard(all);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void setItems(Player p){
		
		//Spieler Verstecker
		for(String all : Main.hider){
			Player target = Bukkit.getPlayer(all);
			
			if((target != null) && (target != p)){
				target.hidePlayer(p);
			}
		}
		
		for(String all : Main.hidet){
			if(!p.hasPermission("Traiunity.VIPSpieler")){
				Player target = Bukkit.getPlayer(all);
			
				if((target != null) && (target != p)){
					target.hidePlayer(p);
				}
			}
		}			
				
		//Vanish System
		for(Player v : VanishCommand.vanished){
			if(!p.hasPermission("Traiunity.Vanish.Join") | !p.hasPermission("Traiunity.Vanish")){
				p.hidePlayer(v);
			}else{
				p.showPlayer(v);
			}
		}
			    
		//Items
			    
	    ArrayList<String> lore0 = new ArrayList<>();
	    lore0.add("§7Damit kannst du dich teleportieren");
	    ItemStack TP = new ItemStack(Material.COMPASS, 1);
	    ItemMeta TPMeta = TP.getItemMeta();
	    TPMeta.setDisplayName("§cTeleporter §8● §7Rechtsklick");
	    TPMeta.setLore(lore0);
	    TP.setItemMeta(TPMeta);						    
	    
	    ArrayList<String> lore3 = new ArrayList<>();
	    lore3.add("§7Erweiterungseinstellungen und Tools");
	    ItemStack EW = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
	    ItemMeta EWMeta = EW.getItemMeta();
	    EWMeta.setDisplayName("§aErweiterungen §8● §7Rechtsklick");
	    EWMeta.setLore(lore3);
	    EW.setItemMeta(EWMeta);
	    
		ItemStack I5 = new ItemStack(Material.GLOWSTONE_DUST);
		ItemMeta I5M = I5.getItemMeta();
		I5M.setDisplayName("§6VIP Bereich §8● §7Rechtsklick");
		I5M.setLore(lore0);
		I5.setItemMeta(I5M);
		
		ItemStack I6 = new ItemStack(351, 1, (short)5);
		ItemMeta I6M = I6.getItemMeta();
		I6M.setDisplayName("§5Bühne §8● §7Rechtsklick");
		I6M.setLore(lore0);
		I6.setItemMeta(I6M);
    	
    	ItemStack SV = new ItemStack(351, 1, (short)10);
    	ItemMeta SVMeta = SV.getItemMeta();
    	SVMeta.setDisplayName("§aAlle Spieler §8● §7Rechtsklick");
    	SV.setItemMeta(SVMeta);
		
    	SetBoots.setBoots(p);
    	
    	p.getInventory().setItem(1, TP);
    	p.getInventory().setItem(7, SV);	
    	
	    if (p.hasPermission("Rangsystem.Premium") && !p.hasPermission("Rangsystem.Administrator") && !p.hasPermission("Rangsystem.Owner")) {
	    	p.getInventory().setItem(4, I5);
	    }
    	
	    if (p.hasPermission("Rangsystem.Premium+") || p.hasPermission("Rangsystem.Freund") || p.hasPermission("Rangsystem.Streamer") || p.hasPermission("Rangsystem.Youtuber")
	    		|| p.hasPermission("Rangsystem.Builder") || p.hasPermission("Rangsystem.Builder") || p.hasPermission("Rangsystem.ProbeSupporter") || p.hasPermission("Rangsystem.Supporter")
	    		|| p.hasPermission("Rangsystem.Moderator") || p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Content") || p.hasPermission("Rangsystem.JrDeveloper")
	    		|| p.hasPermission("Rangsystem.Developer") || p.hasPermission("Rangsystem.SrDeveloper")) {
	    	p.getInventory().setItem(3, I5);
	    	p.getInventory().setItem(4, null);
	    	p.getInventory().setItem(5, I6);
	    }
	    
    	if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
    		p.getInventory().setItem(3, I5);
    		p.getInventory().setItem(4, EW);
    		p.getInventory().setItem(5, I6);
    	}
	}
}
