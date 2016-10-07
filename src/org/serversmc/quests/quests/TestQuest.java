package org.serversmc.quests.quests;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.serversmc.quests.types.Quest;

public class TestQuest extends Quest implements Listener {

	public TestQuest() {
		location = new Location(Bukkit.getWorld("world"), 156, 64, -455);
	}

	@Override
	public void init(Player player) {
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
	}

}
