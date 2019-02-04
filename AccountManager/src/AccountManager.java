
public class AccountManager {
	
	
	public static void main (String [] args )
	{
		
		Account mySavings = new SavingsAccount("Save001","10.00"); // creates an instance from subclass SavingsAccount
		try {
			
			mySavings.withdraw("5.00");
		}
		catch (IllegalArgumentException e)
		{
			System.err.println("Invalid Withdrawal");
		}
		
		Account myChecking = new CheckingAccount ("Check002", "10.00", 1); // creates an instance from subclass CheckingAccount
		
		try {
			myChecking.withdraw("5.00");
		}
		catch (IllegalArgumentException e)
		{
			System.err.println("Invalid Withdrawal");
		}
		
		
	}
}
