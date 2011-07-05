package de.noonex.moddropplugin;

import javax.naming.OperationNotSupportedException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.iConomy.iConomy;
import com.iConomy.system.Holdings;

import de.noonex.moddropplugin.amount.IAmountable;

public class iConomyDrop extends AbstractDrop {
	
	public iConomyDrop()
	{	}

	@SuppressWarnings("static-access")
	@Override
	public void CreateDrop(final Location loc, final World world, final Player player)
	{
		final PluginHookManager pluginhook = PluginHookManager.getInstance();
		
		if(pluginhook.IsiConomyAvailable())
		{
			this.amount.Do(new IAmountable()
			{
				
				@Override
				public void Do(Object param)
				{
					// TODO Auto-generated method stub
					try
					{
						iConomy icon = pluginhook.getiConomy();
						Holdings playerBalance = icon.getAccount(
								player.getName()).getHoldings();

						playerBalance.add((Double) param);
					}
					catch (OperationNotSupportedException e)
					{
						// do nothing
						e.printStackTrace();
					}
				}
			});

		}
	}

}
