package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandVersion extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandVersion(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("version")) {
			sender.sendMessage(ChatColor.GREEN + "Version: " + plugin.pdf.getVersion());
		}
		
		return false;
	}

}
