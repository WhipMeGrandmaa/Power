package me.whipmegrandma.power;

import org.mineacademy.fo.plugin.SimplePlugin;

public final class Power extends SimplePlugin {

	@Override
	protected void onPluginStart() {
	}

	@Override
	protected void onReloadablesStart() {

	}

	public static Power getInstance() {
		return (Power) SimplePlugin.getInstance();
	}
}
