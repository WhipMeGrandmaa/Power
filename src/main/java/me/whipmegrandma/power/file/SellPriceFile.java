package me.whipmegrandma.power.file;

import org.mineacademy.fo.settings.YamlStaticConfig;

public class SellPriceFile extends YamlStaticConfig {

	public static Integer spiderEye;
	public static Integer netherWart;
	public static Integer amethyst;
	public static Integer rottenFlesh;
	public static Integer lives;
	public static Integer mobFragments;
	public static Integer magmaCream;
	public static Integer blazeRod;

	@Override
	protected void onLoad() throws Exception {
		setPathPrefix("Sell");
		this.loadConfiguration("settings.yml");
		
	}

	private static void init() {

		spiderEye = getInteger("Spider_Eye");
		netherWart = getInteger("Nether_Wart");
		amethyst = getInteger("Amethyst");
		rottenFlesh = getInteger("Rotten_Flesh");
		lives = getInteger("Lives");
		mobFragments = getInteger("Mob_Fragments");
		magmaCream = getInteger("Magma_Cream");
		blazeRod = getInteger("Blaze_Rod");

	}

}
