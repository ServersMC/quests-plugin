package org.serversmc.quests.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.serversmc.quests.types.Quest;

public class QuestEvent implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location location = event.getClickedBlock().getLocation();
		
		for (Quest quest : Quest.quests) {
			if (location.distance(quest.location) == 0) {
				quest.init(player);
			}
		}
	}
	
}