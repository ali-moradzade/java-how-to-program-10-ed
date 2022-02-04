package CubesPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

public class CubesPanel extends JPanel
{
	private final int firstPointX;
	private final int firstPointY;
	private final int width;
	private final int length;
	private final int widthChange;
	private final int lengthChange;
	
	public CubesPanel(int firstPointX, int firstPointY, int width,
		int length, int widthChange, int lengthChange)
	{
		if (firstPointX < 0 || firstPointY < 0)
			throw new IllegalArgumentException("first point x and/ or y must be >= 0");
		
		if (width <= 0 || length <= 0)
			throw new IllegalArgumentException(
				"width and/or length must be > 0");
		
		if (widthChange <= 0 || lengthChange <= 0)
			throw new IllegalArgumentException(
				"width change and/or length change must be > 0");
				
		this.firstPointX = firstPointX;
		this.firstPointY = firstPointY;
		this.width = width;
		this.length = length;
		this.widthChange = widthChange;
		this.lengthChange = lengthChange;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		GeneralPath cube = new GeneralPath();
		
		int[] xValues = {firstPointX, firstPointX + length,
			firstPointX + length,	firstPointX};
		int[] yValues = {firstPointY, firstPointY, 
			firstPointY + width, firstPointY + width};
		
		int[] xValues2 = {firstPointX + lengthChange, firstPointX + length + lengthChange,
			firstPointX + length + lengthChange,	firstPointX + lengthChange};
		int[] yValues2 = {firstPointY + widthChange, firstPointY + widthChange, 
			firstPointY + width + widthChange, firstPointY + width + widthChange};
		
		cube.moveTo(xValues[0], yValues[0]);
		
		for (int i = 0; i < xValues.length; i++)
		{
			cube.lineTo(xValues2[i], yValues2[i]);
			
			int next = (i + 1 < xValues.length) ? i + 1 : 0;
			cube.lineTo(xValues2[next], yValues2[next]);
			
			cube.moveTo(xValues[i], yValues[i]);
			cube.lineTo(xValues[next], yValues[next]);
		}
		
		g2d.draw(cube);
	}
}
