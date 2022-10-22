package me.whipmegrandma.power.manager;

import me.whipmegrandma.power.database.Database;
import org.bukkit.entity.Player;

import java.util.*;

public class PowerManager {

	public static HashMap<UUID, Integer> powerManager = new HashMap<>();

	public static void join(Player player, int amount) {
		UUID uuid = player.getUniqueId();

		powerManager.put(uuid, amount);
	}

	public static void quit(Player player) {
		UUID uuid = player.getUniqueId();

		powerManager.remove(uuid);
	}

	public static void give(Player player, int amount) {
		UUID uuid = player.getUniqueId();

		int power = powerManager.get(uuid);
		int powerUpdated = power + amount;

		powerManager.put(uuid, powerUpdated);

		Database.getInstance().saveCache(player);
	}

	public static void remove(Player player, int amount) {
		UUID uuid = player.getUniqueId();

		int power = powerManager.get(uuid);
		int powerUpdated = power - amount;

		powerManager.put(uuid, powerUpdated);

		Database.getInstance().saveCache(player);
	}

	public static void set(Player player, int amount) {
		UUID uuid = player.getUniqueId();

		powerManager.put(uuid, amount);

		Database.getInstance().saveCache(player);
	}

	public static int balance(Player player) {
		UUID uuid = player.getUniqueId();

		int balance = powerManager.get(uuid);

		return balance;
	}

	public static List<Map.Entry<String, Integer>> sortLeaderboard(HashMap<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		return list;
	}

	public static int leaderboardPosition(Player player, HashMap<String, Integer> map) {

		int i = 1;

		for (Map.Entry<String, Integer> list : sortLeaderboard(map)) {
			String leaderboard = list.getKey();
			String playerName = player.getName();

			if (leaderboard.equals(playerName)) {
				return i;
			}

			i++;

		}
		return 0;
	}
}
