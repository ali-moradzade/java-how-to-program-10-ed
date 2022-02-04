package ScreenSaverPanel1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaverPanel extends JPanel implements ActionListener
{
	private Timer timer;
	
	public ScreenSaverPanel()
	{
		timer = new Timer(1000, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();
		
		for (int i = 0; i < 100; i++)
		{
			Color color = new Color(random.nextInt(256), random.nextInt(256), 
				random.nextInt(256));
			g2d.setColor(color);
			
			BasicStroke basicStroke = new BasicStroke(5 + 20 * random.nextFloat());
			g2d.setStroke(basicStroke);
			
			g2d.draw(new Line2D.Double(random.nextInt(getWidth()), 
				random.nextInt(getHeight()), random.nextInt(getWidth()),
				random.nextInt(getHeight())));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
