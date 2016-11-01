package de.sytm.areablocker.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.sytm.areablocker.util.MarkerUtils;

public class MarkerListener implements Listener {

	@EventHandler
	public void on(PlayerInteractEvent event) {
		if (event.getPlayer().hasPermission("areablocker.setup")) {
			if (event.getClickedBlock() != null && event.getItem() != null) {
				if (event.getClickedBlock().getType() != Material.AIR
						&& event.getItem().getType() == Material.GOLD_AXE) {
					if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
						event.setCancelled(true);
						MarkerUtils.setPos1(event.getPlayer(), event.getClickedBlock().getLocation());
					} else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
						event.setCancelled(true);
						MarkerUtils.setPos2(event.getPlayer(), event.getClickedBlock().getLocation());
					}
				}
			}
		}
	}
}
