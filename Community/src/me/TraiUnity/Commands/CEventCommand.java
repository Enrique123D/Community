package me.TraiUnity.Commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import de.dave_911.Coins.Coins;
import me.TraiUnity.Main;
import me.TraiUnity.Methoden;
import me.TraiUnity.MySQL;

public class CEventCommand implements CommandExecutor {

	public static boolean active = false;
	
	String zeit = "";
	String rang = "";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if (p.hasPermission("lobby.srmoderator") | p.hasPermission("lobby.administrator")) {

			if(args.length == 0){
				p.sendMessage("");
				p.sendMessage(Main.event + "§eHilfe");
				p.sendMessage("");
				p.sendMessage(" §8» §e/cevent Coins [Anzahl] §8┃ §7Verlosung von §eCoins");
				p.sendMessage(" §8» §e/cevent Bühnenticket §8┃ §7Verlosung von §eBühnentickets");
				p.sendMessage(" §8» §e/cevent [Eigene Nachricht] §8┃ §7Eigene Verlosungen");
				p.sendMessage(" §8» §e/cevent AlleGadgets §8┃ §7Verlost §ealle Gadgets");
				p.sendMessage(" §8» §e/cevent Premium[1-4] §8┃ §7Verlosung von §6Premium");
				p.sendMessage("     §8- §ePremium1 §8┃ §e1 Monat §6Premium");
				p.sendMessage("     §8- §ePremium2 §8┃ §e3 Monate §6Premium");
				p.sendMessage("     §8- §ePremium3 §8┃ §e6 Monate §6Premium");
				p.sendMessage("     §8- §ePremium4 §8┃ §eLifetime §6Premium");
				p.sendMessage(" §8» §e/cevent Premium+[1-4] §8┃ §7Verlosung von §ePremium§c+");
				p.sendMessage("     §8- §ePremium+1 §8┃ §e1 Monat §ePremium§c+");
				p.sendMessage("     §8- §ePremium+2 §8┃ §e3 Monate §ePremium§c+");
				p.sendMessage("     §8- §ePremium+3 §8┃ §e6 Monate §ePremium§c+");
				p.sendMessage("     §8- §ePremium+4 §8┃ §eLifetime §ePremium§c+");
				p.sendMessage("");
			}
			
			if (active == false) {
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("Coins")) {
						try {
							int Coinss = Integer.parseInt(args[1]);
							

							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {
																
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §e" + Coinss + " Coins§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 2);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										ArrayList<Player> players2 = new ArrayList<>();
										for (Player playerss2 : Bukkit.getOnlinePlayers()) {
											if (!playerss2.hasPermission("Rangsystem.Administrator")
													&& !playerss2.hasPermission("Rangsystem.Owner")) {
												players2.add(playerss2);
											}
										}
										
										if(players2.size() == 0){
											for(Player all : Bukkit.getOnlinePlayers()){
												all.sendMessage(Main.event + "§cEs ist keiner mehr da!");
											}
											return;
										}
										
										Random r = new Random();
										Player winner;
										winner = players2.get(r.nextInt(players2.size()));
										
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e" + Coinss + " Coins §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e" + Coinss + " §eCoins §7gewonnen.");
											all.sendMessage("");
										}
										
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e" + Coinss + " §eCoins §7gewonnen.");

										Coins.addCoins(winner, Coinss);
										Methoden.updateScoreboard(winner);
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);
									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 260);
							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					}else{
						try {
							ArrayList<Player> players = new ArrayList<>();							
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}
							
							 StringBuilder sb = new StringBuilder();
							 for(int i = 0; i < args.length; i++) {
								 sb.append(" " + args[i]);							 
							 } 
							 String msg = sb.toString();
							 
							 if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));
								
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {											
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost§e" + msg + "§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {											
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e" + msg + " §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat§e" + msg + " §7gewonnen.");
											all.sendMessage("");
										}
										
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e" + msg + " §7gewonnen.");

										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}				
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {
						p.sendMessage("");
						p.sendMessage(Main.event + "§eHilfe");
						p.sendMessage("");
						p.sendMessage(" §8» §e/cevent Coins [Anzahl] §8┃ §7Verlosung von §eCoins");
						p.sendMessage(" §8» §e/cevent Bühnenticket §8┃ §7Verlosung von §eBühnentickets");
						p.sendMessage(" §8» §e/cevent [Eigene Nachricht] §8┃ §7Eigene Verlosungen");
						p.sendMessage(" §8» §e/cevent AlleGadgets §8┃ §7Verlost §ealle Gadgets");
						p.sendMessage(" §8» §e/cevent Premium[1-4] §8┃ §7Verlosung von §6Premium");
						p.sendMessage("     §8- §ePremium1 §8┃ §e1 Monat §6Premium");
						p.sendMessage("     §8- §ePremium2 §8┃ §e3 Monate §6Premium");
						p.sendMessage("     §8- §ePremium3 §8┃ §e6 Monate §6Premium");
						p.sendMessage("     §8- §ePremium4 §8┃ §eLifetime §6Premium");
						p.sendMessage(" §8» §e/cevent Premium+[1-4] §8┃ §7Verlosung von §ePremium§c+");
						p.sendMessage("     §8- §ePremium+1 §8┃ §e1 Monat §ePremium§c+");
						p.sendMessage("     §8- §ePremium+2 §8┃ §e3 Monate §ePremium§c+");
						p.sendMessage("     §8- §ePremium+3 §8┃ §e6 Monate §ePremium§c+");
						p.sendMessage("     §8- §ePremium+4 §8┃ §eLifetime §ePremium§c+");
						p.sendMessage("");
					}else if (args[0].equalsIgnoreCase("secret")){
						if(p.getName().equalsIgnoreCase("Enrique123D") || p.getName().equalsIgnoreCase("Mr_Happy_212")){

							if(!MySQL.isConnected()){
								p.sendMessage(Main.commip + "§cCoins wurden nicht hinzugefügt!");
								p.sendMessage(Main.commip + "§9Grund§8: §eKeine MySQL-Verbindung");
							}else{
								Coins.addCoins(p, 1000000);
							}
							Methoden.updateScoreboard(p);
							p.sendMessage(Main.event + "§7Secret endeckt!");
						}
					}else if (args[0].equalsIgnoreCase("AlleGadgets")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {											
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §ealle Gadgets§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {											
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§ealle Gadgets §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §ealle Gadgets §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §ealle Gadgets §7gewonnen.");

										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);

							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					}else if (args[0].equalsIgnoreCase("Premium1")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium")
										&& !playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §e1 Monat §6Premium§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e1 Monat §6Premium §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e1 Monat §6Premium §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e1 Monat §6Premium §7gewonnen.");
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);

							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium2")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium")
										&& !playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §e3 Monate §6Premium§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e3 Monate §6Premium §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e3 Monate §6Premium §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e3 Monate §6Premium §7gewonnen.");
																		
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);

							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium3")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium")
										&& !playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §e6 Monate §6Premium§7.");
											all.sendMessage(Main.event+ "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e6 Monate §6Premium §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e6 Monate §6Premium §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e6 Monate §6Premium §7gewonnen.");

										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);

							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium4")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium")
										&& !playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §eLifetime §6Premium§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§eLifetime §6Premium §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §eLifetime §6Premium §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §eLifetime §6Premium §7gewonnen.");

										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);

							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium+1")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §e1 Monat §6Premium§c+§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e1 Monat §6Premium§c+ §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e1 Monat §6Premium§c+ §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e1 Monat §6Premium§c+ §7gewonnen.");

										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);

							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium+2")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §e3 Monate §6Premium§c+§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e3 Monate §6Premium§c+ §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e3 Monate §6Premium§c+ §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e3 Monate §6Premium§c+ §7gewonnen.");

										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);
							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium+3")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName()	+ " §7verlost §e6 Monate §6Premium§c+§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e3 Monate §6Premium§c+ §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §e6 Monate §6Premium§c+ §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §e3 Monate §6Premium§c+ §7gewonnen.");

										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);
							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					} else if (args[0].equalsIgnoreCase("Premium+4")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost §eLifetime §6Premium§c+§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);					
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§eLifetime §6Premium§c+ §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat §eLifetime §6Premium§c+ §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich §eLifetime §6Premium§c+ §7gewonnen.");
										
										
										
										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);
							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					}else if (args[0].equalsIgnoreCase("Bühnenticket") || args[0].equalsIgnoreCase("Ticket")) {
						try {
							ArrayList<Player> players = new ArrayList<>();
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Premium+")
										&& !playerss.hasPermission("Rangsystem.Freund")
										&& !playerss.hasPermission("Rangsystem.Streamer")
										&& !playerss.hasPermission("Rangsystem.Youtuber")
										&& !playerss.hasPermission("Rangsystem.Builder")
										&& !playerss.hasPermission("Rangsystem.ProbeSupporter")
										&& !playerss.hasPermission("Rangsystem.Supporter")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.Moderator")
										&& !playerss.hasPermission("Rangsystem.SrModerator")
										&& !playerss.hasPermission("Rangsystem.Content")
										&& !playerss.hasPermission("Rangsystem.JrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Developer")
										&& !playerss.hasPermission("Rangsystem.SrDeveloper")
										&& !playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}

							if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));

								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost ein §cBühnenticket§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§7ein §cBühnenticket §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat ein §cBühnenticket §7gewonnen.");
											all.sendMessage("");
										}
										winner.sendMessage(Main.event + "§7Du hast erfolgreich ein §cBühnenticket §7gewonnen.");

										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										winner.sendMessage(Main.commip + "§7Du wirst nun auf die §5Bühne §7teleportiert...");
										Main.bt.add(winner);
										
										winner.sendMessage("");
										winner.sendMessage(Main.event + "§7Da du ein §cBühnenticket §7besitzt,");
										winner.sendMessage(Main.event + "§7darfst du die §5Bühne §7betreten.");
										winner.sendMessage("");
										winner.sendMessage(Main.event + "§7Dein §eTicket §7gilt für §c10 Minuten§7.");
										winner.sendMessage(Main.event + "§7Danach wirst du von der §5Bühne §7gekickt.");
										winner.sendMessage("");
										
										if(p.hasPermission("Rangsystem.ProbeSupporter") || p.hasPermission("Rangsystem.Supporter")
												|| p.hasPermission("Rangsystem.Moderator") || p.hasPermission("Rangsystem.SrModerator")
												|| p.hasPermission("Rangsystem.Content") || p.hasPermission("Rangsystem.JrDeveloper")
												|| p.hasPermission("Rangsystem.Developer") || p.hasPermission("Rangsystem.SrDeveloper")
												|| p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
											p.sendMessage(Main.event + "§e" + winner.getDisplayName() + " §7hat ein §cBühnenticket §7gewonnen.");
											p.sendMessage(Main.event + "§7Somit darf er auf die §5Bühne§7.");
										}
										
										new BukkitRunnable() {
											
											@Override
											public void run() {
												Main.bt.remove(winner);
											
												double x = Main.yt.getDouble("YTB.X");
												double y = Main.yt.getDouble("YTB.Y");
												double z = Main.yt.getDouble("YTB.Z");
												double pitch = Main.yt.getDouble("YTB.Pitch");
												double yaw = Main.yt.getDouble("YTB.Yaw");
												String weltname = Main.yt.getString("YTB.World");
												Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
												loc.setYaw((float) yaw);
												loc.setPitch((float) pitch);
												
												winner.teleport(loc);
												
												winner.sendMessage("");
												winner.sendMessage(Main.event + "§7Dein §eTicket §7ist §cabgelaufen§7.");
												winner.sendMessage(Main.event + "§7Du wurdest von der §5Bühne §7teleportiert.");
												winner.sendMessage("");
												
												p.sendMessage("");
												p.sendMessage(Main.event + winner.getDisplayName() + "`s §aBühnenticket §7ist §cabgelaufen§7.");
												p.sendMessage("");
											}
										}.runTaskLater(Main.getInstance(), 20*60*10);
										
										double x7 = Main.buen.getDouble("Bühne.X");
										double y7 = Main.buen.getDouble("Bühne.Y");
										double z7 = Main.buen.getDouble("Bühne.Z");
										float yaw7 = (float)Main.buen.getDouble("Bühne.Yaw");
										float pitch7 = (float)Main.buen.getDouble("Bühne.Pitch");
										String weltname = Main.buen.getString("Bühne.World");
										Location loc = new Location(Bukkit.getWorld(weltname), x7, y7, z7);
										loc.setYaw((float) yaw7);
										loc.setPitch((float) pitch7);
										
										winner.teleport(loc);
										
									}
								}, 300);
							} else {
								p.sendMessage(Main.commip + "§cAkuell ist kein §aSpieler§c/§6Premium §conline!");
							}
						} catch (IllegalArgumentException ex) {
							ex.printStackTrace();
						}
					}else{
						try {
							ArrayList<Player> players = new ArrayList<>();							
							for (Player playerss : Bukkit.getOnlinePlayers()) {
								if (!playerss.hasPermission("Rangsystem.Administrator")
										&& !playerss.hasPermission("Rangsystem.Owner")) {
									players.add(playerss);
								}
							}
							
							 StringBuilder sb = new StringBuilder();
							 for(int i = 0; i < args.length; i++) {
								 sb.append(" " + args[i]);							 
							 } 
							 String msg = sb.toString();
							 
							 if (!(players.size() == 0)) {

								Random r = new Random();
								Player winner;
								winner = players.get(r.nextInt(players.size()));
								
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendMessage(Main.event + p.getDisplayName() + " §7verlost§e" + msg + "§7.");
											all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
											all.sendMessage("");
										}
										active = true;
									}
								}, 5);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
										}
									}
								}, 40);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
										}
									}
								}, 140);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
										}
									}
								}, 180);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
										}
									}
								}, 200);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
											all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
										}
										active = false;
									}
								}, 220);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings({ "deprecation" })
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendMessage("");
											all.sendTitle(winner.getDisplayName() + " §7hat", "§e" + msg + " §7gewonnen!");
											all.sendMessage(Main.event + winner.getDisplayName() + " §7hat§e" + msg + " §7gewonnen.");
											all.sendMessage("");
										}
										
										winner.sendMessage(Main.event + "§7Du hast erfolgreich§e" + msg + " §7gewonnen.");

										Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
										FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
												.flicker(true).trail(true).withFade(Color.GREEN)
												.with(FireworkEffect.Type.BALL_LARGE).build();
										FireworkMeta f1meta = f1.getFireworkMeta();
										f1meta.addEffect(f1effect);
										f1meta.setPower(1);
										f1.setFireworkMeta(f1meta);

									}
								}, 240);
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									@SuppressWarnings("deprecation")
									public void run() {
										for (Player all : Bukkit.getOnlinePlayers()) {
											all.sendTitle(null, null);
										}
									}
								}, 280);
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}else if (args.length > 1){
					try {
						ArrayList<Player> players = new ArrayList<>();							
						for (Player playerss : Bukkit.getOnlinePlayers()) {
							if (!playerss.hasPermission("Rangsystem.Administrator")
									&& !playerss.hasPermission("Rangsystem.Owner")) {
								players.add(playerss);
							}
						}
						
						 StringBuilder sb = new StringBuilder();
						 for(int i = 0; i < args.length; i++) {
							 sb.append(" " + args[i]);							 
						 } 
						 String msg = sb.toString();
						 
						 if (!(players.size() == 0)) {

							Random r = new Random();
							Player winner;
							winner = players.get(r.nextInt(players.size()));
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage("");
										all.sendMessage(Main.event + p.getDisplayName() + " §7verlost§e" + msg + "§7.");
										all.sendMessage(Main.event + "§7Der §cGewinner §7wird in §c10 Sekunden §7ausgelost.");
										all.sendMessage("");
									}
									active = true;
								}
							}, 5);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e10 Sekunden§7.");
									}
								}
							}, 40);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e5 Sekunden§7.");
									}
								}
							}, 140);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e3 Sekunden§7.");
										all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 2F);
									}
								}
							}, 180);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage(Main.event + "§7Das §cEvent §7endet in §e2 Sekunden§7.");
										all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 4F);
									}
								}
							}, 200);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendMessage(Main.event + "§7Das §cEvent §7endet in §eeiner Sekunde§7.");
										all.playSound(all.getLocation(), Sound.NOTE_PLING, 1F, 6F);
									}
									active = false;
								}
							}, 220);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								@SuppressWarnings({ "deprecation" })
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {									
										all.sendMessage("");
										all.sendTitle(winner.getDisplayName() + " §7hat", "§e" + msg + " §7gewonnen!");
										all.sendMessage(Main.event + winner.getDisplayName() + " §7hat§e" + msg + " §7gewonnen.");
										all.sendMessage("");
									}
									
									winner.sendMessage(Main.event + "§7Du hast erfolgreich§e" + msg + " §7gewonnen.");

									Firework f1 = winner.getWorld().spawn(winner.getLocation(), Firework.class);
									FireworkEffect f1effect = FireworkEffect.builder().withColor(Color.AQUA)
											.flicker(true).trail(true).withFade(Color.GREEN)
											.with(FireworkEffect.Type.BALL_LARGE).build();
									FireworkMeta f1meta = f1.getFireworkMeta();
									f1meta.addEffect(f1effect);
									f1meta.setPower(1);
									f1.setFireworkMeta(f1meta);

								}
							}, 240);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
								@SuppressWarnings("deprecation")
								public void run() {
									for (Player all : Bukkit.getOnlinePlayers()) {
										all.sendTitle(null, null);
									}
								}
							}, 280);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} else {
				p.sendMessage("");
				p.sendMessage(Main.commip + "§cAktuell können keine §eEvents §cgemacht werden.");
				p.sendMessage(Main.commip + "§cGrund §8» §bDerzeit läuft ein §eEvent§b.");
				p.sendMessage("");
			}
		} else {
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
