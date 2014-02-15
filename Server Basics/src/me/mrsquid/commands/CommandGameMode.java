package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGameMode extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandGameMode(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player = (Player)sender;
		
		if(commandLabel.equalsIgnoreCase("gm")) {
			if(sender.hasPermission("basics.command.gm.self")) {
				if(args.length == 1){
					
					//checking gamemode
					
					if(args[0] == "1" || args[0].equalsIgnoreCase("creative")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(ChatColor.BLUE + "You're gamemode has been set to Creative");
					}
					
					if(args[0] == "2" || args[0].equalsIgnoreCase("adventure")) {
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(ChatColor.BLUE + "You're gamemode has been set to Adventure");
					}
					
					if(args[0] == "0" || args[0].equalsIgnoreCase("survival")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(ChatColor.BLUE + "You're gamemode has been set to Survival");
					}
					
					
				}else {
					sender.sendMessage(ChatColor.RED + "Too few or too many arguments");
				}
			}
			if(sender.hasPermission("basics.command.gm.other")) {
				if(args.length == 2){
					Player tplayer = player.getServer().getPlayer(args[0]);
					//checking gamemode
					
					if(args[0] == "1" || args[0].equalsIgnoreCase("creative")) {
						tplayer.setGameMode(GameMode.CREATIVE);
						tplayer.sendMessage(ChatColor.BLUE + "You're gamemode has been set to Creative");
					}
					
					if(args[0] == "2" || args[0].equalsIgnoreCase("adventure")) {
						tplayer.setGameMode(GameMode.ADVENTURE);
						tplayer.sendMessage(ChatColor.BLUE + "You're gamemode has been set to Adventure");
					}
					
					if(args[0] == "0" || args[0].equalsIgnoreCase("survival")) {
						tplayer.setGameMode(GameMode.SURVIVAL);
						tplayer.sendMessage(ChatColor.BLUE + "You're gamemode has been set to Survival");
					}
			}else {
				sender.sendMessage(ChatColor.RED + "Too few or too many arguments");
			}
		}
		
		
		}
		
		return false;
	}
	
}
