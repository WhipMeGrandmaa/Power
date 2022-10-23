package me.whipmegrandma.power.command;

import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.manager.PowerManager;
import me.whipmegrandma.power.menu.PowerTopMenu;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.Map;

@AutoRegister
public final class PowerTopCommand extends SimpleCommand {

	public PowerTopCommand() {
		super("powertop|ptop");
	}

	@Override
	protected void onCommand() {

		checkConsole();
		Database.getInstance().pollAllCache(cache -> {
			PowerTopMenu menu = new PowerTopMenu();

			int i = 0;

			for (Map.Entry<String, Integer> map : PowerManager.sortLeaderboard(cache)) {
				i++;

				if (i == 1)
					menu.setFirst(ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#1 " + map.getKey(), "", "&ePower: " + map.getValue()).skullOwner(map.getKey()).make());

				if (i == 2)
					menu.setSecond(ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#2 " + map.getKey(), "", "&ePower: " + map.getValue()).skullOwner(map.getKey()).make());

				if (i == 3)
					menu.setThird(ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#3 " + map.getKey(), "", "&ePower: " + map.getValue()).skullOwner(map.getKey()).make());

				if (i == 4)
					menu.setFourth(ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#4 " + map.getKey(), "", "&ePower: " + map.getValue()).skullOwner(map.getKey()).make());

				if (i == 5) {
					menu.setFifth(ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#5 " + map.getKey(), "", "&ePower: " + map.getValue()).skullOwner(map.getKey()).make());

					break;
				}

			}

			menu.displayTo(getPlayer());

		});

	}

}
