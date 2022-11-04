package me.whipmegrandma.power.command.power;

import me.whipmegrandma.power.database.Database;
import org.bukkit.Bukkit;
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
		String receiver = args[0];

		Database.getInstance().setPower(receiver, 0, name -> {
			if (!sender.getName().equals(receiver))
				Common.tell(sender, "The power of " + name + " has been reset.");
		});

		if (Bukkit.getPlayer(receiver) == null)
			return;

		Player receiverPlayer = findPlayer(args[0]);

		Common.tell(receiverPlayer, "Your power has been reset.");
	}

	@Override
	protected List<String> tabComplete() {
		return args.length == 1 ? completeLastWordPlayerNames() : NO_COMPLETE;
	}
}
