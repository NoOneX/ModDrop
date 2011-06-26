package de.noonex.glassdropplugin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

public class MultipleDrop extends AbstractDrop {

	List<AbstractDrop> droplist;
	
	public MultipleDrop(AbstractDrop... drops)
	{
		droplist = new LinkedList<AbstractDrop>();
		droplist.addAll(Arrays.asList(drops));
	}
	
	@Override
	public void CreateDrop(Location loc, World world) {
		for(AbstractDrop drop: droplist)
		{
			drop.CreateDrop(loc, world);
		}
	}
}
