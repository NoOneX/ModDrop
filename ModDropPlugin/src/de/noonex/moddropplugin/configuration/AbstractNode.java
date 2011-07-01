package de.noonex.moddropplugin.configuration;
import de.noonex.moddropplugin.AbstractDrop;

public abstract class AbstractNode
{
	//TODO: Search an alternative
	protected final String name;
	
	public AbstractNode(String name)
	{
		this.name = name;
	}
	
	abstract boolean IsPossibleChild(String name);
	abstract boolean IsResponsible(String keyword);
	
	abstract void ExecuteNode(String parameter, AbstractDrop previousResult);
}
