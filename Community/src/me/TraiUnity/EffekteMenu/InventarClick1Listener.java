package me.TraiUnity.EffekteMenu;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TraiUnity.ItemBuilder1;
import me.TraiUnity.Main;
import me.TraiUnity.Commands.DiscoBootsCommand;
import me.TraiUnity.Inventare.EffektEinstellungsInventar;
import me.TraiUnity.Listener.SetBoots;
import me.TraiUnity.MusikMenu.Settings2;

public class InventarClick1Listener implements Listener {

	public static Settings1 s;
		
	public static File File1 = FileManager1.File1;
	public static YamlConfiguration Settings11 = FileManager1.Settings1;	
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onKlickInv1(InventoryClickEvent e){
	
		try{
		
			if(e.getCurrentItem() != null){
				
				Player p = (Player) e.getWhoClicked();
						
				if(e.getInventory().getName().equals("§4Einstellungen §8(§eLasershow§8)")){
					e.setCancelled(true);
					
					ItemStack LS = e.getCurrentItem();

					if(LS.getItemMeta().getDisplayName().equalsIgnoreCase("§4✖")){
						return;
					}
					
					if(LS.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")){
						Settings1.openInv1(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						return;
					}
					
					if(e.getSlot() == 9 && Effects.laserzahl < 5){
						Effects.laserzahl++;
					}
					if(e.getSlot() == 18 && Effects.laserzahl > 1){
						Effects.laserzahl--;
					}
					
					if(e.getSlot() == 10 && Effects.laserspeed < 30){
						Effects.laserspeed+=5;
					}
					if(e.getSlot() == 19 && Effects.laserspeed > 5){
						Effects.laserspeed-=5;
					}
					
					for(Player all : Bukkit.getOnlinePlayers()){
						if(all.getOpenInventory().getTitle().equals("§4Einstellungen §8(§eLasershow§8)")){
							EffektEinstellungsInventar.openEinstellungenLasershow(all);
						}
					}
				}
				
				if(e.getInventory().getName().equals("§4Einstellungen §8(§eFlammenwerfer§8)")){
					e.setCancelled(true);
					
					ItemStack E = e.getCurrentItem();

					if(E.getItemMeta().getDisplayName().equalsIgnoreCase("§4✖")){
						return;
					}
					
					if(E.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zurück")){
						Settings1.openInv1(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						return;
					}
					
					if(e.getSlot() == 9 && Effects.flammenhöhe < 8){
						Effects.flammenhöhe++;
					}
					if(e.getSlot() == 18 && Effects.flammenhöhe > 2){
						Effects.flammenhöhe--;
					}
					
					if(e.getSlot() == 10 && Effects.flammenanzahl < 25){
						Effects.flammenanzahl+=1;
					}
					if(e.getSlot() == 19 && Effects.flammenanzahl > 4){
						Effects.flammenanzahl-=1;
					}
					
					for(Player all : Bukkit.getOnlinePlayers()){
						if(all.getOpenInventory().getTitle().equals("§4Einstellungen §8(§eFlammenwerfer§8)")){
							EffektEinstellungsInventar.openEinstellungenFlammenwerfer(all);
						}
					}
				}
					
				if(e.getInventory().getName().equals("§4Einstellungen §8(§eFeuerwerk§8)")){
					e.setCancelled(true);
					
					ItemStack FW = e.getCurrentItem();
					
					if(FW.getItemMeta().getDisplayName().equalsIgnoreCase("§cAktuell")){
						return;
					}
					
					if(FW.getItemMeta().getDisplayName().equalsIgnoreCase("§4✖")){
						return;
					}
					
					if(e.getClick().isLeftClick()){
						if(FW.getType().equals(Material.FIREWORK)){
							if(FW.getItemMeta().getDisplayName().equalsIgnoreCase("§aDein Feuerwerk")){
								ConfigurationSection section = Main.fwke.getConfigurationSection(p.getName());
								
								FeuerwerkErweiterungen.setAktuellesFeuerwerk(section.getString("Flicker"), section.getString("Trail"),
								section.getString("Farbe"), section.getString("Verblassfarbe"), section.getString("Höhe"), section.getString("Form"));
								
								p.closeInventory();
								p.sendMessage(Main.commip + "§7Das §5Feuerwerk §7wurde auf §cdeins §7gesetzt.");
							}else if(FW.getItemMeta().getDisplayName().startsWith("§cSchnellzugriff")){
								String sz = FW.getItemMeta().getDisplayName().replaceAll("§c", "");
								
								String[] z = sz.split(" ");
								int szz = Integer.parseInt(z[1]);
								
								ConfigurationSection section = Main.fwke.getConfigurationSection("FW." + szz);
								
								FeuerwerkErweiterungen.setAktuellesFeuerwerk(section.getString("Flicker"), section.getString("Trail"),
								section.getString("Farbe"), section.getString("Verblassfarbe"), section.getString("Höhe"), section.getString("Form"));
								
								p.closeInventory();
								p.sendMessage(Main.commip + "§7Das §5Feuerwerk §7wurde auf §c"+sz+" §7gesetzt.");
							}
						}
					}else if(e.getClick().isRightClick()){
						FeuerwerkErweiterungen.openBearbeitungen(FW.getItemMeta().getDisplayName(), p);
					}
				}
				
				if(e.getInventory().getTitle().equalsIgnoreCase("§aDein Feuerwerk") || e.getInventory().getTitle().startsWith("§cSchnellzugriff")){
					e.setCancelled(true);
					if(e.getRawSlot() == 9){
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")){
							e.getInventory().setItem(9, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§cNein", 14));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")){
							e.getInventory().setItem(9, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§aJa", 13));
						}
					}
					
					if(e.getRawSlot() == 10){
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")){
							e.getInventory().setItem(10, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§cNein", 14));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")){
							e.getInventory().setItem(10, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§aJa", 13));
						}
					}
					
					if(e.getRawSlot() == 11){
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Orange")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§dMagenta", 2));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dMagenta")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§9Hellblau", 3));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Hellblau")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§eGelb", 4));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGelb")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§aHellgrün", 5));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHellgrün")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§8Grau", 7));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8Grau")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§7Hellgrau", 8));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hellgrau")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§bCyan", 9));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCyan")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§5Lila", 10));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Lila")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§1Blau", 11));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§1Blau")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§2Grün", 13));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Grün")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§cRot", 14));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRot")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§0Schwarz", 15));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§0Schwarz")){
							e.getInventory().setItem(11, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§6Orange", 1));
						}
					}
					
					if(e.getRawSlot() == 12){
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Orange")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§dMagenta", 2));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dMagenta")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§9Hellblau", 3));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Hellblau")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§eGelb", 4));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGelb")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§aHellgrün", 5));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHellgrün")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§8Grau", 7));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8Grau")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§7Hellgrau", 8));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hellgrau")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§bCyan", 9));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCyan")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§5Lila", 10));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Lila")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§1Blau", 11));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§1Blau")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§2Grün", 13));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Grün")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§cRot", 14));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRot")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§0Schwarz", 15));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§0Schwarz")){
							e.getInventory().setItem(12, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§6Orange", 1));
						}
					}
					
					if(e.getRawSlot() == 13){
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a1")){
							e.getInventory().setItem(13, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§e2", 4));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e2")){
							e.getInventory().setItem(13, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§c3", 14));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c3")){
							e.getInventory().setItem(13, ItemBuilder1.createItemWithShort(Material.STAINED_CLAY, 1, "§a1", 13));
						}
					}
					
					if(e.getRawSlot() == 14){
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kugel")){
							e.getInventory().setItem(14, ItemBuilder1.createItem(Material.FIREBALL, 1, "§cGroße Kugel"));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGroße Kugel")){
							e.getInventory().setItem(14, ItemBuilder1.createItem(Material.SULPHUR, 1, "§fBurst"));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fBurst")){
							e.getInventory().setItem(14, ItemBuilder1.createItemWithShort(Material.SKULL_ITEM, 1, "§aCreeper", 4));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCreeper")){
							e.getInventory().setItem(14, ItemBuilder1.createItem(Material.NETHER_STAR, 1, "§eStern"));
						}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eStern")){
							e.getInventory().setItem(14, ItemBuilder1.createItem(Material.GHAST_TEAR, 1, "§6Kugel"));
						}
					}
					
					if(e.getRawSlot() == 8){
						String flicker = "";
						String trail = "";
						String farbe = "";
						String vfarbe = "";
						String höhe = "";
						String form = "";
						
						flicker = e.getInventory().getItem(9).getItemMeta().getDisplayName().replaceAll("§a", "").replaceAll("§c", "");
						trail = e.getInventory().getItem(10).getItemMeta().getDisplayName().replaceAll("§a", "").replaceAll("§c", "");
						farbe = e.getInventory().getItem(11).getItemMeta().getDisplayName().replaceAll("§6", "").replaceAll("§d", "").replaceAll("§9", "").replaceAll("§e", "").replaceAll("§a", "")
						.replaceAll("§8", "").replaceAll("§7", "").replaceAll("§b", "").replaceAll("§5", "").replaceAll("§1", "").replaceAll("§2", "").replaceAll("§c", "").replaceAll("§0", "").replaceAll("", "");
						vfarbe = e.getInventory().getItem(12).getItemMeta().getDisplayName().replaceAll("§6", "").replaceAll("§d", "").replaceAll("§9", "").replaceAll("§e", "").replaceAll("§a", "")
						.replaceAll("§8", "").replaceAll("§7", "").replaceAll("§b", "").replaceAll("§5", "").replaceAll("§1", "").replaceAll("§2", "").replaceAll("§c", "").replaceAll("§0", "").replaceAll("", "");
						höhe = e.getInventory().getItem(13).getItemMeta().getDisplayName().replaceAll("§a", "").replaceAll("§e", "").replaceAll("§c", "");
						form = e.getInventory().getItem(14).getItemMeta().getDisplayName().replaceAll("§6", "").replaceAll("§c", "")
						.replaceAll("§f", "").replaceAll("§a", "").replaceAll("§e", "");
						
						if(e.getInventory().getTitle().equalsIgnoreCase("§aDein Feuerwerk")){
							FeuerwerkErweiterungen.setFeuerwerkEinstellungen(p.getName(), flicker, trail, farbe, vfarbe, höhe, form);
							p.sendMessage(Main.commip + "§7Du hast §cdein §7Feuerwerk bearbeitet.");
						}else{
							String name = e.getInventory().getTitle().replaceAll("§cSchnellzugriff ", "");
							FeuerwerkErweiterungen.setFeuerwerkEinstellungen("FW."+name, flicker, trail, farbe, vfarbe, höhe, form);
							p.sendMessage(Main.commip + "§7Du hast §cFW"+name+" §7bearbeitet.");
						}
						
						Settings1.openInv1(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}
					
					if(e.getRawSlot() == 17){
						EffektEinstellungsInventar.openEinstellungenFeuerwerk(p);
					}
				}
				
				if(e.getInventory().getName().equals("§bEffekte §8● §7Seite§8: §a1")){
					e.setCancelled(true);
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Schließen")){
						e.setCancelled(true);
						p.closeInventory();
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a2")){
						e.setCancelled(true);
						s.openInv2(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAlle aktiven Effekte deaktivieren")){
						e.setCancelled(true);
						
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						if(e.isLeftClick()){						
							if(Settings11.getString("Config.Lasershow").equals("true")){
								Settings11.set("Config.Lasershow", "false");
								Settings1.Lasershow = false;
								Effects.endLasershow();
							}
							
							if(Settings11.getString("Config.Explosion").equals("true")){
								Settings11.set("Config.Explosion", "false");
								Settings1.Explosion = false;
								Effects.endExplosion();
							}		
							
							if(Settings11.getString("Config.Blitze").equals("true")){
								Settings11.set("Config.Blitze", "false");
								Settings1.Blitze = false;
								Effects.endBlitze();
							}		
							
							if(Settings11.getString("Config.Nebel").equals("true")){
								Settings11.set("Config.Nebel", "false");
								Settings1.Nebel = false;
								Effects.endNebel();
							}		
							
							if(Settings11.getString("Config.Konfetti").equals("true")){
								Settings11.set("Config.Konfetti", "false");
								Settings1.Konfetti = false;
								Effects.endKonfetti();
							}		
							
							if(Settings11.getString("Config.Fire Shots").equals("true")){
								Settings11.set("Config.Fire Shots", "false");
								Settings1.Flammenwerfer = false;
								Effects.endFlammenwerfer();
							}
							
							if(Settings11.getString("Config.Stroboskop").equals("true")){
								Settings11.set("Config.Stroboskop", "false");
								Settings1.Stroboskop = false;
								Effects.endStroboskop();
							}	
							
							if(Settings11.getString("Config.Feuerwerk").equals("true")){
								Settings11.set("Config.Feuerwerk", "false");
								Settings1.Feuerwerk = false;
								Effects.endFeuerwerk();
							}
							
							if(Settings11.getString("Config.Welle").equals("true")){
								Settings11.set("Config.Welle", "false");
								Settings1.welle = false;
								Effects.endWelle();
							}
							
							if(Settings11.getString("Config.Heartcannon").equals("true")){
								Settings11.set("Config.Heartcannon", "false");
								Settings1.heartcannon = false;
								Effects.endheartcannon();
							}
							
							if(Settings11.getString("Config.Spiralen").equals("true")){
								Settings11.set("Config.Spiralen", "false");
								Settings1.spiralen = false;
								Effects.endSpiralen();
							}
							
							if(Settings11.getString("Config.Flammen").equals("true")){
								Settings11.set("Config.Flammen", "false");
								Settings1.flammen = false;
								Effects.endFlammen();
							}
							
							if(Settings11.getString("Config.Rauch").equals("true")){
								Settings11.set("Config.Rauch", "false");
								Settings1.rauch = false;
								Effects.endRauchmaschine();
							}
							
							if(Settings11.getString("Config.DiscoschuheTeammitglieder").equals("true")){
								Settings11.set("Config.DiscoschuheTeammitglieder", "false");
								Settings1.DiscoBootsTeammitglieder = false;
								DiscoBootsCommand.discobootsteammitglieder = false;
								
								for(Player all : Bukkit.getOnlinePlayers()){
									SetBoots.setBoots(all);
								}
							}
							
							if(Settings11.getString("Config.DiscoschuheAlle").equals("true")){
								Settings11.set("Config.DiscoschuheAlle", "false");
								Settings1.DiscoBootsAlle = false;
								DiscoBootsCommand.discobootsalle = false;
								
								for(Player all : Bukkit.getOnlinePlayers()){
									SetBoots.setBoots(all);
								}
							}
							
							try { 
								Settings11.save(File1);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							s.loadConfig(p);
							s.openInv();
							
							p.sendMessage(Main.commip + "§7Alle §5Effekte §7wurden §cdeaktiviert§7!");
							
						}else if(e.isRightClick()){
							if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){								
								if(Settings11.getString("Config.Lasershow").equals("false")){
									Settings11.set("Config.Lasershow", "true");
									Settings1.Lasershow = true;
									Effects.startLasershow();
								}
								
								if(Settings11.getString("Config.Explosion").equals("false")){
									Settings11.set("Config.Explosion", "true");
									Settings1.Explosion = true;
									Effects.startExplosion();
								}		
								
								if(Settings11.getString("Config.Blitze").equals("false")){
									Settings11.set("Config.Blitze", "true");
									Settings1.Blitze = true;
									Effects.startBlitze();
								}		
								
								if(Settings11.getString("Config.Nebel").equals("false")){
									Settings11.set("Config.Nebel", "true");
									Settings1.Nebel = true;
									Effects.startNebel();
								}		
								
								if(Settings11.getString("Config.Konfetti").equals("false")){
									Settings11.set("Config.Konfetti", "true");
									Settings1.Konfetti = true;
									Effects.startKonfetti();
								}		
								
								if(Settings11.getString("Config.Fire Shots").equals("false")){
									Settings11.set("Config.Fire Shots", "true");
									Settings1.Flammenwerfer = true;
									Effects.startFlammenwerfer();
								}
								
								if(Settings11.getString("Config.Stroboskop").equals("false")){
									Settings11.set("Config.Stroboskop", "true");
									Settings1.Stroboskop = true;
									Effects.startStroboskop();
								}	
								
								if(Settings11.getString("Config.Feuerwerk").equals("false")){
									Settings11.set("Config.Feuerwerk", "true");
									Settings1.Feuerwerk = true;
									Effects.startFeuerwerk();
								}
								
								if(Settings11.getString("Config.Welle").equals("false")){
									Settings11.set("Config.Welle", "true");
									Settings1.welle = true;
									Effects.startWelle();
								}
								
								if(Settings11.getString("Config.Heartcannon").equals("false")){
									Settings11.set("Config.Heartcannon", "true");
									Settings1.heartcannon = true;
									Effects.startheartcannon();
								}
								
								if(Settings11.getString("Config.Spiralen").equals("false")){
									Settings11.set("Config.Spiralen", "true");
									Settings1.spiralen = true;
									Effects.startSpiralen();
								}
								
								if(Settings11.getString("Config.Flammen").equals("false")){
									Settings11.set("Config.Flammen", "true");
									Settings1.flammen = true;
									Effects.startFlammen();
								}
								
								if(Settings11.getString("Config.Rauch").equals("false")){
									Settings11.set("Config.Rauch", "true");
									Settings1.rauch = true;
									Effects.startRauchmaschine();
								}
								
								if(Settings11.getString("Config.DiscoschuheTeammitglieder").equals("true")){
									Settings11.set("Config.DiscoschuheTeammitglieder", "false");
									Settings1.DiscoBootsTeammitglieder = false;
									DiscoBootsCommand.discobootsteammitglieder = false;
									
									for(Player all : Bukkit.getOnlinePlayers()){
										SetBoots.setBoots(all);
									}
								}
								
								if(Settings11.getString("Config.DiscoschuheAlle").equals("false")){
									Settings11.set("Config.DiscoschuheAlle", "true");
									Settings1.DiscoBootsAlle = false;
									DiscoBootsCommand.discobootsalle = true;
									
									for(Player all : Bukkit.getOnlinePlayers()){
										SetBoots.setBoots(all);
									}
								}
								
								try { 
									Settings11.save(File1);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								s.loadConfig(p);
								s.openInv();
								
								p.sendMessage(Main.commip + "§7Alle §5Effekte §7wurden §aaktiviert§7!");
							}
						}							
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Einstellungen §8(§eLasershow§8)")){
						EffektEinstellungsInventar.openEinstellungenLasershow(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Einstellungen §8(§eFlammenwerfer§8)")){
						EffektEinstellungsInventar.openEinstellungenFlammenwerfer(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Einstellungen §8(§eFeuerwerk§8)")){
						EffektEinstellungsInventar.openEinstellungenFeuerwerk(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMusik")){
						e.setCancelled(true);
						Settings2.openMusik1(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bLasershow")){
					
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Lasershow", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.laserspeed = 20;
						Effects.laserzahl = 1;
						
						Effects.startLasershow();
						
						s.loadConfig(p);
						s.openInv();	
					
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bLasershow")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Lasershow", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
										
						Effects.endLasershow();
						
		    			if(Effects.laserzahl != 2){
		    				Effects.laserzahl = 2;
		    			}
		    			
		    			if(Effects.laserspeed != 5){
		    				Effects.laserspeed = 5;
		    			}
						
						s.loadConfig(p);
						s.openInv();
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bExplosion")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Explosion", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
		
						Effects.startExplosion();
						
						s.loadConfig(p);
						s.openInv();	
					
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bExplosion")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Explosion", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.endExplosion();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bBlitze")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Blitze", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startBlitze();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bBlitze")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Blitze", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
		
						Effects.endBlitze();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bNebel")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Nebel", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
										
						Effects.startNebel();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bNebel")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Nebel", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
										
						Effects.endNebel();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bKonfetti")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Konfetti", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startKonfetti();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bKonfetti")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Konfetti", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.endKonfetti();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bFire Shots")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Fire Shots", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startFlammenwerfer();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bFire Shots")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Fire Shots", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.flammenhöhe = 2;
						Effects.flammenanzahl = 4;
						
						Effects.endFlammenwerfer();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bStroboskop")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Stroboskop", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
								
						Effects.startStroboskop();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bStroboskop")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Stroboskop", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
										
						Effects.endStroboskop();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bFeuerwerk")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Feuerwerk", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startFeuerwerk();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bFeuerwerk")){
										
						e.setCancelled(true);
						
						Settings11.set("Config.Feuerwerk", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.endFeuerwerk();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bWelle")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Welle", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startWelle();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bWelle")){
										
						e.setCancelled(true);
						
						Settings11.set("Config.Welle", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
									
						Effects.endWelle();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bHerzkannone")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Heartcannon", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startheartcannon();
						
						s.loadConfig(p);
						s.openInv();
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bHerzkannone")){
										
						e.setCancelled(true);
						
						Settings11.set("Config.Heartcannon", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
									
						Effects.endheartcannon();
						
						s.loadConfig(p);
						s.openInv();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bSpiralen")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Spiralen", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startSpiralen();
						
						s.loadConfig(p);
						s.openInv();
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bSpiralen")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Spiralen", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
									
						Effects.endSpiralen();
						
						s.loadConfig(p);
						s.openInv();	
		
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bFlammen")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Flammen", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startFlammen();
						
						s.loadConfig(p);
						s.openInv();
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bFlammen")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Flammen", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
									
						Effects.endFlammen();
						
						s.loadConfig(p);
						s.openInv();		
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bRauch")){
						
						e.setCancelled(true);
						
						if(getActiveEffects() >= 4 && !p.hasPermission("Rangsystem.Owner")){
							p.closeInventory();
							p.sendMessage(Main.commip + "§7Es sind bereits §e4 §7Effekte §aaktiv§7!");
							return;
						}
						
						for(World w : Bukkit.getWorlds()){
							w.setTime(90000);
						}
						
						Settings11.set("Config.Rauch", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						Effects.startRauchmaschine();
						
						s.loadConfig(p);
						s.openInv();
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bRauch")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.Rauch", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
									
						Effects.endRauchmaschine();
						
						s.loadConfig(p);
						s.openInv();		
					}
					return;
				}
				
				if(e.getInventory().getName().equals("§bEffekte §8● §7Seite§8: §a2")){
					e.setCancelled(true);
					
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Schließen")){
						e.setCancelled(true);
						p.closeInventory();
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Zur Seite §a1")){
						e.setCancelled(true);
						s.openInv1(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAlle aktiven Effekte deaktivieren")){
						e.setCancelled(true);
						
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						if(e.isLeftClick()){							
							if(Settings11.getString("Config.Lasershow").equals("true")){
								Settings11.set("Config.Lasershow", "false");
								Settings1.Lasershow = false;
								Effects.endLasershow();
							}
							
							if(Settings11.getString("Config.Explosion").equals("true")){
								Settings11.set("Config.Explosion", "false");
								Settings1.Explosion = false;
								Effects.endExplosion();
							}		
							
							if(Settings11.getString("Config.Blitze").equals("true")){
								Settings11.set("Config.Blitze", "false");
								Settings1.Blitze = false;
								Effects.endBlitze();
							}		
							
							if(Settings11.getString("Config.Nebel").equals("true")){
								Settings11.set("Config.Nebel", "false");
								Settings1.Nebel = false;
								Effects.endNebel();
							}		
							
							if(Settings11.getString("Config.Konfetti").equals("true")){
								Settings11.set("Config.Konfetti", "false");
								Settings1.Konfetti = false;
								Effects.endKonfetti();
							}		
							
							if(Settings11.getString("Config.Fire Shots").equals("true")){
								Settings11.set("Config.Fire Shots", "false");
								Settings1.Flammenwerfer = false;
								Effects.endFlammenwerfer();
							}
							
							if(Settings11.getString("Config.Stroboskop").equals("true")){
								Settings11.set("Config.Stroboskop", "false");
								Settings1.Stroboskop = false;
								Effects.endStroboskop();
							}	
							
							if(Settings11.getString("Config.Feuerwerk").equals("true")){
								Settings11.set("Config.Feuerwerk", "false");
								Settings1.Feuerwerk = false;
								Effects.endFeuerwerk();
							}
							
							if(Settings11.getString("Config.Welle").equals("true")){
								Settings11.set("Config.Welle", "false");
								Settings1.welle = false;
								Effects.endWelle();
							}
							
							if(Settings11.getString("Config.Heartcannon").equals("true")){
								Settings11.set("Config.Heartcannon", "false");
								Settings1.heartcannon = false;
								Effects.endheartcannon();
							}
							
							if(Settings11.getString("Config.Spiralen").equals("true")){
								Settings11.set("Config.Spiralen", "false");
								Settings1.spiralen = false;
								Effects.endSpiralen();
							}
							
							if(Settings11.getString("Config.Flammen").equals("true")){
								Settings11.set("Config.Flammen", "false");
								Settings1.flammen = false;
								Effects.endFlammen();
							}
							
							if(Settings11.getString("Config.Rauch").equals("true")){
								Settings11.set("Config.Rauch", "false");
								Settings1.rauch = false;
								Effects.endRauchmaschine();
							}
							
							if(Settings11.getString("Config.DiscoschuheTeammitglieder").equals("true")){
								Settings11.set("Config.DiscoschuheTeammitglieder", "false");
								Settings1.DiscoBootsTeammitglieder = false;
								DiscoBootsCommand.discobootsteammitglieder = false;
								
								for(Player all : Bukkit.getOnlinePlayers()){
									SetBoots.setBoots(all);
								}
							}
							
							if(Settings11.getString("Config.DiscoschuheAlle").equals("true")){
								Settings11.set("Config.DiscoschuheAlle", "false");
								Settings1.DiscoBootsAlle = false;
								DiscoBootsCommand.discobootsalle = false;
								
								for(Player all : Bukkit.getOnlinePlayers()){
									SetBoots.setBoots(all);
								}
							}
							
							try { 
								Settings11.save(File1);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							s.loadConfig(p);
							s.openInv();
							
							p.sendMessage(Main.commip + "§7Alle §5Effekte §7wurden §cdeaktiviert§7!");
							
						}else if(e.isRightClick()){
							if(p.hasPermission("Rangsystem.SrModerator") || p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){								
								if(Settings11.getString("Config.Lasershow").equals("false")){
									Settings11.set("Config.Lasershow", "true");
									Settings1.Lasershow = true;
									Effects.startLasershow();
								}
								
								if(Settings11.getString("Config.Explosion").equals("false")){
									Settings11.set("Config.Explosion", "true");
									Settings1.Explosion = true;
									Effects.startExplosion();
								}		
								
								if(Settings11.getString("Config.Blitze").equals("true")){
									Settings11.set("Config.Blitze", "true");
									Settings1.Blitze = true;
									Effects.startBlitze();
								}		
								
								if(Settings11.getString("Config.Nebel").equals("true")){
									Settings11.set("Config.Nebel", "true");
									Settings1.Nebel = true;
									Effects.startNebel();
								}		
								
								if(Settings11.getString("Config.Konfetti").equals("true")){
									Settings11.set("Config.Konfetti", "true");
									Settings1.Konfetti = true;
									Effects.startKonfetti();
								}		
								
								if(Settings11.getString("Config.Fire Shots").equals("true")){
									Settings11.set("Config.Fire Shots", "true");
									Settings1.Flammenwerfer = true;
									Effects.startFlammenwerfer();
								}
								
								if(Settings11.getString("Config.Stroboskop").equals("true")){
									Settings11.set("Config.Stroboskop", "true");
									Settings1.Stroboskop = true;
									Effects.startStroboskop();
								}	
								
								if(Settings11.getString("Config.Feuerwerk").equals("true")){
									Settings11.set("Config.Feuerwerk", "true");
									Settings1.Feuerwerk = true;
									Effects.startFeuerwerk();
								}
								
								if(Settings11.getString("Config.Welle").equals("true")){
									Settings11.set("Config.Welle", "true");
									Settings1.welle = true;
									Effects.startWelle();
								}
								
								if(Settings11.getString("Config.Heartcannon").equals("true")){
									Settings11.set("Config.Heartcannon", "true");
									Settings1.heartcannon = true;
									Effects.startheartcannon();
								}
								
								if(Settings11.getString("Config.Spiralen").equals("true")){
									Settings11.set("Config.Spiralen", "true");
									Settings1.spiralen = true;
									Effects.startSpiralen();
								}
								
								if(Settings11.getString("Config.Flammen").equals("true")){
									Settings11.set("Config.Flammen", "true");
									Settings1.flammen = true;
									Effects.startFlammen();
								}
								
								if(Settings11.getString("Config.Rauch").equals("true")){
									Settings11.set("Config.Rauch", "true");
									Settings1.rauch = true;
									Effects.startRauchmaschine();
								}
								
								if(Settings11.getString("Config.DiscoschuheTeammitglieder").equals("true")){
									Settings11.set("Config.DiscoschuheTeammitglieder", "false");
									Settings1.DiscoBootsTeammitglieder = false;
									DiscoBootsCommand.discobootsteammitglieder = false;
									
									for(Player all : Bukkit.getOnlinePlayers()){
										SetBoots.setBoots(all);
									}
								}
								
								if(Settings11.getString("Config.DiscoschuheAlle").equals("true")){
									Settings11.set("Config.DiscoschuheAlle", "true");
									Settings1.DiscoBootsAlle = false;
									DiscoBootsCommand.discobootsalle = true;
									
									for(Player all : Bukkit.getOnlinePlayers()){
										SetBoots.setBoots(all);
									}
								}
								
								try { 
									Settings11.save(File1);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								s.loadConfig(p);
								s.openInv();
								
								p.sendMessage(Main.commip + "§7Alle §5Effekte §7wurden §aaktiviert§7!");
							}
						}
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMusik")){
						e.setCancelled(true);
						Settings2.openMusik1(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bDiscoschuheTeammitglieder")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.DiscoschuheTeammitglieder", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						if(DiscoBootsCommand.discobootsalle == true){
							DiscoBootsCommand.discobootsalle = false;
							
							for(Player all : Bukkit.getOnlinePlayers()){
								SetBoots.setBoots(all);
							}
						}
						
						DiscoBootsCommand.discobootsteammitglieder = true;
						
						for(Player all : Bukkit.getOnlinePlayers()){
						    if (all.hasPermission("Rangsystem.Premium+") || all.hasPermission("Rangsystem.Freund") || all.hasPermission("Rangsystem.Streamer") || all.hasPermission("Rangsystem.Youtuber")
						    		|| all.hasPermission("Rangsystem.Builder") || all.hasPermission("Rangsystem.ProbeSupporter") || all.hasPermission("Rangsystem.Supporter") || all.hasPermission("Rangsystem.Moderator")
						    		|| all.hasPermission("Rangsystem.SrModerator") || all.hasPermission("Rangsystem.Content") || all.hasPermission("Rangsystem.JrDeveloper") || all.hasPermission("Rangsystem.Developer")
						    		|| all.hasPermission("Rangsystem.SrDeveloper") || all.hasPermission("Rangsystem.Administrator") || all.hasPermission("Rangsystem.Owner")) {
								ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
								ItemMeta LBMeta = LB.getItemMeta();
								LBMeta.setDisplayName("§eDisco-Schuhe §8» §cTeammitglieder");
								LB.setItemMeta(LBMeta);
								all.getInventory().setBoots(LB);
							}
						}
						
						s.loadConfig(p);
						s.openInv22();
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bDiscoschuheTeammitglieder")){
										
						e.setCancelled(true);
						
						Settings11.set("Config.DiscoschuheTeammitglieder", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
										
						DiscoBootsCommand.discobootsteammitglieder = false;
						
						for(Player all : Bukkit.getOnlinePlayers()){
						    if (all.hasPermission("Rangsystem.Premium+") || all.hasPermission("Rangsystem.Freund") || all.hasPermission("Rangsystem.Streamer") || all.hasPermission("Rangsystem.Youtuber")
						    		|| all.hasPermission("Rangsystem.Builder") || all.hasPermission("Rangsystem.ProbeSupporter") || all.hasPermission("Rangsystem.Supporter") || all.hasPermission("Rangsystem.Moderator")
						    		|| all.hasPermission("Rangsystem.SrModerator") || all.hasPermission("Rangsystem.Content") || all.hasPermission("Rangsystem.JrDeveloper") || all.hasPermission("Rangsystem.Developer")
						    		|| all.hasPermission("Rangsystem.SrDeveloper") || all.hasPermission("Rangsystem.Administrator") || all.hasPermission("Rangsystem.Owner")) {
								SetBoots.setBoots(all);
							}
						}
						
						s.loadConfig(p);
						s.openInv22();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktiviert §8● §bDiscoschuheAlle")){
						
						e.setCancelled(true);
						
						Settings11.set("Config.DiscoschuheAlle", "true");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						if(DiscoBootsCommand.discobootsteammitglieder == true){
							DiscoBootsCommand.discobootsteammitglieder = false;
							
							for(Player all : Bukkit.getOnlinePlayers()){
								SetBoots.setBoots(all);
							}
						}
						
						DiscoBootsCommand.discobootsalle = true;
						
						for(Player all : Bukkit.getOnlinePlayers()){
							ItemStack LB = new ItemStack(Material.LEATHER_BOOTS, 1);
							ItemMeta LBMeta = LB.getItemMeta();
							LBMeta.setDisplayName("§eDisco-Schuhe §8» §cTeammitglieder");
							LB.setItemMeta(LBMeta);
							all.getInventory().setBoots(LB);
						}
						
						s.loadConfig(p);
						s.openInv22();	
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktiviert §8● §bDiscoschuheAlle")){
										
						e.setCancelled(true);
						
						Settings11.set("Config.DiscoschuheAlle", "false");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
						
						try{
							Settings11.save(File1);
						}catch(IOException f){
							f.printStackTrace();
						}
						
						try{
							Settings11.load(File1);
						}catch(IOException e1){
							e1.printStackTrace();
						}catch(InvalidConfigurationException e1){
							e1.printStackTrace();
						}
						
						DiscoBootsCommand.discobootsalle = false;
						
						for(Player all : Bukkit.getOnlinePlayers()){
							SetBoots.setBoots(all);
						}
						
						s.loadConfig(p);
						s.openInv22();	
						
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static int getActiveEffects(){
		
		int i = 0;
		
		if(Settings11.getString("Config.Lasershow").equals("true")) i++;
		if(Settings11.getString("Config.Explosion").equals("true")) i++;
		if(Settings11.getString("Config.Blitze").equals("true")) i++;
		if(Settings11.getString("Config.Nebel").equals("true")) i++;
		if(Settings11.getString("Config.Konfetti").equals("true")) i++;
		if(Settings11.getString("Config.Fire Shots").equals("true")) i++;
		if(Settings11.getString("Config.Stroboskop").equals("true")) i++;
		if(Settings11.getString("Config.Feuerwerk").equals("true")) i++;
		if(Settings11.getString("Config.Welle").equals("true")) i++;
		if(Settings11.getString("Config.Heartcannon").equals("true")) i++;
		if(Settings11.getString("Config.Spiralen").equals("true")) i++;
		if(Settings11.getString("Config.Flammen").equals("true")) i++;
		if(Settings11.getString("Config.Rauch").equals("true")) i++;

		return i;
	}
}
