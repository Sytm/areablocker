package de.sytm.areablocker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.sytm.areablocker.util.AreaRestriction;
import de.sytm.areablocker.util.RestrictionManager;

public class ListCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("areablocker")) {
			sender.sendMessage("§aAll Restrictions (The ids)");
			for (AreaRestriction restr : RestrictionManager.restrictions()) {
				sender.sendMessage("§a > " + restr.getID());
			}
		}
		return false;
	}
}
