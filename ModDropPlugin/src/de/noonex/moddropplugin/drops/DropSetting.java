package de.noonex.moddropplugin.drops;

public class DropSetting 
{
	private AbstractDrop drop;
	private int blockId;
	
	public DropSetting(AbstractDrop drop, int blockId)
	{
		this.drop = drop;
		this.blockId = blockId;
	}
	
	public AbstractDrop getDrop()
	{
		return drop;
	}
	
	public void setDrop(AbstractDrop drop)
	{
		this.drop = drop;
	}
	
	public int getBlockId()
	{
		return blockId;
	}
	
	public void setBlockId(int blockId)
	{
		this.blockId = blockId;
	}
}
