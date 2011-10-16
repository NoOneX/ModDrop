package de.noonex.moddropplugin;

import javax.naming.OperationNotSupportedException;

import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;
import org.bukkit.plugin.Plugin;

import com.nijikokun.register.Register;

//Singleton
public final class PluginHookManager extends ServerListener
{
	//TODO: Use a hash map with Plugins?
	private Register register = null;
	private ModDropPlugin plugin = null;
	private static PluginHookManager _instance = new PluginHookManager();
	
	private PluginHookManager()
	{
		
	}
	
	@Override
	public void onPluginEnable(PluginEnableEvent event)
	{
		if(!IsRegisterAvailable() && IsPluginSet())
		{
			Plugin reg = plugin.getServer().getPluginManager().getPlugin("Register");
			
			if(reg != null)
			{
				if(reg.isEnabled() && reg.getClass().getName().equals("com.nijikokun.register.Register"))
				{
					this.register = (Register)reg;
					System.out.println("[ModDropPlugin]: Enabled economy support.");
				}
			}
		}
	}
	
	@Override
	public void onPluginDisable(PluginDisableEvent event)
	{
		if(IsRegisterAvailable())
		{
			if(event.getPlugin().getDescription().getName().equals("Register"))
			{
				this.register = null;
				System.out.println("[ModDropPlugin]: Disabled economy support.");
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
	
	public boolean IsRegisterAvailable()
	{
		//TODO: Use another method?
		return !(register == null);
	}
	
	public Register getRegister() throws OperationNotSupportedException
	{
		if(IsRegisterAvailable())
		{
			return register;
		}
		else
		{
			throw new OperationNotSupportedException("Economy-support is not available.");
		}
	}
}
