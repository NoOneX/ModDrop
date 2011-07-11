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
		PluginHookManager.getInstance().setPlugin(this);
		
		stpBlockListener = new ModDropPluginBlockListener(log, moddrop, configManager.getDropList());
		moddrop = configManager.getModDrop();
		stpBlockListener.setDropGlass(moddrop);
		
		pm = server.getPluginManager();
		pm.registerEvent(Type.BLOCK_BREAK, stpBlockListener, Event.Priority.Lowest, this);
		pm.registerEvent(Type.PLUGIN_ENABLE, PluginHookManager.getInstance(), Event.Priority.Monitor, this);
		pm.registerEvent(Type.PLUGIN_DISABLE, PluginHookManager.getInstance(), Event.Priority.Monitor, this);
		
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
			player.sendMessage(ChatColor.RED + "You have not the necessary rights to use this command.");
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
		String state, servermessage;
		
		moddrop = !moddrop;
		state = moddrop ? "enabled" : "disabled";
		stpBlockListener.setDropGlass(moddrop);
		configManager.setModDrop(moddrop);
		
		servermessage = String.format("%sModDrop is %s%s%s (changed by %s).", ChatColor.GOLD, ChatColor.AQUA, state, ChatColor.GOLD, playerName);
		getServer().broadcastMessage(servermessage);
		
		return true;
	}
}
