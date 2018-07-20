package me.TraiUnity.Screenbox;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.TraiUnity.Main;
import me.TraiUnity.Methoden;
import me.TraiUnity.AdminMenu.FileManager3;
import me.TraiUnity.Commands.VanishCommand;
import me.TraiUnity.EffekteMenu.FileManager1;
import me.TraiUnity.MusikMenu.FileManager2;
import me.TraiUnity.TeamInventar.FileManager4;

public class KnopfInteractEvent implements Listener{

	public static File ScrB = Main.sbn;
	public static FileConfiguration ScrBox = Main.sben;
	
	@EventHandler
	public void onKnopfDr(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
	
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Material.STONE_BUTTON)){
				if(FileManager1.Button1.getString(e.getClickedBlock().getLocation().toString()) != null
						|| FileManager2.Button2.getString(e.getClickedBlock().getLocation().toString()) != null
						|| FileManager4.Button4.getString(e.getClickedBlock().getLocation().toString()) != null
						|| FileManager3.Button3.getString(e.getClickedBlock().getLocation().toString()) != null){
					return;
				}
				for(Screenbox box : Main.boxen.values()){
					if(box.getInbox() == p){
						box.removeInbox(false);
						return;
					}
				}
			}
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)){
				if(FileManager1.Button1.getString(e.getClickedBlock().getLocation().toString()) != null
						|| FileManager2.Button2.getString(e.getClickedBlock().getLocation().toString()) != null
						|| FileManager4.Button4.getString(e.getClickedBlock().getLocation().toString()) != null
						|| FileManager3.Button3.getString(e.getClickedBlock().getLocation().toString()) != null){
					return;
				}
				int box = 0;
				for(int i = 0; i < 50; i++){
					if(ScrBox.contains("Box"+i)){
						ConfigurationSection section = ScrBox.getConfigurationSection("Box"+i);
						if(section.contains("PasteX."+i) && section.contains("SpawnAX."+i) && section.contains("SpawnIX."+i) && section.contains("HoloX."+i) && section.contains("Rotate."+i)){
							if(new Location(Bukkit.getWorld("Community"), section.getDouble("KnopfX."+i), section.getDouble("KnopfY."+i), section.getDouble("KnopfZ."+i))
							.equals(e.getClickedBlock().getLocation())){
								box = i; 
								break;
							}
						}
					}
				}
				
				if(box == 0){
					return;
				}
				
			    if (p.hasPermission("Rangsystem.Premium+") || p.hasPermission("Rangsystem.Streamer") || p.hasPermission("Rangsystem.Youtuber")
			    		|| p.hasPermission("Rangsystem.Developer") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")) {				
		    		if(Main.boxen.get(box).isInWarteschlange(p)){
		    			p.sendMessage(Main.screenb + "§cDu bist bereits in einer §5Screenbox§c.");
		    			return;
		    		}
		    		
		    		if(Main.boxen.get(box).getInbox() == null){
		    			if(VanishCommand.vanished.contains(p)){
		    				p.sendMessage(Main.screenb + "§7Du bist aktuell noch im §eVanish§7.");
		    			}else{
		    				if(Main.edit.contains(p)){
		    					Main.edit.remove(p);
		    					p.getInventory().clear();
		    					p.getInventory().setArmorContents(null);
		    					p.setGameMode(GameMode.ADVENTURE);
		    				}  				
			    			Main.boxen.get(box).setInbox(p);
			    			p.getInventory().clear();
			    			Methoden.setScreenboxItems(p);
		    			}
		    		}else{
		    			if(!Main.boxen.get(box).isInWarteschlange(p)){
			    			Main.boxen.get(box).addForcedToWarteschlange(p);
				    		p.sendMessage(Main.screenb + "§aDu wurdest zur Warteschlange hinzugefügt.");			    		
		    			}else{
		    				p.sendMessage(Main.screenb + "§cDu bist bereits in der Warteschlange!");
		    			}
		    		}
		    	}else{
		    		if(!(Main.boxen.get(box).getInbox() == null)){
		    			if(!Main.boxen.get(box).isInWarteschlange(p)){
				    		Main.boxen.get(box).addToWarteschlange(p);
				    		p.sendMessage(Main.screenb + "§aDu wurdest zur Warteschlange hinzugefügt.");
		    			}else{
		    				p.sendMessage(Main.screenb + "§cDu bist bereits in der Warteschlange!");
		    			}
		    		}else{
		    			p.sendMessage(Main.screenb + "§cDiese Box ist aktuell leer. :/");
		    		}
		    	}
			}
		}	
	}
}
