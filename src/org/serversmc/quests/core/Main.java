package org.serversmc.quests.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.serversmc.quests.enums.EQuests;
import org.serversmc.quests.events.QuestListener;
import org.serversmc.quests.utils.Console;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		Console.info("Enabled!");
		Bukkit.getPluginManager().registerEvents(new QuestListener(), this);
		EQuests.values();
		setupFiles();
	}
	
	public void setupFiles() {
		List<File> folders = new ArrayList<File>();
		folders.add(getDataFolder());
		folders.add(new File(getDataFolder(), "players/"));
		for (File folder : folders) {
			folder.mkdirs();
		}
	}
	
	@Override
	public void onDisable() {
		Console.info("Eisabled!");
	}
	
}
