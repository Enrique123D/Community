package me.TraiUnity.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TraiUnity.Listener.SetBoots;

public class DiscoBootsCommand implements CommandExecutor {

	public static boolean discobootsteammitglieder = false;
	public static boolean discobootsalle = false;
	
	public static final void DiscoBootsOn(Player p) {

		discobootsalle = true;

		ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
		ItemMeta LBMeta = LB.getItemMeta();
		LBMeta.setDisplayName("§eDisco-Schuhe §8» §aAlle");
		LB.setItemMeta(LBMeta);
		for(Player all : Bukkit.getOnlinePlayers()){
			all.getInventory().setBoots(LB);
		}
	}

	public static final void DiscoBootsOff(Player p) {

		discobootsalle = false;
				
		for(Player all : Bukkit.getOnlinePlayers()){
			SetBoots.setBoots(all);
		}		
	}
	
	public static final void DiscoBootsTeamOn(Player p) {

		discobootsteammitglieder = true;

		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("Rangsystem.ProbeSupporter") || all.hasPermission("Rangsystem.Supporter")
					|| all.hasPermission("Rangsystem.Moderator") || all.hasPermission("Rangsystem.SrModerator")
					|| all.hasPermission("Rangsystem.Content") || all.hasPermission("Rangsystem.JrDeveloper")
					|| all.hasPermission("Rangsystem.Developer") || all.hasPermission("Rangsystem.SrDeveloper")
					|| all.hasPermission("Rangsystem.Administrator") || all.hasPermission("Rangsystem.Owner")){
				ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
				ItemMeta LBMeta = LB.getItemMeta();
				LBMeta.setDisplayName("§eDisco-Schuhe §8» §cTeammitglieder");
				LB.setItemMeta(LBMeta);
				all.getInventory().setBoots(LB);
			}
		}
	}

	public static final void DiscoBootsTeamOff(Player p) {

		discobootsteammitglieder = false;
				
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("Rangsystem.ProbeSupporter") || all.hasPermission("Rangsystem.Supporter")
					|| all.hasPermission("Rangsystem.Moderator") || all.hasPermission("Rangsystem.SrModerator")
					|| all.hasPermission("Rangsystem.Content") || all.hasPermission("Rangsystem.JrDeveloper")
					|| all.hasPermission("Rangsystem.Developer") || all.hasPermission("Rangsystem.SrDeveloper")
					|| all.hasPermission("Rangsystem.Administrator") || all.hasPermission("Rangsystem.Owner")){
				SetBoots.setBoots(all);
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
			if (args.length == 1) {
				if(args[0].equalsIgnoreCase("alle")){
					if (discobootsalle == false) {
						discobootsalle = true;
						DiscoBootsOn(p);
					}else{
						discobootsalle = false;
						DiscoBootsOff(p);
					}
				}else if(args[0].equalsIgnoreCase("teammitglieder")){
					if (discobootsteammitglieder == false) {
						discobootsteammitglieder = true;
						DiscoBootsTeamOn(p);
					}else{
						discobootsteammitglieder = false;
						DiscoBootsTeamOff(p);
					}
				}
			}
		}
		return false;
	}
}
