package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import me.TraiUnity.Screenbox.Screenbox;

public class GameModeCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")
				|| cmd.getName().equalsIgnoreCase("baumodus")) {
			if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.isOp()) {
				if (args.length == 1) {

					for(Screenbox box : Main.boxen.values()){
						if(box.getInbox() == p){
							p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
							return false;
						}
					}
					
					if (args[0].equalsIgnoreCase("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendTitle("§eGM §8● §aÜberleben", "");
					}
					if (args[0].equalsIgnoreCase("1")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendTitle("§eGM §8● §aKreativ", "");
					}
					if (args[0].equalsIgnoreCase("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendTitle("§eGM §8● §aAbenteuer", "");
					}
					if (args[0].equalsIgnoreCase("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendTitle("§eGM §8● §aZuschauer", "");
					}
				} else if (args.length == 2) {
					
					for(Screenbox box : Main.boxen.values()){
						if(box.getInbox() == p){
							p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
							return false;
						}
					}
					
					Player target = Bukkit.getPlayerExact(args[1]);
					if (target == null) {
						p.sendMessage(Main.commip + "§cDieser Spieler existiert nicht!");
					} else {
						if (args[0].equalsIgnoreCase("0")) {
							target.setGameMode(GameMode.SURVIVAL);
							p.sendTitle("§eGM §8● §9" + target.getName() + " §8● §aÜberleben", "");
							target.sendTitle("§eGM §8● §aÜberleben", "");
						}
						if (args[0].equalsIgnoreCase("1")) {
							target.setGameMode(GameMode.CREATIVE);
							p.sendTitle("§eGM §8● §9" + target.getName() + " §8● §aKreativ", "");
							target.sendTitle("§eGM §8● §aKreativ", "");
						}
						if (args[0].equalsIgnoreCase("2")) {
							target.setGameMode(GameMode.ADVENTURE);
							p.sendTitle("§eGM §8● §9" + target.getName() + " §8● §aAbenteuer", "");
							target.sendTitle("§eGM §8● §aAbenteuer", "");
						}
						if (args[0].equalsIgnoreCase("3")) {
							target.setGameMode(GameMode.SPECTATOR);
							p.sendTitle("§eGM §8● §9" + target.getName() + " §8● §aZuschauer", "");
							target.sendTitle("§eGM §8● §aZuschauer", "");
						}
					}
				}
			} else {
				p.sendMessage(Main.unknowncmd);
				return true;
			}
		}
		return false;
	}
}
