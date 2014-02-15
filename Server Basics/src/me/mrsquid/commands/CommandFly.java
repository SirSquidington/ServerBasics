package me.mrsquid.commands;

import me.mrsquid.main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly extends Main implements CommandExecutor {
	
	public Main plugin;
	private boolean enabled = false;
	
	public CommandFly(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player)sender;
		if(commandLabel.equalsIgnoreCase("fly")) {
			if(sender.hasPermission("basics.command.fly.self")) {
				if(args.length == 0) {
					final float fall = player.getFallDistance();
					if(enabled) {
						player.setAllowFlight(false);
						player.setFlying(false);
						player.setFallDistance(fall);
					}
					if(!enabled) {
						player.setAllowFlight(true);
						player.setFlying(true);
						player.setFallDistance(0f);
					}
					
				}
			}
		}
		return false;
	}
	
}
