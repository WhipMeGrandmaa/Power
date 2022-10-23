package me.whipmegrandma.power.papi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class PlaceholderApi extends PlaceholderExpansion {

	String ptopname1;
	String ptopname2;
	String ptopname3;
	String ptopname4;
	String ptopname5;
	String ptopname6;
	String ptopname7;
	String ptopname8;

	String ptopbal1;
	String ptopbal2;
	String ptopbal3;
	String ptopbal4;
	String ptopbal5;
	String ptopbal6;
	String ptopbal7;
	String ptopbal8;

	@Override
	public @NotNull String getIdentifier() {
		return "power";
	}

	@Override
	public @NotNull String getAuthor() {
		return "WhipMeGrandma";
	}

	@Override
	public @NotNull String getVersion() {
		return "1.0.0";
	}

	@Override
	public boolean canRegister() {
		return true;
	}

	@Override
	public boolean persist() {
		return true;
	}

	@Override
	public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
		if (player == null)
			return "";

		if ("playerpower".equals(params))
			return String.valueOf(PowerManager.balance(player));

		Database.getInstance().pollAllCache(cache -> {
			int i = 0;

			for (Map.Entry<String, Integer> map : PowerManager.sortLeaderboard(cache)) {
				i++;

				if (i == 1) {
					PlaceholderApi.this.ptopname1 = map.getKey();
					PlaceholderApi.this.ptopbal1 = String.valueOf(map.getValue());
				}

				if (i == 2) {
					PlaceholderApi.this.ptopname2 = map.getKey();
					PlaceholderApi.this.ptopbal2 = String.valueOf(map.getValue());
				}

				if (i == 3) {
					PlaceholderApi.this.ptopname3 = map.getKey();
					PlaceholderApi.this.ptopbal3 = String.valueOf(map.getValue());
				}

				if (i == 4) {
					PlaceholderApi.this.ptopname4 = map.getKey();
					PlaceholderApi.this.ptopbal4 = String.valueOf(map.getValue());
				}

				if (i == 5) {
					PlaceholderApi.this.ptopname5 = map.getKey();
					PlaceholderApi.this.ptopbal5 = String.valueOf(map.getValue());
				}

				if (i == 6) {
					PlaceholderApi.this.ptopname6 = map.getKey();
					PlaceholderApi.this.ptopbal6 = String.valueOf(map.getValue());
				}

				if (i == 7) {
					PlaceholderApi.this.ptopname7 = map.getKey();
					PlaceholderApi.this.ptopbal7 = String.valueOf(map.getValue());
				}

				if (i == 8) {
					PlaceholderApi.this.ptopname8 = map.getKey();
					PlaceholderApi.this.ptopbal8 = String.valueOf(map.getValue());

					break;
				}
			}
		});

		if ("ptopname1".equals(params))
			return this.ptopname1;

		if ("ptopname2".equals(params))
			return this.ptopname2;

		if ("ptopname3".equals(params))
			return this.ptopname3;

		if ("ptopname4".equals(params))
			return this.ptopname4;

		if ("ptopname5".equals(params))
			return this.ptopname5;

		if ("ptopname6".equals(params))
			return this.ptopname6;

		if ("ptopname7".equals(params))
			return this.ptopname7;

		if ("ptopname8".equals(params))
			return this.ptopname8;


		if ("ptopbal1".equals(params))
			return this.ptopbal1;

		if ("ptopbal2".equals(params))
			return this.ptopbal2;

		if ("ptopbal3".equals(params))
			return this.ptopbal3;

		if ("ptopbal4".equals(params))
			return this.ptopbal4;

		if ("ptopbal5".equals(params))
			return this.ptopbal5;

		if ("ptopbal6".equals(params))
			return this.ptopbal6;

		if ("ptopbal7".equals(params))
			return this.ptopbal7;

		if ("ptopbal8".equals(params))
			return this.ptopbal8;

		return null;
	}

}
