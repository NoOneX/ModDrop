package de.noonex.moddropplugin.commands;

import de.noonex.moddropplugin.ModDropPlugin;

public class ToggleCommand extends AbstractCommand
{

	public ToggleCommand()
	{
		super("toggle", "switch", "onoff");
	}

	@Override
	public String ExecuteCommand(ModDropPlugin plugin)
	{
		String msg;
		plugin.setModDrop(!plugin.getModDrop());
		
		msg = String.format("[ModDrop] Moddrop %b.", plugin.getModDrop());
		
		return msg;
	}

	@Override
	public String ExecuteCommand(ModDropPlugin plugin, String... parameters)
	{
		return ExecuteCommand(plugin);
	}

}
