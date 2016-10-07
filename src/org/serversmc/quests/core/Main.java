package org.serversmc.quests.core;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.serversmc.quests.enums.EDirectory;
import org.serversmc.quests.enums.EQuest;
import org.serversmc.quests.events.QuestListener;
import org.serversmc.quests.utils.Console;
import org.serversmc.quests.utils.PlayerUtils;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		Bukkit.getPluginManager().registerEvents(new QuestListener(), this);
		
		EQuest.values();
		setupFiles();
		
		loadMemory();
		
		Console.info("Enabled!");
	}
	
	public void setupFiles() {
		for (EDirectory dir : EDirectory.values()) {
			new File(dir.toString()).mkdirs();
		}
	}
	
	public void loadMemory() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			PlayerUtils.loadPlayer(player);
		}
	}
	
	public void saveMemory() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			PlayerUtils.savePlayer(player);
		}
	}
	
	@Override
	public void onDisable() {
		saveMemory();
		Console.info("Disabled!");
	}
	
}
