package ArcsJPanel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ArcsJPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.white);
		
		g.setColor(Color.red);
		g.drawRect(15, 35, 80, 80);
		g.setColor(Color.black);
		g.drawArc(15, 35, 80, 80, 0, 360);
		
		g.setColor(Color.red);
		g.drawRect(100, 35, 80, 80);
		g.setColor(Color.black);
		g.drawArc(100, 35, 80, 80, 0, 110);
		
		g.setColor(Color.red);
		g.drawRect(185, 35, 80, 80);
		g.setColor(Color.black);
		g.drawArc(185, 35, 80, 80, 0, -270);
		
		g.fillArc(15, 120, 80, 40, 0, 360);
		g.fillArc(100, 120, 80, 40, 270, -90);
		g.fillArc(185, 120, 80, 40, 0, -270);
	}
}