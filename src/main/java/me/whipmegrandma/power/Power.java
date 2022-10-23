package me.whipmegrandma.power;

import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.file.PowerShopCauldronFile;
import org.mineacademy.fo.FileUtil;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class Power extends SimplePlugin {

	@Override
	protected void onPluginStart() {

		Database.getInstance().connect("jdbc:sqlite:" + FileUtil.getOrMakeFile("database.sqlite").getAbsolutePath());

	}

	@Override
	protected void onReloadablesStart() {

		PowerShopCauldronFile.onEnable();

	}

	public static Power getInstance() {
		return (Power) SimplePlugin.getInstance();
	}
}
