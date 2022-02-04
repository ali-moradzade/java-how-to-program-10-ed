import java.util.Scanner;

public class InvoiceTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter part number:");
		String partNumber = input.nextLine();
		
		System.out.println("Enter part description:");
		String partDescription = input.nextLine();
		
		System.out.print("Enter quantity of items being purchased: ");
		int quantity = input.nextInt();
		
		System.out.print("Enter price per item: ");
		double pricePerItem = input.nextDouble();
		
		Invoice invoice =
			new Invoice(partNumber, partDescription, quantity, pricePerItem);
		
		System.out.printf("%nAbout our invoice we have:%n");
		System.out.printf("%s%s%n%s%s%n%s%d%n%s%.2f%n%s%.2f%n",
			"Part number: ", invoice.getPartNumber(),
			"Part description: ", invoice.getPartDescription(),
			"Quntity of items: ", invoice.getQuantity(),
			"Price per item: ", invoice.getPricePerItem(),
			"-> Invoice amount: ", invoice.getInvoiceAmount());
	}
}
