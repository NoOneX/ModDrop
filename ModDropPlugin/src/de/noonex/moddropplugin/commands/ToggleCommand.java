package de.noonex.moddropplugin.commands;

import de.noonex.moddropplugin.ModDropPlugin;

//TODO: Add usage and help methods!

public class ToggleCommand extends AbstractCommand
{

	public ToggleCommand()
	{
		super("toggle", "noonex.moddrop.usage", "switch", "onoff");
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

}
