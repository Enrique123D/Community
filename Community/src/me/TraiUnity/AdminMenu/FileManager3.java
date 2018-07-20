package me.TraiUnity.AdminMenu;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class FileManager3 implements Listener {

	public static File MySQLFile3 = new File("plugins/TraidioNET-Traiunity_V3/Admin", "MySQL.yml");
	public static YamlConfiguration MySQL3 = YamlConfiguration.loadConfiguration(MySQLFile3);
	
	public static File ButtonsFile3 = new File("plugins/TraidioNET-Traiunity_V3/Admin", "Button3.yml");
	public static YamlConfiguration Button3 = YamlConfiguration.loadConfiguration(ButtonsFile3);
	
}
