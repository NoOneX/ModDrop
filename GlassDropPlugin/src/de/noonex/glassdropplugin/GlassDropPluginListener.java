package de.noonex.glassdropplugin;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class GlassDropPluginListener extends BlockListener
{
	Logger serverLog;
	Boolean dropglass;

	public GlassDropPluginListener(Logger log, Boolean dropglass)
	{
		this.serverLog = log;
		this.dropglass = dropglass;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event)
	{
		if(dropglass)
		{
			if(event.getBlock().getType() == Material.GLASS)
			{
				Material blockmaterial = event.getBlock().getType();
				ItemStack droppedItem = new ItemStack(blockmaterial, 1);
				
				event.getPlayer().getInventory().addItem(droppedItem);
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
}
