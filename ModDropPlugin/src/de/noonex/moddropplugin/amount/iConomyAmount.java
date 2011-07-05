package de.noonex.moddropplugin.amount;

public class iConomyAmount extends Amount
{
	Double moneyamount;
	
	public iConomyAmount(Double moneyamount)
	{
		this.moneyamount = moneyamount;
	}

	@Override
	public void Do(IAmountable amountable)
	{
		amountable.Do(moneyamount);
	}

}
