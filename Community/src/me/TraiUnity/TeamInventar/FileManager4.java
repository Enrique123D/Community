package me.TraiUnity.TeamInventar;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class FileManager4 implements Listener {

	public static File MySQLFile4 = new File("plugins/TraidioNET-Traiunity_V3/Team", "MySQL.yml");
	public static YamlConfiguration MySQL4 = YamlConfiguration.loadConfiguration(MySQLFile4);
	
	public static File ButtonsFile4 = new File("plugins/TraidioNET-Traiunity_V3/Team", "Button4.yml");
	public static YamlConfiguration Button4 = YamlConfiguration.loadConfiguration(ButtonsFile4);
	
}
