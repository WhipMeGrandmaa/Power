package me.whipmegrandma.power.menu;

import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class SellMenu extends Menu {

	@Position(10)
	private final Button spiderEye;

	@Position(12)
	private final Button netherWart;

	@Position(14)
	private final Button amethyst;

	@Position(16)
	private final Button rottenFlesh;

	@Position(28)
	private final Button lives;

	@Position(30)
	private final Button mobFragments;

	@Position(32)
	private final Button magmaCream;

	@Position(34)
	private final Button blazeRod;

	public SellMenu() {
		this.setSize(45);

		this.setTitle("&ePower Sell");

		this.spiderEye = Button.makeSimple(ItemCreator.of(CompMaterial.SPIDER_EYE, "&dSpider Eye", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.netherWart = Button.makeSimple(ItemCreator.of(CompMaterial.NETHER_WART, "&dNether Wart", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.amethyst = Button.makeSimple(ItemCreator.of(CompMaterial.AMETHYST_SHARD, "&dAmethyst", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.rottenFlesh = Button.makeSimple(ItemCreator.of(CompMaterial.ROTTEN_FLESH, "&dRotten Flesh", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.lives = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_GOLDEN_APPLE, "&dLives", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.mobFragments = Button.makeSimple(ItemCreator.of(CompMaterial.PHANTOM_MEMBRANE, "&dMob Fragments", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.magmaCream = Button.makeSimple(ItemCreator.of(CompMaterial.MAGMA_CREAM, "&dMagma Cream", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});

		this.blazeRod = Button.makeSimple(ItemCreator.of(CompMaterial.BLAZE_ROD, "&dBlaze Rod", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					player.sendMessage("HEY");
				});
	}

}
