package de.sytm.areablocker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sytm.areablocker.util.RestrictionManager;

public class RemoveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("areablocker.setup")) {
				if (args.length == 1) {
					if (RestrictionManager.remove(args[0])) {
						player.sendMessage("§aRestriction successfully removed!");
					} else {
						player.sendMessage("§cA Restriction with the id " + args[0] + " doesn't exists!");
					}
				} else {
					player.sendMessage("§cSyntax error!");
					player.sendMessage("§c/abremove <ID> (/abremove vip-area)");
				}
			}
		} else {
			sender.sendMessage("§cYou have to be a player to execute this command!");
		}
		return false;
	}
}
