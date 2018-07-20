package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Screenbox.Screenbox;

public class TeleportAllCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("lobby.srmoderator") || p.hasPermission("lobby.administrator") && p.isOp()) {
			if (args.length == 0) {				
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}
				
				for (Player players : Bukkit.getOnlinePlayers()) {
					if ((players != p) && (!players.hasPermission("lobby.administrator") && (!players.isOp()))) {
						players.teleport(p);
						players.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(Main.commip + "§7Alle §eSpieler §7wurden zu " + p.getDisplayName() + " §7teleportiert.");
						Bukkit.broadcastMessage("");
					}
				}

				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.sendMessage(Main.commip + "§7Du hast alle §eSpieler §7zu dir teleportiert.");
				return true;
			}
			p.sendMessage(Main.unknowncmd);
			return true;
		}
		p.sendMessage(Main.unknowncmd);
		return true;
	}
}
