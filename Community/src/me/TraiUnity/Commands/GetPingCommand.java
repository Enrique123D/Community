package me.TraiUnity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;

public class GetPingCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.commip + "§cDu musst ein Spieler sein, um diesen Befehl zu verwenden.");
			return true;
		}

		Player p = (Player) sender;
		
		if(getPing(p) < 100){
			p.sendMessage(Main.commip + "§7Dein Ping§8: §a" + getPing(p) + "ms");
		}else if(getPing(p) >= 100 && getPing(p) < 200){
			p.sendMessage(Main.commip + "§7Dein Ping§8: §e" + getPing(p) + "ms");
		}else if(getPing(p) >= 300 && getPing(p) < 400){
			p.sendMessage(Main.commip + "§7Dein Ping§8: §c" + getPing(p) + "ms");
		}else if(getPing(p) >= 400){
			p.sendMessage(Main.commip + "§7Dein Ping§8: §4" + getPing(p) + "ms");	
		}
		return false;
	}
	
    public int getPing(Player p) {
        CraftPlayer pingc = (CraftPlayer) p;
        EntityPlayer pinge = pingc.getHandle();
        return pinge.ping;
    }
}
