package me.whipmegrandma.power.command.power;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.ReloadCommand;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.model.SimpleComponent;

import java.util.Arrays;
import java.util.List;

@AutoRegister
public final class PowerCommandGroup extends SimpleCommandGroup {

	public PowerCommandGroup() {
		super("power|p");

	}

	@Override
	protected void registerSubcommands() {
		this.registerSubcommand(new GiveSubCommand(this));
		this.registerSubcommand(new SetSubCommand(this));
		this.registerSubcommand(new RemoveSubCommand(this));
		this.registerSubcommand(new BalanceSubCommand(this));
		this.registerSubcommand(new EditSubCommand(this));
		this.registerSubcommand(new ResetSubCommand(this));
		this.registerSubcommand(new ReloadCommand());
	}

	@Override
	protected String[] getHelpHeader() {
		return new String[]{Common.colorize("{prefix} The following commands are available:")};
	}


	@Override
	protected List<SimpleComponent> getNoParamsHeader() {
		return Arrays.asList(SimpleComponent.of("{prefix} Use /power ? to list the commands."));
	}
}
