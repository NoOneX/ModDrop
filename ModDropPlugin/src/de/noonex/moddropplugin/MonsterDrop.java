package de.noonex.moddropplugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

public class MonsterDrop extends AbstractDrop {

	private CreatureType monsterType;
	private int amount;
	
	public MonsterDrop(CreatureType monsterType, int amount)
	{
		this.monsterType = monsterType;
		this.amount = amount;
	}
	
	@Override
	public void CreateDrop(Location loc, World world, Player player)
	{
		if(amount <= 0)
		{
			return;
		}
		
		for(int i = 0; i < amount; i++)
		{
			world.spawnCreature(loc, monsterType);
		}
	}

}
