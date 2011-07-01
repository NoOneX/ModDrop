package de.noonex.moddropplugin;

import javax.naming.OperationNotSupportedException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.iConomy.iConomy;
import com.iConomy.system.Holdings;

public class iConomyDrop extends AbstractDrop {
	
	double moneyamount;
	
	public iConomyDrop(double moneyamount)
	{
		this.moneyamount = moneyamount;
	}

	@SuppressWarnings("static-access")
	@Override
	public void CreateDrop(Location loc, World world, Player player)
	{
		PluginHookManager pluginhook = PluginHookManager.getInstance();
		
		if(pluginhook.IsiConomyAvailable())
		{
			try {
				iConomy icon = pluginhook.getiConomy();
				Holdings playerBalance = icon.getAccount(player.getName()).getHoldings();
				
				playerBalance.add(moneyamount);
			} catch (OperationNotSupportedException e) {
				//do nothing
				e.printStackTrace();
			}
		}
	}

}
