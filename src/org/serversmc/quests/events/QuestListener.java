package org.serversmc.quests.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.serversmc.quests.types.Quest;
import org.serversmc.quests.utils.PlayerUtils;

public class QuestListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (!event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			return;
		}
		Location location = event.getClickedBlock().getLocation();
		
		for (Quest quest : Quest.quests) {
			if (location.distance(quest.location) == 0) {
				quest.preInit(player);
			}
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		PlayerUtils.loadPlayer(event.getPlayer());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		PlayerUtils.savePlayer(event.getPlayer());
	}
	
}
