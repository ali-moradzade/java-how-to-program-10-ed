package two;

public class PolymorphismTest
{
	public static void main(String[] args)
	{
		CommissionEmployee commissionEmployee =
			new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);
		
		BasePlusCommissionEmployee basePlusCommissionEmployee = 
			new BasePlusCommissionEmployee(
				"Bob", "Lewis", "333-33-3333", 5000, .04, 3000);
		
		System.out.printf("%s %s:%n%n%s%n%n",
			"Call commissionEmployee's toString with superclass reference ",
			"to superclass object", commissionEmployee);
		
		System.out.printf("%s %s:%n%n%s%n%n",
			"Call BasePlusCommissionEmployee's toString with subclass",
			"reference to subclass object", basePlusCommissionEmployee);
		
		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		System.out.printf("%s %s:%n%n%s%n",
			"Call BasePluscommissionEmployee's toString with superclass", 
			"reference to subclass object", commissionEmployee2);
	}
}