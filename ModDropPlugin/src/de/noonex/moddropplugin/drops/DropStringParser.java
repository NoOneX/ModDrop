package de.noonex.moddropplugin.drops;

import java.text.ParseException;

import org.bukkit.Material;
import org.bukkit.entity.CreatureType;

import de.noonex.moddropplugin.amount.Amount;
import de.noonex.moddropplugin.amount.AmountParser;
import de.noonex.moddropplugin.amount.iConomyAmount;
import de.noonex.moddropplugin.conditions.Condition;
import de.noonex.moddropplugin.conditions.ConditionParser;
import de.noonex.moddropplugin.conditions.NullCondition;

//TODO: Parser as a plugin
public class DropStringParser
{
	public static DropSetting ParseDrop(String str) throws ParseException
	{
		DropSetting newDrop;
		String[] arguments;
		
		Condition[] conditions = new Condition[1];
		conditions[0] = new NullCondition();
		
		if(str.contains("@"))
		{
			String[] configurationString = str.split("@");
			if(configurationString.length != 2)
			{
				throw new ParseException(
						"Bad format. Use this format: droptype:blockId:additionalarguments:amount@conditions",
						0);
			}
			
			try
			{
				conditions = ConditionParser.ParseConditions(configurationString[1]);
			}
			catch(ParseException ex)
			{
				//print warning, ignore conditions
				System.out.println("[ModDrop][WARNING] Bad conditions.");
			}
			
			arguments = configurationString[0].split(":");
		}
		else
		{
			arguments = str.split(":");
		}		
		
		if (arguments.length != 4)
		{
			throw new ParseException(
					"Bad format. Use this format: droptype:blockId:additionalarguments:amount",
					0);
		}

		if (arguments[0].equalsIgnoreCase("block"))
		{
			newDrop = parseBlockDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("monster"))
		{
			newDrop = parseMonsterDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("icon"))
		{
			newDrop = parseiConomyDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("explosion"))
		{
			newDrop = parseExplosionDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("lightning"))
		{
			newDrop = parseLightningDrop(arguments);
		}
		else
		{
			throw new ParseException("This keyword is not supported: "
					+ arguments[0], 0);
		}
		
		newDrop.getDrop().AddCondition(conditions);
		
		return newDrop;
	}

	private static DropSetting parseLightningDrop(String[] arguments) throws ParseException
	{
		AbstractDrop newDrop;
		Amount amount;
		int blockID;
		int damage;

		try
		{
			blockID = Integer.parseInt(arguments[1]);
			damage = Integer.parseInt(arguments[2]);
		}
		catch (NumberFormatException ex)
		{
			throw new ParseException(
					"Bad format: BlockID or the damage are not numbers.", 0);
		}
		
		amount = AmountParser.ParseAmount(arguments[3]);
		newDrop = new LightningDrop(damage);
		newDrop.setAmount(amount);
		
		return new DropSetting(newDrop, blockID);
	}

	private static DropSetting parseExplosionDrop(String[] arguments)
			throws ParseException
	{
		AbstractDrop newDrop;
		Amount amount;
		int blockID;
		float strength;

		try
		{
			blockID = Integer.parseInt(arguments[1]);
			strength = Float.parseFloat(arguments[2]);
		}
		catch (NumberFormatException ex)
		{
			throw new ParseException(
					"Bad format: BlockID or the strength are not numbers.", 0);
		}
		
		amount = AmountParser.ParseAmount(arguments[3]);
		newDrop = new ExplosionDrop(strength);
		newDrop.setAmount(amount);
		
		return new DropSetting(newDrop, blockID);
	}

	private static DropSetting parseiConomyDrop(String[] arguments)
			throws ParseException
	{
		AbstractDrop newDrop;
		Amount amount;
		int blockID;

		try
		{
			blockID = Integer.parseInt(arguments[1]);
			amount = new iConomyAmount(Double.parseDouble(arguments[3]));
		}
		catch (NumberFormatException ex)
		{
			// TODO: Use the right offset
			throw new ParseException(
					"Bad format: BlockID or the amount are not numbers.", 0);
		}

		newDrop = new iConomyDrop();
		newDrop.setAmount(amount);

		return new DropSetting(newDrop, blockID);
	}

	private static DropSetting parseMonsterDrop(String[] arguments)
			throws ParseException
	{
		AbstractDrop newDrop;

		Amount amount;
		int blockID;
		CreatureType creature;

		try
		{
			blockID = Integer.parseInt(arguments[1]);
			creature = CreatureType.fromName(arguments[2]);
		}
		catch (NumberFormatException ex)
		{
			// TODO: Use the right offset
			throw new ParseException(
					"Bad format: BlockID or the amount are not numbers. Or the creature name is wrong.",
					0);
		}

		amount = AmountParser.ParseAmount(arguments[3]);

		newDrop = new MonsterDrop(creature);
		newDrop.setAmount(amount);

		return new DropSetting(newDrop, blockID);
	}

	private static DropSetting parseBlockDrop(String[] arguments)
			throws ParseException
	{
		AbstractDrop newDrop;

		Amount amount;
		int dropID;
		int blockID;
		Material material;

		try
		{
			blockID = Integer.parseInt(arguments[1]);
			dropID = Integer.parseInt(arguments[2]);
		}
		catch (NumberFormatException ex)
		{
			// TODO: Use the right offset
			throw new ParseException(
					"Bad format: BlockID, DropID or the amount are not numbers.",
					0);
		}

		amount = AmountParser.ParseAmount(arguments[3]);

		material = Material.getMaterial(dropID);
		newDrop = new NormalDrop(material);
		newDrop.setAmount(amount);

		return new DropSetting(newDrop, blockID);
	}
}
