package Fractals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.PI;
import javax.swing.JPanel;

public class FractalJPanel extends JPanel
{
	private Color color;
	private int level;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public FractalJPanel(int currentLevel)
	{
		color = Color.blue;
		level = currentLevel;
		
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics2D g)
	{
		if (level == 0)
			g.drawLine(xA, yA, xB, yB);
		else
		{
			int xC = (xA + xB) / 2;
			int yC = (yA + yB) / 2;
			
			int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
			int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
			
			drawFractal(level - 1, xD, yD, xA, yA, g);
			drawFractal(level - 1, xD, yD, xC, yC, g);
			drawFractal(level - 1, xD, yD, xB, yB, g);
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(color);
		g2d.translate(200, 200);
		
		for (int i = 0; i < 20; i++)
		{
			g2d.rotate(2 * PI / 5);
			drawFractal(level, 0, 0, 100, 100, g2d);
		}
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setLevel(int currentLevel)
	{
		level = currentLevel;
	}
	
	public int getLevel()
	{
		return level;
	}
}
