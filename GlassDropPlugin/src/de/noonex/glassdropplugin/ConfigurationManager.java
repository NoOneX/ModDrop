package de.noonex.glassdropplugin;

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
	
	public boolean getDropglass()
	{
		return this.config.getBoolean("dropglass_on", false);
	}
	
	public void setDropglass(boolean value)
	{
		this.config.setProperty("dropglass_on", true);
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
			String[] dropItem = configDropItem.split(":");
			if(dropItem.length != 3)
			{
				continue;
			}
			
			int amount;
			int blockID;
			int dropID;
			Material material;
			AbstractDrop newDrop;
			
			try
			{
				amount = Integer.parseInt(dropItem[2]);
				blockID = Integer.parseInt(dropItem[0]);
				dropID = Integer.parseInt(dropItem[1]);
			}
			catch(NumberFormatException ex)
			{
				continue;
			}
			
			material = Material.getMaterial(dropID);
			
			newDrop = new NormalDrop(amount, material);
			droplist.put(blockID, newDrop);
		}
		
		return droplist;
	}
}
