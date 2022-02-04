package PaintPanel;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel
{
	private final ArrayList<Point> points;
	
	public PaintPanel()
	{
		points = new ArrayList<>();
		
		addMouseMotionListener(
			new MouseMotionAdapter()
			{
				@Override
				public void mouseDragged(MouseEvent e)
				{
					points.add(e.getPoint());
					repaint();
				}
			}
		);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (Point point : points)
		{
			g.fillOval(point.x, point.y, 4, 4);
		}
	}
}
