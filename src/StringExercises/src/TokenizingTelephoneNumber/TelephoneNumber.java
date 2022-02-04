package TokenizingTelephoneNumber;

public class TelephoneNumber
{
	private final String areaCode;
	private final String threeDigits;
	private final String fourDigits;
	
	public TelephoneNumber(String specificFormCode)
	{
		String[] tokens = specificFormCode.split("\\s+");
		
		areaCode = tokens[0].substring(1, 4);
		
		threeDigits = tokens[1].substring(0, 3);
		fourDigits = tokens[1].substring(4, 8);
	}

	public int getAreaCode()
	{
		return Integer.parseInt(areaCode);
	}

	public int getPhoneNumber()
	{
		return Integer.parseInt(threeDigits + fourDigits);
	}
	
	public int getThreeDigits()
	{
		return Integer.parseInt(threeDigits);
	}
	
	public int getFourDigits()
	{
		return Integer.parseInt(fourDigits);
	}
}
