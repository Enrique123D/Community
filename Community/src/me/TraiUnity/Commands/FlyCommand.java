package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Screenbox.Screenbox;

public class FlyCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			if (args.length == 0) {			
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}
				
				if (Main.fly.contains(p)) {
					p.setAllowFlight(false);
					p.setFlying(false);
					
					Main.fly.remove(p);
					p.sendTitle("§eFly §8● §cAus", "");
					return true;
				}
				p.setAllowFlight(true);
				p.setFlying(true);
				
				Main.fly.add(p);
				p.sendTitle("§eFly §8● §aAn", "");
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
					if (target != p) {
						if (Main.fly.contains(target)) {
							target.setAllowFlight(false);
							target.setFlying(false);
							Main.fly.remove(target);
							p.sendTitle("§eFly §8● §9" + target.getName() + " §8● §cAus", "");
							target.sendTitle("§eFly §8● §cAus", "");
							return true;
						}
						target.setAllowFlight(true);
						target.setFlying(true);
						Main.fly.add(target);
						p.sendTitle("§eFly §8● §9" + target.getName() + " §8● §aAn", "");
						target.sendTitle("§eFly §8● §aAn", "");
						return true;
					}
					p.sendMessage(Main.commip + "§cBenutze §e/fly §cum selber fliegen zu können.");
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
