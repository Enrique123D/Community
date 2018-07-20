package me.TraiUnity.Minispiele;

import java.util.HashMap;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import de.dave_911.Coins.Coins;
import me.TraiUnity.ItemBuilder2;
import me.TraiUnity.Main;
import me.TraiUnity.Methoden;

public class SchereSteinPapier implements CommandExecutor, Listener{
	
	public enum SSPType{
		SCHERE(), STEIN(), PAPIER(), LEER();
	}
	
	// Falls nicht - LEER
	public static HashMap<Player, SSPType> choosen = new HashMap<>();
	// rechts der einladende
	public static HashMap<Player, LinkedList<Player>> invites = new HashMap<>();
	public static HashMap<Player, Player> enemy = new HashMap<>();
	public static HashMap<Player, Integer> round = new HashMap<>();
	
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("invite")) {
				Player target = Bukkit.getPlayer(args[1]);
				if(target == null) {
					p.sendMessage(Main.ssp + "§cDieser Spieler ist nicht online.");
					return false;
				}
				if(target.equals(p)) {
					p.sendMessage(Main.ssp + "§cDu kannst dich nicht selbst einladen.");
					return false;
				}
				if(invites.containsKey(target) && invites.get(target).contains(p)) {
					p.sendMessage(Main.ssp + "§cDu hast §e" + target.getDisplayName() + " §cbereits eingeladen.");
					return false;
				}
				
				LinkedList<Player> list = new LinkedList<>();
				if(invites.containsKey(target)) list = invites.get(target);
				list.add(p);
				invites.remove(target);
				invites.put(target, list);
				p.sendMessage(Main.ssp + "§aDu hast §e" + target.getDisplayName() + " §aherausgefordert.");
				target.sendMessage(Main.ssp + "§aDu wurdest von §e" + p.getDisplayName() + " §aherausgefordert.");
				target.sendMessage(Main.ssp + "§7Nehme die Anfrage mit §e/ssp accept " + p.getName() + " §aan.");
				new BukkitRunnable() {
					private int sec = 60;
					@Override
					public void run() {
						if(!invites.containsKey(target) || (invites.containsKey(target) && !invites.get(target).contains(p))) cancel();
						sec--;
						if(sec == 0){
							if(invites.containsKey(target) && invites.get(target).contains(p)) {
								LinkedList<Player> list = invites.get(target);
								list.remove(p);
								invites.put(target, list);
								p.sendMessage(Main.ssp + "§cDeine herausforderung an §e" + target.getDisplayName() + " §cist abgelaufen!");
							}
						}
					}}.runTaskTimer(Main.plugin, 20, 20);
			}else if(args[0].equalsIgnoreCase("accept")) {
				Player target = Bukkit.getPlayer(args[1]);
				if(target == null) {
					p.sendMessage(Main.ssp + "§cDieser Spieler ist nicht online.");
					return false;
				}
				if(!invites.get(p).contains(target)) {
					p.sendMessage(Main.ssp + "§cDu hast keine herausforderung von §e" + target.getDisplayName() + " §cerhalten.");
					return false;
				}
				
				LinkedList<Player> list = invites.get(p);
				list.remove(target);
				invites.remove(p);
				invites.put(p, list);
				p.sendMessage(Main.ssp + "§aDu hast die Herausforderung von §e" + target.getDisplayName() + " §aangenommen.");
				target.sendMessage(Main.ssp + "§aDeine Herausforderung an §e" + p.getDisplayName() + " §awurde angenommen.");
				enemy.put(p, target);
				enemy.put(target, p);
				choosen.put(p, SSPType.LEER);
				choosen.put(target, SSPType.LEER);
				round.put(p, 1);
				round.put(target, 1);
				p.openInventory(getStandartSSPInv());
				target.openInventory(getStandartSSPInv());
				
				new BukkitRunnable() {
					@Override
					public void run() {
						if(!enemy.containsKey(p) || !enemy.containsKey(target)){
							cancel();
							return;
						}
						int time = Integer.parseInt(p.getOpenInventory().getItem(22).getItemMeta().getDisplayName().replaceAll("§7", ""));
						time--;
						
						if(time <= 0) {
							if(choosen.get(p).equals(SSPType.LEER) && choosen.get(target).equals(SSPType.LEER)) {
								p.sendMessage(Main.ssp + "§aDu hast gegen §e" + target.getDisplayName() + " §aein Unentschieden erzielt!");
								target.sendMessage(Main.ssp + "§aDu hast gegen §e" + p.getDisplayName() + " §aein Unentschieden erzielt!");
								
								choosen.remove(p); choosen.remove(target);
								enemy.remove(p); enemy.remove(target);
								round.remove(p); round.remove(target);
								
								p.closeInventory();
								target.closeInventory();
							}else {
								if(choosen.get(p).equals(SSPType.LEER)) setWinner(p);
								if(choosen.get(target).equals(SSPType.LEER)) setWinner(target);
							}
						}else {
							p.getOpenInventory().setItem(22, new ItemBuilder2(Material.WATCH).displayName("§7"+time).build());
							target.getOpenInventory().setItem(22, new ItemBuilder2(Material.WATCH).displayName("§7"+time).build());
							p.updateInventory();
							target.updateInventory();
						}
					}}.runTaskTimer(Main.plugin, 20, 20);
			}
		}
		return false;
	}
	
	@EventHandler
	public void onSSPclick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(enemy.containsKey(p)) {
			if(e.getClickedInventory().getName().equalsIgnoreCase("§7Schere, Stein, Papier")) {
				e.setCancelled(true);
				if(e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()){
					return;
				}
				Player target = enemy.get(p);
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stein")) {
					choosen.remove(p);
					choosen.put(p, SSPType.STEIN);
					p.getOpenInventory().setItem(20, new ItemBuilder2(Material.STONE).displayName("§7Stein").build());
					target.getOpenInventory().setItem(24, new ItemBuilder2(Material.DIAMOND).displayName("§aFertig").build());
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Papier")) {
					choosen.remove(p);
					choosen.put(p, SSPType.PAPIER);
					p.getOpenInventory().setItem(20, new ItemBuilder2(Material.PAPER).displayName("§7Papier").build());
					target.getOpenInventory().setItem(24, new ItemBuilder2(Material.DIAMOND).displayName("§aFertig").build());
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schere")) {
					choosen.remove(p);
					choosen.put(p, SSPType.SCHERE);
					p.getOpenInventory().setItem(20, new ItemBuilder2(Material.SHEARS).displayName("§7Schere").build());
					target.getOpenInventory().setItem(24, new ItemBuilder2(Material.DIAMOND).displayName("§aFertig").build());
				}
				
				p.updateInventory();
				target.updateInventory();

				if(choosen.containsKey(p) && choosen.containsKey(target) && !choosen.get(p).equals(SSPType.LEER) && !choosen.get(target).equals(SSPType.LEER)) {
					if(choosen.get(p).equals(SSPType.STEIN) && choosen.get(target).equals(SSPType.STEIN)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 4).displayName("§eUnentschieden").build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 4).displayName("§eUnentschieden").build());
					}else if(choosen.get(p).equals(SSPType.STEIN) && choosen.get(target).equals(SSPType.PAPIER)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("§c"+target.getDisplayName()).build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("§a"+target.getDisplayName()).build());
					}else if(choosen.get(p).equals(SSPType.STEIN) && choosen.get(target).equals(SSPType.SCHERE)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("§a"+p.getDisplayName()).build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("§c"+p.getDisplayName()).build());
					}else if(choosen.get(p).equals(SSPType.PAPIER) && choosen.get(target).equals(SSPType.STEIN)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("§a"+p.getDisplayName()).build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("§c"+p.getDisplayName()).build());
					}else if(choosen.get(p).equals(SSPType.PAPIER) && choosen.get(target).equals(SSPType.PAPIER)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 4).displayName("§eUnentschieden").build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 4).displayName("§eUnentschieden").build());
					}else if(choosen.get(p).equals(SSPType.PAPIER) && choosen.get(target).equals(SSPType.SCHERE)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("§c"+target.getDisplayName()).build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("§a"+target.getDisplayName()).build());
					}else if(choosen.get(p).equals(SSPType.SCHERE) && choosen.get(target).equals(SSPType.STEIN)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("§c"+target.getDisplayName()).build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("§a"+target.getDisplayName()).build());
					}else if(choosen.get(p).equals(SSPType.SCHERE) && choosen.get(target).equals(SSPType.PAPIER)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("§a"+p.getDisplayName()).build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("§c"+p.getDisplayName()).build());
					}else if(choosen.get(p).equals(SSPType.SCHERE) && choosen.get(target).equals(SSPType.SCHERE)) {
						p.getOpenInventory().setItem(38+round.get(p), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 4).displayName("§eUnentschieden").build());
						target.getOpenInventory().setItem(38+round.get(target), new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 4).displayName("§eUnentschieden").build());
					}
					
					p.getOpenInventory().setItem(20, new ItemBuilder2(Material.NAME_TAG).displayName("§7Wählt..").build());
					target.getOpenInventory().setItem(20, new ItemBuilder2(Material.NAME_TAG).displayName("§7Wählt..").build());
					p.getOpenInventory().setItem(24, new ItemBuilder2(Material.NAME_TAG).displayName("§7Wählt..").build());
					target.getOpenInventory().setItem(24, new ItemBuilder2(Material.NAME_TAG).displayName("§7Wählt..").build());
					
					p.getOpenInventory().setItem(22, new ItemBuilder2(Material.WATCH).displayName("§760").build());
					target.getOpenInventory().setItem(22, new ItemBuilder2(Material.WATCH).displayName("§760").build());
					
					p.updateInventory();
					target.updateInventory();
					
					choosen.put(p, SSPType.LEER); choosen.put(target, SSPType.LEER);
					round.put(p, round.get(p)+1); round.put(target, round.get(target)+1);
					
					if(round.get(p) == 4 && round.get(target) == 4) {
						int winsA = 0, winsB = 0;
						
						if(p.getOpenInventory().getItem(39).getItemMeta().getDisplayName().contains(p.getDisplayName())) winsA++;
						if(p.getOpenInventory().getItem(40).getItemMeta().getDisplayName().contains(p.getDisplayName())) winsA++;
						if(p.getOpenInventory().getItem(41).getItemMeta().getDisplayName().contains(p.getDisplayName())) winsA++;
						if(target.getOpenInventory().getItem(39).getItemMeta().getDisplayName().contains(target.getDisplayName())) winsB++;
						if(target.getOpenInventory().getItem(40).getItemMeta().getDisplayName().contains(target.getDisplayName())) winsB++;
						if(target.getOpenInventory().getItem(41).getItemMeta().getDisplayName().contains(target.getDisplayName())) winsB++;
						
						if(winsA > winsB) setWinner(p);
						if(winsB > winsA) setWinner(target);
						if(winsA == winsB){
							p.sendMessage(Main.ssp + "§aDu hast gegen §e" + target.getDisplayName() + " §aein Unentschieden erzielt!");
							target.sendMessage(Main.ssp + "§aDu hast gegen §e" + p.getDisplayName() + " §aein Unentschieden erzielt!");
							
							choosen.remove(p); choosen.remove(target);
							enemy.remove(p); enemy.remove(target);
							round.remove(p); round.remove(target);
							
							p.closeInventory();
							target.closeInventory();
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onSSPclose(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		if(enemy.containsKey(p)) {
			setWinner(enemy.get(p));
		}
	}
	
	@EventHandler
	public void onSSPquit(PlayerQuitEvent e) {
		Player p = (Player) e.getPlayer();
		if(enemy.containsKey(p)) {
			setWinner(enemy.get(p));
		}
	}
	
	public void setWinner(Player p) {
		Player target = enemy.get(p);
		
		p.sendMessage(Main.ssp + "§aDu hast gegen §e" + target.getDisplayName() + " §agewonnen! §8(§e+ 5 Coins§8)");
		Coins.addCoins(p, 5);
		Methoden.updateScoreboard(p);
		target.sendMessage(Main.ssp + "§cDu hast gegen §e" + p.getDisplayName() + " §cverloren!");
		
		choosen.remove(p); choosen.remove(target);
		enemy.remove(p); enemy.remove(target);
		round.remove(p); round.remove(target);
		
		p.closeInventory();
		target.closeInventory();
	}
	
	public Inventory getStandartSSPInv() {
		Inventory inv = Bukkit.createInventory(null, 54, "§7Schere, Stein, Papier");
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short)15).displayName("").build());
		}
		
		inv.setItem(10, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(11, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(12, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(19, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(21, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(28, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(29, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(30, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 5).displayName("").build());
		inv.setItem(14, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(15, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(16, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(23, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(25, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(32, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(33, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		inv.setItem(34, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 14).displayName("").build());
		
		inv.setItem(20, new ItemBuilder2(Material.NAME_TAG).displayName("§7Wählt..").build());
		inv.setItem(24, new ItemBuilder2(Material.NAME_TAG).displayName("§7Wählt..").build());
		
		inv.setItem(22, new ItemBuilder2(Material.WATCH).displayName("§760").build());
		
		inv.setItem(39, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 0).displayName("§7Erster Sieger").build());
		inv.setItem(40, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 0).displayName("§7Zweiter Sieger").build());
		inv.setItem(41, new ItemBuilder2(Material.STAINED_GLASS_PANE, (short) 0).displayName("§7Dritter Sieger").build());
		
		inv.setItem(47, new ItemBuilder2(Material.STONE).displayName("§7Stein").build());
		inv.setItem(49, new ItemBuilder2(Material.PAPER).displayName("§7Papier").build());
		inv.setItem(51, new ItemBuilder2(Material.SHEARS).displayName("§7Schere").build());
		
		return inv;
	}
	
	public boolean hasChoosen(Player p) {
		if(choosen.containsKey(p) && !choosen.get(p).equals(SSPType.LEER)) return true;
		return false;
	}
}
