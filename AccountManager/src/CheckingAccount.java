import java.math.BigDecimal;

public class CheckingAccount extends Account{
	private int numberOfSigs;
	private static final BigDecimal minBalance = new BigDecimal("100.00");
	
	public CheckingAccount(String acctName, String startAmount, int sigs)
	{
		super(acctName, startAmount);
		this.setNumberOfSigs(sigs);
	}
	
	
	public int getNumberOfSigs()
	{
		return numberOfSigs;
	}
	
	public void setNumberOfSigs(int sigs)
	{
		this.numberOfSigs = sigs;
	}
	
	@Override
	public void withdraw(String withdrawal) 
	{
		BigDecimal desiredAmount = new BigDecimal(withdrawal);
		
		// if withdrawal would put that balance below the minimum
		// throw an exception
		
		if (this.getAmount().compareTo(desiredAmount.add(minBalance)) < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.withdraw(withdrawal);
		}
	}
	
	@Override
	public String toString()
	{
		return "Checking Acount " + super.toString();
	}
	
}

