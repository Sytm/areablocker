package de.sytm.areablocker.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MarkerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("areablocker.setup")) {
				ItemStack stack = new ItemStack(Material.GOLD_AXE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("§6Marker-Tool");
				stack.setItemMeta(meta);
				player.getInventory().addItem(stack);
			}
		} else {
			sender.sendMessage("§cYou have to be a player to execute this command!");
		}
		return false;
	}
}
