package de.noonex.moddropplugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

public class MonsterDrop extends AbstractDrop {

	private CreatureType monsterType;
	
	public MonsterDrop(CreatureType monsterType)
	{
		this.monsterType = monsterType;
	}
	
	@Override
	public void CreateDrop(Location loc, World world, Player player)
	{
		world.spawnCreature(loc, monsterType);		
	}

}
