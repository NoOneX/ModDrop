package de.noonex.moddropplugin.drops;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.noonex.moddropplugin.amount.IAmountable;

public class LightningDrop extends AbstractDrop
{
	boolean damage;
	
	public LightningDrop(int damage)
	{
		this.damage = (damage != 0);
	}

	@Override
	public void CreateDrop(final Location loc, final World world, final Player player,
			boolean checkConditions)
	{
		if(checkConditions)
		{
			if(!this.CheckConditions(player, loc))
			{
				//cancel the drop
				return;
			}
		}
		
		this.amount.Do(new IAmountable()
		{			
			@Override
			public void Do(Object param)
			{
				if(damage)
				{
					world.strikeLightning(loc);
				}
				else
				{
					world.strikeLightningEffect(loc);
				}
			}
		});

	}

}
