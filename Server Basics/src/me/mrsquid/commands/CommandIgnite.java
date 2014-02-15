package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandIgnite extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandIgnite(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player)sender;
		if(commandLabel.equalsIgnoreCase("ignite")) {
			if(sender.hasPermission("basics.command.ignite.self")) {
				if(args.length == 1) {
					sender.sendMessage(ChatColor.GREEN + "You have been ignited!");
					player.setFireTicks(Integer.parseInt(args[0]) * 20);
				}
			}
			if(sender.hasPermission("basics.command.ignite.other")) {
				if(args.length == 2) {
					Player tplayer = player.getServer().getPlayer(args[1]);
					tplayer.setFireTicks(Integer.parseInt(args[0]) * 20);
					sender.sendMessage(ChatColor.GREEN + "You have ignited " + tplayer);
					tplayer.sendMessage(ChatColor.GREEN + "You have been ignited by " + sender);
				}
			}
		}
		
		return false;
	}
	
}
