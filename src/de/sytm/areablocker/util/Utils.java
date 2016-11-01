package de.sytm.areablocker.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Utils {

	public static void push(Player player, Location from, Location to) {
		player.teleport(from);
		Vector vec = from.toVector().subtract(to.toVector());
		vec = vec.normalize().multiply(0.8).setY(0.3);
		player.setVelocity(vec);
	}
}
