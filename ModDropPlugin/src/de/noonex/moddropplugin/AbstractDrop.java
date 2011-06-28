package de.noonex.moddropplugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class AbstractDrop 
{	
	public AbstractDrop()
	{
	}
	
	public abstract void CreateDrop(Location loc, World world, Player player);
}
