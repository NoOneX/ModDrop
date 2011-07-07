package de.noonex.moddropplugin.conditions;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class DamageValueCondition extends Condition
{
	byte damagevalue;
	
	public DamageValueCondition(byte damagevalue)
	{
		this.damagevalue = damagevalue;
	}

	@Override
	public boolean CheckCondition(Player player, Location loc)
	{
		return loc.getBlock().getData() == this.damagevalue;
	}

}
