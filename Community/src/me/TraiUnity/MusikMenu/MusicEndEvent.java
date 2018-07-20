package me.TraiUnity.MusikMenu;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import com.xxmicloxx.NoteBlockAPI.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.SongEndEvent;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import me.TraiUnity.Main;
import me.TraiUnity.EffekteMenu.Effects;
import me.TraiUnity.EffekteMenu.InventarClick1Listener;

public class MusicEndEvent implements Listener{
	
	  @SuppressWarnings("static-access")
	@EventHandler
	  public void onSongend(SongEndEvent e){
		  if(e.getSongPlayer().getSong().equals(Music.aktuelles_lied.getSong())){
			  
			  for(Player all : Bukkit.getOnlinePlayers()){
				  if(all.hasPermission("Rangsystem.Owner")){
					  all.sendMessage(Main.musik + "§7Lied§8: §c" + Music.aktuelles_lied.getName() + " §8● §7Länge§8: §a" + Main.minuten + " Min. §7und §a" + Main.sekunden + " Sek.");
				  }
			  }
			  
			  if(InventarClick1Listener.Settings11.getString("Config.Lasershow").equals("true")){
				  InventarClick1Listener.Settings11.set("Config.Lasershow", "false");
					
				  try{
					  InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
				  }catch(IOException f){
					  f.printStackTrace();
				  }
					
				  try{
					  InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
				  }catch(IOException e1){
					  e1.printStackTrace();
				  }catch(InvalidConfigurationException e1){
					  e1.printStackTrace();
				  }
					
				  Effects.endLasershow();
				  
				  for(Player all1 : Bukkit.getOnlinePlayers()){
					  InventarClick1Listener.s.loadConfig(all1);	    			    				
				  }
  			  		
				  for(Player all : Bukkit.getOnlinePlayers()){
					  if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
						  new BukkitRunnable() {							
							  @Override
							  public void run() {
								  InventarClick1Listener.s.openInv();
							  }
						  }.runTaskLater(Main.plugin, 40);
					  }
				  }
			  }
			  
			  if(InventarClick1Listener.Settings11.getString("Config.Fire Shots").equals("true")){
				  InventarClick1Listener.Settings11.set("Config.Fire Shots", "false");
					
				  try{
					  InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
				  }catch(IOException f){
					  f.printStackTrace();
				  }
					
				  try{
					  InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
				  }catch(IOException e1){
					  e1.printStackTrace();
				  }catch(InvalidConfigurationException e1){
					  e1.printStackTrace();
				  }
				  
				  Effects.flammenhöhe = 2;
				  Effects.flammenanzahl = 4;
				  
				  Effects.endFlammenwerfer();
				  
				  for(Player all1 : Bukkit.getOnlinePlayers()){
					  InventarClick1Listener.s.loadConfig(all1);	    			    				
				  }
  			  		
				  for(Player all : Bukkit.getOnlinePlayers()){
					  if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
						  new BukkitRunnable() {							
							  @Override
							  public void run() {
								  InventarClick1Listener.s.openInv();
							  }
						  }.runTaskLater(Main.plugin, 40);
					  }
				  }
			  }
			  
			  if(InventarClick1Listener.Settings11.getString("Config.Flammen").equals("true")){
				  InventarClick1Listener.Settings11.set("Config.Flammen", "false");
					
				  try{
					  InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
				  }catch(IOException f){
					  f.printStackTrace();
				  }
					
				  try{
					  InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
				  }catch(IOException e1){
					  e1.printStackTrace();
				  }catch(InvalidConfigurationException e1){
					  e1.printStackTrace();
				  }
				  
				  Effects.endFlammen();
				  
				  for(Player all1 : Bukkit.getOnlinePlayers()){
					  InventarClick1Listener.s.loadConfig(all1);	    			    				
				  }
  			  		
				  for(Player all : Bukkit.getOnlinePlayers()){
					  if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
						  new BukkitRunnable() {							
							  @Override
							  public void run() {
								  InventarClick1Listener.s.openInv();
							  }
						  }.runTaskLater(Main.plugin, 40);
					  }
				  }
			  }
			  
			  if(InventarClick1Listener.Settings11.getString("Config.Konfetti").equals("true")){
				  InventarClick1Listener.Settings11.set("Config.Konfetti", "false");
					
				  try{
					  InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
				  }catch(IOException f){
					  f.printStackTrace();
				  }
					
				  try{
					  InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
				  }catch(IOException e1){
					  e1.printStackTrace();
				  }catch(InvalidConfigurationException e1){
					  e1.printStackTrace();
				  }
				  
				  Effects.endKonfetti();
				  
				  for(Player all1 : Bukkit.getOnlinePlayers()){
					  InventarClick1Listener.s.loadConfig(all1);	    			    				
				  }
  			  		
				  for(Player all : Bukkit.getOnlinePlayers()){
					  if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
						  new BukkitRunnable() {							
							  @Override
							  public void run() {
								  InventarClick1Listener.s.openInv();
							  }
						  }.runTaskLater(Main.plugin, 40);
					  }
				  }
			  }
			  
			  Music.aktuelles_lied = null;
			  if(Music.loop) 
				  Music.aktuelle_playlist.add(Music.aktuelle_playlist.get(0));
			  Music.aktuelle_playlist.remove(0);
			  Music.aktueller_player = null;
			  
			  Main.musikstart = false;
 
			  if(!Music.aktuelle_playlist.isEmpty()){
				  new BukkitRunnable() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						Music.aktuelles_lied = Music.aktuelle_playlist.get(0);
						SongPlayer sp = new RadioSongPlayer(Music.aktuelles_lied.getSong());
						sp.setAutoDestroy(true);
						for(Player all : Bukkit.getOnlinePlayers()){
							sp.addPlayer(all); 					  
						}
						sp.setPlaying(true);
						Music.aktueller_player = sp;
						
    	    			Main.startMusikZahl();
    	    			Main.musikstart = true;
						
    	    			if(Music.aktuelles_lied.getName().equalsIgnoreCase("Faded")){
    		  			  	if(InventarClick1Listener.Settings11.getString("Config.Flammen").equals("false")){
    							InventarClick1Listener.Settings11.set("Config.Flammen", "true");
    							
    							try{
    								InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
    							}catch(IOException f){
    								f.printStackTrace();
    							}
    							
    							try{
    								InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
    							}catch(IOException e1){
    								e1.printStackTrace();
    							}catch(InvalidConfigurationException e1){
    								e1.printStackTrace();
    							}
    							
    		  			  		Effects.startFlammen();
    		  			  		    		  			  		
    		  			  		for(Player all1 : Bukkit.getOnlinePlayers()){
    		  			  			InventarClick1Listener.s.loadConfig(all1);	    			    				
    		  			  		}
    		  			  		
    		  			  		for(Player all : Bukkit.getOnlinePlayers()){
    		  			  			if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
    		  			  				new BukkitRunnable() {							
    		  			  					@Override
    		  			  					public void run() {
    		  			  						InventarClick1Listener.s.openInv();
    		  			  					}
    		  			  				}.runTaskLater(Main.plugin, 40);
    		  			  			}
    		  			  		}
    		  			  	}
    	    			}
    	    			
    	    			if(Music.aktuelles_lied.getName().equalsIgnoreCase("Geboren um zu Leben")){
    		  			  	if(InventarClick1Listener.Settings11.getString("Config.Lasershow").equals("false")){
    							InventarClick1Listener.Settings11.set("Config.Lasershow", "true");
    							
    							try{
    								InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
    							}catch(IOException f){
    								f.printStackTrace();
    							}
    							
    							try{
    								InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
    							}catch(IOException e1){
    								e1.printStackTrace();
    							}catch(InvalidConfigurationException e1){
    								e1.printStackTrace();
    							}
    							
    			    			if(Effects.laserzahl != 2){
    			    				Effects.laserzahl = 2;
    			    			}
    			    			
    			    			if(Effects.laserspeed != 5){
    			    				Effects.laserspeed = 5;
    			    			}
    							
    			    			Effects.startLasershow();
    			    			    		  			  		
    		  			  		for(Player all1 : Bukkit.getOnlinePlayers()){
    		  			  			InventarClick1Listener.s.loadConfig(all1);	    			    				
    		  			  		}
    		  			  		
    		  			  		for(Player all : Bukkit.getOnlinePlayers()){
    		  			  			if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
    		  			  				new BukkitRunnable() {							
    		  			  					@Override
    		  			  					public void run() {
    		  			  						InventarClick1Listener.s.openInv();
    		  			  					}
    		  			  				}.runTaskLater(Main.plugin, 40);
    		  			  			}
    		  			  		}
    		  			  	}
    		  			  	if(InventarClick1Listener.Settings11.getString("Config.Fire Shots").equals("false")){
    							InventarClick1Listener.Settings11.set("Config.Fire Shots", "true");
    							
    							try{
    								InventarClick1Listener.Settings11.save(InventarClick1Listener.File1);
    							}catch(IOException f){
    								f.printStackTrace();
    							}
    							
    							try{
    								InventarClick1Listener.Settings11.load(InventarClick1Listener.File1);
    							}catch(IOException e1){
    								e1.printStackTrace();
    							}catch(InvalidConfigurationException e1){
    								e1.printStackTrace();
    							}
    										
    							Effects.flammenhöhe = 2;
    							Effects.flammenanzahl = 4;
    							
    			    			Effects.startFlammenwerfer();
    			    			    		  			  		
    		  			  		for(Player all1 : Bukkit.getOnlinePlayers()){
    		  			  			InventarClick1Listener.s.loadConfig(all1);	    			    				
    		  			  		}
    		  			  		
    		  			  		for(Player all : Bukkit.getOnlinePlayers()){
    		  			  			if(all.getOpenInventory().getTitle().startsWith("§bEffekte §8● §7Seite§8: §a1")){	    		  		    				
    		  			  				new BukkitRunnable() {							
    		  			  					@Override
    		  			  					public void run() {
    		  			  						InventarClick1Listener.s.openInv();
    		  			  					}
    		  			  				}.runTaskLater(Main.plugin, 40);
    		  			  			}
    		  			  		}
    		  			  	}
    	    			}
    	    			
						for(Player all : Bukkit.getOnlinePlayers()){
    						all.sendTitle("§7Nun spielt", "§e" + Music.aktuelles_lied.getName() + " §8● §e" + Music.aktuelles_lied.getInterpret());
						}				  
					}
				}.runTaskLater(Main.plugin, 30);
			  }
		  }
	  }
}
