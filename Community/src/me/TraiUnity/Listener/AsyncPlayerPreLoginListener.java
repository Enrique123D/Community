package me.TraiUnity.Listener;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import de.dave_911.Coins.Coins;

public class AsyncPlayerPreLoginListener implements Listener {

	@EventHandler
	public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent e) {
		
		UUID uuid = e.getUniqueId();
		String name = e.getName();

		if (e.getLoginResult() == Result.ALLOWED) {
			Coins.registerPlayer(uuid, name);
			Coins.setPlayerName(uuid, name);
		}
	}
}
