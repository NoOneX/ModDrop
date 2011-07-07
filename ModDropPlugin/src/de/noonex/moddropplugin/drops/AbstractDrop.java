package de.noonex.moddropplugin.drops;

import java.util.Arrays;
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
	protected boolean cancelled;
	
	public AbstractDrop()
	{
		conditions = new LinkedList<Condition>();
		cancelled = false;
	}
	
	public abstract void CreateDrop(Location loc, World world, Player player, boolean checkConditions);
	public boolean CheckConditions(Player player, Location loc) //Location for further purposes (region spawning?)
	{
		this.setCancelled(false);
		
		for(Condition c: this.conditions)
		{
			if(!c.CheckCondition(player, loc))
			{
				this.setCancelled(true);
				return false;
			}
		}
		
		return true;
	}
	
	public void AddCondition(Condition... conditions)
	{
		this.conditions.addAll(Arrays.asList(conditions));
	}
	
	public Amount getAmount()
	{
		return this.getAmount();
	}
	
	public void setAmount(Amount value)
	{
		this.amount = value;
	}
	
	public boolean getCancelled()
	{
		return this.cancelled;
	}
	
	public void setCancelled(boolean cancelled)
	{
		this.cancelled = cancelled;
	}
}
