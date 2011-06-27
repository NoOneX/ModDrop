package de.noonex.moddropplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class NormalDrop extends AbstractDrop
{
	private int amount;
	private Material dropType;
	
	public NormalDrop(int amount, Material dropType)
	{
		this.amount = amount;
		this.dropType = dropType;
	}
	
	public void CreateDrop(Location loc, World world)
	{
		ItemStack dropItems = new ItemStack(dropType, amount);
		world.dropItemNaturally(loc, dropItems);
	}
}
