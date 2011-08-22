package de.noonex.moddropplugin.commands;

import java.util.Map;

import de.noonex.moddropplugin.ModDropPlugin;

public class HelpCommand extends AbstractCommand
{
	private Map<String, AbstractCommand> commands;
	CommandHandler commandHandler;
	
	public HelpCommand()
	{
		super("help", "man");
		commandHandler = CommandHandler.getInstance();
		commands = commandHandler.GetCommands();
	}

	@Override
	public String ExecuteCommand(ModDropPlugin plugin)
	{
		return this.GetHelp();
	}

	@Override
	public String ExecuteCommand(ModDropPlugin plugin, String... parameters)
	{
		if(parameters.length > 2)
		{
			String errorString = "[ModDrop: Help] Only one parameter is accepted.";
			return errorString;
		}
		
		String command = parameters[1];
		
		if(!commandHandler.HasCommand(command))
		{
			String errorString = String.format("[ModDrop: Help] Unknown command: %s.", command);
			return errorString;
		}
		
		return commands.get(command).GetHelp();
	}
	
	public String GetHelp()
	{
		return "This command shows the help of other commands. Calling without parameters shows this text.";
	}
	
	public String GetUsage()
	{
		return "Usage: help [command name]";
	}

	public String GetDescription()
	{
		return this.GetHelp();
	}
}
