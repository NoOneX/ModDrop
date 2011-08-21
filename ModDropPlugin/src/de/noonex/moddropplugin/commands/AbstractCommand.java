package de.noonex.moddropplugin.commands;

import de.noonex.moddropplugin.ModDropPlugin;

public abstract class AbstractCommand
{
	String name;
	String[] aliases;
	
	public AbstractCommand(String name, String ...aliases)
	{
		this.name = name;
		this.aliases = aliases;
		this.RegisterCommand();
	}
	
	private void RegisterCommand()
	{
		CommandHandler commandHandler = CommandHandler.getInstance();
		commandHandler.AddCommand(name, this, aliases);
	}
	
	public abstract String ExecuteCommand(ModDropPlugin plugin);
	public abstract String ExecuteCommand(ModDropPlugin plugin, String ...parameters);
	
    public String GetDescription()
    {
        String description;
        description = String.format("The command %s does not provide a description.", name);
        return description;
    }

    public String GetHelp()
    {
        String help;
        help = String.format("The command %s does not provide help.", name);
        return help;
    }
    
    public String GetUsage()
    {
    	String usage;
    	usage = String.format("The command %s does not provide an usage example.", name);
        return usage;
    }
}
