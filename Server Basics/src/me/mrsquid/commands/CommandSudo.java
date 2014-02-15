package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSudo extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandSudo(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player = (Player)sender;
		
		if(commandLabel.equalsIgnoreCase("sudo")) {
			if(sender.hasPermission("basics.command.sudo")) {
				if(args.length > 1) {
					for(int i = 1; i < args.length; i++) {
						Player tplayer = player.getServer().getPlayer(args[0]);
						tplayer.chat(args[i]);
					}
				}else {
					sender.sendMessage(ChatColor.RED + "Too few many arguments");
				}
			}
			
		}
		
		return false;
	}
	
}
