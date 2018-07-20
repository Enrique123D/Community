package me.TraiUnity.EffekteMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import me.TraiUnity.Main;
import me.TraiUnity.MusikMenu.Music;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class Effects {
	
	public static BukkitTask laser;
	public static BukkitTask explosion;
	public static BukkitTask blitze;
	public static BukkitTask nebel;
	public static BukkitTask konfetti;
	public static BukkitTask flammenwerfer;
	public static BukkitTask stroboskop;
	public static BukkitTask feuerwerk;
	public static BukkitTask welle;
	public static BukkitTask heartcannon;
	public static BukkitTask spiralen;
	public static BukkitTask flammen;
	public static BukkitTask rauch;

	public static boolean on = false;
	
	public static ArrayList<ArmorStand> armors = new ArrayList<>();
	public static ArrayList<Laser> lasers = new ArrayList<>();
	public static ArrayList<TNTPrimed> tnt = new ArrayList<>();
	
	public static int laserspeed = 20;
	public static int laserzahl = 1;
	public static int lasertime = 0;
	
	public static int flammenanzahl = 4;
	public static int flammenhöhe = 2;

	public static void stoptAlleEffekte(){
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(Bukkit.getOnlinePlayers().isEmpty()){
					endLasershow();
					endBlitze();
					endExplosion();
					endFeuerwerk();
					endFlammenwerfer();
					endheartcannon();
					endKonfetti();
					endNebel();
					endStroboskop();
					endWelle();
					
					Music.aktuelle_playlist.clear();
					Music.aktueller_player.destroy();
					Music.aktuelles_lied = null;
					Music.aktueller_player = null;
					Music.loop = false;
					Music.pause = false;
				}
			}
		}.runTaskTimer(Main.plugin, 0, 60*20);
	}
	
	public static void startLasershow() {
		
		if(!Main.laser.exists()){
			System.out.println("[StartLasershow] (Effects Klasse)");
			return;
		}
		
		double x = Main.la.getDouble("LaserLamp1.X");
		double y = Main.la.getDouble("LaserLamp1.Y");
		double z = Main.la.getDouble("LaserLamp1.Z");
		
		double x0 = Main.la.getDouble("LaserLamp2.X");
		double y0 = Main.la.getDouble("LaserLamp2.Y");
		double z0 = Main.la.getDouble("LaserLamp2.Z");
		
		double x1 = Main.la.getDouble("LaserLamp3.X");
		double y1 = Main.la.getDouble("LaserLamp3.Y");
		double z1 = Main.la.getDouble("LaserLamp3.Z");
		
		double x2 = Main.la.getDouble("LaserLamp4.X");
		double y2 = Main.la.getDouble("LaserLamp4.Y");
		double z2 = Main.la.getDouble("LaserLamp4.Z");
		
		double x3 = Main.la.getDouble("LaserLamp5.X");
		double y3 = Main.la.getDouble("LaserLamp5.Y");
		double z3 = Main.la.getDouble("LaserLamp5.Z");
			
		Location loclicht1 = new Location(Bukkit.getWorld("Community"), x + 1, y, z);
		Location loclicht2 = new Location(Bukkit.getWorld("Community"), x0 + 1, y0, z0);
		Location loclicht3 = new Location(Bukkit.getWorld("Community"), x1 + 1, y1, z1);
		Location loclicht4 = new Location(Bukkit.getWorld("Community"), x2 + 1, y2, z2);
		Location loclicht5 = new Location(Bukkit.getWorld("Community"), x3 + 1, y3, z3);
		
		loclicht1.getBlock().setType(Material.REDSTONE_BLOCK);
		loclicht2.getBlock().setType(Material.REDSTONE_BLOCK);
		loclicht3.getBlock().setType(Material.REDSTONE_BLOCK);
		loclicht4.getBlock().setType(Material.REDSTONE_BLOCK);
		loclicht5.getBlock().setType(Material.REDSTONE_BLOCK);
				
		loclicht1.getBlock().setType(Material.AIR);
		loclicht2.getBlock().setType(Material.AIR);
		loclicht3.getBlock().setType(Material.AIR);
		loclicht4.getBlock().setType(Material.AIR);
		loclicht5.getBlock().setType(Material.AIR);
		
		List<Location> locs1 = new ArrayList<>();
		locs1.add(new Location(Bukkit.getWorld("Community"), x, y, z));
		locs1.add(new Location(Bukkit.getWorld("Community"), x0, y0, z0));
		locs1.add(new Location(Bukkit.getWorld("Community"), x1, y1, z1));
		locs1.add(new Location(Bukkit.getWorld("Community"), x2, y2, z2));
		locs1.add(new Location(Bukkit.getWorld("Community"), x3, y3, z3));
		
		double x31 = Main.la.getDouble("Laser1.X");
		double z31 = Main.la.getDouble("Laser1.Z");

		double x4 = Main.la.getDouble("Laser2.X");
		double z4 = Main.la.getDouble("Laser2.Z");
		
		double y31 = Main.la.getDouble("Laser1.Y");
		
		Location loc31 = new Location(Bukkit.getWorld("Community"), x31, y31, z31);
		Location loc4 = new Location(Bukkit.getWorld("Community"), x4, y31, z4);
		
		ArrayList<Location> locs = new ArrayList<>();
		
		int MaxX = Math.max(loc31.getBlockX(), loc4.getBlockX());
		int MaxZ = Math.max(loc31.getBlockZ(), loc4.getBlockZ());
		
		int MinX = Math.min(loc31.getBlockX(), loc4.getBlockX());
		int MinZ = Math.min(loc31.getBlockZ(), loc4.getBlockZ());
		
		for(int X = MinX; X <= MaxX; X++){
			for(int Z = MinZ; Z <= MaxZ; Z++){
				locs.add(new Location(Bukkit.getWorld("Community"), X, y31, Z));
			}
		}
		
		for(int i1 = 0; i1 < laserzahl; i1++){
			for(int i = 0; i < 5; i++){
				Collections.shuffle(locs);
				
				Laser laser = new Laser(locs1.get(i));
				ArmorStand a = locs.get(0).getWorld().spawn(locs.get(0), ArmorStand.class);
				a.setGravity(false); 
				a.setVisible(false);
				
				laser.setTarget(a);
				lasers.add(laser);
				armors.add(a);
			}
		}
		
		laser = new BukkitRunnable() {
			@Override
			public void run() {
				if(lasertime >= 100){
					lasertime = 0;
					endLasershow();
					startLasershow();
				}
				for(ArmorStand stand : armors){ 
					Collections.shuffle(locs);
					stand.teleport(locs.get(0)); 
				}
				lasertime += laserspeed;
			}	
		}.runTaskTimer(Main.plugin, 0, laserspeed);
	}
	
	public static void startExplosion() {
		
		if(!Main.expl.exists()){
			System.out.println("[startExplosion] (Effects Klasse)");
			return;
		}
		
		explosion = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				World w01 = Bukkit.getWorld(Main.explos.getString("Explosion1.World"));
				double x01 = Main.explos.getDouble("Explosion1.X");
				double y01 = Main.explos.getDouble("Explosion1.Y");
				double z01 = Main.explos.getDouble("Explosion1.Z");
				float yaw01 = (float)Main.explos.getDouble("Explosion1.Yaw");
				float pitch01 = (float)Main.explos.getDouble("Explosion1.Pitch");
				Location spawn01 = new Location(w01, x01, y01, z01, yaw01, pitch01);
				
				World w12 = Bukkit.getWorld(Main.explos.getString("Explosion2.World"));
				double x12 = Main.explos.getDouble("Explosion2.X");
				double y12 = Main.explos.getDouble("Explosion2.Y");
				double z12 = Main.explos.getDouble("Explosion2.Z");
				float yaw12 = (float)Main.explos.getDouble("Explosion2.Yaw");
				float pitch12 = (float)Main.explos.getDouble("Explosion2.Pitch");
				Location spawn12 = new Location(w12, x12, y12, z12, yaw12, pitch12);
				
				Particle c = new Particle(EnumParticle.FIREWORKS_SPARK, spawn01, true, 0, 0, 0, 0.1F, 100);
				c.sendAll();
				Particle c1 = new Particle(EnumParticle.FIREWORKS_SPARK, spawn12, true, 0, 0, 0, 0.1F, 100);
				c1.sendAll();
				
//				for (Player players : Bukkit.getOnlinePlayers()) {
//					players.spigot().playEffect(spawn01, Effect.FIREWORKS_SPARK, 0, 1, 0, 0, 0, (float) 0.1, 100, 90);
//					players.spigot().playEffect(spawn12, Effect.FIREWORKS_SPARK, 0, 1, 0, 0, 0, (float) 0.1, 100, 90);
//				}
			}
		}, 10, 10);
	}
	
	public static void startBlitze(){
		
		if(!Main.bli.exists()){
			System.out.println("[startBlitze] (Effects Klasse)");
			return;
		}
		
		LinkedList<Location> locs = new LinkedList<>();
		
		double x0 = Main.bliz.getDouble("Blitze1.X");
		double y0 = Main.bliz.getDouble("Blitze1.Y");
		double z0 = Main.bliz.getDouble("Blitze1.Z");
		
		double x1 = Main.bliz.getDouble("Blitze2.X");
		double y1 = Main.bliz.getDouble("Blitze2.Y");
		double z1 = Main.bliz.getDouble("Blitze2.Z");
		
		Location loc1 = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), x0, y0, z0);
		Location loc2 = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), x1, y1, z1);
		
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
					if(loc.getBlock().getType().equals(Material.AIR))
						locs.add(loc);
				}
			}
		}
		
		blitze = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				Collections.shuffle(locs);
				locs.get(0).getWorld().strikeLightningEffect(locs.get(0));				
			}		
		}, 0, 20);
	}
	
	public static void startNebel(){
		
		if(!Main.nebel.exists()){
			System.out.println("[startNebel] (Effects Klasse)");
			return;
		}
		
		Random r = new Random();
		
		nebel = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				Collections.shuffle(Main.locs2);
				
				for(Location loc : Main.locs2){
					Particle c = new Particle(EnumParticle.CLOUD, loc, true, r.nextFloat(), r.nextFloat(), r.nextFloat(), 0, 1);
					c.sendAll();
				}
			}		
		}, 0, 20*2);
	}
	
	public static void startKonfetti(){
		
		if(Main.locs1.isEmpty()){
			System.out.println("[startKonfetti] (Effects Klasse)");
			return;
		}
		
		Random r = new Random();
		
		konfetti = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				Collections.shuffle(Main.locs1);
				
				for(Location loc : Main.locs1){
					Particle c = new Particle(EnumParticle.REDSTONE, loc, true, (float) (r.nextFloat()*2.3), r.nextFloat(), (float) (r.nextFloat()*2.3), 1, 1);
					c.sendAll();
				}
			}		
		}, 0, 20*2);
	}
	
	public static void startFlammenwerfer() {
		
		if(!Main.effe.exists()){
			System.out.println("[startFlammenwerfer] (Effects Klasse)");
			return;
		}
		
		flammenwerfer = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
		
				World w0 = Bukkit.getWorld(Main.eff.getString("Flamme1.World"));
				double x0 = Main.eff.getDouble("Flamme1.X");
				double y0 = Main.eff.getDouble("Flamme1.Y");
				double z0 = Main.eff.getDouble("Flamme1.Z");
				float yaw0 = (float)Main.eff.getDouble("Flamme1.Yaw");
				float pitch0 = (float)Main.eff.getDouble("Flamme1.Pitch");
				Location spawn0 = new Location(w0, x0, y0, z0, yaw0, pitch0);
				
				World w1 = Bukkit.getWorld(Main.eff.getString("Flamme2.World"));
				double x1 = Main.eff.getDouble("Flamme2.X");
				double y1 = Main.eff.getDouble("Flamme2.Y");
				double z1 = Main.eff.getDouble("Flamme2.Z");
				float yaw1 = (float)Main.eff.getDouble("Flamme2.Yaw");
				float pitch1 = (float)Main.eff.getDouble("Flamme2.Pitch");
				Location spawn1 = new Location(w1, x1, y1, z1, yaw1, pitch1);
				
				World w2 = Bukkit.getWorld(Main.eff.getString("Flamme3.World"));
				double x2 = Main.eff.getDouble("Flamme3.X");
				double y2 = Main.eff.getDouble("Flamme3.Y");
				double z2 = Main.eff.getDouble("Flamme3.Z");
				float yaw2 = (float)Main.eff.getDouble("Flamme3.Yaw");
				float pitch2 = (float)Main.eff.getDouble("Flamme3.Pitch");
				Location spawn2 = new Location(w2, x2, y2, z2, yaw2, pitch2);
				
				World w3 = Bukkit.getWorld(Main.eff.getString("Flamme4.World"));
				double x3 = Main.eff.getDouble("Flamme4.X");
				double y3 = Main.eff.getDouble("Flamme4.Y");
				double z3 = Main.eff.getDouble("Flamme4.Z");
				float yaw3 = (float)Main.eff.getDouble("Flamme4.Yaw");
				float pitch3 = (float)Main.eff.getDouble("Flamme4.Pitch");
				Location spawn3 = new Location(w3, x3, y3, z3, yaw3, pitch3);	
				
				Particle c = new Particle(EnumParticle.LAVA, spawn0, true, 0, flammenhöhe, 0, 0.1F, flammenanzahl);
				c.sendAll();
				Particle c1 = new Particle(EnumParticle.LAVA, spawn1, true, 0, flammenhöhe, 0, 0.1F, flammenanzahl);
				c1.sendAll();
				Particle c2 = new Particle(EnumParticle.LAVA, spawn2, true, 0, flammenhöhe, 0, 0.1F, flammenanzahl);
				c2.sendAll();
				Particle c3 = new Particle(EnumParticle.LAVA, spawn3, true, 0, flammenhöhe, 0, 0.1F, flammenanzahl);
				c3.sendAll();
			}	
		}, 8, 2);
	}
	
	public static void startStroboskop(){
		
		if(!Main.strob.exists()){
			System.out.println("[startStroboskop] (Effects Klasse)");
			return;
		}
		
		stroboskop = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				double x0 = Main.strobo.getDouble("Stroboskop.X");
				double y0 = Main.strobo.getDouble("Stroboskop.Y");
				double z0 = Main.strobo.getDouble("Stroboskop.Z");
				
				Location stro = new Location(Bukkit.getWorld(Main.loc.getString("Spawn.World")), x0, y0, z0);
				
				int r = Main.strobo.getInt("Stroboskop.Radius");
				
				for(Player all : Bukkit.getOnlinePlayers()){
					if(stro.distance(all.getLocation()) <= r){
						all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 1));
					}
				}
			}
		}, 0, 1);
	}
	
	public static void startFeuerwerk() {
		
		if(!Main.fwe.exists()){
			System.out.println("[startFeuerwerk] (Effects Klasse)");
			return;
		}
		
		feuerwerk = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				for(int i = 1; i < 5; i++){
					World w0 = Bukkit.getWorld(Main.fwk.getString("Feuerwerk"+i+".World"));
					double x0 = Main.fwk.getDouble("Feuerwerk"+i+".X");
					double y0 = Main.fwk.getDouble("Feuerwerk"+i+".Y");
					double z0 = Main.fwk.getDouble("Feuerwerk"+i+".Z");
					float yaw0 = (float)Main.fwk.getDouble("Feuerwerk"+i+".Yaw");
					float pitch0 = (float)Main.fwk.getDouble("Feuerwerk"+i+".Pitch");
					Location spawn0 = new Location(w0, x0, y0, z0, yaw0, pitch0);
					
					ConfigurationSection section = Main.fwke.getConfigurationSection("Aktuell");
					
					boolean flicker = section.getString("Flicker").equalsIgnoreCase("Ja") ? true : false;
					boolean trail = section.getString("Trail").equalsIgnoreCase("Ja") ? true : false;
					
					String f = section.getString("Farbe");
					String vf = section.getString("Verblassfarbe");
					Color cf = null;
					Color cvf = null;
					
					if(f.equalsIgnoreCase("Orange")){ cf = Color.ORANGE; } if(f.equalsIgnoreCase("Magenta")){ cf = Color.FUCHSIA; } if(f.equalsIgnoreCase("Hellblau")){ cf = Color.BLUE; } 
					if(f.equalsIgnoreCase("Gelb")){ cf = Color.YELLOW; } if(f.equalsIgnoreCase("Grau")){ cf = Color.GRAY; } if(f.equalsIgnoreCase("Hellgrau")){ cf = Color.SILVER; }
					if(f.equalsIgnoreCase("Cyan")){ cf = Color.AQUA; } if(f.equalsIgnoreCase("Lila")){ cf = Color.PURPLE; } if(f.equalsIgnoreCase("Blau")){ cf = Color.NAVY; } 
					if(f.equalsIgnoreCase("Grün")){ cf = Color.GREEN; } if(f.equalsIgnoreCase("Rot")){ cf = Color.RED; }  if(f.equalsIgnoreCase("Schwarz")){ cf = Color.BLACK; }
					if(f.equalsIgnoreCase("HellGrün")){ cf = Color.LIME; }
					
					if(vf.equalsIgnoreCase("Orange")){ cvf = Color.ORANGE; } if(vf.equalsIgnoreCase("Magenta")){ cvf = Color.FUCHSIA; } if(vf.equalsIgnoreCase("Hellblau")){ cvf = Color.BLUE; } 
					if(vf.equalsIgnoreCase("Gelb")){ cvf = Color.YELLOW; } if(vf.equalsIgnoreCase("Grau")){ cvf = Color.GRAY; } if(vf.equalsIgnoreCase("Hellgrau")){ cvf = Color.SILVER; }
					if(vf.equalsIgnoreCase("Cyan")){ cvf = Color.AQUA; } if(vf.equalsIgnoreCase("Lila")){ cvf = Color.PURPLE; } if(vf.equalsIgnoreCase("Blau")){ cvf = Color.NAVY; } 
					if(vf.equalsIgnoreCase("Grün")){ cvf = Color.GREEN; } if(vf.equalsIgnoreCase("Rot")){ cvf = Color.RED; }  if(vf.equalsIgnoreCase("Schwarz")){ cvf = Color.BLACK; }
					if(vf.equalsIgnoreCase("HellGrün")){ cvf = Color.LIME; }
					
					int Höhe = Integer.parseInt(section.getString("Höhe"));
					
					String form = section.getString("Form");
					Type tform = null;
					if(form.equalsIgnoreCase("Kugel")){ tform = Type.BALL; }if(form.equalsIgnoreCase("Große Kugel")){ tform = Type.BALL_LARGE; }
					if(form.equalsIgnoreCase("Burst")){ tform = Type.BURST; }if(form.equalsIgnoreCase("Creeper")){ tform = Type.CREEPER; }
					if(form.equalsIgnoreCase("Stern")){ tform = Type.STAR; }
					
				    Firework fe = (Firework) spawn0.getWorld().spawnEntity(spawn0, EntityType.FIREWORK);
				    FireworkMeta meta = fe.getFireworkMeta();
				    meta.addEffects(FireworkEffect.builder().flicker(flicker).trail(trail).withColor(cf).withFade(cvf).with(tform).build());
				    meta.setPower(Höhe);
				    fe.setFireworkMeta(meta);
				}
			    
			}	
		}, 0, 20*5);
	}
	
	 public static void startWelle(){
		 
		 if(!Main.well.exists()){
			 System.out.println("[startWelle] (Effects Klasse)");
			 return;
		 }
		 
	    Location loc1 = new Location(Bukkit.getWorld("Community"), Main.welle.getDouble("Wave1.X"), Main.welle.getDouble("Wave1.Y"), Main.welle.getDouble("Wave1.Z"));
	    Location loc2 = new Location(Bukkit.getWorld("Community"), Main.welle.getDouble("Wave2.X"), Main.welle.getDouble("Wave2.Y"), Main.welle.getDouble("Wave2.Z"));
	    int range = Main.welle.getInt("Wave.Range");

	    if (range == 0) {
	      return;
	    }
	    if (((loc1.getZ() == loc2.getZ()) || (loc1.getX() == loc2.getX())) && (loc1.getY() == loc2.getY())){
	      final LinkedList<LinkedList<Location>> locs1 = new LinkedList<>();
	      
	      int MaxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
	      int MaxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
	      
	      int MinX = Math.min(loc1.getBlockX(), loc2.getBlockX());
	      int MinZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
	      
	      int faceing = Main.welle.getInt("Wave.Faceing");
	      if (faceing == 0){
	        if (loc1.getZ() == loc2.getZ()) {
	          for (double Z = MinZ; Z <= MaxZ + range; Z += 0.25D){
	            LinkedList<Location> locs = new LinkedList<>();
	            for (double X = MinX; X <= MaxX; X += 0.5D){
	              Location loc = new Location(loc1.getWorld(), X, loc1.getY(), Z);
	              locs.add(loc);
	            }
	            locs1.add(locs);
	          }
	        } else if (loc1.getX() == loc2.getX()) {
	          for (double X = MinX; X <= MaxX + range; X += 0.25D){
	            LinkedList<Location> locs = new LinkedList<>();
	            for (double Z = MinZ; Z <= MaxZ; Z += 0.5D){
	              Location loc = new Location(loc1.getWorld(), X, loc1.getY(), Z);
	              locs.add(loc);
	            }
	            locs1.add(locs);
	          }
	        }
	      }else if (faceing == 1){
	        if (loc1.getZ() == loc2.getZ()) {
	          for (double Z = MinZ; Z >= MaxZ - range; Z -= 0.25D)
	          {
	            LinkedList<Location> locs = new LinkedList<>();
	            for (double X = MinX; X <= MaxX; X += 0.5D)
	            {
	              Location loc = new Location(loc1.getWorld(), X, loc1.getY(), Z);
	              locs.add(loc);
	            }
	            locs1.add(locs);
	          }
	        } else if (loc1.getX() == loc2.getX()) {
	          for (double X = MinX; X >= MaxX - range; X -= 0.25D){
	            LinkedList<Location> locs = new LinkedList<>();
	            for (double Z = MinZ; Z <= MaxZ; Z += 0.5D){
	              Location loc = new Location(loc1.getWorld(), X, loc1.getY(), Z);
	              locs.add(loc);
	            }
	            locs1.add(locs);
	          }
	        }
	      }else {
	        return;
	      }
	      welle = new BukkitRunnable(){
	        public void run(){
	          new BukkitRunnable(){
	            int index = 0;
	            
	            public void run() {			
					for(Location loc : locs1.get(index)){
						Particle c = new Particle(EnumParticle.FIREWORKS_SPARK, loc, true, 0, 0, 0, 0, 1);
						c.sendAll();
					}					
					index++;
					if(index == locs1.size()) cancel();
				}
	          }.runTaskTimer(Main.plugin, 0L, 6L);
	        }
	      }.runTaskTimer(Main.plugin, 0L, 120L);
	    }
	}
	 
	public static void startheartcannon() {
		
		if(!Main.hc.exists()){
			System.out.println("[startHeatcannon] (Effects Klasse)");
			return;
		}
		
	    final Location loc1 = new Location(Bukkit.getWorld("Community"), Main.heardc.getDouble("heartcannon1.X"), Main.heardc.getDouble("heartcannon1.Y"), Main.heardc.getDouble("heartcannon1.Z"),
	    		(float) Main.heardc.getDouble("heartcannon1.Yaw"), (float) Main.heardc.getDouble("heartcannon1.Pitch"));
	    final Location loc2 = new Location(Bukkit.getWorld("Community"), Main.heardc.getDouble("heartcannon2.X"), Main.heardc.getDouble("heartcannon2.Y"), Main.heardc.getDouble("heartcannon2.Z"),
	    		(float) Main.heardc.getDouble("heartcannon1.Yaw"), (float) Main.heardc.getDouble("heartcannon1.Pitch"));
	    
	    heartcannon = new BukkitRunnable() {
			
			@Override
			public void run() {
				TNTPrimed tnt1 = (TNTPrimed) loc1.getWorld().spawnEntity(loc1, EntityType.PRIMED_TNT);
				tnt1.setVelocity(loc1.getDirection().multiply(2D));
				tnt1.setFuseTicks(20);
				tnt.add(tnt1);
				
				TNTPrimed tnt2 = (TNTPrimed) loc2.getWorld().spawnEntity(loc2, EntityType.PRIMED_TNT);
				tnt2.setVelocity(loc2.getDirection().multiply(2D));
				tnt2.setFuseTicks(20);
				tnt.add(tnt2);
			}
		}.runTaskTimer(Main.plugin, 0, 33);
	}
	
	public static void startSpiralen() {
		if(!Main.spi.exists()){
			System.out.println("[startSpiralen] (Effects Klasse)");
			return;
		}
	    
	    spiralen = 	new BukkitRunnable() {
			Location loc1 = new Location(Bukkit.getWorld("Community"), Main.spir.getDouble("spirale1.X"), Main.spir.getDouble("spirale1.Y"), Main.spir.getDouble("spirale1.Z"));
			Location loc2 = new Location(Bukkit.getWorld("Community"), Main.spir.getDouble("spirale2.X"), Main.spir.getDouble("spirale2.Y"), Main.spir.getDouble("spirale2.Z"));
			Location loc3 = new Location(Bukkit.getWorld("Community"), Main.spir.getDouble("spirale3.X"), Main.spir.getDouble("spirale3.Y"), Main.spir.getDouble("spirale3.Z"));
			Location loc4 = new Location(Bukkit.getWorld("Community"), Main.spir.getDouble("spirale4.X"), Main.spir.getDouble("spirale4.Y"), Main.spir.getDouble("spirale4.Z"));
			double t = 0;
			double r = 1;
			public void run() {
				t += Math.PI/8;
				double x = r * Math.cos(t);
				double y = t;
				double z = r * Math.sin(t);
				
				loc1.add(x, y, z);
				Particle par1 = new Particle(EnumParticle.HEART, loc1, true, 0, 0, 0, 0, 1);
				par1.sendAll();
				loc1.subtract(2*x, 0, 2*z);
				Particle par11 = new Particle(EnumParticle.HEART, loc1, true, 0, 0, 0, 0, 1);
				par11.sendAll();
				loc1.add(x, -y, z);
				
				loc2.add(x, y, z);
				Particle par2 = new Particle(EnumParticle.HEART, loc2, true, 0, 0, 0, 0, 1);
				par2.sendAll();
				loc2.subtract(x, y, z);
				
				loc3.add(x, y, z);
				Particle par3 = new Particle(EnumParticle.HEART, loc3, true, 0, 0, 0, 0, 1);
				par3.sendAll();
				loc3.subtract(x, y, z);
				
				loc4.add(x, y, z);
				Particle par4 = new Particle(EnumParticle.HEART, loc4, true, 0, 0, 0, 0, 1);
				par4.sendAll();
				loc4.subtract(2*x, 0, 2*z);
				Particle par44 = new Particle(EnumParticle.HEART, loc4, true, 0, 0, 0, 0, 1);
				par44.sendAll();
				loc4.add(x, -y, z);
				
				if(t > Math.PI*6) {
					t = 0;
				}
			}
		}.runTaskTimer(Main.plugin, 0, 1);
	}
	
	public static void startFlammen() {
		if(!Main.flam.exists()){
			System.out.println("[startFlammen] (Effects Klasse)");
			return;
		}
		
		Location loc1 = new Location(Bukkit.getWorld("Community"), Main.flammen.getDouble("Flammen1.X"), Main.flammen.getDouble("Flammen1.Y"), Main.flammen.getDouble("Flammen1.Z"));
		Location loc2 = new Location(Bukkit.getWorld("Community"), Main.flammen.getDouble("Flammen2.X"), Main.flammen.getDouble("Flammen2.Y"), Main.flammen.getDouble("Flammen2.Z"));
		Location loc3 = new Location(Bukkit.getWorld("Community"), Main.flammen.getDouble("Flammen3.X"), Main.flammen.getDouble("Flammen3.Y"), Main.flammen.getDouble("Flammen3.Z"));
		Location loc4 = new Location(Bukkit.getWorld("Community"), Main.flammen.getDouble("Flammen4.X"), Main.flammen.getDouble("Flammen4.Y"), Main.flammen.getDouble("Flammen4.Z"));
		Location loc5 = new Location(Bukkit.getWorld("Community"), Main.flammen.getDouble("Flammen5.X"), Main.flammen.getDouble("Flammen5.Y"), Main.flammen.getDouble("Flammen5.Z"));
		Location loc6 = new Location(Bukkit.getWorld("Community"), Main.flammen.getDouble("Flammen6.X"), Main.flammen.getDouble("Flammen6.Y"), Main.flammen.getDouble("Flammen6.Z"));

	    flammen = new BukkitRunnable() {
			public void run() {
				Particle c = new Particle(EnumParticle.FLAME, loc1, true, 0, 2, 0, 0F, 25);
				c.sendAll();
				Particle c1 = new Particle(EnumParticle.FLAME, loc2, true, 0, 2, 0, 0F, 25);
				c1.sendAll();
				Particle c2 = new Particle(EnumParticle.FLAME, loc3, true, 0, 2, 0, 0F, 25);
				c2.sendAll();
				Particle c3 = new Particle(EnumParticle.FLAME, loc4, true, 0, 2, 0, 0F, 25);
				c3.sendAll();
				Particle c4 = new Particle(EnumParticle.FLAME, loc5, true, 0, 2, 0, 0F, 25);
				c4.sendAll();
				Particle c5 = new Particle(EnumParticle.FLAME, loc6, true, 0, 2, 0, 0F, 25);
				c5.sendAll();
			}
		}.runTaskTimer(Main.plugin, 0, 5);
	}
	
	public static void startRauchmaschine() {
		if(!Main.rauch.exists()){
			System.out.println("[startRauchmaschine] (Effects Klasse)");
			return;
		}
		
		Location loc1 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch1.X"), Main.rauchp.getDouble("Rauch1.Y"), Main.rauchp.getDouble("Rauch1.Z"));
		Location loc2 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch2.X"), Main.rauchp.getDouble("Rauch2.Y"), Main.rauchp.getDouble("Rauch2.Z"));
		Location loc3 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch3.X"), Main.rauchp.getDouble("Rauch3.Y"), Main.rauchp.getDouble("Rauch3.Z"));
		Location loc4 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch4.X"), Main.rauchp.getDouble("Rauch4.Y"), Main.rauchp.getDouble("Rauch4.Z"));
		Location loc5 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch5.X"), Main.rauchp.getDouble("Rauch5.Y"), Main.rauchp.getDouble("Rauch5.Z"));
		Location loc6 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch6.X"), Main.rauchp.getDouble("Rauch6.Y"), Main.rauchp.getDouble("Rauch6.Z"));
		Location loc7 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch7.X"), Main.rauchp.getDouble("Rauch7.Y"), Main.rauchp.getDouble("Rauch7.Z"));
		Location loc8 = new Location(Bukkit.getWorld("Community"), Main.rauchp.getDouble("Rauch8.X"), Main.rauchp.getDouble("Rauch8.Y"), Main.rauchp.getDouble("Rauch8.Z"));
		
	    rauch = new BukkitRunnable() {
			public void run() {				
				Particle c1 = new Particle(EnumParticle.SMOKE_NORMAL, loc1, true, 5, 0, 0, 0F, 250);
				c1.sendAll();
				Particle c2 = new Particle(EnumParticle.SMOKE_NORMAL, loc2, true, 5, 0, 0, 0F, 250);
				c2.sendAll();
				Particle c3 = new Particle(EnumParticle.SMOKE_NORMAL, loc3, true, 5, 0, 0, 0F, 250);
				c3.sendAll();
				Particle c4 = new Particle(EnumParticle.SMOKE_NORMAL, loc4, true, 5, 0, 0, 0F, 250);
				c4.sendAll();
				Particle c5 = new Particle(EnumParticle.SMOKE_NORMAL, loc5, true, 5, 0, 0, 0F, 250);
				c5.sendAll();
				Particle c6 = new Particle(EnumParticle.SMOKE_NORMAL, loc6, true, 5, 0, 0, 0F, 250);
				c6.sendAll();
				Particle c7 = new Particle(EnumParticle.SMOKE_NORMAL, loc7, true, 5, 0, 0, 0F, 250);
				c7.sendAll();
				Particle c8 = new Particle(EnumParticle.SMOKE_NORMAL, loc8, true, 5, 0, 0, 0F, 250);
				c8.sendAll();
			}
		}.runTaskTimer(Main.plugin, 0, 5);		
	}
	
	public static void endLasershow() {
		 laser.cancel();
			
		 for(ArmorStand stand : armors){ 
			 stand.remove(); 
		 }
		 for(Laser las : lasers){
			 las.despawn(null); 
		 }
			 
		 double x = Main.la.getDouble("LaserLamp1.X");
		 double y = Main.la.getDouble("LaserLamp1.Y");
		 double z = Main.la.getDouble("LaserLamp1.Z");
			
		 double x0 = Main.la.getDouble("LaserLamp2.X");
		 double y0 = Main.la.getDouble("LaserLamp2.Y");
		 double z0 = Main.la.getDouble("LaserLamp2.Z");
		 
		 double x1 = Main.la.getDouble("LaserLamp3.X");
		 double y1 = Main.la.getDouble("LaserLamp3.Y");
		 double z1 = Main.la.getDouble("LaserLamp3.Z");
			
		 double x2 = Main.la.getDouble("LaserLamp4.X");
		 double y2 = Main.la.getDouble("LaserLamp4.Y");
		 double z2 = Main.la.getDouble("LaserLamp4.Z");
			
		 double x3 = Main.la.getDouble("LaserLamp5.X");
		 double y3 = Main.la.getDouble("LaserLamp5.Y");
		 double z3 = Main.la.getDouble("LaserLamp5.Z");
		 
		 Location loclicht1 = new Location(Bukkit.getWorld("Community"), x, y, z);
		 Location loclicht2 = new Location(Bukkit.getWorld("Community"), x0, y0, z0);
		 Location loclicht3 = new Location(Bukkit.getWorld("Community"), x1, y1, z1);
		 Location loclicht4 = new Location(Bukkit.getWorld("Community"), x2, y2, z2);
		 Location loclicht5 = new Location(Bukkit.getWorld("Community"), x3, y3, z3);
		 
		 loclicht1.getBlock().setType(Material.REDSTONE_LAMP_OFF);
		 loclicht2.getBlock().setType(Material.REDSTONE_LAMP_OFF);
		 loclicht3.getBlock().setType(Material.REDSTONE_LAMP_OFF);
		 loclicht4.getBlock().setType(Material.REDSTONE_LAMP_OFF);
		 loclicht5.getBlock().setType(Material.REDSTONE_LAMP_OFF);
	}
	 
	public static void endBlitze() {
		blitze.cancel();
	}
	
	public static void endNebel() {
		nebel.cancel();
	}
	
	public static void endKonfetti() {
		konfetti.cancel();
	}
	
	public static void endFlammenwerfer() {
		flammenwerfer.cancel();
	}
	
	public static void endExplosion() {
		explosion.cancel();
	}

	public static void endStroboskop() {
		stroboskop.cancel();
	}
	
	public static void endFeuerwerk() {
		feuerwerk.cancel();
	}

	public static void endWelle() {
		welle.cancel();
	}
	
	public static void endheartcannon() {
		heartcannon.cancel();		
	}
	
	public static void endSpiralen(){
		spiralen.cancel();
	}
	
	public static void endFlammen(){
		flammen.cancel();
	}
	
	public static void endRauchmaschine(){
		rauch.cancel();
	}
}
