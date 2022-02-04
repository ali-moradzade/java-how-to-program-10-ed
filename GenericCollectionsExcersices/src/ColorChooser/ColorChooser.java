package ColorChooser;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorChooser
{
	private final Map<String, Color> map;
	private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
		Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
		Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	private static final String[] colorNames = {"black", "blue", "cyan", "darkGray", "gray", "green",
		"lightGray", "magenta", "orange", "pink", "red", "white", "yellow"};
	private static final String[] colorsUppercaseNames = {"BLACK", "BLUE", "CYAN",
		"DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK",
		"RED", "WHITE", "YELLOW"};
		
	public ColorChooser()
	{
		map = new HashMap<>();
		
		for (int i = 0; i < colors.length; i++)
		{
			map.put(colorNames[i], colors[i]);
		}
		
		for (int i = 0; i < colors.length; i++)
		{
			map.put(colorsUppercaseNames[i], colors[i]);
		}
	}
	
	public Map<String, Color> getMap()
	{
		return map;
	}
}
