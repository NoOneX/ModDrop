package de.noonex.moddropplugin.commands;

import java.util.Map;

import de.noonex.moddropplugin.ModDropPlugin;

public class UsageCommand extends AbstractCommand
{
	private Map<String, AbstractCommand> commands;
	CommandHandler commandHandler;
	
	public UsageCommand()
	{
		super("usage");
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
			String errorString = String.format("[ModDrop: Usage] Unknown command: %s.", command);
			return errorString;
		}
		
		return commands.get(command).GetUsage();
	}
	
	public String GetHelp()
	{
		return "This command shows the usage information of other commands. Calling without parameters shows this text.";
	}
	
	public String GetUsage()
	{
		return "Usage: usage [command name]";
	}

	public String GetDescription()
	{
		return this.GetHelp();
	}
}
