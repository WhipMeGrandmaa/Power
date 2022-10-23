package me.whipmegrandma.power.command.power;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public final class EditSubCommand extends SimpleSubCommand {

	protected EditSubCommand(SimpleCommandGroup parent) {
		super(parent, "edit");

		this.setPermission("power.command.edit");
	}

	@Override
	protected void onCommand() {

		checkConsole();

		Player player = getPlayer();

		ItemStack cauldron = ItemCreator.of(CompMaterial.CAULDRON, "&9Power Shop Menu", "", "PLACE ME").tag("Power", "Shop").glow(true).make();

		player.getInventory().addItem(cauldron);
		Common.tell(player, "Given a power cauldron. Place this down wherever you want a shop.");
	}
}
