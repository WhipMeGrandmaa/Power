package me.whipmegrandma.power.menu;

import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;

@Setter
public class PowerTopMenu extends Menu {
	private ItemStack first;
	private ItemStack second;
	private ItemStack third;
	private ItemStack fourth;
	private ItemStack fifth;

	public PowerTopMenu() {
		this.setSize(45);

		this.setTitle("&ePower Leaderboard");
	}

	@Override
	public ItemStack getItemAt(int slot) {

		if (slot == 13)
			return this.first;

		if (slot == 21)
			return this.second;

		if (slot == 23)
			return this.third;

		if (slot == 29)
			return this.fourth;

		if (slot == 33)
			return this.fifth;

		return null;


	}

}
