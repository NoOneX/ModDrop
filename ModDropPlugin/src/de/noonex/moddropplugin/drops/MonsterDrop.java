package de.noonex.moddropplugin.drops;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

import de.noonex.moddropplugin.amount.IAmountable;

public class MonsterDrop extends AbstractDrop {

	private CreatureType monsterType;
	
	public MonsterDrop(CreatureType monsterType)
	{
		this.monsterType = monsterType;
	}
	
	@Override
	public void CreateDrop(final Location loc, final World world, Player player)
	{
		this.amount.Do(new IAmountable()
		{
			
			@Override
			public void Do(Object param)
			{
				world.spawnCreature(loc, monsterType);
			}
		});
	}
}
