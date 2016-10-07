package org.serversmc.quests.types;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public abstract class Quest implements Listener {
	
	// STATIC //
	
	public static List<Quest> quests = new ArrayList<Quest>();
	
	public static Quest getQuestById(Integer id) {
		for (Quest quest : quests) {
			if (quest.id.equals(id)) {
				return quest;
			}
		}
		return null;
	}
	
	// OBJECT //

	public Quest() {
		Quest.quests.add(this);
	}
	
	public Integer id;
	public Location location;
	
	public abstract void init(Player player);
	
}