package de.noonex.moddropplugin;

import java.text.ParseException;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.util.config.Configuration;

public class ConfigurationManager
{
	private Configuration config;
	
	public ConfigurationManager(Configuration config)
	{
		this.config = config;
		this.config.load();
	}
	
	public boolean getModDrop()
	{
		return this.config.getBoolean("moddrop_on", false);
	}
	
	public void setModDrop(boolean value)
	{
		this.config.setProperty("moddrop_on", value);
	}
	
	public void SaveConfiguration()
	{
		this.config.save();
	}
	
	public void LoadConfiguration()
	{
		this.config.load();
	}
	
	public HashMap<Integer, AbstractDrop> getDropList()
	{
		HashMap<Integer, AbstractDrop> droplist = new HashMap<Integer, AbstractDrop>();
		String configDroplist = this.config.getString("droplist", "20:20:1");
		
		for(String configDropItem: configDroplist.split(" "))
		{
			DropSetting drop;
			AbstractDrop newDrop;
			int blockID;
			
			try
			{
				drop = DropStringParser.ParseDrop(configDropItem);
			}
			catch(ParseException ex)
			{
				//TODO: Create better messages
				System.out.println("[ModDrop][WARNING] " + ex.getMessage());
				continue;
			}
			
			blockID = drop.getBlockId();
			
			if(droplist.containsKey(blockID))
			{
				AbstractDrop previousSetting = droplist.get(blockID);
				
				if(previousSetting instanceof MultipleDrop)
				{
					MultipleDrop previousMultipleDrop = (MultipleDrop)previousSetting;
					previousMultipleDrop.AddDrop(drop.getDrop());
					continue;
				}
				else
				{
					newDrop = new MultipleDrop(previousSetting, drop.getDrop());
				}
			}
			else
			{
				newDrop = drop.getDrop();
			}
			droplist.put(blockID, newDrop);
		}
		
		return droplist;
	}
}
