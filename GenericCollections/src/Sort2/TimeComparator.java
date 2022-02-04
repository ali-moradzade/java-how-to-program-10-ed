package Sort2;

import java.util.Comparator;

public class TimeComparator implements Comparator<Time>
{
	@Override
	public int compare(Time time1, Time time2)
	{
		int hourDifference = time1.getHour() - time2.getHour();
		
		if (hourDifference != 0)
			return hourDifference;
		
		int minuteDifference = time1.getMinute() - time2.getMinute();
		
		if (minuteDifference != 0)
			return minuteDifference;
		
		return time1.getSecond() - time2.getSecond();
	}
}
