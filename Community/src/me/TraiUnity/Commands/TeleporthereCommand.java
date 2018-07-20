package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Screenbox.Screenbox;

public class TeleporthereCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") | p.hasPermission("Rangsystem.Owner")) {
			if (args.length == 0) {
				
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}
				
				p.sendMessage(Main.commip + "§cDu musst einen Spieler eingeben, um ihn zu dir zu teleportieren.");
				return true;
			}
			if (args.length == 1) {
				
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}
				
				Player target = Bukkit.getServer().getPlayerExact(args[0]);
				if (target != null) {
					if (!target.hasPermission("Rangsystem.Administrator") && !target.hasPermission("Rangsystem.Owner")) {
						if (target != p) {
							target.teleport(p);
							p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
							target.playSound(target.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);

							p.sendMessage(Main.commip + "§7Du hast " + target.getDisplayName() + " §7zu dir teleportiert.");
							target.sendMessage(Main.commip + "§7Du wurdest zu " + p.getDisplayName() + " §7teleportiert.");
							return true;
						}
						p.sendMessage(Main.commip + "§cDu darfst dich nicht selbst zu dir teleportieren.");
						return true;
					}
					p.sendMessage(Main.commip + "§cDu darfst keine §eTeammitglieder §cteleportieren.");
					return true;
				}
				p.sendMessage(Main.commip + "§cDer Spieler §e" + args[0] + " §cist nicht §aonline§c.");
				return true;
			}
			p.sendMessage(Main.unknowncmd);
			return true;
		}
		p.sendMessage(Main.unknowncmd);
		return true;
	}
}
