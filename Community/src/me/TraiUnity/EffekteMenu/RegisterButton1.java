package me.TraiUnity.EffekteMenu;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.material.Button;

import me.TraiUnity.Main;

public class RegisterButton1 implements Listener {

	@EventHandler
	public void onSignChangeB1(SignChangeEvent e){
	
		Player p = e.getPlayer();
	
		if(e.getLine(0).equalsIgnoreCase("[Effekte]") &&
			e.getBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.WOOD_BUTTON){
			
			if(FileManager1.Button1.contains(e.getBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().getLocation().toString())){
		
				e.setCancelled(true);
				e.getPlayer().sendMessage(Main.commip + "§cAn dieser Stelle wurde bereits");
				e.getPlayer().sendMessage(Main.commip + "§cein §eButton §cregistriert.");
				e.getBlock().breakNaturally();
				
			}else{
				
				FileManager1.Button1.set(e.getBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().getLocation().toString(), "");
				
				try{
					FileManager1.Button1.save(FileManager1.ButtonsFile1);
				}catch(IOException ex){
					e.getPlayer().sendMessage(Main.commip + "§cFehler beim Editieren der Buttondatei.");
				}
				e.getBlock().setType(Material.AIR);
				e.getPlayer().sendMessage(Main.commip + "§aDer §eButton §afür §bEffekte §awurde erstellt.");
				e.getPlayer().playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}		
	}
	
	public static Button button(BlockFace f, Button button){
		button.setFacingDirection(f);
		return button;
	}
}
