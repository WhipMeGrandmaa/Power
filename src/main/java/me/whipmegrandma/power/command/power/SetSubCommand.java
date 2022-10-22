package me.whipmegrandma.power.command.power;

import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public final class SetSubCommand extends SimpleSubCommand {

	protected SetSubCommand(SimpleCommandGroup parent) {
		super(parent, "set");

		this.setPermission("power.command.set");
		this.setUsage("<username> <amount>");
		this.setMinArguments(2);
	}

	@Override
	protected void onCommand() {

		CommandSender sender = getSender();

		Player receiver = findPlayer(args[0]);
		int power = findNumber(1, "The amount must be a positive whole number!");

		checkBoolean(power < 0 ? false : true, "The amount must be a positive whole number!");

		PowerManager.set(receiver, power);

		Common.tell(receiver, "Your power has been set to: " + power + " power.");

		if (!sender.equals(receiver))
			Common.tell(sender, "You have set the power of " + receiver.getName() + " to: " + power);
	}
}
