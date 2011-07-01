package de.noonex.moddropplugin;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class AbstractDrop 
{
	protected Amount amount;
	protected List<Condition> conditions;
	
	public AbstractDrop()
	{
	}
	
	public abstract void CreateDrop(Location loc, World world, Player player);
	public boolean CheckConditions(Player player, Location loc) //Location for further purposes (region spawning?)
	{
		for(Condition c: this.conditions)
		{
			if(!c.CheckCondition(player, loc))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void AddCondition(Condition cond)
	{
		this.conditions.add(cond);
	}
	
	public Amount getAmount()
	{
		return this.getAmount();
	}
	
	public void setAmount(Amount value)
	{
		this.amount = value;
	}
}
