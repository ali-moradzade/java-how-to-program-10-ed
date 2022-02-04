package ManipulatingInvoiceStream;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProcessingInvoices
{
	public static void main(String[] args) 
	{
		Invoice[] invoices = {
			new Invoice(83, "Electric sander", 7, 57.98),
			new Invoice(24, "Power saw", 18, 99.99),
			new Invoice(7, "Sledge hammer", 11, 21.50),
			new Invoice(77, "Hammer", 76, 11.99),
			new Invoice(39, "Lawn mower", 3, 79.50),
			new Invoice(68, "Screwdriver", 106, 6.99),
			new Invoice(56, "Jig saw", 21, 11.00),
			new Invoice(3, "Wrench", 34, 7.50)
		};
		
		List<Invoice> list = Arrays.asList(invoices);
		
		System.out.printf("Invoices list sorted by part description:%n");
		list.stream()
			 .sorted(Comparator.comparing(Invoice::getPartDescription,
				 String.CASE_INSENSITIVE_ORDER))
			 .forEach(System.out::println);
		
		System.out.printf("%nInvoices list sorted by price:%n");
		list.stream()
			 .sorted(Comparator.comparing(Invoice::getPricePerItem))
			 .forEach(System.out::println);
		
		System.out.printf("%nPart descriptions:%n");
		list.stream()
			 .map(Invoice::getPartDescription)
			 .forEach(System.out::println);
		
		System.out.printf(
			"%nPart descriptions with quantity:%n");
		list.stream()
			 .sorted(Comparator.comparing(Invoice::getQuantity))
			 .collect(Collectors.groupingBy(Invoice::getPartDescription))
			 .forEach((partDescription, invoice) -> {
				 System.out.printf("%s ", partDescription);
				 invoice.forEach((i) -> System.out.println(i.getQuantity()));
			 });
		
		System.out.printf("%nPart descrtions and price amount:%n");
		list.stream()
			 .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
			 .collect(Collectors.groupingBy(Invoice::getPartDescription))
			 .forEach((partDescription, invoicesList) -> {
				 System.out.printf("%s ", partDescription);
				 
				 invoicesList.forEach(invoice -> 
					 System.out.printf("%.2f%n", invoice.getInvoiceAmount()));
			 });
	}
}
