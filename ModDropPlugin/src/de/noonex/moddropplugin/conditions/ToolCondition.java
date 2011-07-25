package de.noonex.moddropplugin.conditions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ToolCondition extends Condition
{
	Material tool;
	
	public ToolCondition(Material tool)
	{
		this.tool = tool;
	}

	@Override
	public boolean CheckCondition(Player player, Location loc)
	{
		return tool == player.getItemInHand().getType();
	}

	@Override
	public String ToString()
	{
		return tool.toString();
	}

}
