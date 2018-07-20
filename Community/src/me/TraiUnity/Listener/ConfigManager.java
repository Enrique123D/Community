package me.TraiUnity.Listener;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.TraiUnity.Main;

public class ConfigManager {

    private Main plugin;
    private File file;
    private FileConfiguration cfg;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        file = new File(plugin.getDataFolder(), "positions.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
        Load();
    }


    public void Load() {
        if(!file.exists()) {
            cfg.options().copyDefaults(true);
            save();
        } else {

            try {
                cfg.load(file);
            } catch (IOException | InvalidConfigurationException ex) {
                Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            Logger.getLogger(ConfigManager.class.getName()).log( Level.SEVERE, null, e);
        }
    }

    public void saveLocation(Location loc, String name) {
        cfg.set(name + ".X",  loc.getX());
        cfg.set(name + ".Y",  loc.getY());
        cfg.set(name + ".Z",  loc.getZ());
        cfg.set(name + ".Yaw",  loc.getYaw());
        cfg.set(name + ".Pitch",  loc.getPitch());
        cfg.set(name + ".World",  loc.getWorld().getName());
        save();
    }

    public void saveBlockLocation(Location loc, String name) {
        cfg.set(name + ".X",  loc.getX());
        cfg.set(name + ".Y",  loc.getY());
        cfg.set(name + ".Z",  loc.getZ());
        cfg.set(name + ".World",  loc.getWorld().getName());
        save();
    }

    public Location LoadLocation(String name) {
        double X = cfg.getDouble(name + ".X");
        double Y = cfg.getDouble(name + ".Y");
        double Z = cfg.getDouble(name + ".Z");
        double Yaw = cfg.getDouble(name + ".Yaw");
        double Pitch = cfg.getDouble(name + ".Pitch");
        World World = plugin.getServer().getWorld(cfg.getString(name + ".World"));

        Location loc = new Location(World, X, Y, Z);
        loc.setPitch((float) Pitch);
        loc.setYaw((float) Yaw);

        return loc;
    }

    public Location LoadBlockLocation(String name) {
        double X = cfg.getDouble(name + ".X");
        double Y = cfg.getDouble(name + ".Y");
        double Z = cfg.getDouble(name + ".Z");
        World World = plugin.getServer().getWorld(cfg.getString(name + ".World"));

        Location loc = new Location(World, X, Y, Z);

        return loc;
    }

    public FileConfiguration get() {
        return cfg;
    }	
}
