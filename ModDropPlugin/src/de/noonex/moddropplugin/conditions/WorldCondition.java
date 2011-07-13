package de.noonex.moddropplugin.conditions;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WorldCondition extends Condition
{
	private String worldName;
	
	public WorldCondition(String worldName)
	{
		this.worldName = worldName;
	}
	
	@Override
	public boolean CheckCondition(Player player, Location loc)
	{
		return loc.getWorld().getName().equals(this.worldName);
	}

	@Override
	public String ToString()
	{
		return this.worldName;
	}
}
