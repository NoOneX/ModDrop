package de.noonex.moddropplugin.amount;

import java.util.Random;


public class NormalAmount extends Amount
{
	int probability;
	int amount;
	
	public NormalAmount(int amount, int probability)
	{
		this.probability = probability;
		this.amount = amount;
	}

	@Override
	public void Do(IAmountable amountable)
	{
		if(amount == 0)
		{
			return;
		}
		
		Random rnd = new Random();
		if (rnd.nextInt(100) <= probability * 100)
		{
			for (int i = 0; i < amount; i++)
			{
				// or null as parameter?
				amountable.Do(amount);
			}
		}
	}

}
