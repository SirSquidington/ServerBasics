package me.mrsquid.main;

import java.util.logging.Logger;

import me.mrsquid.commands.CommandFeed;
import me.mrsquid.commands.CommandGameMode;
import me.mrsquid.commands.CommandHeal;
import me.mrsquid.commands.CommandIgnite;
import me.mrsquid.commands.CommandPing;
import me.mrsquid.commands.CommandSudo;
import me.mrsquid.commands.CommandVersion;
import me.mrsquid.commands.CommandWhoIs;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public final Logger log = Logger.getLogger("Minecraft");
	public final PluginDescriptionFile pdf = this.getDescription();
	
	
	public void onEnable() {
		log.info("[" + pdf.getName() + "]" + "is now enabled");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getCommand("ping").setExecutor(new CommandPing(this));
		getCommand("heal").setExecutor(new CommandHeal(this));
		getCommand("feed").setExecutor(new CommandFeed(this));
		getCommand("gm").setExecutor(new CommandGameMode(this));
		getCommand("sudo").setExecutor(new CommandSudo(this));
		getCommand("whois").setExecutor(new CommandWhoIs(this));
		getCommand("ignite").setExecutor(new CommandIgnite(this));
		getCommand("version").setExecutor(new CommandVersion(this));
	}
	
	public void onDisable() {
		log.info("[" + pdf.getName() + "]" + "is now disabled");
	}
	
}
