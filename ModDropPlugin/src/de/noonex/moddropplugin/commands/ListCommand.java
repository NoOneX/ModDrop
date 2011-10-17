package de.noonex.moddropplugin.commands;

import java.util.Map;

import de.noonex.moddropplugin.ModDropPlugin;

public class ListCommand extends AbstractCommand
{	
	private Map<String, AbstractCommand> commands;
	
	public ListCommand()
	{
		super("list", "noonex.moddrop.usage", "commands");
		this.commands = CommandHandler.getInstance().GetCommands();
	}

	@Override
	protected String ExecuteCommand(ModDropPlugin plugin)
	{
		String commandList = "";
		
		for(AbstractCommand command: commands.values())
		{
			System.out.println(String.format("[ModDrop: List] Command listed: %s", command.GetName()));
			commandList += String.format("%s: %s%s", command.GetName(), command.GetDescription(), System.getProperty("line.separator"));
		}
		
		return commandList;
	}

	@Override
	protected String ExecuteCommand(ModDropPlugin plugin, String... parameters)
	{
		return this.ExecuteCommand(plugin);
	}
}
