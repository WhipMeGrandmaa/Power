package me.whipmegrandma.power.menu;

import me.whipmegrandma.power.file.BuyPriceFile;
import me.whipmegrandma.power.manager.PowerManager;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.ItemUtil;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyMenu extends Menu {
	@Position(10)
	private final Button lives;

	@Position(11)
	private final Button drill;

	@Position(12)
	private final Button haste;

	@Position(13)
	private final Button speed;

	@Position(14)
	private final Button antiHunger;

	@Position(15)
	private final Button randomEnchant;

	@Position(16)
	private final Button netheriteIngot;

	@Position(19)
	private final Button storeCredits;

	@Position(20)
	private final Button regularEco;

	@Position(21)
	private final Button elytra;

	@Position(22)
	private final Button shulkerBox;

	@Position(23)
	private final Button villagerEgg;

	@Position(24)
	private final Button randomSpawner;

	@Position(25)
	private final Button voteKeys;

	public BuyMenu() {
		this.setSize(36);

		this.setTitle("&ePower Buy Shop");

		this.lives = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_GOLDEN_APPLE, "&dLives", "&fPower per 1: &e1" + BuyPriceFile.lives, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.lives, ItemCreator.of(CompMaterial.ENCHANTED_GOLDEN_APPLE).make(), this);
				});

		this.drill = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dDrill Enchant", "&fPower per 1: &e" + BuyPriceFile.drill, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.drill, ItemCreator.of(CompMaterial.ENCHANTED_BOOK).make(), this);
				});

		this.haste = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dDrill Enchant", "&fPower per 1: &e" + BuyPriceFile.haste, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.haste, ItemCreator.of(CompMaterial.ENCHANTED_BOOK).make(), this);
				});

		this.speed = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dSpeed Enchant", "&fPower per 1: &e" + BuyPriceFile.speed, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.speed, ItemCreator.of(CompMaterial.ENCHANTED_BOOK).make(), this);
				});

		this.antiHunger = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dAnti-Hunger Enchant", "&fPower per 1: &e" + BuyPriceFile.antiHunger, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.antiHunger, ItemCreator.of(CompMaterial.ENCHANTED_BOOK).make(), this);
				});

		this.randomEnchant = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dRandom Vanilla Enchant", "&fPower per 1: &e" + BuyPriceFile.randomEnchant, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.randomEnchant, ItemCreator.of(CompMaterial.ENCHANTED_BOOK).make(), this);
				});

		this.netheriteIngot = Button.makeSimple(ItemCreator.of(CompMaterial.NETHERITE_INGOT, "&dNetherite Ingot", "&fPower per 1: &e" + BuyPriceFile.netheriteIngot, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.netheriteIngot, ItemCreator.of(CompMaterial.NETHERITE_INGOT).make(), this);
				});

		this.storeCredits = Button.makeSimple(ItemCreator.of(CompMaterial.DIAMOND, "&dStore Credits", "&fPower per 1: &e" + BuyPriceFile.storeCredits, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.storeCredits, ItemCreator.of(CompMaterial.DIRT).make(), this);
				});

		this.regularEco = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dRegular Eco", "&fPower per 1: &e" + BuyPriceFile.regularEco, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.regularEco, ItemCreator.of(CompMaterial.EMERALD).make(), this);
				});

		this.elytra = Button.makeSimple(ItemCreator.of(CompMaterial.ELYTRA, "&dElytra", "&fPower per 1: &e" + BuyPriceFile.elytra, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.elytra, ItemCreator.of(CompMaterial.ELYTRA).make(), this);
				});

		this.shulkerBox = Button.makeSimple(ItemCreator.of(CompMaterial.SHULKER_BOX, "&dShulker Box", "&fPower per 1: &e" + BuyPriceFile.shulkerBox, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.shulkerBox, ItemCreator.of(CompMaterial.SHULKER_BOX).make(), this);
				});

		this.villagerEgg = Button.makeSimple(ItemCreator.of(CompMaterial.VILLAGER_SPAWN_EGG, "&dVillager Spawn Egg", "&fPower per 1: &e" + BuyPriceFile.villagerEgg, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.villagerEgg, ItemCreator.of(CompMaterial.VILLAGER_SPAWN_EGG).make(), this);
				});

		this.randomSpawner = Button.makeSimple(ItemCreator.of(CompMaterial.SPAWNER, "&dRandom Spawner", "&fPower per 1: &e" + BuyPriceFile.randomSpawner, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.randomSpawner, randomEntity(), this);
				});

		this.voteKeys = Button.makeSimple(ItemCreator.of(CompMaterial.ENCHANTED_BOOK, "&dVote Key", "&fPower per 1: &e" + BuyPriceFile.voteKeys, "", "&f&nClick to purchase 1."),
				player -> {
					PowerManager.buy(player, BuyPriceFile.voteKeys, ItemCreator.of(CompMaterial.TRIPWIRE_HOOK).glow(true).make(), this);
				});
	}

	private ItemStack randomEntity() {

		EntityType type = randomMob();

		ItemStack spawner = ItemCreator.of(CompMaterial.SPAWNER).make();
		BlockStateMeta meta = (BlockStateMeta) spawner.getItemMeta();
		meta.setDisplayName(Common.colorize("&f" + ItemUtil.bountifyCapitalized(type.name()) + " Spawner"));
		CreatureSpawner creatureSpawner = (CreatureSpawner) meta.getBlockState();
		creatureSpawner.setSpawnedType(type);

		meta.setBlockState(creatureSpawner);
		spawner.setItemMeta(meta);

		return spawner;
	}

	private EntityType randomMob() {

		Random random = new Random();
		List<EntityType> list = new ArrayList<>();

		for (EntityType type : EntityType.values())
			if (type.isAlive() && type.isSpawnable())
				list.add(type);

		int number = random.nextInt(list.size());

		EntityType randomType = list.get(number);

		return randomType;
	}

}
