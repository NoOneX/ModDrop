package de.noonex.moddropplugin.configuration;

import java.util.regex.Pattern;

import de.noonex.moddropplugin.drops.AbstractDrop;

public class AmountNode extends AbstractNode
{

	public AmountNode()
	{
		super("AmountNode");
	}

	@Override
	boolean IsPossibleChild(String name)
	{
		return false;
	}

	@Override
	boolean IsResponsible(String keyword)
	{
		// TODO Auto-generated method stub
		Pattern regex = Pattern.compile("^(amount:*[0-9]$)");
		return regex.matcher(keyword).find();
	}

	@Override
	void ExecuteNode(String parameter, AbstractDrop previousResult)
	{
		// TODO Auto-generated method stub

	}

}
