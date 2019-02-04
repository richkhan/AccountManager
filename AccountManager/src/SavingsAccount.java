
public class SavingsAccount extends Account{
	
	
	public SavingsAccount(String acctName, String startAmount)
	{
		super(acctName, startAmount);
		this.deposit("10.00");
	}
	
	@Override
	public String toString()
	{
		return "Savings Account " + super.toString();
	}
}
