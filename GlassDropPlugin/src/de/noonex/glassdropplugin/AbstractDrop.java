package de.noonex.glassdropplugin;

import org.bukkit.Location;
import org.bukkit.World;

public abstract class AbstractDrop 
{	
	public AbstractDrop()
	{
	}
	
	public abstract void CreateDrop(Location loc, World world);
}
