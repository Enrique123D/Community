package me.TraiUnity.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Methoden;

public class SetEventCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
			if(args.length == 2){
				String date = args[0];
				String time = args[1];
				
				Main.eventa.set("Datum", date);
				Main.eventa.set("Uhrzeit", time);
				
				try {
					Main.eventa.save(Main.ev);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				p.sendMessage(Main.commip + "§7Nächstes Event §8● §e" + date + " §7um §e" + time + " §7Uhr");
				
				Methoden.updateScoreboardAll();
			}else{
				p.sendMessage(Main.commip + "§cBenutze §e/setevent §8(§7Datum§8) §8(§7Uhrzeit§8)");
			}
		}
		return false;
	}
}
