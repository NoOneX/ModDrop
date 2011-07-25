package de.noonex.moddropplugin.conditions;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;

public final class ConditionParser
{
	public static Condition[] ParseConditions(String conditionsString) throws ParseException
	{
		List<Condition> conditions = new LinkedList<Condition>();
		String[] keyvaluepairs = conditionsString.split(";");
		
		for(String keyvalue: keyvaluepairs)
		{
			String[] keyvalueArr = keyvalue.split(":");
			
			if(keyvalueArr[0].equalsIgnoreCase("world"))
			{
				conditions.add(ParseWorldCondition(keyvalueArr[1]));
			}
			else if(keyvalueArr[0].equalsIgnoreCase("damage"))
			{
				try
				{
					conditions.add(ParseDamageCondition(keyvalueArr[1]));
				}
				catch(ParseException ex)
				{
					System.out.println("[ModDrop][WARNING] The damage condition value is not a number." + keyvalue);
					continue;
				}
			}
			else if(keyvalueArr[0].equalsIgnoreCase("tool"))
			{
				try
				{
					conditions.add(ParseToolCondition(keyvalueArr[1]));
				}
				catch(ParseException ex)
				{
					System.out.println("[ModDrop][WARNING] The tool condition value is not valid." + keyvalue);
					continue;
				}
			}
			else
			{
				continue;
			}
		}
		
		if(conditions.size() <= 0)
		{
			throw new ParseException("No conditions specified.", 0);
		}
		
		return conditions.toArray(new Condition[conditions.size()]);
	}

	private static Condition ParseToolCondition(String value) throws ParseException
	{
		Material blockInHand;
		
		blockInHand = Material.matchMaterial(value);
		
		if(blockInHand != null)
		{
			return new ToolCondition(blockInHand);
		}
		
		//if block name isnt valid try blockid
		
		try
		{
			int toolID = Integer.parseInt(value);
			blockInHand = Material.getMaterial(toolID);
		}
		catch (NumberFormatException ex)
		{
			throw new ParseException("The tool condition value is not valid", 0);
		}
		
		
		if(blockInHand != null)
		{
			return new ToolCondition(blockInHand);
		}
		
		//if it still fails throw exception
		throw new ParseException("The tool condition value is not valid", 0);
	}

	private static Condition ParseDamageCondition(String value) throws ParseException
	{
		byte damagevalue;
		
		try
		{
			damagevalue = Byte.parseByte(value);
		}
		catch(NumberFormatException ex)
		{
			throw new ParseException("The damage condition value is not valid", 0);
		}
		
		return new DamageValueCondition(damagevalue);
	}

	private static Condition ParseWorldCondition(String value)
	{
		return new WorldCondition(value);
	}
}
