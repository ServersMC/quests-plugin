package org.serversmc.quests.quests;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.serversmc.quests.types.Quest;

public class TestQuest extends Quest implements Listener {

	public TestQuest() {
		loc = new Location(Bukkit.getWorld("world"), 156, 64, -455);
	}
	
	@Override
	public void init() {
	}

	@Override
	public void update() {
	}
	
}
