package me.TraiUnity.MusikMenu;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.xxmicloxx.NoteBlockAPI.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import me.TraiUnity.Main;
import me.TraiUnity.EffekteMenu.Effects;
import me.TraiUnity.EffekteMenu.InventarClick1Listener;
import me.TraiUnity.EffekteMenu.Settings1;

public class InventarClick2Listener implements Listener{

	@SuppressWarnings({ "deprecation", "static-access" })
	@EventHandler
	public void onKlickInv1(InventoryClickEvent e){
		
		try{
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equals("§eMusik §8● §7Seite§8: §a1")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Schließen")){
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a2")){
				Settings2.openMusik2(p);
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Effekte")){
				Settings1.openInv1(p);
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);	
			}
			
			
		}
		
		if(e.getInventory().getName().equals("§eMusik §8● §7Seite§8: §a2")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Schließen")){
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a1")){
				Settings2.openMusik1(p);
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Effekte")){
				Settings1.openInv1(p);
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);	
			}
			
			
		}
		
		if(e.getInventory().getName().startsWith("§eMusik §8● §7Seite§8:")){
	    	e.setCancelled(true);
	    	
    		if(e.getRawSlot() == 0){    
    			if(Music.aktuelles_lied == null){
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
    		}
    		
    		if(e.getRawSlot() == 16){
    			if(Music.aktuelles_lied == null){
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
    			
    			if(Music.aktuelles_lied == null){
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
    		}
    		
    		if(e.getRawSlot() == 30){
    			if(Music.aktuelles_lied == null){
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
    			}
    			
    			if(Music.aktuelles_lied == null){
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
    		}
    		
    		if(e.getRawSlot() == 31){
    			if(Music.aktuelles_lied == null){
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
    			if(Music.aktuelles_lied == null){
	  			  	if(InventarClick1Listener.Settings11.getString("Config.Nebel").equals("false")){
						InventarClick1Listener.Settings11.set("Config.Nebel", "true");
						
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
											
		    			Effects.startNebel();
		    			
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
    		}
	    	
	    	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Playlist leeren")){
	    		
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
	    			
	    			if(Effects.laserzahl == 2){
	    				Effects.laserzahl = 1;
	    			}
	    			
	    			if(Effects.laserspeed == 5){
	    				Effects.laserspeed = 20;
	    			}
	    		}
			  
	    		if(InventarClick1Listener.Settings11.getString("Config.Nebel").equals("true")){
	    			InventarClick1Listener.Settings11.set("Config.Nebel", "false");
					
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
				  
	    			Effects.endNebel();
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
			  	}
	    		
	    		if(Music.aktueller_player != null){
					Music.aktueller_player.setPlaying(false);
					Music.aktueller_player.destroy();
	    		}
				
				Music.aktueller_player = null;
				Music.aktuelles_lied = null;
				Music.aktuelle_playlist.clear();
				Music.pause = false;
				
				Main.musikstart = false;			  
				
				Settings2.openMusik1(p);
				
				p.sendMessage(Main.musik + "§7Die §cPlaylist §7wurde geleert.");				
				return;
	    	}
	    	
	    	if(e.getSlot() < 36){
	    		if(Music.aktuelle_playlist.size() == 18){
	    			p.sendMessage(Main.musik + "§cDie Playlist ist voll! §8(§eMax. 18 Lieder§8)");
	    			return;
	    		}
	    		
	    		int i = 0;
	    		
	    		if(e.getInventory().getName().equals("§eMusik §8● §7Seite§8: §a2")){
	    			i = 36;
	    		}
	    		
	    		Music.aktuelle_playlist.add(Music.songs.get(e.getSlot()+i));
	    		
	    		p.sendMessage(Main.musik + "§7Du hast §e" + e.getCurrentItem().getItemMeta().getDisplayName() + " §7zur §cPlaylist §7hinzugefügt.");
	    		
	    		if(Music.aktuelles_lied == null){
	    			Music.aktuelles_lied = Music.songs.get(e.getSlot()+i);
	    			SongPlayer sp = new RadioSongPlayer(Music.aktuelles_lied.getSong());
	    			sp.setAutoDestroy(true);
					for(Player all : Bukkit.getOnlinePlayers()){
						sp.addPlayer(all); 
					}
	    			sp.setPlaying(true);
	    			Music.aktueller_player = sp;
	    				    			
	    			Main.startMusikZahl();
	    			Main.musikstart = true;
	    			
					p.sendTitle("§7Nun spielt", "§e" + Music.aktuelles_lied.getName() + " §8● §e" + Music.aktuelles_lied.getInterpret());
	    		}	    		
	    		Settings2.openMusik1(p);
	    	}else{
	    		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPlaylist")){
	    			Music.openPlaylistInv(p);
	    		}
	    	}
	    }else if(e.getInventory().getName().equals("§bPlaylist")){
	    	e.setCancelled(true);
	    	
	    	if(e.getSlot() < 18){
	    		if(!e.getCurrentItem().getType().equals(Material.AIR)){
	    			if(Music.aktuelle_playlist.get(e.getSlot()).equals(Music.aktuelles_lied)){
	    				Music.aktueller_player.setPlaying(false);
	    				Music.aktueller_player.destroy();
	    				Music.aktuelle_playlist.remove(e.getSlot());
	    				Music.aktuelles_lied = null;

	    				Main.musikstart = false;
	    				
	    				if(!Music.aktuelle_playlist.isEmpty()){
	    					Music.aktuelles_lied = Music.aktuelle_playlist.get(0);
	    					SongPlayer sp = new RadioSongPlayer(Music.aktuelles_lied.getSong());
	    					sp.setAutoDestroy(true);
	    					for(Player all : Bukkit.getOnlinePlayers()){ sp.addPlayer(all); }
	    					sp.setPlaying(true);
	    					Music.aktueller_player = sp;
	    					
	    	    			Main.startMusikZahl();
	    	    			Main.musikstart = true;
	    					
	    					p.sendTitle("§7Nun spielt", "§e" + Music.aktuelles_lied.getName() + " §8● §e" + Music.aktuelles_lied.getInterpret());
	    				}else{
	    					Music.pause = false;
	    				}
	    			}else{
	    				Music.aktuelle_playlist.remove(e.getSlot());
	    			}    			
	    			Music.openPlaylistInv(p);
	    		}
	    	}
	    	if(e.getCurrentItem().getItemMeta().getDisplayName().startsWith("§aWiederholen §8●")){
	    		Music.loop = !Music.loop;
	    		if(Music.loop){
	    			p.sendMessage(Main.musik + "§7Wiederholen gewechselt auf §8● §aJa");
	    		}else{
	    			p.sendMessage(Main.musik + "§7Wiederholen gewechselt auf §8● §cNein");
	    		}
    			Music.openPlaylistInv(p);
    		}
	    	if(e.getCurrentItem().getItemMeta().getDisplayName().startsWith("§cStatus §8●")){
	    		Music.pause = !Music.pause;
	    		Music.aktueller_player.setPlaying(!Music.pause);
	    		if(Music.pause){
	    			p.sendMessage(Main.musik + "§7Status gewechselt auf §8● §cPausiert");
	    		}else{
	    			p.sendMessage(Main.musik + "§7Status gewechselt auf §8● §aLäuft..");
	    		}
    			Music.openPlaylistInv(p);
    		}
	    	
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zum Musik Inventar")){
				Settings2.openMusik1(p);
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
			}
	    }
	}catch(Exception ex) {}
	}
}
