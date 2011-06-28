package de.noonex.moddropplugin;

import javax.naming.OperationNotSupportedException;

import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;
import org.bukkit.plugin.Plugin;

import com.iConomy.iConomy;

//Singleton
public final class PluginHookManager extends ServerListener
{
	//TODO: Use a hash map with JavaPlugins?
	private iConomy iconomy = null;
	private ModDropPlugin plugin = null;
	private static PluginHookManager _instance = new PluginHookManager();
	
	private PluginHookManager()
	{
		
	}
	
	@Override
	public void onPluginEnable(PluginEnableEvent event)
	{
		if(!IsiConomyAvailable() && IsPluginSet())
		{
			Plugin icon = plugin.getServer().getPluginManager().getPlugin("iConomy");
			
			if(icon != null)
			{
				if(icon.isEnabled() && icon.getClass().getName().equals("com.iConomy.iConomy"))
				{
					this.iconomy = (iConomy)icon;
					System.out.println("[ModDropPlugin]: Enabled iConomy support.");
				}
			}
		}
	}
	
	@Override
	public void onPluginDisable(PluginDisableEvent event)
	{
		if(IsiConomyAvailable())
		{
			if(event.getPlugin().getDescription().getName().equals("iConomy"))
			{
				this.iconomy = null;
				System.out.println("[ModDropPlugin]: Un-hooked from iConomy.");
			}
		}
	}
	
	public boolean IsPluginSet()
	{
		return !(plugin == null);
	}
	
	public void setPlugin(ModDropPlugin plugin)
	{
		this.plugin = plugin;
	}
	
	public static PluginHookManager getInstance()
	{
		return _instance;
	}
	
	public boolean IsiConomyAvailable()
	{
		return !(iconomy == null);
	}
	
	public iConomy getiConomy() throws OperationNotSupportedException
	{
		if(IsiConomyAvailable())
		{
			return iconomy;
		}
		else
		{
			throw new OperationNotSupportedException("iConomy-support is not available.");
		}
	}
}
