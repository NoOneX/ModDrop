package de.noonex.moddropplugin.drops;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MultipleDrop extends AbstractDrop {

	List<AbstractDrop> droplist;
	
	public MultipleDrop(AbstractDrop... drops)
	{
		this.droplist = new LinkedList<AbstractDrop>();
		this.droplist.addAll(Arrays.asList(drops));
	}
	
	@Override
	public void CreateDrop(Location loc, World world, Player player, boolean checkConditions) {
		for(AbstractDrop drop: this.droplist)
		{
			if(checkConditions)
			{
				if(!drop.CheckConditions(player, loc))
				{
					//cancel the drop
					continue;
				}
			}
			drop.CreateDrop(loc, world, player, false);
		}
	}
	
	public void AddDrop(AbstractDrop drop)
	{
		this.droplist.add(drop);
	}
	
	public void AddDrop(AbstractDrop... drops)
	{
		this.droplist.addAll(Arrays.asList(drops));
	}
}
