package org.serversmc.quests.core;

import org.bukkit.plugin.java.JavaPlugin;
import org.serversmc.quests.utils.Console;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		Console.info("enabled!");
	}
	
	@Override
	public void onDisable() {
		Console.info("disabled!");
	}
	
}
