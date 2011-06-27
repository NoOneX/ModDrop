package de.noonex.moddropplugin;

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

public class ModDropPlugin extends JavaPlugin
{
	private Logger log = null;
	private PluginManager pm;
	ConfigurationManager configManager;
	private Server server;
	
	Boolean moddrop;
	
	private ModDropPluginBlockListener stpBlockListener;

	@Override
	public void onDisable()
	{
		configManager.SaveConfiguration();
		log.info("ModDropPlugin disabled.");
	}

	@Override
	public void onEnable()
	{
		PluginDescriptionFile description = getDescription();
		log = getServer().getLogger();
		moddrop = false;
		server = getServer();
		
		configManager = new ConfigurationManager(getConfiguration());
		
		stpBlockListener = new ModDropPluginBlockListener(log, moddrop, configManager.getDropList());
		moddrop = configManager.getModDrop();
		stpBlockListener.setDropGlass(moddrop);
		
		pm = server.getPluginManager();
		pm.registerEvent(Type.BLOCK_BREAK, stpBlockListener, Event.Priority.Lowest, this);
		
		log.info(String.format("ModDropPlugin (v.%s) by NoOneX enabled.", description.getVersion()));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(!cmd.getName().equalsIgnoreCase("moddrop") && !cmd.getName().equalsIgnoreCase("refreshmoddrop"))
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
		if(cmd.getName().equalsIgnoreCase("refreshmoddrop"))
		{
			this.configManager.LoadConfiguration();
			stpBlockListener.RefreshDroplist(this.configManager.getDropList());
			return true;
		}
		
		String playerName = player.getName();
		String state, message, servermessage;
		
		moddrop = !moddrop;
		state = moddrop ? "an" : "aus";
		stpBlockListener.setDropGlass(moddrop);
		configManager.setModDrop(moddrop);
		
		//TODO: Braucht ein einzelner Spieler diese Nachricht überhaupt?
		message = String.format("%sGlassDrop ist nun %s%s%s.", ChatColor.GOLD, ChatColor.AQUA, state, ChatColor.GOLD);
		player.sendMessage(message);
		
		servermessage = String.format("%sGlassDrop ist nun %s%s%s (geändert durch %s).", ChatColor.GOLD, ChatColor.AQUA, state, ChatColor.GOLD, playerName);
		getServer().broadcastMessage(servermessage);
		
		//player.sendMessage(ChatColor.GOLD + "GlassDrop ist nun " + ChatColor.AQUA + "aus" + ChatColor.GOLD + ".");
		
		return true;
	}
}
