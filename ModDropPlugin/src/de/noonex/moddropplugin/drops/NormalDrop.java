package de.noonex.moddropplugin.drops;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.noonex.moddropplugin.amount.IAmountable;
import de.noonex.moddropplugin.amount.NormalAmount;


public class NormalDrop extends AbstractDrop
{
	private Material dropType;

	public NormalDrop(Material dropType)
	{
		this.amount = new NormalAmount(0, 0);
		this.dropType = dropType;
	}

	public void CreateDrop(final Location loc, final World world, Player player, boolean checkConditions)
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
				ItemStack dropItems = new ItemStack(dropType, 1);
				world.dropItemNaturally(loc, dropItems);
			}
		});

	}
}