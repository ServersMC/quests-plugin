package org.serversmc.quests.types;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.serversmc.quests.core.Main;
import org.serversmc.quests.enums.EQuest;

public abstract class Quest implements Listener {
	
	// STATIC //
	
	public static List<Quest> quests = new ArrayList<Quest>();
	
	public static Quest getQuestByName(String name) {
		for (EQuest equest : EQuest.values()) {
			if (equest.name().equalsIgnoreCase(name)) {
				return equest.quest;
			}
		}
		return null;
	}
	
	// OBJECT //

	public Location location;
	
	public Quest() {
		Quest.quests.add(this);
		Bukkit.getPluginManager().registerEvents(this, Main.plugin);
	}
	
	public void preInit(Player player) {
		
	}
	
	public abstract void init(Player player);
	public abstract boolean isRepeatable();
	public abstract List<Quest> getRequirments();
	public abstract void loadMemory(Player player, String s);
	public abstract void saveMemory(Player player, PrintWriter writer);
	
}