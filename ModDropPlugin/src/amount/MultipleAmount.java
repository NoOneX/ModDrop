package amount;

import java.util.Random;

public class MultipleAmount extends Amount
{
	int[] amounts;
	Random rnd;
	int length;
	
	public MultipleAmount(int... amounts)
	{
		this.amounts = amounts;
		this.rnd = new Random();
		this.length = amounts.length;
	}

	@Override
	public void Do(IAmountable amountable)
	{
		int rndIndex = this.rnd.nextInt(this.length);
		
		for(int i = 0; i < amounts[rndIndex]; i++)
		{
			amountable.Do(amounts[rndIndex]);
		}
	}

}
