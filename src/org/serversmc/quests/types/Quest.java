package org.serversmc.quests.types;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.serversmc.quests.core.Main;

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

	public Integer id;
	public Location location;
	
	public Quest() {
		id = quests.size();
		Quest.quests.add(this);
		Bukkit.getPluginManager().registerEvents(this, Main.plugin);
	}
	
	public void preInit(Player player) {
		
	}
	
	public abstract void init(Player player);
	public abstract boolean isRepeatable();
	public abstract List<Quest> getRequirments();
	
}