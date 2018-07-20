package me.TraiUnity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Inventare.ErweiterungenInventar;
import me.TraiUnity.Screenbox.Screenbox;

public class ErweiterungsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
			if(args.length == 0){
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
						return false;
					}
				}			
				ErweiterungenInventar.OpenErweiterungen1(p);
			}
		}
		return false;
	}
}
