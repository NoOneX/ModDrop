package de.noonex.moddropplugin.drops;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.nijikokun.register.payment.Method;
import com.nijikokun.register.payment.Method.MethodAccount;
import com.nijikokun.register.payment.Methods;

import de.noonex.moddropplugin.PluginHookManager;
import de.noonex.moddropplugin.amount.IAmountable;

public class iConomyDrop extends AbstractDrop {
	
	public iConomyDrop()
	{	}

	@Override
	public void CreateDrop(final Location loc, final World world, final Player player, boolean checkConditions)
	{
		if(checkConditions)
		{
			if(!this.CheckConditions(player, loc))
			{
				//cancel the drop
				return;
			}
		}
		
		final PluginHookManager pluginhook = PluginHookManager.getInstance();
		
		if(pluginhook.IsRegisterAvailable())
		{
			this.amount.Do(new IAmountable()
			{
				
				@Override
				public void Do(Object param)
				{
					Method paymentMethod = Methods.getMethod();
					String playerName = player.getName();
					MethodAccount playerAccount;
						
					if(!paymentMethod.hasAccount(playerName))
					{
						//TODO: Check the result value?
						paymentMethod.createAccount(playerName);
					}
					
					playerAccount = paymentMethod.getAccount(playerName);
					playerAccount.add((Double) param);
				}
			});

		}
	}

}
