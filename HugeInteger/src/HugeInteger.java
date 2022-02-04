public class HugeInteger
{
	private final int[] digits;
	private int length;
	
	public HugeInteger()
	{
		digits = new int[40];
		length = digits.length;
	}
	
	public void parse(String number)
	{
		length = Math.min(number.length(), digits.length);
		
		for (int digit = 0; digit < length; digit++)
		{
			digits[digit] = Integer.parseInt(
				Character.toString(number.charAt(digit)));
		}
	}
	
	public HugeInteger add(HugeInteger number)
	{
		HugeInteger result = new HugeInteger();
		
		for (int i = 0; i < digits.length - 1; i++)
		{
			int digit = digits[i] + number.digits[i];
			
			if (digit >= 10)
			{
				result.digits[i] += digit % 10;
				result.digits[i + 1] += 1;
			}
			else
				result.digits[i] = digit;
		}
		
		return result;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder("");
		
		for (int i = 0; i < length; i++)
		{
			builder.append(digits[i]);
		}
		return builder.toString();
	}
}
