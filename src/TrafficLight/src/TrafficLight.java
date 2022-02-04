public enum TrafficLight
{
	GREEN(10),
	YELLOW(2),
	RED(50);
	
	private final int duration;
	
	TrafficLight(int duration)
	{
		this.duration = duration;
	}
	
	public int getDuration()
	{
		return duration;
	}
}
