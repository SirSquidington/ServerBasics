package me.mrsquid.commands;

import java.util.logging.Logger;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPing extends Main implements CommandExecutor {
	
	Logger log;
	
	public Main plugin;
	
	public CommandPing(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player = (Player)sender;
		
		if(commandLabel.equalsIgnoreCase("ping")) {
			player.sendMessage(ChatColor.BLUE + "Pong");
		}
		
		return false;
	}
	
	
	
}
