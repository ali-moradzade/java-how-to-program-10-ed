package ManipulatingInvoiceStream;

public class Invoice
{
	private int partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;

	public Invoice(int partNumber, String partDescription, 
		int quantity, double pricePerItem)
	{
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}

	public void setPartNumber(int partNumber)
	{
		this.partNumber = partNumber;
	}

	public int getPartNumber()
	{
		return partNumber;
	}

	public void setPartDescription(String partDescription)
	{
		this.partDescription = partDescription;
	}

	public String getPartDescription()
	{
		return partDescription;
	}

	public void setQuantity(int quantity)
	{
		if (quantity > 0)
			this.quantity = quantity;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setPricePerItem(double pricePerItem)
	{
		if (pricePerItem > 0.0)
			this.pricePerItem = pricePerItem;
	}

	public double getPricePerItem()
	{
		return pricePerItem;
	}
	
	public double getInvoiceAmount()
	{
		return getPricePerItem() * getQuantity();
	}
	
	public double getPaymentAmount()
	{
		return getQuantity() * getPricePerItem();
	}
	
	@Override
	public String toString()
	{
		return String.format("%2d  %-15s %5d %7.2f",
			getPartNumber(), getPartDescription(), getQuantity(), getPricePerItem());
	}
}
