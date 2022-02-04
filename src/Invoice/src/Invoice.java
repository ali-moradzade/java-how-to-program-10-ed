public class Invoice
{
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;

	public Invoice(String partNumber, String partDescription, 
		int quantity, double pricePerItem)
	{
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}

	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}

	public String getPartNumber()
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
}
