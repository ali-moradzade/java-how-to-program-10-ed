package best;

public class Invoice implements Payable
{
	private final String partNumber;
	private final String partDescription;
	private double pricePerItem;
	private int quantity;

	public Invoice(String partNumber, String partDescription, double pricePerItem, int quantity)
	{
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException("price per item must be >= 0.0");
		
		if (quantity < 0)
			throw new IllegalArgumentException("quantity must be >= 0");
		
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.pricePerItem = pricePerItem;
		this.quantity = quantity;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public String getPartDescription()
	{
		return partDescription;
	}

	public void setPricePerItem(double pricePerItem)
	{
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException("price per item must be >= 0.0");
		
		this.pricePerItem = pricePerItem;
	}

	public double getPricePerItem()
	{
		return pricePerItem;
	}

	public void setQuantity(int quantity)
	{
		if (quantity < 0)
			throw new IllegalArgumentException("quantity must be >= 0");
		
		this.quantity = quantity;
	}

	public int getQuantity()
	{
		return quantity;
	}

	@Override
	public double getPaymentAmount()
	{
		return getQuantity() * getPricePerItem();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s:%n%s: %s (%s)%n%s: $%,.2f%n%s: %d",
			"Ivoice",
			"part number", getPartNumber(), getPartDescription(),
			"price per item", getPricePerItem(),
			"quantity", getQuantity());
	}
}
