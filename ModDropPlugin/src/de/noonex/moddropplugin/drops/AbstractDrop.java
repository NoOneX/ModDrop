package de.noonex.moddropplugin.drops;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.noonex.moddropplugin.amount.Amount;
import de.noonex.moddropplugin.conditions.Condition;


public abstract class AbstractDrop 
{
	protected Amount amount;
	protected List<Condition> conditions;
	
	public AbstractDrop()
	{
		conditions = new LinkedList<Condition>();
	}
	
	public abstract void CreateDrop(Location loc, World world, Player player, boolean checkConditions);
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
