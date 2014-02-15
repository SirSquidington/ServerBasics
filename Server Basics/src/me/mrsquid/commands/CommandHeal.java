
package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.apache.logging.log4j.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("unused") //Lol, That irony
public class CommandHeal extends Main implements CommandExecutor {
	
	public Main plugin;
	
	public CommandHeal(Main instance) {
		plugin = instance;
	}
	
	Logger log;
	
	@SuppressWarnings("deprecation")
	public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("heal")) {
			if(sender.hasPermission("basics.command.heal.self")) {
				if(args.length == 0) {
					player.setHealth(20);
					player.sendMessage(ChatColor.GREEN + "You have been healed");
				}else {
					sender.sendMessage(ChatColor.RED + "Not enough arguments");
				}
				if(args.length == 1) {
					if(sender.hasPermission("basics.command.heal.other")) {
						Player tplayer = player.getServer().getPlayer(args[0]);
						tplayer.setHealth(20);
						tplayer.sendMessage(ChatColor.GREEN + "You have been healed by " + sender);
						player.sendMessage(ChatColor.GREEN + "You have healed " + tplayer);
					}
				}else {
					sender.sendMessage(ChatColor.RED + "Too few or too many arguments");
				}
			}
		}
		
		return false;
	}
	
}
