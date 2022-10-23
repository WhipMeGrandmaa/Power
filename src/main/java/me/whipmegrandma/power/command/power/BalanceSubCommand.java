package me.whipmegrandma.power.command.power;

import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public final class BalanceSubCommand extends SimpleSubCommand {

	protected BalanceSubCommand(SimpleCommandGroup parent) {
		super(parent, "balance|bal");

		this.setPermission("power.command.balance");
	}

	@Override
	protected void onCommand() {

		Database.getInstance().pollAllCache(cache -> {
			CommandSender sender = getSender();

			if (args.length == 0) {

				checkConsole();

				int balance = PowerManager.balance((Player) sender);

				Common.tell(sender, "Power: " + balance,
						"Leaderboard place: " + PowerManager.leaderboardPosition((Player) sender, cache));

				return;
			}

			Player receiver = findPlayer(args[0]);

			int balance = PowerManager.balance(receiver);

			Common.tell(sender, "Power of " + receiver.getName() + ": " + balance);
		});
	}

	@Override
	protected List<String> tabComplete() {
		return args.length == 1 ? completeLastWordPlayerNames() : NO_COMPLETE;
	}
}
