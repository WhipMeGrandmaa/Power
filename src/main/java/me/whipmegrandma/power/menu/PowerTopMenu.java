package me.whipmegrandma.power.menu;

import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

@Setter
public class PowerTopMenu extends Menu {
	private ItemStack first = ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#1").make();
	private ItemStack second = ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#2").make();
	private ItemStack third = ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#3").make();
	private ItemStack fourth = ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#4").make();
	private ItemStack fifth = ItemCreator.of(CompMaterial.PLAYER_HEAD, "&6#5").make();

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
