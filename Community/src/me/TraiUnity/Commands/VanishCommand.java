package me.TraiUnity.Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.TraiUnity.Main;
import me.TraiUnity.Screenbox.Screenbox;

public class VanishCommand implements CommandExecutor {

	public static ArrayList<Player> spectator = new ArrayList<>();
	public static List<Player> vanished = new ArrayList<>();
	public static HashMap<Player, BukkitRunnable> runvanished = new HashMap<>();

	int count;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			Vanish(p);
		} else {
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}

	public static void hide(Player p) {
		if (p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			for (Player a : vanished) {
				p.hidePlayer(a);
			}
		}
	}

	@SuppressWarnings({ "deprecation" })
	public static void Vanish(Player p) {

		if (vanished.contains(p)) {
			vanished.remove(p);
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.showPlayer(p);
			}

			p.setPlayerListName(p.getDisplayName());

			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);

			p.sendTitle("§eVanish §8● §cAus", "");
			p.sendMessage(Main.commip + "§7Du hast den §eVanish-Modus §cverlassen §7und bist somit für alle Spieler §esichtbar§7!");
			
			spectator.add(p);
			
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
			
			if(p.getDisplayName().startsWith("§a")){
				spieler.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§6")){
				premium.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§e")){
				premiumplus.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§cFreund")){
				freund.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§5Stream")){
				streamer.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§5YTber")){
				youtuber.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§2Builder")){
				builder.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§3P-Sup")){
				probesupporter.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§3Sup")){
				supporter.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§9Mod")){
				moderator.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§9SrMod")){
				srmoderator.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§bContent")){
				Content.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§bJrDev")){
				jrdeveloper.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§bDev")){
				developer.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§bSrDev")){
				srdeveloper.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§4Admin")){
				administrator.addPlayer(p);
			}
			if(p.getDisplayName().startsWith("§4Owner")){
				owner.addPlayer(p);
			}
			
			String name = p.getDisplayName();

			p.setPlayerListName(name);			
		}else{
			for(Screenbox box : Main.boxen.values()){
				if(box.getInbox() == p){
					p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
					return;
				}
			}
			
			vanished.add(p);
			
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (!all.hasPermission("Rangsystem.Administrator") && !all.hasPermission("Rangsystem.Owner")) {
					all.hidePlayer(p);
					for (Player players : VanishCommand.spectator) {
						players.showPlayer(p);
						p.showPlayer(players);
					}
				}
			}

			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);

			p.sendTitle("§eVanish §8● §aAn", "");
			p.sendMessage(Main.commip + "§7Du hast den §eVanish-Modus §abetreten §7und bist somit §eunsichtbar §7für normale Spieler!");
			
			p.setPlayerListName("§7Vanish §8┃ " + p.getDisplayName());
			
			p.setAllowFlight(true);
			p.setFlying(true);

			p.spigot().setCollidesWithEntities(false);
			
		}
	}
}