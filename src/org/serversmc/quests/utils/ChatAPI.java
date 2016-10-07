package org.serversmc.quests.utils;

import java.lang.reflect.Constructor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatAPI {
	
	public static void sendChat(Player player, String msg) {
		try {
			Object chatS = getMcClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"\",\"extra\":[" + msg + "]}");
			Constructor<?> ctor = getMcClass("PacketPlayOutChat").getConstructor(getMcClass("IChatBaseComponent"));
			sendPacket(player, ctor.newInstance(chatS));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static Class<?> getMcClass(String name) {
		String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		try {
			return Class.forName("net.minecraft.server." + version + "." + name);
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static void sendPacket(Player player, Object packet) {
		try {
			Object handle = player.getClass().getMethod("getHandle").invoke(player);
			Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
			playerConnection.getClass().getMethod("sendPacket", getMcClass("Packet")).invoke(playerConnection, packet);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
