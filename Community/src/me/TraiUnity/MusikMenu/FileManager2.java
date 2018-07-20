package me.TraiUnity.MusikMenu;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class FileManager2 implements Listener {
	
	public static File ButtonsFile2 = new File("plugins/TraidioNET-Traiunity_V3/Musik", "Button2.yml");
	public static YamlConfiguration Button2 = YamlConfiguration.loadConfiguration(ButtonsFile2);
	
	public static File subfile = new File("plugins/TraidioNET-Traiunity_V3/Musik", "SubIDs.yml");
	public static YamlConfiguration subcfg = YamlConfiguration.loadConfiguration(subfile);
	
}