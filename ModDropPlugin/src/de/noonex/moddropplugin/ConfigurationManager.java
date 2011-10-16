package de.noonex.moddropplugin;

import java.text.ParseException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.noonex.moddropplugin.drops.AbstractDrop;
import de.noonex.moddropplugin.drops.DropSetting;
import de.noonex.moddropplugin.drops.DropStringParser;
import de.noonex.moddropplugin.drops.MultipleDrop;

public class ConfigurationManager
{
	private FileConfiguration config;
	private JavaPlugin modDrop;
	
	public ConfigurationManager(FileConfiguration config, JavaPlugin modDrop)
	{
		this.config = config;
		this.modDrop = modDrop;
	}
	
	public boolean getModDrop()
	{
		return this.config.getBoolean("moddrop_on", false);
	}
	
	public void setModDrop(boolean value)
	{
		this.config.set("moddrop_on", value);
	}
	
	public void SaveConfiguration()
	{
		this.modDrop.saveConfig();
	}
	
	public void LoadConfiguration()
	{
		this.modDrop.reloadConfig();
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
