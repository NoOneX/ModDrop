package de.noonex.moddropplugin.commands;

import de.noonex.moddropplugin.ModDropPlugin;

public class ToggleCommand extends AbstractCommand
{

	public ToggleCommand()
	{
		super("toggle", "noonex.moddrop.toggle", "switch", "onoff");
	}

	@Override
	protected String ExecuteCommand(ModDropPlugin plugin)
	{
		String msg;
		plugin.setModDrop(!plugin.getModDrop());
		
		msg = String.format("[ModDrop] Moddrop %b.", plugin.getModDrop());
		
		return msg;
	}

	@Override
	protected String ExecuteCommand(ModDropPlugin plugin, String... parameters)
	{
		return ExecuteCommand(plugin);
	}
	
	public String GetHelp()
	{
		return "This command enables/disables ModDrop.";
	}
	
	public String GetUsage()
	{
		return "Usage: toggle";
	}

	public String GetDescription()
	{
		return this.GetHelp();
	}

}
