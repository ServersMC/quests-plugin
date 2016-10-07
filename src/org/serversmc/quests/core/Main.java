package org.serversmc.quests.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.serversmc.quests.enums.EQuests;
import org.serversmc.quests.events.QuestEvent;
import org.serversmc.quests.utils.Console;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		Console.info("Enabled!");
		Bukkit.getPluginManager().registerEvents(new QuestEvent(), this);
		EQuests.values();
	}
	
	@Override
	public void onDisable() {
		Console.info("Eisabled!");
	}
	
}
