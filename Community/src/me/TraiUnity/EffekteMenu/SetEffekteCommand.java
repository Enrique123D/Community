package me.TraiUnity.EffekteMenu;

import java.io.IOException;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class SetEffekteCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner") || p.getName().equalsIgnoreCase("Enrique143D")) {
			
			if(args.length == 0) {
				p.sendMessage("");
				p.sendMessage(Main.commip + "§cBenutze §e/seteffekte §8(§7Effekt§8) §8(§7Radius§8)");
				p.sendMessage("");
				p.sendMessage(Main.commip + "§7Effekte§8:");
				p.sendMessage("");
				p.sendMessage(Main.commip + "   §8» §7Laser1-4 §8(§cEcke zu Ecke§8)");
				p.sendMessage(Main.commip + "   §8» §7LaserLamp1-5");
				p.sendMessage(Main.commip + "   §8» §7Explosion1-2");
				p.sendMessage(Main.commip + "   §8» §7Blitze1-2 §8(§cEcke zu Ecke§8)");
				p.sendMessage(Main.commip + "   §8» §7Nebel1-2 §8(§cEcke zu Ecke§8)");
				p.sendMessage(Main.commip + "   §8» §7Konfetti1-2 §8(§cEcke zu Ecke§8)");
				p.sendMessage(Main.commip + "   §8» §7Flamme1-4");
				p.sendMessage(Main.commip + "   §8» §7Feuerwerk1-4");
				p.sendMessage(Main.commip + "   §8» §7Stroboskop + Radius");
				p.sendMessage(Main.commip + "   §8» §7Wave1-2");
				p.sendMessage(Main.commip + "   §8» §7Heartcannon1-2");
				p.sendMessage(Main.commip + "   §8» §7Spirale1-4");
				p.sendMessage(Main.commip + "   §8» §7Flammen1-6");
				p.sendMessage(Main.commip + "   §8» §7Rauch1-8");
				p.sendMessage("");
			}
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("hilfe")){
					p.sendMessage("");
					p.sendMessage(Main.commip + "§cBenutze §e/seteffekte §8(§7Effekt§8) §8(§7Radius§8)");
					p.sendMessage("");
					p.sendMessage(Main.commip + "§7Effekte§8:");
					p.sendMessage("");
					p.sendMessage(Main.commip + "   §8» §7Laser1-4 §8(§cEcke zu Ecke§8)");
					p.sendMessage(Main.commip + "   §8» §7LaserLamp1-5");
					p.sendMessage(Main.commip + "   §8» §7Explosion1-2");
					p.sendMessage(Main.commip + "   §8» §7Blitze1-2 §8(§cEcke zu Ecke§8)");
					p.sendMessage(Main.commip + "   §8» §7Nebel1-2 §8(§cEcke zu Ecke§8)");
					p.sendMessage(Main.commip + "   §8» §7Konfetti1-2 §8(§cEcke zu Ecke§8)");
					p.sendMessage(Main.commip + "   §8» §7Flamme1-4");
					p.sendMessage(Main.commip + "   §8» §7Feuerwerk1-4");
					p.sendMessage(Main.commip + "   §8» §7Stroboskop + Radius");
					p.sendMessage(Main.commip + "   §8» §7Wave1-2");
					p.sendMessage(Main.commip + "   §8» §7Heartcannon1-2");
					p.sendMessage(Main.commip + "   §8» §7Spirale1-4");
					p.sendMessage(Main.commip + "   §8» §7Flammen1-6");
					p.sendMessage(Main.commip + "   §8» §7Rauch1-8");
					p.sendMessage("");
				}else if(args[0].equalsIgnoreCase("Flamme1")) {
					Main.eff.set("Flamme1.World", p.getWorld().getName());
					Main.eff.set("Flamme1.X", Double.valueOf(p.getLocation().getX()));
					Main.eff.set("Flamme1.Y", Double.valueOf(p.getLocation().getY()));				
					Main.eff.set("Flamme1.Z", Double.valueOf(p.getLocation().getZ()));
					Main.eff.set("Flamme1.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.eff.set("Flamme1.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.eff.save(Main.effe);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flamme1)");
				}else if(args[0].equalsIgnoreCase("Flamme2")) {
					Main.eff.set("Flamme2.World", p.getWorld().getName());
					Main.eff.set("Flamme2.X", Double.valueOf(p.getLocation().getX()));
					Main.eff.set("Flamme2.Y", Double.valueOf(p.getLocation().getY()));				
					Main.eff.set("Flamme2.Z", Double.valueOf(p.getLocation().getZ()));
					Main.eff.set("Flamme2.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.eff.set("Flamme2.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.eff.save(Main.effe);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flamme2)");
				}else if(args[0].equalsIgnoreCase("Flamme3")) {
					Main.eff.set("Flamme3.World", p.getWorld().getName());
					Main.eff.set("Flamme3.X", Double.valueOf(p.getLocation().getX()));
					Main.eff.set("Flamme3.Y", Double.valueOf(p.getLocation().getY()));				
					Main.eff.set("Flamme3.Z", Double.valueOf(p.getLocation().getZ()));
					Main.eff.set("Flamme3.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.eff.set("Flamme3.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.eff.save(Main.effe);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flamme3)");
				}else if(args[0].equalsIgnoreCase("Flamme4")) {
					Main.eff.set("Flamme4.World", p.getWorld().getName());
					Main.eff.set("Flamme4.X", Double.valueOf(p.getLocation().getX()));
					Main.eff.set("Flamme4.Y", Double.valueOf(p.getLocation().getY()));				
					Main.eff.set("Flamme4.Z", Double.valueOf(p.getLocation().getZ()));
					Main.eff.set("Flamme4.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.eff.set("Flamme4.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.eff.save(Main.effe);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flamme4)");
				}else if(args[0].equalsIgnoreCase("Explosion1")) {
					Main.explos.set("Explosion1.World", p.getWorld().getName());
					Main.explos.set("Explosion1.X", Double.valueOf(p.getLocation().getX()));
					Main.explos.set("Explosion1.Y", Double.valueOf(p.getLocation().getY() + 0.5));				
					Main.explos.set("Explosion1.Z", Double.valueOf(p.getLocation().getZ()));
					Main.explos.set("Explosion1.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.explos.set("Explosion1.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.explos.save(Main.expl);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Explosion1)");
				}else if(args[0].equalsIgnoreCase("Explosion2")) {
					Main.explos.set("Explosion2.World", p.getWorld().getName());
					Main.explos.set("Explosion2.X", Double.valueOf(p.getLocation().getX()));
					Main.explos.set("Explosion2.Y", Double.valueOf(p.getLocation().getY() + 0.5));				
					Main.explos.set("Explosion2.Z", Double.valueOf(p.getLocation().getZ()));
					Main.explos.set("Explosion2.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.explos.set("Explosion2.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.explos.save(Main.expl);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Explosion2)");
				}else if(args[0].equalsIgnoreCase("Feuerwerk1")) {
					Main.fwk.set("Feuerwerk1.World", p.getWorld().getName());
					Main.fwk.set("Feuerwerk1.X", Double.valueOf(p.getLocation().getX()));
					Main.fwk.set("Feuerwerk1.Y", Double.valueOf(p.getLocation().getY()));				
					Main.fwk.set("Feuerwerk1.Z", Double.valueOf(p.getLocation().getZ()));
					Main.fwk.set("Feuerwerk1.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.fwk.set("Feuerwerk1.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.fwk.save(Main.fw);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Feuerwerk1)");
				}else if(args[0].equalsIgnoreCase("Feuerwerk2")) {
					Main.fwk.set("Feuerwerk2.World", p.getWorld().getName());
					Main.fwk.set("Feuerwerk2.X", Double.valueOf(p.getLocation().getX()));
					Main.fwk.set("Feuerwerk2.Y", Double.valueOf(p.getLocation().getY()));				
					Main.fwk.set("Feuerwerk2.Z", Double.valueOf(p.getLocation().getZ()));
					Main.fwk.set("Feuerwerk2.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.fwk.set("Feuerwerk2.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.fwk.save(Main.fw);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Feuerwerk2)");
				}else if(args[0].equalsIgnoreCase("Feuerwerk3")) {
					Main.fwk.set("Feuerwerk3.World", p.getWorld().getName());
					Main.fwk.set("Feuerwerk3.X", Double.valueOf(p.getLocation().getX()));
					Main.fwk.set("Feuerwerk3.Y", Double.valueOf(p.getLocation().getY()));				
					Main.fwk.set("Feuerwerk3.Z", Double.valueOf(p.getLocation().getZ()));
					Main.fwk.set("Feuerwerk3.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.fwk.set("Feuerwerk3.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.fwk.save(Main.fw);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Feuerwerk3)");
				}else if(args[0].equalsIgnoreCase("Feuerwerk4")) {
					Main.fwk.set("Feuerwerk4.World", p.getWorld().getName());
					Main.fwk.set("Feuerwerk4.X", Double.valueOf(p.getLocation().getX()));
					Main.fwk.set("Feuerwerk4.Y", Double.valueOf(p.getLocation().getY()));				
					Main.fwk.set("Feuerwerk4.Z", Double.valueOf(p.getLocation().getZ()));
					Main.fwk.set("Feuerwerk4.Yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.fwk.set("Feuerwerk4.Pitch", Double.valueOf(p.getLocation().getPitch()));
					try{
						Main.fwk.save(Main.fw);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Feuerwerk4)");
				}else if(args[0].equalsIgnoreCase("Konfetti1")){
					Main.kfi.set("Konfetti1.X", Double.valueOf(p.getLocation().getX()));
					Main.kfi.set("Konfetti1.Y", Double.valueOf(p.getLocation().getY()));				
					Main.kfi.set("Konfetti1.Z", Double.valueOf(p.getLocation().getZ()));
					try{
						Main.kfi.save(Main.kf);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Konfetti1)");
				}else if(args[0].equalsIgnoreCase("Konfetti2")){
					Main.kfi.set("Konfetti2.X", Double.valueOf(p.getLocation().getX()));
					Main.kfi.set("Konfetti2.Y", Double.valueOf(p.getLocation().getY()));				
					Main.kfi.set("Konfetti2.Z", Double.valueOf(p.getLocation().getZ()));
					try{
						Main.kfi.save(Main.kf);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Konfetti2)");
				}else if(args[0].equalsIgnoreCase("Nebel1")){
					Main.nebell.set("Nebel1.X", Double.valueOf(p.getLocation().getX()));
					Main.nebell.set("Nebel1.Y", Double.valueOf(p.getLocation().getY()));				
					Main.nebell.set("Nebel1.Z", Double.valueOf(p.getLocation().getZ()));
					try{
						Main.nebell.save(Main.nebel);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Nebel1)");
				}else if(args[0].equalsIgnoreCase("Nebel2")){
					Main.nebell.set("Nebel2.X", Double.valueOf(p.getLocation().getX()));
					Main.nebell.set("Nebel2.Y", Double.valueOf(p.getLocation().getY()));				
					Main.nebell.set("Nebel2.Z", Double.valueOf(p.getLocation().getZ()));
					try{
						Main.nebell.save(Main.nebel);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Nebel2)");
				}else if(args[0].equalsIgnoreCase("Blitze1")){
					Main.bliz.set("Blitze1.X", Double.valueOf(p.getLocation().getX()));
					Main.bliz.set("Blitze1.Y", Double.valueOf(p.getLocation().getY()));				
					Main.bliz.set("Blitze1.Z", Double.valueOf(p.getLocation().getZ()));
					try{
						Main.bliz.save(Main.bli);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Blitze1)");
				}else if(args[0].equalsIgnoreCase("Blitze2")){
					Main.bliz.set("Blitze2.X", Double.valueOf(p.getLocation().getX()));
					Main.bliz.set("Blitze2.Y", Double.valueOf(p.getLocation().getY()));				
					Main.bliz.set("Blitze2.Z", Double.valueOf(p.getLocation().getZ()));
					try{
						Main.bliz.save(Main.bli);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Blitze2)");
				}else if(args[0].equalsIgnoreCase("Wave1")){
					Main.welle.set("Wave.Range", Integer.valueOf(10));
					Main.welle.set("Wave.Faceing", Integer.valueOf(0));
					Main.welle.set("Wave1.X", Double.valueOf(p.getLocation().getBlockX() + 0.5D));
					Main.welle.set("Wave1.Y", Integer.valueOf(p.getLocation().getBlockY()));
					Main.welle.set("Wave1.Z", Double.valueOf(p.getLocation().getBlockZ() + 0.5D));
					try{
				        Main.welle.save(Main.well);
					}catch (IOException e){
						e.printStackTrace();
				    }
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Wave1)");
				}else if(args[0].equalsIgnoreCase("Wave2")){
					Main.welle.set("Wave.Range", Integer.valueOf(10));
					Main.welle.set("Wave.Faceing", Integer.valueOf(0));
					Main.welle.set("Wave2.X", Double.valueOf(p.getLocation().getBlockX() + 0.5D));
					Main.welle.set("Wave2.Y", Integer.valueOf(p.getLocation().getBlockY()));
					Main.welle.set("Wave2.Z", Double.valueOf(p.getLocation().getBlockZ() + 0.5D));
					try{
				        Main.welle.save(Main.well);
					}catch (IOException e){
						e.printStackTrace();
				    }
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Wave2)");
				}else if(args[0].equalsIgnoreCase("Laser1")){
					Main.la.set("Laser1.X", p.getLocation().getBlockX());
					Main.la.set("Laser1.Y", p.getLocation().getBlockY());
					Main.la.set("Laser1.Z", p.getLocation().getBlockZ());
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Laser1)");
				}else if(args[0].equalsIgnoreCase("Laser2")){
					Main.la.set("Laser2.X", p.getLocation().getBlockX());
					Main.la.set("Laser2.Y", p.getLocation().getBlockY());
					Main.la.set("Laser2.Z", p.getLocation().getBlockZ());
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Laser2)");
				}else if(args[0].equalsIgnoreCase("LaserLamp1")){
					Main.la.set("LaserLamp1.X", p.getLocation().getBlockX()+0.5);
					Main.la.set("LaserLamp1.Y", p.getLocation().getBlockY()+0.5);
					Main.la.set("LaserLamp1.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(LaserLamp1)");
				}else if(args[0].equalsIgnoreCase("LaserLamp2")){
					Main.la.set("LaserLamp2.X", p.getLocation().getBlockX()+0.5);
					Main.la.set("LaserLamp2.Y", p.getLocation().getBlockY()+0.5);
					Main.la.set("LaserLamp2.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(LaserLamp2)");
				}else if(args[0].equalsIgnoreCase("LaserLamp3")){
					Main.la.set("LaserLamp3.X", p.getLocation().getBlockX()+0.5);
					Main.la.set("LaserLamp3.Y", p.getLocation().getBlockY()+0.5);
					Main.la.set("LaserLamp3.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(LaserLamp3)");
				}else if(args[0].equalsIgnoreCase("LaserLamp4")){
					Main.la.set("LaserLamp4.X", p.getLocation().getBlockX()+0.5);
					Main.la.set("LaserLamp4.Y", p.getLocation().getBlockY()+0.5);
					Main.la.set("LaserLamp4.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(LaserLamp4)");
				}else if(args[0].equalsIgnoreCase("LaserLamp5")){
					Main.la.set("LaserLamp5.X", p.getLocation().getBlockX()+0.5);
					Main.la.set("LaserLamp5.Y", p.getLocation().getBlockY()+0.5);
					Main.la.set("LaserLamp5.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.la.save(Main.laser);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(LaserLamp5)");
				}else if(args[0].equalsIgnoreCase("heartcannon1")){
					Main.heardc.set("heartcannon1.X", p.getEyeLocation().getBlockX());
					Main.heardc.set("heartcannon1.Y", p.getEyeLocation().getBlockY());
					Main.heardc.set("heartcannon1.Z", p.getEyeLocation().getBlockZ());
					Main.heardc.set("heartcannon1.Yaw", p.getEyeLocation().getYaw());
					Main.heardc.set("heartcannon1.Pitch", p.getEyeLocation().getPitch());
					
					try {
						Main.heardc.save(Main.hc);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Heartcannon1)");
				}else if(args[0].equalsIgnoreCase("heartcannon2")){
					Main.heardc.set("heartcannon2.X", p.getEyeLocation().getBlockX());
					Main.heardc.set("heartcannon2.Y", p.getEyeLocation().getBlockY());
					Main.heardc.set("heartcannon2.Z", p.getEyeLocation().getBlockZ());
					Main.heardc.set("heartcannon2.Yaw", p.getEyeLocation().getYaw());
					Main.heardc.set("heartcannon2.Pitch", p.getEyeLocation().getPitch());
					
					try {
						Main.heardc.save(Main.hc);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Heartcannon2)");
				}else if(args[0].equalsIgnoreCase("spirale1")){
					Main.spir.set("spirale1.X", p.getLocation().getBlockX()+0.5);
					Main.spir.set("spirale1.Y", p.getLocation().getBlockY());
					Main.spir.set("spirale1.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.spir.save(Main.spi);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Spirale1)");
				}else if(args[0].equalsIgnoreCase("spirale2")){
					Main.spir.set("spirale2.X", p.getLocation().getBlockX()+0.5);
					Main.spir.set("spirale2.Y", p.getLocation().getBlockY());
					Main.spir.set("spirale2.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.spir.save(Main.spi);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Spirale2)");
				}else if(args[0].equalsIgnoreCase("spirale3")){
					Main.spir.set("spirale3.X", p.getLocation().getBlockX()+0.5);
					Main.spir.set("spirale3.Y", p.getLocation().getBlockY());
					Main.spir.set("spirale3.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.spir.save(Main.spi);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Spirale3)");
				}else if(args[0].equalsIgnoreCase("spirale4")){
					Main.spir.set("spirale4.X", p.getLocation().getBlockX()+0.5);
					Main.spir.set("spirale4.Y", p.getLocation().getBlockY());
					Main.spir.set("spirale4.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.spir.save(Main.spi);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Spirale4)");
				}else if(args[0].equalsIgnoreCase("flammen1")){
					Main.flammen.set("Flammen1.X", p.getLocation().getBlockX()+0.5);
					Main.flammen.set("Flammen1.Y", p.getLocation().getBlockY());
					Main.flammen.set("Flammen1.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.flammen.save(Main.flam);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flammen1)");
				}else if(args[0].equalsIgnoreCase("flammen2")){
					Main.flammen.set("Flammen2.X", p.getLocation().getBlockX()+0.5);
					Main.flammen.set("Flammen2.Y", p.getLocation().getBlockY());
					Main.flammen.set("Flammen2.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.flammen.save(Main.flam);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flammen2)");
				}else if(args[0].equalsIgnoreCase("flammen3")){
					Main.flammen.set("Flammen3.X", p.getLocation().getBlockX()+0.5);
					Main.flammen.set("Flammen3.Y", p.getLocation().getBlockY());
					Main.flammen.set("Flammen3.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.flammen.save(Main.flam);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flammen3)");
				}else if(args[0].equalsIgnoreCase("flammen4")){
					Main.flammen.set("Flammen4.X", p.getLocation().getBlockX()+0.5);
					Main.flammen.set("Flammen4.Y", p.getLocation().getBlockY());
					Main.flammen.set("Flammen4.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.flammen.save(Main.flam);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flammen4)");
				}else if(args[0].equalsIgnoreCase("flammen5")){
					Main.flammen.set("Flammen5.X", p.getLocation().getBlockX()+0.5);
					Main.flammen.set("Flammen5.Y", p.getLocation().getBlockY());
					Main.flammen.set("Flammen5.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.flammen.save(Main.flam);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flammen5)");
				}else if(args[0].equalsIgnoreCase("flammen6")){
					Main.flammen.set("Flammen6.X", p.getLocation().getBlockX()+0.5);
					Main.flammen.set("Flammen6.Y", p.getLocation().getBlockY());
					Main.flammen.set("Flammen6.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.flammen.save(Main.flam);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Flammen6)");
				}else if(args[0].equalsIgnoreCase("rauch1")){
					Main.rauchp.set("Rauch1.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch1.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch1.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch1)");
				}else if(args[0].equalsIgnoreCase("rauch2")){
					Main.rauchp.set("Rauch2.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch2.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch2.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch2)");
				}else if(args[0].equalsIgnoreCase("rauch3")){
					Main.rauchp.set("Rauch3.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch3.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch3.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch3)");
				}else if(args[0].equalsIgnoreCase("rauch4")){
					Main.rauchp.set("Rauch4.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch4.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch4.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch4)");
				}else if(args[0].equalsIgnoreCase("rauch5")){
					Main.rauchp.set("Rauch5.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch5.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch5.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch5)");
				}else if(args[0].equalsIgnoreCase("rauch6")){
					Main.rauchp.set("Rauch6.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch6.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch6.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch6)");
				}else if(args[0].equalsIgnoreCase("rauch7")){
					Main.rauchp.set("Rauch7.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch7.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch7.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch7)");
				}else if(args[0].equalsIgnoreCase("rauch8")){
					Main.rauchp.set("Rauch8.X", p.getLocation().getBlockX());
					Main.rauchp.set("Rauch8.Y", p.getLocation().getBlockY()+0.5);
					Main.rauchp.set("Rauch8.Z", p.getLocation().getBlockZ()+0.5);
					
					try {
						Main.rauchp.save(Main.rauch);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Rauch8)");
				}
			}else if(args.length == 4){
				if(args[0].equalsIgnoreCase("stroboskop")){
					int i = 0;
					try{
						i = Integer.parseInt(args[1]);
					}catch(NumberFormatException e){
						p.sendMessage(Main.commip + "§cBitte gebe eine Zahl ein!");
						return false;
					}
					Main.strobo.set("Stroboskop.X", Double.valueOf(p.getLocation().getX()));
					Main.strobo.set("Stroboskop.Y", Double.valueOf(p.getLocation().getY()));				
					Main.strobo.set("Stroboskop.Z", Double.valueOf(p.getLocation().getZ()));
					Main.strobo.set("Stroboskop.Radius", i);
					try{
						Main.strobo.save(Main.strob);
					}catch (IOException ex){
						ex.printStackTrace();
					}
					p.sendMessage(Main.commip + "§7Erfolgreich gesetzt. §e(Stroboskop) (Radius: " + args[1] + ")");
				}
			}
		}	
		return false;
	}
}
