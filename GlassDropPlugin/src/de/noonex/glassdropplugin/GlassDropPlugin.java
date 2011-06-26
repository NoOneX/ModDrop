package de.noonex.glassdropplugin;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GlassDropPlugin extends JavaPlugin
{
	private Logger log = null;
	private PluginManager pm;
	ConfigurationManager configManager;
	private Server server;
	
	Boolean dropglass;
	
	private GlassDropPluginListener stpBlockListener;

	@Override
	public void onDisable()
	{
		configManager.SaveConfiguration();
		log.info("GlassDropPlugin disabled.");
	}

	@Override
	public void onEnable()
	{
		PluginDescriptionFile description = getDescription();
		log = getServer().getLogger();
		dropglass = false;
		server = getServer();
		
		configManager = new ConfigurationManager(getConfiguration());
		
		stpBlockListener = new GlassDropPluginListener(log, dropglass, configManager.getDropList());
		dropglass = configManager.getDropglass();
		stpBlockListener.setDropGlass(dropglass);
		
		pm = server.getPluginManager();
		pm.registerEvent(Type.BLOCK_BREAK, stpBlockListener, Event.Priority.Lowest, this);
		
		log.info(String.format("GlassDropPlugin (v.%s) by NoOneX enabled.", description.getVersion()));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(!cmd.getName().equalsIgnoreCase("glassdrop") && !cmd.getName().equalsIgnoreCase("refreshglassdrop"))
		{
			return false;
		}
		
		if(!(sender instanceof Player))
		{
			return true;
		}
		
		Player player = (Player) sender;
		
		if(!player.isOp())
		{
			player.sendMessage(ChatColor.RED + "Sie haben nicht genügend Rechte diesen Befehl zu nutzen.");
			return true;
		}
		
		//TODO: Provisorisch
		if(cmd.getName().equalsIgnoreCase("refreshglassdrop"))
		{
			this.configManager.LoadConfiguration();
			stpBlockListener.RefreshDroplist(this.configManager.getDropList());
			return true;
		}
		
		String playerName = player.getName();
		String state, message, servermessage;
		
		dropglass = !dropglass;
		state = dropglass ? "an" : "aus";
		stpBlockListener.setDropGlass(dropglass);
		configManager.setDropglass(dropglass);
		
		//TODO: Braucht ein einzelner Spieler diese Nachricht überhaupt?
		message = String.format("%sGlassDrop ist nun %s%s%s.", ChatColor.GOLD, ChatColor.AQUA, state, ChatColor.GOLD);
		player.sendMessage(message);
		
		servermessage = String.format("%sGlassDrop ist nun %s%s%s (geändert durch %s).", ChatColor.GOLD, ChatColor.AQUA, state, ChatColor.GOLD, playerName);
		getServer().broadcastMessage(servermessage);
		
		//player.sendMessage(ChatColor.GOLD + "GlassDrop ist nun " + ChatColor.AQUA + "aus" + ChatColor.GOLD + ".");
		
		return true;
	}
}
