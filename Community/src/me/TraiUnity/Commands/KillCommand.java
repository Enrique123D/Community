package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Screenbox.Screenbox;

public class KillCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.isOp()) {
			if (args.length == 0) {		
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}
				
				p.setHealth(0.0D);
				p.sendMessage(Main.commip + "§cDu hast Selbstmord begangen. :(");

				for (World worlds : Bukkit.getWorlds()) {
					for (Entity ent : worlds.getEntities()) {
						if (!(ent instanceof Player)) {
							ent.remove();
						}
					}
				}
			}else if (args.length == 1) {
				
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}
				
				String target = args[0];
				if (Bukkit.getPlayer(target) != null) {
					Player t = Bukkit.getPlayer(target);
					t.setHealth(0.0D);
					p.sendMessage(Main.commip + "§cDu hast " + t.getDisplayName() + " §cget§tet.");

					for (World worlds : Bukkit.getWorlds()) {
						for (Entity ent : worlds.getEntities()) {
							if (!(ent instanceof Player)) {
								ent.remove();
							}
						}
					}
				}else{
					p.sendMessage(Main.commip + "§cDieser Spieler ist nicht §aonline§c.");
				}
			}
		}else{
			p.sendMessage(Main.unknowncmd);
		}
		return false;
	}
}
