package three;

public class PayableInterfaceTest
{
	public static void main(String[] args)
	{
		SalariedEmployee salariedEmployee = 
			new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = 
			new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee =
			new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = 
			new BasePlusCommissionEmployee(
				"Bob", "Lewis", "444-44-4444", 5000, .04, 300);
		Invoice invoice1 = new Invoice("01234", "seat", 2, 375.00);
		Invoice invoice2 = new Invoice("56789", "tire", 4, 79.95);
		
		Payable[] payableObjects = new Payable[6];
		
		payableObjects[0] = salariedEmployee;
		payableObjects[1] = hourlyEmployee;
		payableObjects[2] = commissionEmployee;
		payableObjects[3] = basePlusCommissionEmployee;
		payableObjects[4] = invoice1;
		payableObjects[5] = invoice2;
		
		System.out.println("Payables processed polymorphically:\n");
		
		for (Payable currentPayable : payableObjects)
		{
			System.out.println(currentPayable);
			
			if (currentPayable instanceof BasePlusCommissionEmployee)
			{
				BasePlusCommissionEmployee employee = 
					(BasePlusCommissionEmployee) currentPayable;
				
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n",
					employee.getBaseSalary());
			}
			
			System.out.printf("paied $%,.2f%n%n", currentPayable.getPaymentAmount());
		}
		
		for (int j = 0; j < payableObjects.length; j++)
		{
			System.out.printf("Employee %d is a %s%n",
				j, payableObjects[j].getClass().getName());
		}
	}
}
