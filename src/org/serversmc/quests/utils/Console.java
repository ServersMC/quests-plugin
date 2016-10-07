package org.serversmc.quests.utils;

import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;

public class Console {
	
	private static final boolean debug = true;
	
	public static void info(String msg) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Quests] " + msg);
	}
	
	public static void warn(String msg) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[Quests] " + msg);
	}
	
	public static void err(String msg) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[Quests] " + msg);
	}

	public static void debug(String msg) {
		if (debug) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Quests] " + msg);
		}
	}
	
}
