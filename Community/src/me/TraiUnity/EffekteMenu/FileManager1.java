package me.TraiUnity.EffekteMenu;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import me.TraiUnity.Main;

public class FileManager1 implements Listener {

	public static File File1 = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "EffektConfig.yml");
	public static YamlConfiguration Settings1 = YamlConfiguration.loadConfiguration(File1);
	
	public static File ButtonsFile1 = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Button1.yml");
	public static YamlConfiguration Button1 = YamlConfiguration.loadConfiguration(ButtonsFile1);
	
	public static void loadFile(){
	
		if(!File1.exists()){
		
			Settings1.addDefault("Config.Lasershow", "");
			Settings1.addDefault("Config.Explosion", "");
			Settings1.addDefault("Config.Blitze", "");
			Settings1.addDefault("Config.Nebel", "");
			Settings1.addDefault("Config.Konfetti", "");
			Settings1.addDefault("Config.Fire Shots", "");
			Settings1.addDefault("Config.Stroboskop", "");
			Settings1.addDefault("Config.Feuerwerk", "");
			Settings1.addDefault("Config.Welle", "");
			Settings1.addDefault("Config.Heartcannon", "");
			Settings1.addDefault("Config.Spiralen", "");
			Settings1.addDefault("Config.Flammen", "");
			Settings1.addDefault("Config.Rauch", "");

			Settings1.set("Config.Lasershow", "false");
			Settings1.set("Config.Explosion", "false");
			Settings1.set("Config.Blitze", "false");
			Settings1.set("Config.Nebel", "false");
			Settings1.set("Config.Konfetti", "false");
			Settings1.set("Config.Fire Shots", "false");
			Settings1.set("Config.Stroboskop", "false");
			Settings1.set("Config.Feuerwerk", "false");
			Settings1.set("Config.Welle", "false");
			Settings1.set("Config.Heartcannon", "false");
			Settings1.set("Config.Spiralen", "false");
			Settings1.set("Config.Flammen", "false");
			Settings1.set("Config.Rauch", "false");

			try{
				Settings1.save(File1);
				Settings1.load(File1);
			}catch(IOException e){
				Bukkit.getConsoleSender().sendMessage(Main.commip + "§cFehler beim laden der MySQL! (SF1)");
				e.printStackTrace();
			}catch(InvalidConfigurationException e){
				e.printStackTrace();
			}
			
			if(!ButtonsFile1.exists()){
				try{
					Button1.save(ButtonsFile1);
				}catch(IOException e){
					e.printStackTrace();
				}
			}			
		}
	}
}