package me.TraiUnity.Secrets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class SecretCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}
		
		Player p = (Player)sender;
		
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("add")){
				if(!Secret.secretExists(p.getLocation().getBlock().getLocation())){
					Secret.addLocation(p.getLocation().getBlock().getLocation());
					p.sendMessage(Main.secret + "§aSecret Ort hinzugefügt!");
				}else{
					p.sendMessage(Main.secret + "§cHier existiert bereits ein Secret!");
				}
			}else 	if(args[0].equalsIgnoreCase("remove")){
				if(Secret.secretExists(p.getLocation().getBlock().getLocation())){
					Secret.removeLocation(p.getLocation().getBlock().getLocation());
					p.sendMessage(Main.secret + "§cSecret gelöscht!");
				}else{
					p.sendMessage(Main.secret + "§cHier existiert kein Secret!");
				}
			}else{
				p.sendMessage(Main.secret + "§cBenutze §e/secret §8(§7add§8,§7remove§8)");
			}
		}else{
			p.sendMessage(Main.secret + "§cBenutze §e/secret §8(§7add§8,§7remove§8)");
		}
		return false;
	}
}
