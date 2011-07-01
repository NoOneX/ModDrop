package de.noonex.moddropplugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Condition
{	
	public abstract boolean CheckCondition(Player player, Location loc);
}
