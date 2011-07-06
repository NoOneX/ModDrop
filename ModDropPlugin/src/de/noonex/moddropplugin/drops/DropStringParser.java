package de.noonex.moddropplugin.drops;

import java.text.ParseException;

import org.bukkit.Material;
import org.bukkit.entity.CreatureType;

import de.noonex.moddropplugin.amount.Amount;
import de.noonex.moddropplugin.amount.AmountParser;
import de.noonex.moddropplugin.amount.iConomyAmount;

//TODO: Parser as a plugin
public class DropStringParser
{
	public static DropSetting ParseDrop(String str) throws ParseException
	{
		String[] arguments = str.split(":");
		if (arguments.length != 4)
		{
			throw new ParseException(
					"Bad format. Use this format: droptype:blockId:additionalarguments:amount",
					0);
		}

		if (arguments[0].equalsIgnoreCase("block"))
		{
			return parseBlockDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("monster"))
		{
			return parseMonsterDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("icon"))
		{
			return parseiConomyDrop(arguments);
		}
		else if (arguments[0].equalsIgnoreCase("primedtnt"))
		{
			return parsePrimedTNTDrop(arguments);
		}
		else
		{
			throw new ParseException("This keyword is not supported: "
					+ arguments[0], 0);
		}
	}

	private static DropSetting parsePrimedTNTDrop(String[] arguments)
			throws ParseException
	{
		AbstractDrop newDrop;
		Amount amount;
		int blockID;

		try
		{
			blockID = Integer.parseInt(arguments[1]);
		}
		catch (NumberFormatException ex)
		{
			throw new ParseException(
					"Bad format: BlockID or the amount are not numbers.", 0);
		}
		
		amount = AmountParser.ParseAmount(arguments[3]);
		newDrop = new PrimedTNTDrop();
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
