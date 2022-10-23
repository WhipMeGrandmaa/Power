package me.whipmegrandma.power.manager;

import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.menu.BuyMenu;
import me.whipmegrandma.power.menu.SellMenu;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.ItemUtil;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;

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

	public static void sell(Player player, int amount, CompMaterial material, SellMenu menu) {
		UUID uuid = player.getUniqueId();
		ItemStack[] items = player.getInventory().getContents();

		int times = 0;

		for (ItemStack item : items)
			if (item != null && material.toMaterial() == item.getType()) {
				times += item.getAmount();
			}

		if (times == 0) {
			menu.restartMenu("&cInsufficient " + ItemUtil.bountifyCapitalized(material) + "!");
			CompSound.ENTITY_VILLAGER_NO.play(player);

			return;
		}

		PlayerUtil.take(player, material, times);

		CompSound.ENTITY_VILLAGER_CELEBRATE.play(player);

		int power = powerManager.get(uuid);
		int powerUpdated = power + (amount * times);

		powerManager.put(uuid, powerUpdated);

		Database.getInstance().saveCache(player);

		menu.restartMenu("&aSold for " + (amount * times) + " power!");

	}

	public static void buy(Player player, int amount, ItemStack item, BuyMenu menu) {
		UUID uuid = player.getUniqueId();
		ItemStack[] items = player.getInventory().getContents();

		int power = powerManager.get(uuid);
		int powerUpdated = power - amount;

		if (powerUpdated < 0) {
			menu.restartMenu("&cInsufficient funds!");
			CompSound.ENTITY_VILLAGER_NO.play(player);

			return;
		}

		PlayerUtil.addItemsOrDrop(player, item);

		CompSound.ENTITY_VILLAGER_CELEBRATE.play(player);

		powerManager.put(uuid, powerUpdated);

		Database.getInstance().saveCache(player);

		menu.restartMenu("&aYou received a " + ItemUtil.bountifyCapitalized(item.getType()) + "!");
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
