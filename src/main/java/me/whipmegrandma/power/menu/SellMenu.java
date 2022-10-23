package me.whipmegrandma.power.menu;

import me.whipmegrandma.power.file.SellPriceFile;
import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.entity.Player;
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

	@Position(49)
	private final Button balance;

	public SellMenu(Player person) {
		this.setSize(54);

		this.setTitle("&ePower Sell");

		this.spiderEye = Button.makeSimple(ItemCreator.of(CompMaterial.SPIDER_EYE, "&dSpider Eye", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.spiderEye, CompMaterial.SPIDER_EYE, this);
				});

		this.netherWart = Button.makeSimple(ItemCreator.of(CompMaterial.NETHER_WART, "&dNether Wart", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.netherWart, CompMaterial.NETHER_WART, this);
				});

		this.amethyst = Button.makeSimple(ItemCreator.of(CompMaterial.AMETHYST_SHARD, "&dAmethyst", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.amethyst, CompMaterial.AMETHYST_SHARD, this);
				});

		this.rottenFlesh = Button.makeSimple(ItemCreator.of(CompMaterial.ROTTEN_FLESH, "&dRotten Flesh", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.rottenFlesh, CompMaterial.ROTTEN_FLESH, this);
				});

		this.lives = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_GOLDEN_APPLE, "&dLives", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.lives, CompMaterial.ENCHANTED_GOLDEN_APPLE, this);
				});

		this.mobFragments = Button.makeSimple(ItemCreator.of(CompMaterial.PHANTOM_MEMBRANE, "&dMob Fragments", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.mobFragments, CompMaterial.PHANTOM_MEMBRANE, this);
				});

		this.magmaCream = Button.makeSimple(ItemCreator.of(CompMaterial.MAGMA_CREAM, "&dMagma Cream", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.magmaCream, CompMaterial.MAGMA_CREAM, this);
				});

		this.blazeRod = Button.makeSimple(ItemCreator.of(CompMaterial.BLAZE_ROD, "&dBlaze Rod", "&fPower per 1: &e1", "", "&f&nClick to sell all."),
				player -> {
					PowerManager.sell(player, SellPriceFile.blazeRod, CompMaterial.BLAZE_ROD, this);
					this.restartMenu();
				});

		this.balance = Button.makeSimple(ItemCreator.of(CompMaterial.PLAYER_HEAD, "&fPower Balance: &e" + PowerManager.balance(person))
				.skullUrl("https://textures.minecraft.net/texture/df323ec6d848c24950fc7aa51b6caca05a22fd7068d12504dbb97213f1f20980"), player -> {
		});

	}

}
