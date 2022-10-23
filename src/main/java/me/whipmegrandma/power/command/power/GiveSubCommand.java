package me.whipmegrandma.power.command.power;

import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class GiveSubCommand extends SimpleSubCommand {

	protected GiveSubCommand(SimpleCommandGroup parent) {
		super(parent, "give");

		this.setPermission("power.command.give");
		this.setUsage("<username> <amount>");
		this.setMinArguments(2);
	}

	@Override
	protected void onCommand() {

		CommandSender sender = getSender();

		Player receiver = findPlayer(args[0]);
		int power = findNumber(1, "The amount must be a number!");

		checkBoolean(power < 0 ? false : true, "The amount must be a positive whole number!");

		PowerManager.give(receiver, power);

		Common.tell(receiver, power + " power has been given to you.");

		if (!sender.equals(receiver))
			Common.tell(sender, power + " power has been given to " + receiver.getName());
	}

	@Override
	protected List<String> tabComplete() {
		return args.length == 1 ? completeLastWordPlayerNames() : NO_COMPLETE;
	}
}
