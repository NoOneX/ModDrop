package de.noonex.moddropplugin.commands;

import java.util.Map;

import de.noonex.moddropplugin.ModDropPlugin;

public class ListCommand extends AbstractCommand
{	
	private Map<String, AbstractCommand> commands;
	
	public ListCommand()
	{
		super("list", "commands");
		this.commands = CommandHandler.getInstance().GetCommands();
	}

	@Override
	public String ExecuteCommand(ModDropPlugin plugin)
	{
		String commandList = "";
		
		for(AbstractCommand command: commands.values())
		{
			commandList += String.format("%s: %s%s", command.GetName(), command.GetDescription(), System.getProperty("line.separator"));
		}
		
		return commandList;
	}

	@Override
	public String ExecuteCommand(ModDropPlugin plugin, String... parameters)
	{
		return this.ExecuteCommand(plugin);
	}
}
