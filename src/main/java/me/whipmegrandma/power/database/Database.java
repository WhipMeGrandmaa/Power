package me.whipmegrandma.power.database;

import lombok.Getter;
import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.database.SimpleDatabase;
import org.mineacademy.fo.remain.Remain;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.function.Consumer;

public class Database extends SimpleDatabase {

	@Getter
	private final static Database instance = new Database();

	private Database() {
		this.addVariable("table", "Database");
	}

	@Override
	protected void onConnected() {
		this.createTable(TableCreator.of("{table}")
				.add("UUID", "VARCHAR(64)")
				.add("Name", "TEXT")
				.addDefault("Power", "BIGINT", "0")
				.setPrimaryColumn("UUID"));
	}

	public void loadCache(Player player, Consumer<Integer> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			try {
				ResultSet resultSet = this.query("SELECT * FROM {table} WHERE UUID='" + player.getUniqueId() + "'");

				if (!resultSet.next()) {
					Common.runLater(() -> onLoaded.accept(0));
					this.saveNewPlayerCache(player);

					return;
				}

				int balance = Integer.parseInt(resultSet.getString("Power"));

				Common.runLater(() -> onLoaded.accept(balance));
			} catch (Throwable t) {
				Remain.sneaky(t);
			}

		});
	}

	public void saveCache(Player player) {
		this.saveCache(player, non -> {
		});
	}

	public void saveCache(Player player, Consumer<Integer> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			try {
				SerializedMap map = SerializedMap.ofArray(
						"UUID", player.getUniqueId(),
						"Name", player.getName(),
						"Power", PowerManager.balance(player));

				String columns = Common.join(map.keySet());
				String values = Common.join(map.values(), ", ", value -> value == null || value.equals("NULL") ? "NULL" : "'" + value + "'");

				this.update("INSERT OR REPLACE INTO {table} (" + columns + ") VALUES (" + values + ");");

				int balance = PowerManager.balance(player);

				Common.runLater(() -> onLoaded.accept(balance));
			} catch (Throwable t) {
				Remain.sneaky(t);
			}
		});
	}

	public void addPower(String player, int amount, Consumer<String> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			try {

				this.update("UPDATE {table} SET Power=Power + " + amount + " WHERE Name='" + player + "' COLLATE NOCASE");

				ResultSet resultSet = this.query("SELECT Name FROM {table} WHERE Name='" + player + "' COLLATE NOCASE");

				String playerName = resultSet.getString("Name");

				Common.runLater(() -> {
					onLoaded.accept(player);

					Player playerObject = Bukkit.getPlayerExact(playerName);
					if (playerObject != null)
						PowerManager.give(playerObject, amount);
				});


			} catch (Throwable t) {
				Remain.sneaky(t);
			}
		});
	}

	public void subtractPower(String player, int amount, Consumer<String> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			try {

				this.update("UPDATE {table} SET Power=Power - " + amount + " WHERE Name='" + player + "' COLLATE NOCASE");

				ResultSet resultSet = this.query("SELECT Name FROM {table} WHERE Name='" + player + "' COLLATE NOCASE");

				String playerName = resultSet.getString("Name");

				Common.runLater(() -> {
					onLoaded.accept(player);

					Player playerObject = Bukkit.getPlayerExact(playerName);
					if (playerObject != null)
						PowerManager.remove(playerObject, amount);
				});


			} catch (Throwable t) {
				Remain.sneaky(t);
			}
		});
	}

	public void setPower(String player, int amount, Consumer<String> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			try {

				this.update("UPDATE {table} SET Power=" + amount + " WHERE Name='" + player + "' COLLATE NOCASE");

				ResultSet resultSet = this.query("SELECT Name FROM {table} WHERE Name='" + player + "' COLLATE NOCASE");

				String playerName = resultSet.getString("Name");

				Common.runLater(() -> {
					onLoaded.accept(player);

					Player playerObject = Bukkit.getPlayerExact(playerName);
					if (playerObject != null)
						PowerManager.set(playerObject, amount);
				});


			} catch (Throwable t) {
				Remain.sneaky(t);
			}
		});
	}

	public void saveNewPlayerCache(Player player) {

		try {
			SerializedMap map = SerializedMap.ofArray(
					"UUID", player.getUniqueId(),
					"Name", player.getName(),
					"Power", 0);

			String columns = Common.join(map.keySet());
			String values = Common.join(map.values(), ", ", value -> value == null || value.equals("NULL") ? "NULL" : "'" + value + "'");

			this.update("INSERT OR REPLACE INTO {table} (" + columns + ") VALUES (" + values + ");");

		} catch (Throwable t) {
			Remain.sneaky(t);
		}
	}

	public void pollCache(String playerName, Consumer<ResultSet> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			try {
				ResultSet resultSet = this.query("SELECT * FROM {table} WHERE Name='" + playerName + "' COLLATE NOCASE");

				if (!resultSet.next()) {
					Common.runLater(() -> onLoaded.accept(null));

					return;
				}

				Common.runLater(() -> onLoaded.accept(resultSet));
			} catch (Throwable t) {
				Remain.sneaky(t);
			}
		});
	}

	public void pollAllCache(Consumer<HashMap<String, Integer>> onLoaded) {
		Valid.checkSync("Please call this on the main thread.");

		Common.runAsync(() -> {
			HashMap<String, Integer> allCache = new HashMap<>();

			try {
				this.selectAll("{table}", resultSet -> {
					String uuid = resultSet.getString("Name");
					int balance = Integer.parseInt(resultSet.getString("Power"));

					allCache.put(uuid, balance);
				});

				Common.runLater(() -> onLoaded.accept(allCache));

			} catch (Throwable t) {
				Remain.sneaky(t);
			}
		});
	}

}
