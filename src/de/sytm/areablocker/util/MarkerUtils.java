package de.sytm.areablocker.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MarkerUtils {

	private static Map<UUID, Location> pos1 = new HashMap<UUID, Location>();
	private static Map<UUID, Location> pos2 = new HashMap<UUID, Location>();

	public static void setPos1(Player player) {
		setPos1(player, player.getLocation());
	}

	public static void setPos2(Player player) {
		setPos2(player, player.getLocation());
	}

	public static void setPos1(Player player, Location location) {
		pos1.put(player.getUniqueId(), location);
		player.sendMessage("§aPosition 1 set!");
	}

	public static void setPos2(Player player, Location location) {
		pos2.put(player.getUniqueId(), location);
		player.sendMessage("§aPosition 2 set!");
	}

	public static Location getPos1(Player player) {
		return pos1.get(player.getUniqueId());
	}

	public static Location getPos2(Player player) {
		return pos2.get(player.getUniqueId());
	}

	public static boolean isPos1Set(Player player) {
		return pos1.containsKey(player.getUniqueId());
	}

	public static boolean isPos2Set(Player player) {
		return pos2.containsKey(player.getUniqueId());
	}
}
