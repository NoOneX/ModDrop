package de.noonex.moddropplugin.drops;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.noonex.moddropplugin.amount.IAmountable;

public class ExplosionDrop extends AbstractDrop
{
	private float strength;
	
	public ExplosionDrop(float strength)
	{
		this.strength = strength;
	}

	@Override
	public void CreateDrop(final Location loc, final World world, final Player player)
	{
		this.amount.Do(new IAmountable()
		{			
			@Override
			public void Do(Object param)
			{
				world.createExplosion(loc, strength);
			}
		});
	}

}
