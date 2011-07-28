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
	private byte damageData;

	public NormalDrop(Material dropType, byte damageData)
	{
		this.amount = new NormalAmount(0, 0);
		this.dropType = dropType;
		this.damageData = damageData;
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
				ItemStack dropItems = new ItemStack(dropType, 1, damageData, damageData);
				world.dropItemNaturally(loc, dropItems);
			}
		});

	}
}
