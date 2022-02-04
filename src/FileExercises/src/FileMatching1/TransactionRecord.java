package FileMatching1;

public class TransactionRecord
{
	private int accountNumber;
	private double amount;
	
	public TransactionRecord(int accountNumber, double amount)
	{
		if (accountNumber <= 0)
			throw new IllegalArgumentException("account number must be > 0");
		
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public void setAccountNumber(int accountNumber)
	{
		if (accountNumber <= 0)
			throw new IllegalArgumentException("account number must be > 0");
		
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public double getAmount()
	{
		return amount;
	}
}
