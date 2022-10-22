package me.whipmegrandma.power.manager;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PowerManager {

	public static HashMap<UUID, Integer> powerManager = new HashMap<>();

	public static void join(Player player) {
		UUID uuid = player.getUniqueId();

		powerManager.put(uuid, 0);
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
	}

	public static void remove(Player player, int amount) {
		UUID uuid = player.getUniqueId();

		int power = powerManager.get(uuid);
		int powerUpdated = power - amount;

		powerManager.put(uuid, powerUpdated);
	}

	public static void set(Player player, int amount) {
		UUID uuid = player.getUniqueId();

		powerManager.put(uuid, amount);
	}

	public static int balance(Player player) {
		UUID uuid = player.getUniqueId();

		int balance = powerManager.get(uuid);

		return balance;
	}
}
