package de.noonex.glassdropplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class Drop 
{
	private int amount;
	private Material dropType;
	
	public Drop(int amount, Material dropType)
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
