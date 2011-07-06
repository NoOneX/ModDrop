package de.noonex.moddropplugin.drops;

import net.minecraft.server.EntityTNTPrimed;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.material.MaterialData;

import de.noonex.moddropplugin.amount.IAmountable;

public class PrimedTNTDrop extends AbstractDrop
{
	
	public PrimedTNTDrop()
	{	}

	@Override
	public void CreateDrop(final Location loc, final World world, final Player player)
	{
		this.amount.Do(new IAmountable()
		{			
			@Override
			public void Do(Object param)
			{
				//CraftTNTPrimed tnt = new CraftTNTPrimed(w, entity)
				
				/*Block currentBlock = loc.getBlock();
				
				currentBlock.get
				
				currentBlock.setType(Material.TNT);
				
				BlockState blockState = currentBlock.getState();
				MaterialData materialData = blockState.getData();
				materialData.setData((byte)10);*/
				
				/*EntityTNTPrimed primedTNT = new EntityTNTPrimed((net.minecraft.server.World) world, loc.getX(), loc.getY(), loc.getZ());
				CraftWorld cworld = (CraftWorld)world;				
				cworld.getHandle().a(primedTNT, (byte) 0);*/
			}
		});
	}

}
