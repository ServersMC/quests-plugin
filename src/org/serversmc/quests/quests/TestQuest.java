package org.serversmc.quests.quests;

import java.math.BigDecimal;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.serversmc.quests.types.Quest;
import com.earth2me.essentials.api.*;

public class TestQuest extends Quest implements Listener {

	public TestQuest() {
		location = new Location(Bukkit.getWorld("world"), 156, 64, -455);
	}

	private HashMap<Player, Integer> memory = new HashMap<Player, Integer>();

	@Override
	public void init(Player player) {
		if (memory.containsKey(player)) {
			player.sendMessage(ChatColor.RED + "You have already started this quest!");
		} else {
			player.sendMessage(
					ChatColor.GREEN + "If you can collect kill 15 mobs for me, I'll give you a reward of $150.00!");
			memory.put(player, 0);
		}
	}

	@EventHandler
	public void onEntityDeathEvent(EntityDeathEvent event) {
		Entity death = event.getEntity();
		Entity killer = event.getEntity().getKiller();
		if (death instanceof Player) {
			return;
		}
		if (!(killer instanceof Player)) {
			return;
		}
		Player player = (Player) killer;
		if (memory.containsKey(player)) {
			memory.replace(player, memory.get(player) + 1);
			System.out.println(memory.get(player));
			if (memory.get(player) == 3) {
				player.sendMessage(ChatColor.GREEN + "Thanks man! Here's your $150!");
				memory.remove(player);
				try {
					Economy.add(player.getName(), BigDecimal.valueOf(150d));
				} catch (NoLoanPermittedException | UserDoesNotExistException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
