package de.noonex.moddropplugin;

import java.awt.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.noonex.moddropplugin.commands.CommandHandler;
import de.noonex.moddropplugin.commands.HelpCommand;
import de.noonex.moddropplugin.commands.ListCommand;
import de.noonex.moddropplugin.commands.UsageCommand;

public class ModDropPlugin extends JavaPlugin
{
	private Logger log = null;
	private PluginManager pm;
	private ConfigurationManager configManager;
	private Server server;
	
	private CommandHandler commandHandler;
	
	private Boolean moddrop;
	
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
		
		RegisterCommands();
		
		pm = server.getPluginManager();
		pm.registerEvent(Type.BLOCK_BREAK, stpBlockListener, Event.Priority.Lowest, this);
		pm.registerEvent(Type.PLUGIN_ENABLE, PluginHookManager.getInstance(), Event.Priority.Monitor, this);
		pm.registerEvent(Type.PLUGIN_DISABLE, PluginHookManager.getInstance(), Event.Priority.Monitor, this);
		
		log.info(String.format("ModDropPlugin (v.%s) by NoOneX enabled.", description.getVersion()));
	}
	
	private void RegisterCommands()
	{
		commandHandler = CommandHandler.getInstance();
		new HelpCommand();
		new UsageCommand();
		new ListCommand();		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(!cmd.getName().equalsIgnoreCase("md"))
		{
			return false;
		}
		
		if(!sender.isOp())
		{
			sender.sendMessage(ChatColor.RED + "You have not the necessary rights to use this command.");
			return true;
		}
		
		String commandString = "";
		String senderMessage;
		
		for(String param: args)
		{
			commandString += param + " ";
		}
		
		senderMessage = commandHandler.ProcessCommand(commandString, this);
		
		for(String messagePart: senderMessage.split(System.getProperty("line.separator")))
		{		
			sender.sendMessage(messagePart);
		}
		
		/*if(!player.isOp())
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
		getServer().broadcastMessage(servermessage);*/
		
		return true;
	}
}

