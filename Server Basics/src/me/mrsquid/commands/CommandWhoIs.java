package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWhoIs extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandWhoIs(Main instance) {
		plugin = instance;
	}
	//Add more things to display e.g. AFK, Health Level, Gamemode, etc.
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player)sender;
		if(commandLabel.equalsIgnoreCase("whois")) {
			if(sender.hasPermission("basics.command.whois.self")) {
				if(args.length == 0) {
					sender.sendMessage(ChatColor.GRAY + "IP: " + player.getAddress().toString());
					sender.sendMessage(ChatColor.GRAY + "Display Name: " + player.getDisplayName());
					sender.sendMessage(ChatColor.GRAY + "Food Level: " + player.getFoodLevel());
				}else {
					sender.sendMessage(ChatColor.RED + "Too few or too many arguments");
				}
			}
			if(sender.hasPermission("basics.command.whois.other")) {
				if(args.length == 1) {
					sender.sendMessage(ChatColor.GRAY + "IP: " +  player.getAddress().toString());
					sender.sendMessage(ChatColor.GRAY + "Display Name: " + player.getDisplayName());
					sender.sendMessage(ChatColor.GRAY + "Food Level: " + player.getFoodLevel());
				}
			}
			
		}
		
		return false;
	}
	
}
