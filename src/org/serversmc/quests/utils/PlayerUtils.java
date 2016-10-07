package org.serversmc.quests.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.serversmc.quests.enums.EDirectory;
import org.serversmc.quests.enums.EQuest;
import org.serversmc.quests.types.Quest;

public class PlayerUtils {

	public static HashMap<Player, List<String>> players = new HashMap<Player, List<String>>();
	
	public static void addCompleted(Player player, Quest quest) {
		players.get(player).add(EQuest.parse(quest).name());
	}
	
	public static boolean hasCompleted(Player player, Quest quest) {
		List<String> list;
		if ((list = players.get(player)) != null) {
			return list.contains(EQuest.parse(quest).name());
		}
		return false;
	}
	
	public static void loadPlayer(Player player) {
		File file = new File(EDirectory.PLAYERS + player.getUniqueId().toString());
		if (!file.exists()) {
			try {
				file.createNewFile();
				return;
			} catch (IOException e) {
				Console.err("Could not create data file for " + player.getName());
				e.printStackTrace();
			}
		}
		players.put(player, new ArrayList<String>());
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			String[] enums = line.split(" ");
			for (String var : enums) {
				try {
					players.get(player).add(var);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				String[] vars = line.split(":", 2);
				Quest quest = Quest.getQuestByName(vars[0]);
				quest.loadMemory(player, vars[1]);
			}
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void savePlayer(Player player) {
		File file = new File(EDirectory.PLAYERS + player.getUniqueId().toString());
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.println(String.join(" ", players.get(player)).trim());
			for (EQuest quest : EQuest.values()) {
				if (!quest.quest.hasMemory(player)) {
					continue;
				}
				writer.print(quest.name() + ":");
				quest.quest.saveMemory(player, writer);
			}
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
