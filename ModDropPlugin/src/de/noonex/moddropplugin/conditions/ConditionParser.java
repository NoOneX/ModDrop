package de.noonex.moddropplugin.conditions;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

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

	private static Condition ParseWorldCondition(String value)
	{
		return new WorldCondition(value);
	}
}
