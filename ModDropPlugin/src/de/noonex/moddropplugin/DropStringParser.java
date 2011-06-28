package de.noonex.moddropplugin;

import java.text.ParseException;

import org.bukkit.Material;
import org.bukkit.entity.CreatureType;

//TODO: Parser as a plugin
public class DropStringParser
{
	public static DropSetting ParseDrop(String str) throws ParseException
	{
		String[] arguments = str.split(":");
		if(arguments.length != 4)
		{
			throw new ParseException("Bad format. Use this format: droptype:blockId:additionalarguments:amount", 0);
		}
		
		AbstractDrop newDrop;
		DropSetting drop;
		int blockID;
		
		if(arguments[0].equalsIgnoreCase( "block"))
		{
			int amount;
			int dropID;
			Material material;
			
			try
			{				
				blockID = Integer.parseInt(arguments[1]);
				dropID = Integer.parseInt(arguments[2]);
				amount = Integer.parseInt(arguments[3]);
			}
			catch(NumberFormatException ex)
			{
				//TODO: Use the right offset
				throw new ParseException("Bad format: BlockID, DropID or the amount are not numbers.", 0);
			}
			
			material = Material.getMaterial(dropID);
			newDrop = new NormalDrop(amount, material);
		}
		else if(arguments[0].equalsIgnoreCase("monster"))
		{
			int amount;
			CreatureType creature;
			
			try
			{				
				blockID = Integer.parseInt(arguments[1]);
				creature = CreatureType.fromName(arguments[2]);
				amount = Integer.parseInt(arguments[3]);
			}
			catch(NumberFormatException ex)
			{
				//TODO: Use the right offset
				throw new ParseException("Bad format: BlockID or the amount are not numbers. Or the creature name is wrong.", 0);
			}
			
			newDrop = new MonsterDrop(creature, amount);
		}
		else if(arguments[0].equalsIgnoreCase("icon"))
		{
			double amount;
			
			try
			{				
				blockID = Integer.parseInt(arguments[1]);
				amount = Double.parseDouble(arguments[3]);
			}
			catch(NumberFormatException ex)
			{
				//TODO: Use the right offset
				throw new ParseException("Bad format: BlockID or the amount are not numbers.", 0);
			}
			
			newDrop = new iConomyDrop(amount);
		}
		else
		{
			throw new ParseException("This keyword is not supported: " + arguments[0], 0);
		}
		
		drop = new DropSetting(newDrop, blockID);		
		return drop;
	}
}
