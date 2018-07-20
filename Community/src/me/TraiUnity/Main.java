package me.TraiUnity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import me.TraiUnity.AdminMenu.FileManager3;
import me.TraiUnity.AdminMenu.InteractEvent3;
import me.TraiUnity.AdminMenu.RegisterButton3;
import me.TraiUnity.AdminMenu.Settings3;
import me.TraiUnity.Commands.BuildCommand;
import me.TraiUnity.Commands.CEventCommand;
import me.TraiUnity.Commands.COnlineCommand;
import me.TraiUnity.Commands.CPSCommand;
import me.TraiUnity.Commands.CTeamCommand;
import me.TraiUnity.Commands.ClearChatMeCommand;
import me.TraiUnity.Commands.DifficultyCommand;
import me.TraiUnity.Commands.DiscoBootsCommand;
import me.TraiUnity.Commands.ErweiterungsCommand;
import me.TraiUnity.Commands.FlyCommand;
import me.TraiUnity.Commands.GameModeCommand;
import me.TraiUnity.Commands.GetPingCommand;
import me.TraiUnity.Commands.GlobalMuteCommand;
import me.TraiUnity.Commands.InvseeCommand;
import me.TraiUnity.Commands.KickallCommand;
import me.TraiUnity.Commands.KillCommand;
import me.TraiUnity.Commands.LaggClearCommand;
import me.TraiUnity.Commands.OpCommand;
import me.TraiUnity.Commands.RenameCommand;
import me.TraiUnity.Commands.RideCommand;
import me.TraiUnity.Commands.SetEventCommand;
import me.TraiUnity.Commands.SetTBCommand;
import me.TraiUnity.Commands.SkullCommand;
import me.TraiUnity.Commands.SpeedCommand;
import me.TraiUnity.Commands.TaschenRechnerCommand;
import me.TraiUnity.Commands.TeleportAllCommand;
import me.TraiUnity.Commands.TeleporthereCommand;
import me.TraiUnity.Commands.VanishCommand;
import me.TraiUnity.EffekteMenu.Effects;
import me.TraiUnity.EffekteMenu.FileManager1;
import me.TraiUnity.EffekteMenu.InteractEvent1;
import me.TraiUnity.EffekteMenu.InventarClick1Listener;
import me.TraiUnity.EffekteMenu.RegisterButton1;
import me.TraiUnity.EffekteMenu.SetEffekteCommand;
import me.TraiUnity.EffekteMenu.Settings1;
import me.TraiUnity.Listener.Actionbar;
import me.TraiUnity.Listener.AsyncPlayerChatEvent;
import me.TraiUnity.Listener.EventsListener;
import me.TraiUnity.Listener.InventoryClickListener;
import me.TraiUnity.Listener.JoinListener;
import me.TraiUnity.Listener.PlayerInteractListener;
import me.TraiUnity.Listener.RegionEnterListener;
import me.TraiUnity.Listener.SetBoots;
import me.TraiUnity.Listener.SignChangeListener;
import me.TraiUnity.Minispiele.SchereSteinPapier;
import me.TraiUnity.Minispiele.VersteckenCommand;
import me.TraiUnity.MusikMenu.FileManager2;
import me.TraiUnity.MusikMenu.InteractEvent2;
import me.TraiUnity.MusikMenu.InventarClick2Listener;
import me.TraiUnity.MusikMenu.Music;
import me.TraiUnity.MusikMenu.MusicEndEvent;
import me.TraiUnity.MusikMenu.RegisterButton2;
import me.TraiUnity.MusikMenu.SetSignCommand;
import me.TraiUnity.MusikMenu.Settings2;
import me.TraiUnity.Screenbox.KnopfInteractEvent;
import me.TraiUnity.Screenbox.Screenbox;
import me.TraiUnity.Screenbox.ScreenboxCommand;
import me.TraiUnity.Secrets.SecretBuild;
import me.TraiUnity.Secrets.SecretCommand;
import me.TraiUnity.Secrets.SecretInteract;
import me.TraiUnity.Secrets.SecretJoin;
import me.TraiUnity.TeamInventar.FileManager4;
import me.TraiUnity.TeamInventar.InteractEvent4;
import me.TraiUnity.TeamInventar.RegisterButton4;
import me.TraiUnity.WarpSystem.SchildClickListener;
import me.TraiUnity.WarpSystem.WarpCommand;
import net.minecraft.server.v1_8_R3.MinecraftServer;

//(C) 2018 Enrique von Dombrowski und Jonas Klein

public class Main extends JavaPlugin {

	public static String pre = "§8§l┃ §bTraidioNET §8┃ ";
	public static String commip = "§8§l┃ §5Community §8┃ ";
	public static String verstecken = "§8§l┃ §eVerstecken §8┃ ";
	public static String ssp = "§8§l┃ §eSSP §8┃ ";
	public static String secret = "§8§l┃ §eSecret §8┃ ";
	public static String event = "§8§l┃ §bEvent §8┃ ";
	public static String musik = "§8§l┃ §eMusik §8┃ ";
	public static String screenb = "§8§l┃ §5Screenbox §8┃ ";
	public static String ccc = "§8§l┃ §eCCC §8┃ ";
	public static String nac = "§8§l┃ §cNAC §8┃ ";
	public static String tr = "§8§l┃ §eTS §8┃ ";
	public static String achtung = "§8§l┃ §cAchtung §8┃ ";
	public static String noPerms = "§cDu hast keine Berechtigung auf diesen Befehl.";
	public static String unknowncmd = commip + "§cDieser Befehl ist uns nicht bekannt.";
	
	public static String host = "127.0.0.1";
	public static String port = "3306";
	public static String user = "root";
	public static String pw = "dshchangE55";
	public static String db = "Coins";
	
	public static int subCount = 0;
	public static int viewCount = 0;
	
	public static int i = 0;
	public static int color = 0;
	public static int red = 255;
	public static int green = 0;
	public static int blue = 0;
	public static int subid = 0;
	
	public static HashMap<String, Scoreboard> score = new HashMap<>();
	public static HashMap<Player, String> playingjnr = new HashMap<>();
	public static HashMap<Integer, Screenbox> boxen = new HashMap<>();
	public static HashMap<Player, Integer> pleaseCheckThisPlayer = new HashMap<>();
	  
	public static ArrayList<Player> bt = new ArrayList<>();
	public static ArrayList<Player> fly = new ArrayList<>();
	public static ArrayList<Player> edit = new ArrayList<>();
	public static ArrayList<String> hider = new ArrayList<>();
	public static ArrayList<String> hidet = new ArrayList<>();
	
	public static List<Player> hider1 = new ArrayList<>();
	public static LinkedList<Location> locs1 = new LinkedList<>();
	public static LinkedList<Location> locs2 = new LinkedList<>();
	
	public WorldEditPlugin worldedit = null;
	public static Main plugin;

	public static boolean musikstart = false;
	
	public static Main getInstance(){
		return plugin;		
	}
	
	public static File ev = new File("plugins/TraidioNET-Traiunity_V3", "Event.yml");
	public static FileConfiguration eventa = YamlConfiguration.loadConfiguration(ev);
	
	public static File tb = new File("plugins/TraidioNET-Traiunity_V3", "Teambesprechung.yml");
	public static FileConfiguration teamb = YamlConfiguration.loadConfiguration(tb);
	
	public static File rank = new File("plugins/TraidioNET-Traiunity_V3", "RankSigns.yml");
	public static FileConfiguration ranking = YamlConfiguration.loadConfiguration(rank);
	
	public static File laser = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Laser.yml");
	public static FileConfiguration la = YamlConfiguration.loadConfiguration(laser);
	
	public static File expl = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Explosion.yml");
	public static FileConfiguration explos = YamlConfiguration.loadConfiguration(expl);
	
	public static File bli = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Blitze.yml");
	public static FileConfiguration bliz = YamlConfiguration.loadConfiguration(bli);
	
	public static File nebel = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Nebel.yml");
	public static FileConfiguration nebell = YamlConfiguration.loadConfiguration(nebel);
	
	public static File kf = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Konfetti.yml");
	public static FileConfiguration kfi = YamlConfiguration.loadConfiguration(kf);
	
	public static File effe = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Flammenwerfer.yml");
	public static FileConfiguration eff = YamlConfiguration.loadConfiguration(effe);
	
	public static File strob = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Stroboskop.yml");
	public static FileConfiguration strobo = YamlConfiguration.loadConfiguration(strob);
	
	public static File fw = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Feuerwerk.yml");
	public static FileConfiguration fwk = YamlConfiguration.loadConfiguration(fw);
	
	public static File fwe = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "FeuerwerkErweiterungen.yml");
	public static FileConfiguration fwke = YamlConfiguration.loadConfiguration(fwe);
	
	public static File well = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Welle.yml");
	public static FileConfiguration welle = YamlConfiguration.loadConfiguration(well);
	
	public static File hc = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Heartcannon.yml");
	public static FileConfiguration heardc = YamlConfiguration.loadConfiguration(hc);
	
	public static File spi = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Spiralen.yml");
	public static FileConfiguration spir = YamlConfiguration.loadConfiguration(spi);
	
	public static File flam = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Flammen.yml");
	public static FileConfiguration flammen = YamlConfiguration.loadConfiguration(flam);
	
	public static File rauch = new File("plugins/TraidioNET-Traiunity_V3/Effekte", "Rauch.yml");
	public static FileConfiguration rauchp = YamlConfiguration.loadConfiguration(rauch);
	
	public static File sign = new File("plugins/TraidioNET-Traiunity_V3/Musik", "Sign.yml");
	public static FileConfiguration signl = YamlConfiguration.loadConfiguration(sign);
	
	public static File locs = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Spawn.yml");
	public static FileConfiguration loc = YamlConfiguration.loadConfiguration(locs);
	
	public static File ytb = new File("plugins/TraidioNET-Traiunity_V3/Locations", "YT-Bühne.yml");
	public static FileConfiguration yt = YamlConfiguration.loadConfiguration(ytb);
	
	public static File sb = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Screenboxen.yml");
	public static FileConfiguration scb = YamlConfiguration.loadConfiguration(sb);
	
	public static File pyt = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Premium+UndYouTuber.yml");
	public static FileConfiguration pundyt = YamlConfiguration.loadConfiguration(pyt);
	
	public static File jnrs = new File("plugins/TraidioNET-Traiunity_V3/Locations", "JumpAndRuns.yml");
	public static FileConfiguration jnr = YamlConfiguration.loadConfiguration(jnrs);
	
	public static File vipb = new File("plugins/TraidioNET-Traiunity_V3/Locations", "VIP-Bereich.yml");
	public static FileConfiguration vip = YamlConfiguration.loadConfiguration(vipb);
	
	public static File bue = new File("plugins/TraidioNET-Traiunity_V3/Locations", "Bühne.yml");
	public static FileConfiguration buen = YamlConfiguration.loadConfiguration(bue);
			
	public static File sbn = new File("plugins/TraidioNET-Traiunity_V3/Screenbox", "Screenbox.yml");
	public static FileConfiguration sben = YamlConfiguration.loadConfiguration(sbn);
		
	public static boolean joinable = true;
	
	public static int sekunden = 0;
	public static int minuten = 0;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		this.worldedit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin("PermissionsEx"));
								
		loadConfig();
		loadFile();
		
		Bukkit.getOperators().clear();
		
		Bukkit.getConsoleSender().sendMessage(commip + "§eTraidioNET§7-§eTraiunity_V3 §aaktiviert§e.");

		Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
				
		for (World w : Bukkit.getWorlds()){
			w.setAutoSave(false);
	    	w.setThundering(false);
	    	w.setStorm(false);
	    	w.setTime(0);
		    for(Entity e : w.getEntities()){
		    	if(!(e instanceof Player)
		    			&& (!(e instanceof ArmorStand)
		    			&& (!(e instanceof ItemFrame)))){
		    		e.remove();
		    	}
		    }
		}
		
		Music.setSongs();
		
		startSign();
								
//		Effects.stoptAlleEffekte();
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				if (joinable == true) {
					if(Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers()){
						MinecraftServer.getServer().setMotd("§6");
					}else{
						MinecraftServer.getServer().setMotd("§a");					
					}
				}else{
					MinecraftServer.getServer().setMotd("§8");
				}
			}
		}, 1, 1);
		
		if(!ev.exists()){
			eventa.set("Datum", "-");
			eventa.set("Uhrzeit", "-");
			
			try {
				eventa.save(ev);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!fwe.exists()){
			
			ConfigurationSection ak = fwke.createSection("Aktuell");
			
			ak.set("Flicker", "Ja");
			ak.set("Trail", "Ja");
			ak.set("Farbe", "Cyan");
			ak.set("Verblassfarbe", "Gelb");
			ak.set("Höhe", "1");
			ak.set("Form", "Kugel");
			
			for(int i = 0; i < 18; i++){
				ConfigurationSection fe = fwke.createSection("FW." + i);
				
				fe.set("Flicker", "Ja");
				fe.set("Trail", "Ja");
				fe.set("Farbe", "Cyan");
				fe.set("Verblassfarbe", "Gelb");
				fe.set("Höhe", "1");
				fe.set("Form", "Kugel");
			}
			
			try{
				fwke.save(fwe);
			}catch(Exception e){ 
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < 50; i++){
			if(sben.contains("Box"+i)){
				ConfigurationSection section = sben.getConfigurationSection("Box"+i);
				if(section.contains("PasteX."+i) && section.contains("SpawnAX."+i) && section.contains("SpawnIX."+i) && section.contains("HoloX."+i) && section.contains("Rotate."+i)){
					Location paste = new Location(Bukkit.getWorld("Community"), section.getDouble("PasteX."+i), section.getDouble("PasteY."+i), section.getDouble("PasteZ."+i));
					Location außen = new Location(Bukkit.getWorld("Community"), section.getDouble("SpawnAX."+i), section.getDouble("SpawnAY."+i), section.getDouble("SpawnAZ."+i), (float)section.getDouble("SpawnAYaw."+i), (float)section.getDouble("SpawnAPitch."+i));
					Location innen = new Location(Bukkit.getWorld("Community"), section.getDouble("SpawnIX."+i), section.getDouble("SpawnIY."+i), section.getDouble("SpawnIZ."+i), (float)section.getDouble("SpawnIYaw."+i), (float)section.getDouble("SpawnIPitch."+i));
					Location holo = new Location(Bukkit.getWorld("Community"), section.getDouble("HoloX."+i), section.getDouble("HoloY."+i), section.getDouble("HoloZ."+i));
					int rotate = section.getInt("Rotate."+i);
					
					boxen.put(i, new Screenbox(paste, innen, außen, holo, rotate));
				}
			}
		}
		
		//Listener
				
	    Bukkit.getPluginManager().registerEvents(new InteractEvent1(), this);
	    Bukkit.getPluginManager().registerEvents(new InteractEvent2(), this);
		Bukkit.getPluginManager().registerEvents(new InteractEvent3(), this);
		Bukkit.getPluginManager().registerEvents(new InteractEvent4(), this);
		
		Bukkit.getPluginManager().registerEvents(new InventarClick1Listener(), this);
		Bukkit.getPluginManager().registerEvents(new InventarClick2Listener(), this);
		
		Bukkit.getPluginManager().registerEvents(new FileManager1(), this);
		Bukkit.getPluginManager().registerEvents(new FileManager2(), this);
		Bukkit.getPluginManager().registerEvents(new FileManager3(), this);
		Bukkit.getPluginManager().registerEvents(new FileManager4(), this);

		Bukkit.getPluginManager().registerEvents(new Settings1(), this);
		Bukkit.getPluginManager().registerEvents(new Settings2(), this);
		Bukkit.getPluginManager().registerEvents(new Settings3(), this);		
		
		Bukkit.getPluginManager().registerEvents(new RegisterButton1(), this);
		Bukkit.getPluginManager().registerEvents(new RegisterButton2(), this);
		Bukkit.getPluginManager().registerEvents(new RegisterButton3(), this);
		Bukkit.getPluginManager().registerEvents(new RegisterButton4(), this);

		Bukkit.getPluginManager().registerEvents(new Actionbar(), this);
		Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatEvent(), this);
		Bukkit.getPluginManager().registerEvents(new EventsListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new SignChangeListener(), this);
		Bukkit.getPluginManager().registerEvents(new SchildClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new RegionEnterListener(), this);
					
		Bukkit.getPluginManager().registerEvents(new KnopfInteractEvent(), this);
		
		Bukkit.getPluginManager().registerEvents(new MusicEndEvent(), this);
		
		Bukkit.getPluginManager().registerEvents(new VersteckenCommand(), this);
		Bukkit.getPluginManager().registerEvents(new SchereSteinPapier(), this);
		
		Bukkit.getPluginManager().registerEvents(new SecretBuild(), this);
		Bukkit.getPluginManager().registerEvents(new SecretInteract(), this);
		Bukkit.getPluginManager().registerEvents(new SecretJoin(), this);
		
		Bukkit.getPluginManager().registerEvents(new SitzListener(), this);
		
		//Commands
		
		getCommand("ccme").setExecutor(new ClearChatMeCommand());
		getCommand("build").setExecutor(new BuildCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("gamemode").setExecutor(new GameModeCommand());
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("kill").setExecutor(new KillCommand());
		getCommand("opme").setExecutor(new OpCommand());
		getCommand("deopme").setExecutor(new OpCommand());
		getCommand("rename").setExecutor(new RenameCommand());
		getCommand("skull").setExecutor(new SkullCommand());
		getCommand("teleportall").setExecutor(new TeleportAllCommand());
		getCommand("teleporthere").setExecutor(new TeleporthereCommand());
		getCommand("vanish").setExecutor(new VanishCommand());				
		getCommand("globalmute").setExecutor(new GlobalMuteCommand());	
		getCommand("cevent").setExecutor(new CEventCommand());
		getCommand("kickall").setExecutor(new KickallCommand());
		getCommand("setwarp").setExecutor(new WarpCommand());
		getCommand("lagg").setExecutor(new LaggClearCommand());
		getCommand("diff").setExecutor(new DifficultyCommand());
		getCommand("seteffekte").setExecutor(new SetEffekteCommand());
		getCommand("taschenrechner").setExecutor(new TaschenRechnerCommand());	
		getCommand("einstellungen").setExecutor(new ErweiterungsCommand());	
		getCommand("discoboots").setExecutor(new DiscoBootsCommand());	
		getCommand("screenbox").setExecutor(new ScreenboxCommand());
		getCommand("ride").setExecutor(new RideCommand());
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("verstecken").setExecutor(new VersteckenCommand());		
		getCommand("ssp").setExecutor(new SchereSteinPapier());
		getCommand("setevent").setExecutor(new SetEventCommand());
		getCommand("settb").setExecutor(new SetTBCommand());
		getCommand("cps").setExecutor(new CPSCommand());		
		getCommand("getping").setExecutor(new GetPingCommand());		
		getCommand("setsign").setExecutor(new SetSignCommand());
		getCommand("conline").setExecutor(new COnlineCommand());
		getCommand("cteam").setExecutor(new CTeamCommand());
		
		getCommand("secret").setExecutor(new SecretCommand());
		
		if(kf.exists()){
			Location loc1 = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), kfi.getInt("Konfetti1.X"), kfi.getInt("Konfetti1.Y"), kfi.getInt("Konfetti1.Z"));
			Location loc2 = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), kfi.getInt("Konfetti2.X"), kfi.getInt("Konfetti2.Y"), kfi.getInt("Konfetti2.Z"));
			
			int MaxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
			int MaxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
			int MaxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
			
			int MinX = Math.min(loc1.getBlockX(), loc2.getBlockX());
			int MinY = Math.min(loc1.getBlockY(), loc2.getBlockY());
			int MinZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
			
			int i = 0;
			
			for(int X = MinX; X <= MaxX; X++){
				for(int Y = MinY; Y <= MaxY; Y++){
					for(int Z = MinZ; Z <= MaxZ; Z++){
						i++;
						if(i == 7){
							Location loc = new Location(loc1.getWorld(), X, Y, Z);
							if(loc.getBlock().getType() == Material.AIR)
								locs1.add(loc);
							i = 0;
						}
					}
				}
			}
		}else{
			Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (Konfetti.yml)");
		}
			
		if(nebel.exists()){
			Location loc1 = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), nebell.getInt("Nebel1.X"), nebell.getInt("Nebel1.Y"), nebell.getInt("Nebel1.Z"));
			Location loc2 = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), nebell.getInt("Nebel2.X"), nebell.getInt("Nebel2.Y"), nebell.getInt("Nebel2.Z"));
			
			int MaxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
			int MaxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
			int MaxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
			
			int MinX = Math.min(loc1.getBlockX(), loc2.getBlockX());
			int MinY = Math.min(loc1.getBlockY(), loc2.getBlockY());
			int MinZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
			
			for(int X = MinX; X <= MaxX; X++){
				for(int Y = MinY; Y <= MaxY; Y++){
					for(int Z = MinZ; Z <= MaxZ; Z++){
						Location loc = new Location(loc1.getWorld(), X, Y, Z);
						if(loc.getBlock().getType() == Material.AIR)
							locs2.add(loc);
					}
				}
			}
		}else{
			Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (Nebel.yml)");
		}
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
		
				if(!locs.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (Spawn.yml)");
				}else{
					
					World w1 = Bukkit.getWorld(Main.loc.getString("Spawn.World"));
					double x1 = Main.loc.getDouble("Spawn.X");
					double y1 = Main.loc.getDouble("Spawn.Y");
					double z1 = Main.loc.getDouble("Spawn.Z");
					float yaw1 = (float)Main.loc.getDouble("Spawn.Yaw");
					float pitch1 = (float)Main.loc.getDouble("Spawn.Pitch");
					Location spawn = new Location(w1, x1, y1, z1, yaw1, pitch1);
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(spawn, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
				if(!ytb.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (YT-Bühne.yml)");
				}else{
					
					World w2 = Bukkit.getWorld(Main.yt.getString("YTB.World"));
					double x2 = Main.yt.getDouble("YTB.X");
					double y2 = Main.yt.getDouble("YTB.Y");
					double z2 = Main.yt.getDouble("YTB.Z");
					float yaw2 = (float)Main.yt.getDouble("YTB.Yaw");
					float pitch2 = (float)Main.yt.getDouble("YTB.Pitch");
					Location ytb = new Location(w2, x2, y2, z2, yaw2, pitch2);
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(ytb, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
				if(!sb.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (Screenboxen.yml)");
				}else{
					
					World w2 = Bukkit.getWorld(Main.scb.getString("SB.World"));
					double x2 = Main.scb.getDouble("SB.X");
					double y2 = Main.scb.getDouble("SB.Y");
					double z2 = Main.scb.getDouble("SB.Z");
					float yaw2 = (float)Main.scb.getDouble("SB.Yaw");
					float pitch2 = (float)Main.scb.getDouble("SB.Pitch");
					Location sb = new Location(w2, x2, y2, z2, yaw2, pitch2);
				
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(sb, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
				if(!jnrs.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (JumpAndRuns.yml)");
				}else{
					
					World w4 = Bukkit.getWorld(Main.jnr.getString("JnRs.World"));
					double x4 = Main.jnr.getDouble("JnRs.X");
					double y4 = Main.jnr.getDouble("JnRs.Y");
					double z4 = Main.jnr.getDouble("JnRs.Z");
					float yaw4 = (float)Main.jnr.getDouble("JnRs.Yaw");
					float pitch4 = (float)Main.jnr.getDouble("JnRs.Pitch");
					Location jnrs = new Location(w4, x4, y4, z4, yaw4, pitch4);
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(jnrs, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
				if(!ytb.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (Premium+UndYouTuber.yml)");
				}else{
					
					World w5 = Bukkit.getWorld(Main.pundyt.getString("PYT.World"));
					double x5 = Main.pundyt.getDouble("PYT.X");
					double y5 = Main.pundyt.getDouble("PYT.Y");
					double z5 = Main.pundyt.getDouble("PYT.Z");
					float yaw5 = (float)Main.pundyt.getDouble("PYT.Yaw");
					float pitch5 = (float)Main.pundyt.getDouble("PYT.Pitch");
					Location pyt = new Location(w5, x5, y5, z5, yaw5, pitch5);
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(pyt, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
				if(!vipb.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (VIP-Bereich.yml)");
				}else{
					
					World w6 = Bukkit.getWorld(Main.vip.getString("VIP.World"));
					double x6 = Main.vip.getDouble("VIP.X");
					double y6 = Main.vip.getDouble("VIP.Y");
					double z6 = Main.vip.getDouble("VIP.Z");
					float yaw6 = (float)Main.vip.getDouble("VIP.Yaw");
					float pitch6 = (float)Main.vip.getDouble("VIP.Pitch");
					Location vip = new Location(w6, x6, y6, z6, yaw6, pitch6);
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(vip, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
				if(!bue.exists()) {
					Bukkit.getConsoleSender().sendMessage(Main.achtung + "§cFehler beim abspielen der Effekte. (Bühne.yml)");
				}else{
					
					World w7 = Bukkit.getWorld(Main.buen.getString("Bühne.World"));
					double x7 = Main.buen.getDouble("Bühne.X");
					double y7 = Main.buen.getDouble("Bühne.Y");
					double z7 = Main.buen.getDouble("Bühne.Z");
					float yaw7 = (float)Main.buen.getDouble("Bühne.Yaw");
					float pitch7 = (float)Main.buen.getDouble("Bühne.Pitch");
					Location buehne = new Location(w7, x7, y7, z7, yaw7, pitch7);
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.spigot().playEffect(buehne, Effect.WITCH_MAGIC, 1, 1, 0, 0, 0, (float) 0.1, 128, 16);
					}
				}
			}
		}, 40, 40);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				if (color == 0) {
					if (blue < 255) {
						blue = blue + 15;
					} else {
						if (red > 0) {
							red = red - 15;
						} else {
							if (green < 255) {
								green = green + 15;
							} else {
								color = 1;
							}
						}
					}
				} else {
					if (blue > 0) {
						blue = blue - 15;
					} else {
						if (red < 255) {
							red = red + 15;
						} else {
							if (green > 0) {
								green = green - 15;
							} else {
								color = 0;
							}
						}
					}
				}
				
				for (Player players : Bukkit.getOnlinePlayers()) {
					if (DiscoBootsCommand.discobootsteammitglieder == true) {
						if(players.hasPermission("Rangsystem.Builder") || players.hasPermission("Rangsystem.ProbeSupporter") || players.hasPermission("Rangsystem.Supporter")
								|| players.hasPermission("Rangsystem.Moderator") || players.hasPermission("Rangsystem.SrModerator") || players.hasPermission("Rangsystem.Content")
								|| players.hasPermission("Rangsystem.JrDeveloper") || players.hasPermission("Rangsystem.Developer") || players.hasPermission("Rangsystem.SrDeveloper")
								|| players.hasPermission("Rangsystem.Administrator") || players.hasPermission("Rangsystem.Owner")){
							ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
							LeatherArmorMeta LBMeta = (LeatherArmorMeta) LB.getItemMeta();
							LBMeta.setColor(Color.fromRGB(red, green, blue));
							LB.setItemMeta(LBMeta);
							players.getInventory().setBoots(LB);
						}
					}
					if (players.getOpenInventory().getTitle() == "§bEffekte §8● §7Seite§8: §a2") {
						if(players.hasPermission("Rangsystem.SrModerator") || players.hasPermission("Rangsystem.Administrator") || players.hasPermission("Rangsystem.Owner")){

							ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
							ItemMeta PH4M = PH4.getItemMeta();
							PH4M.setDisplayName("§4✖");
							PH4.setItemMeta(PH4M);
						
							ArrayList<String> Lore1 = new ArrayList<>();
							Lore1.add("§eDisco-Schuhe §7für §aalle §7Teammitglieder");
							
							ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
	
							LeatherArmorMeta LBMeta = (LeatherArmorMeta) LB.getItemMeta();
							LBMeta.setDisplayName("§eDisco-Schuhe §8» §cTeammitglieder");
							LBMeta.setLore(Lore1);
							LBMeta.setColor(Color.fromRGB(red, green, blue));
							LB.setItemMeta(LBMeta);
							
							players.getOpenInventory().setItem(34, LB);
							players.getOpenInventory().setItem(33, PH4);
							
							if(Settings1.DiscoBootsTeammitglieder){
								if(players.hasPermission("Rangsystem.SrModerator") || players.hasPermission("Rangsystem.Administrator") || players.hasPermission("Rangsystem.Owner")){
									players.getOpenInventory().setItem(43, Settings1.getEnabled("DiscoschuheTeammitglieder"));
								}
							}else{
								if(players.hasPermission("Rangsystem.SrModerator") || players.hasPermission("Rangsystem.Administrator") || players.hasPermission("Rangsystem.Owner")){
									players.getOpenInventory().setItem(43, Settings1.getDisabled("DiscoschuheTeammitglieder"));
								}
							}				
						}
						players.updateInventory();
					}
				}

				for (Player players1 : Bukkit.getOnlinePlayers()) {
					if(DiscoBootsCommand.discobootsalle == true){
						ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
						LeatherArmorMeta LBMeta = (LeatherArmorMeta) LB.getItemMeta();
						LBMeta.setColor(Color.fromRGB(red, green, blue));
						LB.setItemMeta(LBMeta);
						players1.getInventory().setBoots(LB);
					}
					if (players1.getOpenInventory().getTitle() == "§bEffekte §8● §7Seite§8: §a2") {
						if(players1.hasPermission("Rangsystem.SrModerator") || players1.hasPermission("Rangsystem.Administrator") || players1.hasPermission("Rangsystem.Owner")){
							
							ItemStack PH4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
							ItemMeta PH4M = PH4.getItemMeta();
							PH4M.setDisplayName("§4✖");
							PH4.setItemMeta(PH4M);
							
							ArrayList<String> Lore2 = new ArrayList<>();
							Lore2.add("§eDisco-Schuhe §7für §aalle §7Spieler");
							
							ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
	
							LeatherArmorMeta LBMeta = (LeatherArmorMeta) LB.getItemMeta();
							LBMeta.setDisplayName("§eDisco-Schuhe §8» §aAlle");
							LBMeta.setLore(Lore2);
							LBMeta.setColor(Color.fromRGB(red, green, blue));
							LB.setItemMeta(LBMeta);
							
							players1.getOpenInventory().setItem(35, LB);
							players1.getOpenInventory().setItem(42, PH4);
							
							if(Settings1.DiscoBootsAlle){
								if(players1.hasPermission("Rangsystem.SrModerator") || players1.hasPermission("Rangsystem.Administrator") || players1.hasPermission("Rangsystem.Owner")){
									players1.getOpenInventory().setItem(44, Settings1.getEnabled("DiscoschuheAlle"));
								}
							}else{
								if(players1.hasPermission("Rangsystem.SrModerator") || players1.hasPermission("Rangsystem.Administrator") || players1.hasPermission("Rangsystem.Owner")){
									players1.getOpenInventory().setItem(44, Settings1.getDisabled("DiscoschuheAlle"));
								}
							}						
						}
						players1.updateInventory();
					}
				}
			}
		}, 1, 1);
	
//		MySQL.connect();
//		MySQL.connect1();
		
//		Secret.setSecretTables();
	}
	
	@Override
	public void onDisable(){
		
		Bukkit.getConsoleSender().sendMessage(commip + "§eTraidioxNET§7-§eTraiunity_V3 §cdeaktiviert§e.");
			
		if(EventsListener.Settings11.getString("Config.Lasershow").equals("true")){
			EventsListener.Settings11.set("Config.Lasershow", "false");
			Settings1.Lasershow = false;
			Effects.endLasershow();
		}
		
		if(EventsListener.Settings11.getString("Config.Explosion").equals("true")){
			EventsListener.Settings11.set("Config.Explosion", "false");
			Settings1.Explosion = false;
			Effects.endExplosion();
		}		
		
		if(EventsListener.Settings11.getString("Config.Blitze").equals("true")){
			EventsListener.Settings11.set("Config.Blitze", "false");
			Settings1.Blitze = false;
			Effects.endBlitze();
		}		
		
		if(EventsListener.Settings11.getString("Config.Nebel").equals("true")){
			EventsListener.Settings11.set("Config.Nebel", "false");
			Settings1.Nebel = false;
			Effects.endNebel();
		}		
		
		if(EventsListener.Settings11.getString("Config.Konfetti").equals("true")){
			EventsListener.Settings11.set("Config.Konfetti", "false");
			Settings1.Konfetti = false;
			Effects.endKonfetti();
		}		
		
		if(EventsListener.Settings11.getString("Config.Fire Shots").equals("true")){
			EventsListener.Settings11.set("Config.Fire Shots", "false");
			Settings1.Flammenwerfer = false;
			Effects.endFlammenwerfer();
		}
		
		if(EventsListener.Settings11.getString("Config.Stroboskop").equals("true")){
			EventsListener.Settings11.set("Config.Stroboskop", "false");
			Settings1.Stroboskop = false;
			Effects.endStroboskop();
		}	
		
		if(EventsListener.Settings11.getString("Config.Feuerwerk").equals("true")){
			EventsListener.Settings11.set("Config.Feuerwerk", "false");
			Settings1.Feuerwerk = false;
			Effects.endFeuerwerk();
		}
		
		if(EventsListener.Settings11.getString("Config.Welle").equals("true")){
			EventsListener.Settings11.set("Config.Welle", "false");
			Settings1.welle = false;
			Effects.endWelle();
		}
		
		if(EventsListener.Settings11.getString("Config.Heartcannon").equals("true")){
			EventsListener.Settings11.set("Config.Heartcannon", "false");
			Settings1.heartcannon = false;
			Effects.endheartcannon();
		}
		
		if(EventsListener.Settings11.getString("Config.Spiralen").equals("true")){
			EventsListener.Settings11.set("Config.Spiralen", "false");
			Settings1.spiralen = false;
			Effects.endSpiralen();
		}
		
		if(EventsListener.Settings11.getString("Config.DiscoschuheTeammitglieder").equals("true")){
			EventsListener.Settings11.set("Config.DiscoschuheTeammitglieder", "false");
			Settings1.DiscoBootsTeammitglieder = false;
			DiscoBootsCommand.discobootsteammitglieder = false;
		}
		
		if(EventsListener.Settings11.getString("Config.DiscoschuheAlle").equals("true")){
			EventsListener.Settings11.set("Config.DiscoschuheAlle", "false");
			Settings1.DiscoBootsAlle = false;
			DiscoBootsCommand.discobootsalle = false;
		}
		
		try{
			EventsListener.Settings11.save(EventsListener.File1);
		}catch(Exception ex){}
		
		for(Screenbox box : Main.boxen.values()){
			box.setStandsNull();
			if(box.getInbox() != null){
				box.removeInbox(false);
			}
			box.removeArmorstand();
		}
		
		for (World worlds : Bukkit.getWorlds()) {
			for (Entity ent : worlds.getEntities()) {
				if (!(ent instanceof Player)) {
						ent.remove();
				}
			}
		}
		
		for(Player all : Bukkit.getOnlinePlayers()){
			SetBoots.setBoots(all);
		}
		
		//MySQL.disconnect();
	}
	
	public static BukkitTask musikzeitzähler;
	
	public static void startMusikZahl(){
		
		if(musikzeitzähler != null){
			sekunden = 0;
			minuten = 0;
			musikzeitzähler.cancel();
		}
		
		musikzeitzähler = new BukkitRunnable() {		
			@Override
			public void run() {
				if(musikstart = true){
					if(Music.pause == false){
						sekunden++;
						
						if(sekunden == 60){
							sekunden = 0;
							minuten++;
						}
					}
				}else{
					sekunden = 0;
					minuten = 0;
					cancel();
				}				
			}
		}.runTaskTimer(plugin, 0, 20);
	}
	
	public static void startSign(){
		World w1 = Bukkit.getWorld(Main.signl.getString("Sign1.World"));
		double x1 = Main.signl.getDouble("Sign1.X");
		double y1 = Main.signl.getDouble("Sign1.Y");
		double z1 = Main.signl.getDouble("Sign1.Z");
		
		Location sign1 = new Location(w1, x1, y1, z1);
		Block b1 = sign1.getBlock();
		
		Music.pause = false;
		
		if(b1.getState() instanceof Sign){
			Sign s1 = (Sign) b1.getState();
			
			Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
								
				@SuppressWarnings("static-access")
				@Override
				public void run() {					
					if(Music.aktuelles_lied != null && Music.pause == false){						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Faded")){
							if(minuten == 1 && sekunden == 21){
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
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Still")){
							if(minuten == 0 && sekunden == 5){
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
							if(minuten == 0 && sekunden == 54){
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
							if(minuten == 1 && sekunden == 2){
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
	    										
	    							Effects.laserspeed = 5;
	    							
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
							if(minuten == 2 && sekunden == 4){
	    		  			  	if(InventarClick1Listener.Settings11.getString("Config.Konfetti").equals("false")){
	    							InventarClick1Listener.Settings11.set("Config.Konfetti", "true");
	    							
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
	    												
	    			    			Effects.startKonfetti();
	    			    			    		  
	    			    			Effects.laserspeed = 5;
	    			    			
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
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Dreamer")){
							if(minuten == 2 && sekunden == 30){
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
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Tonight im lovin you")){
							if(minuten == 0 && sekunden == 5){
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
							if(minuten == 0 && sekunden == 20){
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
							if(minuten == 2 && sekunden == 2){
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
	    											
	    							Effects.laserzahl = 1;
	    							Effects.laserspeed = 5;
	    							
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
							if(minuten == 2 && sekunden == 41){
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
	    											
	    							Effects.laserzahl = 1;
	    							Effects.laserspeed = 10;
	    							
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
						}
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Deutsche Nationalhymne")){
							if(minuten == 0 && sekunden == 13){
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
							if(minuten == 0 && sekunden == 30){
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
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("How It Is")){
							if(minuten == 0 && sekunden == 14){
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
							if(minuten == 0 && sekunden == 55){
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
							if(minuten == 1 && sekunden == 35){
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
	    												
	    							Effects.laserzahl = 1;
	    							Effects.laserspeed = 10;
	    							
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
						}
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Freaks")){
							if(minuten == 0 && sekunden == 34){
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
							if(minuten == 0 && sekunden == 50){
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
	    							
	    							Effects.laserzahl = 1;
	    							Effects.laserspeed = 10;
	    							
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
							if(minuten == 1 && sekunden == 26){
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
							if(minuten == 1 && sekunden == 26){
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
	    							
		    		  			  	Effects.laserzahl = 1;
		    		  			  	Effects.laserspeed = 5;
	    							
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
						}
						
						if(Music.aktuelles_lied.getName().equalsIgnoreCase("Obladi Oblada")){
							if(minuten == 0 && sekunden == 11){
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
							if(minuten == 1 && sekunden == 30){
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
							if(minuten == 2 && sekunden == 5){
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
	    							
	    							Effects.laserzahl = 1;
	    							Effects.laserspeed = 10;
	    							
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
						}
						
						if(Music.aktuelles_lied.getInterpret().equalsIgnoreCase("Klaus Badelt")){
							if(minuten == 0 && sekunden == 6){
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
							if(minuten == 0 && sekunden == 21){
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
	    							
	    							Effects.laserzahl = 1;
	    							Effects.laserspeed = 5;
	    							
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
							if(minuten == 0 && sekunden == 42){
	    		  			  	if(InventarClick1Listener.Settings11.getString("Config.Konfetti").equals("false")){
	    							InventarClick1Listener.Settings11.set("Config.Konfetti", "true");
	    							
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
	    							
	    							Effects.startKonfetti();
	    			    			    		  			  		
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
						
						s1.setLine(0, "*      - §2Musik §r-      *");
						s1.setLine(1, "§a" + Music.aktuelles_lied.getName());
						if(sekunden < 10){							
							for(Player all : Bukkit.getOnlinePlayers()){
								Actionbar.sendActionBar(all, "§eMusik §8┃ §6" + Music.aktuelles_lied.getName() + " §7von §6" + Music.aktuelles_lied.getInterpret() + " §8┃ §a" + minuten + ":0" + sekunden + " Min. §8/ §a" + Music.aktuelles_lied.getLänge() + " Min.");
							}
							s1.setLine(2, "§e" + minuten + ":0" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}else{							
							for(Player all : Bukkit.getOnlinePlayers()){
								Actionbar.sendActionBar(all, "§eMusik §8┃ §6" + Music.aktuelles_lied.getName() + " §7von §6" + Music.aktuelles_lied.getInterpret() + " §8┃ §a" + minuten + ":" + sekunden + " Min. §8/ §a" + Music.aktuelles_lied.getLänge() + " Min.");
							}				
							s1.setLine(2, "§e" + minuten + ":" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}
						s1.setLine(3, "*                          *");
						s1.update();
					}else if(Music.aktuelles_lied != null && Music.pause == true){
						s1.setLine(0, "*      - §2Musik §r-      *");
						s1.setLine(1, "§a" + Music.aktuelles_lied.getName());
						if(sekunden < 10){							
							for(Player all : Bukkit.getOnlinePlayers()){
								Actionbar.sendActionBar(all, "§eMusik §8┃ §6" + Music.aktuelles_lied.getName() + " §7von §6" + Music.aktuelles_lied.getInterpret() + " §8┃ §a" + minuten + ":0" + sekunden + " Min. §8/ §a" + Music.aktuelles_lied.getLänge() + " Min. §8┃ §9Pausiert");
							}						
							s1.setLine(2, "§e" + minuten + ":0" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}else{							
							for(Player all : Bukkit.getOnlinePlayers()){
								Actionbar.sendActionBar(all, "§eMusik §8┃ §6" + Music.aktuelles_lied.getName() + " §7von §6" + Music.aktuelles_lied.getInterpret() + " §8┃ §a" + minuten + ":" + sekunden + " Min. §8/ §a" + Music.aktuelles_lied.getLänge() + " Min. §8┃ §9Pausiert");
							}							
							s1.setLine(2, "§e" + minuten + ":" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}
						s1.setLine(3, "*      §9Pausiert      §r*");
						s1.update();
					}else{					
						Main.musikstart = false;						
						Main.sekunden = 0;
						Main.minuten = 0;
						
						for(Player all : Bukkit.getOnlinePlayers()){
							if(all.hasPermission("Rangsystem.ProbeSupporter") || all.hasPermission("Rangsystem.Supporter")
									|| all.hasPermission("Rangsystem.Moderator") || all.hasPermission("Rangsystem.SrModerator")
									|| all.hasPermission("Rangsystem.Content") || all.hasPermission("Rangsystem.JrDeveloper")
									|| all.hasPermission("Rangsystem.Developer") || all.hasPermission("Rangsystem.SrDeveloper")
									|| all.hasPermission("Rangsystem.Administrator") || all.hasPermission("Rangsystem.Owner")){
								Actionbar.sendActionBar(all, "§6Nächste Teambesprechung§8: §e" + Main.teamb.getString("Datum") + " §7um §e" + Main.teamb.getString("Uhrzeit") + " Uhr");
							}
						}
						
						s1.setLine(0, "*      - §2Musik §r-      *");
						s1.setLine(1, "§cAktuell läuft");
						s1.setLine(2, "§ckein Lied");
						s1.setLine(3, "*                           *");
						s1.update();
					}
				}
			}, 1, 1);
		}
		
		World w2 = Bukkit.getWorld(Main.signl.getString("Sign2.World"));
		double x2 = Main.signl.getDouble("Sign2.X");
		double y2 = Main.signl.getDouble("Sign2.Y");
		double z2 = Main.signl.getDouble("Sign2.Z");
		
		Location sign2 = new Location(w2, x2, y2, z2);
		Block b2 = sign2.getBlock();
				
		if(b2.getState() instanceof Sign){
			Sign s2 = (Sign) b2.getState();
			
			Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				
				@Override
				public void run() {		
					if(Music.aktuelles_lied != null && Music.pause == false){
						s2.setLine(0, "*      - §2Musik §r-      *");
						s2.setLine(1, "§a" + Music.aktuelles_lied.getName());
						if(sekunden < 10){
							s2.setLine(2, "§e" + minuten + ":0" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}else{
							s2.setLine(2, "§e" + minuten + ":" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}
						s2.setLine(3, "*                          *");
						s2.update();
					}else if(Music.aktuelles_lied != null && Music.pause == true){
						s2.setLine(0, "*      - §2Musik §r-      *");
						s2.setLine(1, "§a" + Music.aktuelles_lied.getName());
						if(sekunden < 10){
							s2.setLine(2, "§e" + minuten + ":0" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}else{
							s2.setLine(2, "§e" + minuten + ":" + sekunden + " Min. §8/ §e" + Music.aktuelles_lied.getLänge() + " Min.");
						}
						s2.setLine(3, "*      §9Pausiert      §r*");
						s2.update();
					}else{
						
						Main.musikstart = false;						
						Main.sekunden = 0;
						Main.minuten = 0;
						
						s2.setLine(0, "*      - §2Musik §r-      *");
						s2.setLine(1, "§cAktuell läuft");
						s2.setLine(2, "§ckein Lied");
						s2.setLine(3, "*                           *");
						s2.update();
					}
				}
			}, 1, 1);
		}
	}
	
	public static void loadFile(){
		
		if(!rank.exists()){
			try{
				ranking.save(rank);
				ranking.load(rank);
			}catch(IOException e){
				Bukkit.getConsoleSender().sendMessage(Main.commip + "§cFehler beim laden der RankFile! (SF1)");
				e.printStackTrace();
			}catch(InvalidConfigurationException e){
				e.printStackTrace();
			}			
		}
	}
	
	public void loadConfig(){		
		Settings1.loadFile();
		saveConfig();		
	}
	
	public static HashMap<Player, String> getPlayingjnr(){
	  return playingjnr;
	}
}
