package de.noonex.moddropplugin.configuration;

import de.noonex.moddropplugin.AbstractDrop;
import de.noonex.moddropplugin.WorldCondition;

public class WorldNode extends AbstractNode
{
	public WorldNode()
	{
		super("WorldNode");
	}

	@Override
	boolean IsPossibleChild(String name)
	{
		return name.equals("PermissionNode") || name.equals("BlockNode");
	}

	@Override
	boolean IsResponsible(String keyword)
	{
		return keyword.equalsIgnoreCase("in");
	}

	@Override
	void ExecuteNode(String parameter, AbstractDrop previousResult)
	{
		previousResult.AddCondition(new WorldCondition(parameter));
	}

}
