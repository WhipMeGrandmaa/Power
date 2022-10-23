package me.whipmegrandma.power.listener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.whipmegrandma.power.database.Database;
import me.whipmegrandma.power.file.PowerShopCauldronFile;
import me.whipmegrandma.power.manager.PowerManager;
import me.whipmegrandma.power.menu.BuyMenu;
import me.whipmegrandma.power.menu.SellMenu;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.remain.CompMetadata;
import org.mineacademy.fo.remain.CompParticle;
import org.mineacademy.fo.remain.CompSound;
import org.mineacademy.fo.remain.Remain;

@AutoRegister
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PlayerListener implements Listener {

	@Getter
	private static final PlayerListener instance = new PlayerListener();

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		Database.getInstance().loadCache(player, loadedCache -> PowerManager.join(player, loadedCache));

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		Database.getInstance().saveCache(player, loadedCache -> PowerManager.quit(player));
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItemInHand();
		Location location = event.getBlock().getLocation();

		String data = CompMetadata.getMetadata(item, "Power");

		if (!"Shop".equals(data))
			return;

		PowerShopCauldronFile.getInstance().add(location);

		CompParticle.FLASH.spawn(location);
		CompSound.ENTITY_ZOMBIE_VILLAGER_CURE.play(location);
		Remain.sendTitle(player, "Successfully &aplaced &fa", "power shop cauldron!");
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Location location = block.getLocation();

		if (!PowerShopCauldronFile.getInstance().has(location))
			return;

		PowerShopCauldronFile.getInstance().remove(location);

		CompParticle.FLASH.spawn(location);
		CompSound.ENTITY_ZOMBIE_VILLAGER_CURE.play(location);
		Remain.sendTitle(player, "Successfully &cremoved &fa", "power shop cauldron!");
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		if (!Remain.isInteractEventPrimaryHand(event))
			return;

		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		Action action = event.getAction();

		if (block == null || player.getGameMode() == GameMode.CREATIVE)
			return;

		Location location = block.getLocation();

		if (!PowerShopCauldronFile.getInstance().has(location))
			return;

		if (action == Action.LEFT_CLICK_BLOCK)
			new BuyMenu().displayTo(player);

		if (action == Action.RIGHT_CLICK_BLOCK)
			new SellMenu(player).displayTo(player);

	}
}
