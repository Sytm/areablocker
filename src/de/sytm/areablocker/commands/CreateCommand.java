package de.sytm.areablocker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sytm.areablocker.util.AreaRestriction;
import de.sytm.areablocker.util.MarkerUtils;
import de.sytm.areablocker.util.Region;
import de.sytm.areablocker.util.RestrictionManager;

public class CreateCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("areablocker.setup")) {
				if (MarkerUtils.isPos1Set(player) && MarkerUtils.isPos2Set(player)) {
					if (MarkerUtils.getPos1(player).getWorld() == MarkerUtils.getPos2(player).getWorld()) {
						if (args.length == 2) {
							Region region = new Region(MarkerUtils.getPos1(player), MarkerUtils.getPos2(player));
							String permission = args[0], id = args[1];
							AreaRestriction restr = new AreaRestriction(region, permission, id);
							RestrictionManager.add(restr);
							player.sendMessage("§aThe Restriction was successfully created!");
						} else {
							player.sendMessage("§cSyntax error!");
							player.sendMessage("§c/abcreate <Permission> <ID> (/abcreate lobby.vip vip-area)");
						}
					} else {
						player.sendMessage("§cThe corners have to be in the same world!");
					}
				} else {
					player.sendMessage("§cPlease set the corners first!");
				}
			}
		} else {
			sender.sendMessage("§cYou have to be a player to execute this command!");
		}
		return false;
	}
}
