package de.noonex.moddropplugin.gui;

import javax.swing.SwingUtilities;

public class ModDropGUI_MainMethod
{	
	public static void main(String[] args)
	{
		Runnable gui = new Runnable()
		{			
			@Override
			public void run()
			{
				new ModDropGUI();
			}
		};
		
		SwingUtilities.invokeLater(gui);
	}
}
