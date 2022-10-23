package me.whipmegrandma.power.file;

import org.mineacademy.fo.settings.YamlStaticConfig;

public class BuyPriceFile extends YamlStaticConfig {

	//public static Integer lives;
	//public static Integer drill;
	//public static Integer haste;
	//public static Integer speed;
	//public static Integer antiHunger;
	public static Integer randomEnchant;
	public static Integer netheriteIngot;
	//public static Integer storeCredits;
	//public static Integer regularEco;
	public static Integer elytra;
	public static Integer shulkerBox;
	public static Integer villagerEgg;
	public static Integer randomSpawner;
	//public static Integer voteKeys;

	@Override
	protected void onLoad() throws Exception {
		setPathPrefix("Buy");
		this.loadConfiguration("settings.yml");
	}

	private static void init() {

		//lives = getInteger("Lives");
		//drill = getInteger("Drill_Enchant");
		//haste = getInteger("Haste_Enchant");
		//speed = getInteger("Speed_Enchant");
		//antiHunger = getInteger("Anti_Hunger_Enchant");
		randomEnchant = getInteger("Random_Vanilla_Enchant");
		netheriteIngot = getInteger("Netherite_Ingot");
		//storeCredits = getInteger("Store_Credits");
		//regularEco = getInteger("Regular_Eco_Transfer");
		elytra = getInteger("Elytra");
		shulkerBox = getInteger("Shulker_Box");
		villagerEgg = getInteger("Villager_Egg");
		randomSpawner = getInteger("Random_Spawner");
		//voteKeys = getInteger("Vote_Keys");

	}

}
