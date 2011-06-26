package de.noonex.glassdropplugin;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

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
		//TODO: Dropglass in Konfigurationsdatei speichern
		if(dropglass)
		{
			//TODO: Andere Blöcke per Konfigurationsdatei
			//Per Compositing-Pattern o.ä., je nach Block einen Befehl hinzu, quasi Events
			//mehrere Drops, also Liste mit Drops, Format DropID:Anzahl
			if(event.getBlock().getType() == Material.GLASS)
			{
				Material blockmaterial = event.getBlock().getType();
				Drop drop = new Drop(1, blockmaterial);
				Location dropLocation = event.getBlock().getLocation();
				
				drop.CreateDrop(dropLocation, dropLocation.getWorld());
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
