package de.noonex.moddropplugin;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

import de.noonex.moddropplugin.drops.AbstractDrop;

public class ModDropPluginBlockListener extends BlockListener
{
	Logger serverLog;
	Boolean moddrop;
	HashMap<Integer, AbstractDrop> droplist;

	public ModDropPluginBlockListener(Logger log, Boolean moddrop, HashMap<Integer, AbstractDrop> droplist)
	{
		this.serverLog = log;
		this.moddrop = moddrop;
		this.droplist = droplist;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event)
	{
		if(moddrop)
		{
			int blockID = event.getBlock().getTypeId();
			if(droplist.containsKey(blockID) && !event.isCancelled())
			{
				AbstractDrop newDrop = droplist.get(blockID);				
				Location dropLocation = event.getBlock().getLocation();				
				newDrop.CreateDrop(dropLocation, dropLocation.getWorld(), event.getPlayer(), true);
				
				//Cancel the normal drop
				event.setCancelled(true);
				event.getBlock().setType(Material.AIR);
			}
		}
	}
	
	public void setDropGlass(Boolean value)
	{
		this.moddrop = value;
	}
	
	public Boolean getDropGlass()
	{
		return this.moddrop;
	}
	
	public void RefreshDroplist(HashMap<Integer, AbstractDrop> newDroplist)
	{
		this.droplist = newDroplist;
	}
}
