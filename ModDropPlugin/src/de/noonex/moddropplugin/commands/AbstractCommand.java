package de.noonex.moddropplugin.commands;

import org.bukkit.command.CommandSender;

import de.noonex.moddropplugin.ModDropPlugin;

public abstract class AbstractCommand
{
	String name;
	String[] aliases;
	String permission;
	
	public AbstractCommand(String name, String permission, String ...aliases)
	{
		this.name = name;
		this.aliases = aliases;
		this.permission = permission;
		this.RegisterCommand();
	}
	
	private void RegisterCommand()
	{
		CommandHandler commandHandler = CommandHandler.getInstance();
		commandHandler.AddCommand(name, this, aliases);
	}
	
	protected abstract String ExecuteCommand(ModDropPlugin plugin);
	protected abstract String ExecuteCommand(ModDropPlugin plugin, String ...parameters);
	
	public String ExecuteCommandWithPermissions(ModDropPlugin plugin, CommandSender sender)
	{
		if(!this.HasPermission(sender))
		{
			return String.format("Insufficient rights to use the command %s.", this.name);
		}
		
		return this.ExecuteCommand(plugin);
	}
	
	public String ExecuteCommandWithPermissions(ModDropPlugin plugin, CommandSender sender, String ...parameters)
	{
		if(!this.HasPermission(sender))
		{
			return String.format("Insufficient rights to use the command %s.", this.name);
		}
		
		return this.ExecuteCommand(plugin, parameters);
	}
	
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
    
    public boolean HasPermission(CommandSender sender)
    {
    	return sender.hasPermission(this.permission);
    }
    
    public String GetName()
    {
    	return this.name;
    }
}
