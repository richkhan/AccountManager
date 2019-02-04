import java.math.BigDecimal;

public abstract class Account {
	private String name;
	private BigDecimal amount;
	
	public Account(String acctName, String startAmount)
	{
		this.setName(acctName);
		this.setAmount(startAmount);
		this.amount.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("Account Created: " + this.getName());
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public BigDecimal getAmount()
	{
		return this.amount;
	}
	
	public void setName(String newName)
	{
		String pattern = "^[a-zA-Z0-9]*$";
		if(newName.matches(pattern))
		{
			this.name = newName;
		}
		
	}
	
	
	public void setAmount(String newAmount)
	{
		this.amount = new BigDecimal(newAmount);
	}
	
	public void withdraw (String withdrawal) throws IllegalArgumentException
	{
		BigDecimal desiredAmount = new BigDecimal(withdrawal);
		
		// if desired amount is negative, throw an exception
		if (desiredAmount.compareTo(BigDecimal.ZERO) < 0)
		{
			throw new IllegalArgumentException();
		}
		
		// if the amount is less than the desired amount, throw an exception 
		if (this.getAmount().compareTo(desiredAmount) < 0)
		{
			this.setAmount(this.getAmount().subtract(desiredAmount).toString());
		}
	}
	
	public void deposit (String deposit) throws IllegalArgumentException
	{
		BigDecimal desiredAmount = new BigDecimal(deposit);
		
		// if desired amount is negative, throw an exception
		if (desiredAmount.compareTo(BigDecimal.ZERO) < 0)
		{
			throw new IllegalArgumentException();
		}
		
		this.setAmount(this.getAmount().add(desiredAmount).toString());
		System.out.println("Deposit: " + this);

	}
	
	@Override
	public String toString()
	{
		return this.getName() + ": Balance = " + this.getAmount();
	}

}
