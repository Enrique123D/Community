package me.TraiUnity.Commands;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.TraiUnity.Main;
import me.TraiUnity.Listener.SetBoots;
import me.TraiUnity.Screenbox.Screenbox;

public class BuildCommand implements CommandExecutor {

	public static HashMap<Player, ItemStack[]> oldinv = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {
			
			for(Screenbox box : Main.boxen.values()){
				if(box.getInbox() == p){
					p.sendMessage(Main.screenb + "§7Du bist aktuell noch in einer §5Screenbox§7!");
					return false;
				}
			}
			
			if (args.length == 0) {			
				if (!Main.edit.contains(p)) {
					Main.edit.add(p);

					p.sendTitle("§eBuild §8● §aAn", "");

					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);

					p.spigot().setCollidesWithEntities(true);
					oldinv.put(p, p.getInventory().getContents());
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					p.setGameMode(GameMode.CREATIVE);
					
					return true;
				}
				Main.edit.remove(p);

				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);

				p.sendTitle("§eBuild §8● §cAus", "");

				p.setGameMode(GameMode.ADVENTURE);

				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				ItemStack[] inv = oldinv.get(p);
				p.getInventory().setContents(inv);
				oldinv.remove(p);
				
				SetBoots.setBoots(p);
				
				p.setLevel(2018);
				p.setExp(0.0F);

				p.setMaxHealth(20);
				p.setHealth(20);
				p.setFoodLevel(20);

				return true;
			}
			p.sendMessage(Main.unknowncmd);
			return true;
		}
		p.sendMessage(Main.unknowncmd);
		return false;
	}
}
