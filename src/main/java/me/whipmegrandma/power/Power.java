package me.whipmegrandma.power;

import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.file.PowerShopCauldronFile;
import me.whipmegrandma.power.hookmanager.PlaceholderApi;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.model.HookManager;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class Power extends SimplePlugin {

	@Override
	protected void onPluginStart() {

		Database.getInstance().connect("jdbc:sqlite:" + FileUtil.getOrMakeFile("database.sqlite").getAbsolutePath());

		Common.setLogPrefix("[Power]");

	}

	@Override
	protected void onReloadablesStart() {

		PowerShopCauldronFile.onEnable();

		if (HookManager.isPlaceholderAPILoaded()) {

			PlaceholderApi.loadPapi();
			Common.log("Enabled support for PlaceholderAPI.");

		} else
			Common.log("Disabling support for PlaceholderAPI. Please download PlaceholderAPI here https://www.spigotmc.org/resources/placeholderapi.6245/");
	}

	public static Power getInstance() {
		return (Power) SimplePlugin.getInstance();
	}
}
