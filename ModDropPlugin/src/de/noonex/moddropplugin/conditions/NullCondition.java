package de.noonex.moddropplugin.conditions;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class NullCondition extends Condition
{

	@Override
	public boolean CheckCondition(Player player, Location loc)
	{
		return true;
	}

}
