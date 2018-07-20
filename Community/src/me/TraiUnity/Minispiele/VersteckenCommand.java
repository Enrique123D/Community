package me.TraiUnity.Minispiele;

import java.util.HashMap;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.TraiUnity.Main;

public class VersteckenCommand implements CommandExecutor, Listener{

	static HashMap<Player, LinkedList<Player>> partys = new HashMap<>();
	HashMap<Player, LinkedList<Player>> invites = new HashMap<>();
	static HashMap<Player, LinkedList<Player>> found = new HashMap<>();
	static HashMap<Player, Integer> searcher = new HashMap<>();
	public static HashMap<Player, Player> search = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "ßcDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}
		
		if(args.length == 0){
			p.sendMessage(Main.verstecken + "");
			p.sendMessage(Main.verstecken + "ßeMinispiel ß8| ß7Verstecken");
			p.sendMessage(Main.verstecken + "");
			p.sendMessage(Main.verstecken + "");
			p.sendMessage(Main.verstecken + "");
			p.sendMessage(Main.verstecken + "");
			p.sendMessage(Main.verstecken + "");
		}
		
		// Test
		if(partys.containsKey(p)){
			p.sendMessage(Main.verstecken + "ß7Deine Partyß8: ße" + partys.get(p.getName()));
		}
		if(invites.containsKey(p)){
			p.sendMessage(Main.verstecken + "ß7Deine Einladungenß8: ße" + invites.get(p.getName()));
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("start")) {
				if(partys.containsKey(p)) {
					if(found.get(search.get(p)) == null) {
						searcher.put(p, 0);
						startNextSearch(p);
					}else {
						p.sendMessage(Main.verstecken + "ßcDie Runde ist bereits gestartet!");
					}
				}else {
					p.sendMessage(Main.verstecken + "ßcDu hast keine Party!");
				}
			}else if(args[0].equalsIgnoreCase("leave")) {
				if(!partys.containsKey(p)) {
					for(Player leader : partys.keySet()) {
						if(partys.get(leader).contains(p)) {
							leader.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party verlassen!");
							for(Player party : partys.get(leader)) {
								party.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party verlassen!");
							}
							
							if(search.containsKey(p)){
								search.remove(p);
							}
							if(found.containsKey(p)){
								found.remove(p);
							}
							startNextSearch(leader);
							break;
						}
					}
				}else {
					p.sendMessage(Main.verstecken + "ßcDu bist kein Partyleiter!");
				}
			}else if(args[0].equalsIgnoreCase("clear")) {
				if(partys.containsKey(p)) {
					if(search.containsKey(p)){
						search.remove(p);
					}
					if(searcher.containsKey(p)){
						searcher.remove(p);
					}
					if(found.containsKey(p)){
						found.remove(p);
					}
					for(Player party : partys.get(p)) {
						if(search.containsKey(party)){
							search.remove(party);
						}
						if(searcher.containsKey(party)){
							searcher.remove(party);
						}
						if(found.containsKey(party)){
							found.remove(party);
						}
						party.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party aufgel√∂st.");
					}
					partys.remove(p);
					for(Player invite : invites.get(p)) {
						invite.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party aufgel√∂st.");
					}
					invites.remove(p);
				}else {
					p.sendMessage(Main.verstecken + "ßcDu bist kein Partyleiter!");
				}
			}
		}else if(args.length == 2){
			if(args[0].equalsIgnoreCase("invite")){
				Player target = null;
				try{
					target = Bukkit.getPlayer(args[1]);
				}catch(Exception e){
					p.sendMessage(Main.verstecken + "ßcDer Spieler ße" + args[1] + " ßcist nicht online!");
					return false;
				}
				
				if(target == p){
					p.sendMessage(Main.verstecken + "ßcDu kannst dir selber keine Einladung schicken!");
					return false;
				}
				
				if(invites.containsKey(p) && invites.get(p).contains(target)){
					p.sendMessage(Main.verstecken + "ßcDu hast diesen Spieler bereits eingeladen!");
					return false;
				}
				if(partys.containsKey(p) && partys.get(p).contains(target)){
					p.sendMessage(Main.verstecken + "ßcDieser Spieler ist bereits in deiner Party!");
					return false;
				}
				
				p.sendMessage(Main.verstecken + "ß7Du hast eine Einladung an " + target.getDisplayName() + " ß7geschickt.");
				target.sendMessage(Main.verstecken + "ß7Du hast eine Einladung von ße" + p.getDisplayName() + " ß7bekommen!");
				target.sendMessage(Main.verstecken + "ß7Nehme sie an mit ßa/verstecken accept " + p.getName());
				LinkedList<Player> list = new LinkedList<>();
				if(invites.containsKey(p)){
					list = invites.get(p);
				}
				list.add(target);
				invites.put(p, list);
			}else if(args[0].equalsIgnoreCase("remove")){
				Player target = null;
				try{
					target = Bukkit.getPlayer(args[1]);
				}catch(Exception e){
					p.sendMessage(Main.verstecken + "ßcDer Spieler ße" + args[1] + " ßcist nicht online!");
					return false;
				}
				
				if(target == p){
					p.sendMessage(Main.verstecken + "ßcDu kannst dich nicht aus der Party kicken!");
					return false;
				}
				
				if(partys.containsKey(p)){
					if(!partys.get(p).contains(target)){
						p.sendMessage(Main.verstecken + "ßcDieser Spieler ist nicht in deiner Party");
						return false;
					}
					
					target.sendMessage(Main.verstecken + "ßcDu wurdest aus der Party gekickt.");
					LinkedList<Player> list = partys.get(p);
					list.remove(target);
					partys.put(p, list);
				}else{
					p.sendMessage(Main.verstecken + "ßcDu hast keine Party!");
				}
			}else if(args[0].equalsIgnoreCase("accept")){
				Player target = null;
				try{
					target = Bukkit.getPlayer(args[1]);
				}catch(Exception e){
					p.sendMessage(Main.verstecken + "ßcDer Spieler ße" + args[1] + " ßcist offline!");
					return false;
				}
				
				if(invites.containsKey(target)){
					target.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Einladung angenommen!");
					p.sendMessage(Main.verstecken + "ß7Du hast die Einladung angenommen!");
					LinkedList<Player> list = new LinkedList<>();
					LinkedList<Player> list2 = new LinkedList<>();
					if(partys.containsKey(target)){
						list = partys.get(target);
					}
					if(invites.containsKey(target)){
						list2 = invites.get(target);
					}
					list.add(p);
					list2.remove(p);
					partys.put(target, list);
					invites.put(target, list2);
					if(list2.size() == 0) invites.remove(target);
				}else{
					p.sendMessage(Main.verstecken + "ßcDieser Spieler hat keine Party!");
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onQuiti(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		
		if(!partys.containsKey(p)) {
			for(Player leader : partys.keySet()) {
				if(partys.get(leader).contains(p)) {
					leader.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party verlassen!");
					for(Player party : partys.get(leader)) {
						party.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party verlassen!");
					}
					
					if(search.containsKey(p)){
						search.remove(p);
					}
					if(found.containsKey(p)){
						found.remove(p);
					}
					startNextSearch(leader);
					break;
				}
			}
		}else {
			if(search.containsKey(p)){
				search.remove(p);
			}
			if(searcher.containsKey(p)){
				searcher.remove(p);
			}
			if(found.containsKey(p)){
				found.remove(p);
			}
			for(Player party : partys.get(p)) {
				if(search.containsKey(party)){
					search.remove(party);
				}
				if(searcher.containsKey(party)){
					searcher.remove(party);
				}
				if(found.containsKey(party)){
					found.remove(party);
				}
				party.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party aufgel√∂st!");
			}
			partys.remove(p);
			for(Player invite : invites.get(p)) {
				invite.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat die Party aufgel√∂st!");
			}
			invites.remove(p);
		}
	}
	
	@EventHandler
	public void onMoveee(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		if(search.containsKey(p) && p.hasPotionEffect(PotionEffectType.BLINDNESS)){
			e.setCancelled(true);
			p.teleport(e.getFrom());
		}
	}
	
	@EventHandler
	public void onEntityGefunden(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		
		if(e.getRightClicked() instanceof Player && search.containsKey(p) && !found.get(p).contains(e.getRightClicked())) {
			Player target = (Player) e.getRightClicked();
			LinkedList<Player> founded = new LinkedList<>();
			if(found.containsKey(p)){
				founded = found.get(p);
			}
			founded.add(target);
			found.put(p, founded);
			p.sendMessage(Main.verstecken + "ßaDu hast ße" + target.getName() + " ßagefunden.");
			target.sendMessage(Main.verstecken + "ßaDu wurdest von ße" + p.getName() + " ßagefunden.");
			if(found.get(p).size() == partys.get(search.get(p)).size()) {
				search.get(p).sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat es geschafft!");
				for(Player party : partys.get(search.get(p))) {
					party.sendMessage(Main.verstecken + p.getDisplayName() + " ß7hat es geschafft!");
				} 
				startNextSearch(search.get(p));
			}
		}
	}
	
	public static void startNextSearch(Player leader) {
		if(searcher.get(leader) == partys.get(leader).size()) searcher.remove(leader);
			for(Player t : partys.get(leader)) {
				if(search.containsKey(t)) {
					search.remove(t);
				}
				if(found.containsKey(t)) {
					found.remove(t);
				}
			}
		
		Player newsearcher = null;
		if(searcher.containsKey(leader)){
			if(searcher.get(leader) != 0) {
				newsearcher = partys.get(leader).get(searcher.get(leader));
			}else{
				newsearcher = leader;
			}
		}
		
		if(newsearcher == null) {
			leader.sendMessage(Main.verstecken + "ß7Die Runde wurde beendet!");
			for(Player party : partys.get(leader)) {
				party.sendMessage(Main.verstecken + "ß7Die Runde wurde beendet!");
			}
			return;
		}
		
		// zum Communityspawnt teleportieren
		
		World w1 = Bukkit.getWorld(Main.loc.getString("Spawn.World"));
		double x1 = Main.loc.getDouble("Spawn.X");
		double y1 = Main.loc.getDouble("Spawn.Y");
		double z1 = Main.loc.getDouble("Spawn.Z");
		float yaw1 = (float)Main.loc.getDouble("Spawn.Yaw");
		float pitch1 = (float)Main.loc.getDouble("Spawn.Pitch");
		Location spawn = new Location(w1, x1, y1, z1, yaw1, pitch1);
		
		leader.teleport(spawn);
		leader.playSound(leader.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
		leader.sendMessage(Main.verstecken + "ßaDie Runde hat gestartet!");
		
		for(Player party : partys.get(leader)) {
			World w12 = Bukkit.getWorld(Main.loc.getString("Spawn.World"));
			double x12 = Main.loc.getDouble("Spawn.X");
			double y12 = Main.loc.getDouble("Spawn.Y");
			double z12 = Main.loc.getDouble("Spawn.Z");
			float yaw12 = (float)Main.loc.getDouble("Spawn.Yaw");
			float pitch12 = (float)Main.loc.getDouble("Spawn.Pitch");
			Location spawn2 = new Location(w12, x12, y12, z12, yaw12, pitch12);
			
			party.teleport(spawn2);
			party.playSound(party.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
			party.sendMessage(Main.verstecken + "ßaDie Runde hat gestartet!");
		}
		newsearcher.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 15*20, 1));
		newsearcher.sendMessage(Main.verstecken + "ßaDu bist dran mit suchen!");
		
		search.put(newsearcher, leader);
		found.put(newsearcher, new LinkedList<>());
	}
}
