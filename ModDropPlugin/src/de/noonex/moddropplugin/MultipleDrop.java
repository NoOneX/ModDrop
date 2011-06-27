package de.noonex.moddropplugin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

public class MultipleDrop extends AbstractDrop {

	List<AbstractDrop> droplist;
	
	public MultipleDrop(AbstractDrop... drops)
	{
		this.droplist = new LinkedList<AbstractDrop>();
		this.droplist.addAll(Arrays.asList(drops));
	}
	
	@Override
	public void CreateDrop(Location loc, World world) {
		for(AbstractDrop drop: this.droplist)
		{
			drop.CreateDrop(loc, world);
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
