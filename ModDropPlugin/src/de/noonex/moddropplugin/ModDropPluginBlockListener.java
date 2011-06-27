package de.noonex.moddropplugin;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

public class ModDropPluginBlockListener extends BlockListener
{
	Logger serverLog;
	Boolean dropglass;
	HashMap<Integer, AbstractDrop> droplist;

	public ModDropPluginBlockListener(Logger log, Boolean dropglass, HashMap<Integer, AbstractDrop> droplist)
	{
		this.serverLog = log;
		this.dropglass = dropglass;
		this.droplist = droplist;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event)
	{
		if(dropglass)
		{
			int blockID = event.getBlock().getTypeId();
			if(droplist.containsKey(blockID))
			{
				AbstractDrop newDrop = droplist.get(blockID);				
				Location dropLocation = event.getBlock().getLocation();				
				newDrop.CreateDrop(dropLocation, dropLocation.getWorld());
			}
		}
	}
	
	public void setDropGlass(Boolean value)
	{
		this.dropglass = value;
	}
	
	public Boolean getDropGlass()
	{
		return this.dropglass;
	}
	
	public void RefreshDroplist(HashMap<Integer, AbstractDrop> newDroplist)
	{
		this.droplist = newDroplist;
	}
}
