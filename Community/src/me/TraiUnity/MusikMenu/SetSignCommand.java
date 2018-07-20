package me.TraiUnity.MusikMenu;

import java.io.IOException;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class SetSignCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.isOp()) {
			if(args.length == 0){			
				p.sendMessage(Main.musik + "");
			}else if(args.length == 1){
				if(args[0].equalsIgnoreCase("1")){
					Main.signl.set("Sign1.World", p.getWorld().getName());
					Main.signl.set("Sign1.X", Double.valueOf(p.getLocation().getX()));
					Main.signl.set("Sign1.Y", Double.valueOf(p.getLocation().getY()));				
					Main.signl.set("Sign1.Z", Double.valueOf(p.getLocation().getZ()));
					
					try{
						Main.signl.save(Main.sign);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					
					p.sendMessage(Main.musik + "§7Das §eSchild §8(§a1§8) §7wurde erfolgreich gesetzt!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				}else if(args[0].equalsIgnoreCase("2")){
					Main.signl.set("Sign2.World", p.getWorld().getName());
					Main.signl.set("Sign2.X", Double.valueOf(p.getLocation().getX()));
					Main.signl.set("Sign2.Y", Double.valueOf(p.getLocation().getY()));				
					Main.signl.set("Sign2.Z", Double.valueOf(p.getLocation().getZ()));
					
					try{
						Main.signl.save(Main.sign);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					
					p.sendMessage(Main.musik + "§7Das §eSchild §8(§a2§8) §7wurde erfolgreich gesetzt!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				}
			}
		}
		return false;
	}
}
