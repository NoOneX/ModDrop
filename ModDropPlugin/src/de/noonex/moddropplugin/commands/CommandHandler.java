package de.noonex.moddropplugin.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler
{
	// singleton stuff
	private CommandHandler _instance = new CommandHandler();

	private CommandHandler()
	{
		commands = new HashMap<String, AbstractCommand>();
	}

	public CommandHandler getInstance()
	{
		return _instance;
	}

	// commands
	private Map<String, AbstractCommand> commands;

	public void AddCommand(String name, AbstractCommand command)
	{
		if (commands.containsKey(name))
		{
			String errorMessage = String.format("The command %s is already added.", name);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void AddCommand(String name, AbstractCommand command, String... aliases)
	{
		try
		{
			this.AddCommand(name, command);
		}
		catch (IllegalArgumentException ex)
		{
			ex.printStackTrace();
			throw ex;
		}

		for (String alias : aliases)
		{
			this.AddCommand(alias, command);
		}
	}
}
