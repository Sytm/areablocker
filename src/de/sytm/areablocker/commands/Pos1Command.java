package de.sytm.areablocker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sytm.areablocker.util.MarkerUtils;

public class Pos1Command implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("areablocker.setup")) {
				MarkerUtils.setPos1(player);
			}
		} else {
			sender.sendMessage("§cYou have to be a player to execute this command!");
		}
		return false;
	}
}
