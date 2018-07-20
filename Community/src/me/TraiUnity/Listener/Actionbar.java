package me.TraiUnity.Listener;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Actionbar implements Listener
{
public static void sendActionBar(Player p, String message)
{
	IChatBaseComponent c = net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
	PacketPlayOutChat pac = new PacketPlayOutChat(c, (byte)2);
	((CraftPlayer)p).getHandle().playerConnection.sendPacket(pac);
	}
}
