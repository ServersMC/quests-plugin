package org.serversmc.quests.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.entity.Player;
import org.serversmc.quests.enums.EDirectory;
import org.serversmc.quests.enums.EQuest;
import org.serversmc.quests.types.Quest;

public class PlayerUtils {

	public static void loadPlayer(Player player) {
		File file = new File(EDirectory.PLAYERS + player.getUniqueId().toString());
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Console.err("Could not create data file for " + player.getName());
				e.printStackTrace();
			}
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				String[] vars = line.split(line, 2);
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
			
			for (EQuest quest : EQuest.values()) {
				writer.print(quest.name() + ":");
				quest.quest.saveMemory(player, writer);
			}
			
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
