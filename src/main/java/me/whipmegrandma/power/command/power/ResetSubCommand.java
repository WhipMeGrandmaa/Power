package me.whipmegrandma.power.command.power;

import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class ResetSubCommand extends SimpleSubCommand {

	protected ResetSubCommand(SimpleCommandGroup parent) {
		super(parent, "reset");

		this.setPermission("power.command.reset");
		this.setUsage("<username>");
		this.setMinArguments(1);
	}

	@Override
	protected void onCommand() {

		CommandSender sender = getSender();

		Player receiver = findPlayer(args[0]);

		PowerManager.set(receiver, 0);

		Common.tell(receiver, "Your power has been reset.");

		if (!sender.equals(receiver))
			Common.tell(sender, "You have reset the power of " + receiver.getName() + ".");
	}

	@Override
	protected List<String> tabComplete() {
		return args.length == 1 ? completeLastWordPlayerNames() : NO_COMPLETE;
	}
}
