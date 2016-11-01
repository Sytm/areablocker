package de.sytm.areablocker.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.sytm.areablocker.util.AreaRestriction;
import de.sytm.areablocker.util.RestrictionManager;
import de.sytm.areablocker.util.Utils;

public class MoveListener implements Listener {

	@EventHandler
	public void on(PlayerMoveEvent event) {
		for (AreaRestriction restriction : RestrictionManager.restrictions()) {
			if (restriction.getRegion().isIn(event.getTo())) {
				Player player = event.getPlayer();
				if (!player.hasPermission(restriction.getPermission())) {
					Utils.push(player, event.getFrom(), event.getTo());
					return;
				}
			}
		}
	}
}
