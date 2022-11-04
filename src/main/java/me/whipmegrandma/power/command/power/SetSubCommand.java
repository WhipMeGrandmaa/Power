package me.whipmegrandma.power.command.power;

import me.whipmegrandma.power.database.Database;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

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
		String receiver = args[0];

		int power = findNumber(1, "The amount must be a number!");

		checkBoolean(power < 0 ? false : true, "The amount must be a positive whole number!");

		Database.getInstance().setPower(receiver, power, name -> {
			if (!sender.getName().equals(receiver))
				Common.tell(sender, "The power of " + name + " has been set to " + power + ".");
		});

		if (Bukkit.getPlayer(receiver) == null)
			return;

		Player receiverPlayer = findPlayer(args[0]);

		Common.tell(receiverPlayer, "Your power has been set to " + power + ".");
	}

	@Override
	protected List<String> tabComplete() {
		return args.length == 1 ? completeLastWordPlayerNames() : NO_COMPLETE;
	}
}
