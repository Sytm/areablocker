package de.sytm.areablocker.util;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.World;

public class Region {

	private int minX, minY, minZ, maxX, maxY, maxZ;
	private World world;

	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMinZ() {
		return minZ;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getMaxZ() {
		return maxZ;
	}

	public World getWorld() {
		return world;
	}

	public Location getUpperCorner() {
		return new Location(world, maxX, maxY, maxZ);
	}

	public Location getLowerCorner() {
		return new Location(world, minX, minY, minZ);
	}

	public Region(Location pos1, Location pos2) {
		if (pos1.getWorld() != pos2.getWorld())
			throw new IllegalArgumentException("Both Locations must be in the same world!");
		world = pos1.getWorld();
		minX = Math.min(pos1.getBlockX(), pos2.getBlockX());
		minY = Math.min(pos1.getBlockY(), pos2.getBlockY());
		minZ = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
		maxX = Math.max(pos1.getBlockX(), pos2.getBlockX());
		maxY = Math.max(pos1.getBlockY(), pos2.getBlockY());
		maxZ = Math.max(pos1.getBlockZ(), pos2.getBlockZ());
	}

	public boolean isIn(Location loc) {
		loc = loc.getBlock().getLocation();
		if (loc.getWorld() == world) {
			if (loc.getX() >= minX && loc.getX() <= maxX) {
				if (loc.getY() >= minY && loc.getY() <= maxY) {
					if (loc.getZ() >= minZ && loc.getZ() <= maxZ) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("minX", minX);
		map.put("maxX", maxX);
		map.put("minY", minY);
		map.put("maxY", maxY);
		map.put("minZ", minZ);
		map.put("maxZ", maxZ);
		map.put("world", world.getName());
		return map;
	}
	
	public void print() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("minX", minX);
		map.put("maxX", maxX);
		map.put("minY", minY);
		map.put("maxY", maxY);
		map.put("minZ", minZ);
		map.put("maxZ", maxZ);
		map.put("world", world.getName());
		map.forEach((k, v) -> System.out.println(k + " -> " + v));
	}
}