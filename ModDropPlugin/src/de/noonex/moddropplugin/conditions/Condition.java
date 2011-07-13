package de.noonex.moddropplugin.conditions;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Condition
{	
	public abstract boolean CheckCondition(Player player, Location loc);
	public abstract String ToString();
}
