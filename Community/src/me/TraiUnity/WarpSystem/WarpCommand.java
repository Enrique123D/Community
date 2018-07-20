package me.TraiUnity.WarpSystem;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

	private me.TraiUnity.Main Main;
	
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}		
		
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("setwarp")) {
	      if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
	        if (args.length == 1) {
	        	String warp = args[0];
	        	addWarp(warp, p);
	        }else{
	        	p.sendMessage(Main.commip + "§cBenutze §e/setwarp §8(§7Warpname§8)");
	        }
	      }else{
	        p.sendMessage(Main.unknowncmd);
	      }
	    }else if (cmd.getName().equalsIgnoreCase("delwarp")) {
		      if (p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
	    		if (args.length == 1){
	    			String warp = args[0];
	    			delWarp(warp, p);
	    		}else{
	    			p.sendMessage(Main.commip + "§cBenutze §e/delwarp §8(§7Warpname§8)");
	    		}
	    	}else{
	    		p.sendMessage(Main.unknowncmd);
	      }
	    }
		return false;
	}
	
	@SuppressWarnings("static-access")
	public void addWarp(String warp, Player p)
	  {
	    File Warp = new File("plugins/TraidioNET-Traiunity_V3/WarpSystem", "Warp.yml");
	    FileConfiguration File = YamlConfiguration.loadConfiguration(Warp);
	    if (warpExists(warp.toLowerCase()))
	    {
	      p.sendMessage(Main.commip + "§cDer Warp §e" + warp + " §cexistiert bereits.");
	      return;
	    }
	    File.set(warp.toLowerCase() + ".world", p.getLocation().getWorld().getName());
	    File.set(warp.toLowerCase() + ".x", Double.valueOf(p.getLocation().getX()));
	    File.set(warp.toLowerCase() + ".y", Double.valueOf(p.getLocation().getY()));
	    File.set(warp.toLowerCase() + ".z", Double.valueOf(p.getLocation().getZ()));
	    File.set(warp.toLowerCase() + ".yaw", Float.valueOf(p.getLocation().getYaw()));
	    File.set(warp.toLowerCase() + ".pitch", Float.valueOf(p.getLocation().getPitch()));
	    try
	    {
	      File.save(Warp);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    p.sendMessage(Main.commip + "§7Der Warp §e" + warp + " §7wurde erfolgreich §aerstellt§7.");
	  }
	  
	  @SuppressWarnings("static-access")
	public void delWarp(String warp, Player p)
	  {
		File Warp = new File("plugins/TraidioNET-Traiunity_V3/WarpSystem", "Warp.yml");
	    FileConfiguration File = YamlConfiguration.loadConfiguration(Warp);
	    if (warpExists(warp.toLowerCase()))
	    {
	      File.set(warp.toLowerCase() + ".world", null);
	      File.set(warp.toLowerCase() + ".x", null);
	      File.set(warp.toLowerCase() + ".y", null);
	      File.set(warp.toLowerCase() + ".z", null);
	      File.set(warp.toLowerCase() + ".yaw", null);
	      File.set(warp.toLowerCase() + ".pitch", null);
	      try
	      {
	        File.save(Warp);
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	      p.sendMessage(Main.commip + "§7Der Warp §e" + warp + " §7wurde erfolgreich §centfernt§7.");
	      return;
	    }
	      p.sendMessage(Main + "§cDer Warp §e" + warp + " §cexistiert nicht.");
	  }
	  
	  public static boolean warpExists(String warp)
	  {
		File Main = new File("plugins/TraidioNET-Traiunity_V3/WarpSystem", "Warp.yml");
	    FileConfiguration File = YamlConfiguration.loadConfiguration(Main);
	    if (File.contains(warp.toLowerCase() + ".world")) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static Location getWarp(String warp)
	  {
		File Main = new File("plugins/TraidioNET-Traiunity_V3/WarpSystem", "Warp.yml");
	    FileConfiguration File = YamlConfiguration.loadConfiguration(Main);
	    Location loc = null;
	    String world = File.getString(warp + ".world");
	    double x = File.getDouble(warp + ".x");
	    double y = File.getDouble(warp + ".y");
	    double z = File.getDouble(warp + ".z");
	    float yaw = (float)File.getDouble(warp + ".yaw");
	    float pitch = (float)File.getDouble(warp + ".pitch");
	    loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
	    return loc;
		
	  }
}
