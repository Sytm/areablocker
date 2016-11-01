package de.sytm.areablocker.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {

	private static final File configFile = new File("plugins/AreaBlocker/restrictions.yml");

	public static void load() {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		if (config.contains("areas")) {
			for (String id : config.getConfigurationSection("areas").getKeys(false)) {
				String permission = config.getString("areas." + id + ".permission");
				String base = "areas." + id + ".region.";
				World world = Bukkit.getWorld(config.getString(base + "world"));
				Region region = new Region(
						new Location(world, config.getDouble(base + "minX"), config.getDouble(base + "minY"),
								config.getDouble(base + "minZ")),
						new Location(world, config.getDouble(base + "maxX"), config.getDouble(base + "maxY"),
								config.getDouble(base + "maxZ")));
				RestrictionManager.add(new AreaRestriction(region, permission, id));
			}
		}
	}

	public static void save() {
		configFile.delete();
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		for (AreaRestriction restriction : RestrictionManager.restrictions()) {
			String base = "areas." + restriction.getID() + ".";
			config.set(base + "permission", restriction.getPermission());
			config.set(base + "region", restriction.getRegion().map());
		}
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
