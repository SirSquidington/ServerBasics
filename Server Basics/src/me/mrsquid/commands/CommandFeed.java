package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandFeed(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player)sender;
		
		if(commandLabel.equalsIgnoreCase("feed"));
			if(sender.hasPermission("basics.command.feed.self") || sender.isOp()) {
				if(args.length == 0) {
					player.setExhaustion(20);
					player.sendMessage(ChatColor.GREEN + "You're hunger has been filled");
				}else {
					sender.sendMessage(ChatColor.RED + "Too few or too many arguments");
				}
			}
			
			if(sender.hasPermission("basics.command.feed.other") || sender.isOp()) {
				if(args.length == 1) {
					Player tplayer = player.getServer().getPlayer(args[0]);
					tplayer.setExhaustion(20);
					tplayer.sendMessage(ChatColor.GREEN + "You're hunger has been filled by " + sender);
					player.sendMessage(ChatColor.GREEN + "You have healed " + tplayer + "'s hunger bar");
				}else {
					sender.sendMessage(ChatColor.RED + "Too few or too many arguments");
				}
			}
			
		return false;
	}
	
}
