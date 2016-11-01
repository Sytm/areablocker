package de.sytm.areablocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.sytm.areablocker.commands.CreateCommand;
import de.sytm.areablocker.commands.ListCommand;
import de.sytm.areablocker.commands.MarkerCommand;
import de.sytm.areablocker.commands.Pos1Command;
import de.sytm.areablocker.commands.Pos2Command;
import de.sytm.areablocker.commands.RemoveCommand;
import de.sytm.areablocker.listener.MarkerListener;
import de.sytm.areablocker.listener.MoveListener;
import de.sytm.areablocker.util.ConfigManager;

public class AreaBlocker extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("abcreate").setExecutor(new CreateCommand());
		getCommand("abremove").setExecutor(new RemoveCommand());
		getCommand("ablist").setExecutor(new ListCommand());
		getCommand("abmarker").setExecutor(new MarkerCommand());
		getCommand("abpos1").setExecutor(new Pos1Command());
		getCommand("abpos2").setExecutor(new Pos2Command());

		Bukkit.getPluginManager().registerEvents(new MarkerListener(), this);
		Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
		
		ConfigManager.load();
	}
	
	@Override
	public void onDisable() {
		ConfigManager.save();
	}
}
