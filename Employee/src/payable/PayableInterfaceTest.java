package payable;

public class PayableInterfaceTest
{
	public static void main(String[] args)
	{
		Payable[] payablesObjects = new Payable[4];
		
		payablesObjects[0] = new Invoice("01234", "seat", 2, 375.00);
		payablesObjects[1] = new Invoice("56789", "tire", 4, 79.95);
	
		payablesObjects[2] =
			new SalariedEmployee("John", "Smith", "111-11-1111", 800);
		payablesObjects[3] =
			new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00);
		
		System.out.println("Invoices and Employees processed polymorphically:");
		
		for (Payable currentPayable : payablesObjects)
		{
			System.out.printf("%n%s%n%s: $%,.2f%n",
				currentPayable,
				"payment due", currentPayable.getPaymentAmount());
		}
	}
}
