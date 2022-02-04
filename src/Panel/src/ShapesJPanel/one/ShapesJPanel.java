package ShapesJPanel.one;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ShapesJPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(new GradientPaint(5, 30, Color.blue, 35, 100,
			Color.yellow, true));
		g2d.fill(new Ellipse2D.Double(5, 30, 65, 100));
		
		g2d.setPaint(Color.red);
		g2d.setStroke(new BasicStroke(10.0f));
		g2d.draw(new Rectangle2D.Double(80, 30, 65, 100));
		
		BufferedImage bufferedImage = 
			new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D gg = bufferedImage.createGraphics();
		gg.setColor(Color.yellow);
		gg.fillRect(0, 0, 10, 10);
		gg.setColor(Color.black);
		gg.drawRect(1, 1, 6, 6);
		gg.setColor(Color.blue);
		gg.fillRect(1, 1, 3, 3);
		gg.setColor(Color.red);
		gg.fillRect(4, 4, 3, 3);
		
		g2d.setPaint(new TexturePaint(bufferedImage, new Rectangle(10, 10)));
		g2d.fill(new RoundRectangle2D.Double(155, 30, 75, 100, 50, 50));
		
		g2d.setPaint(Color.white);
		g2d.setStroke(new BasicStroke(6.0f));
		g2d.draw(new Arc2D.Double(240, 30, 75, 100, 0, 270, Arc2D.PIE));
		
		g2d.setPaint(Color.green);
		g2d.draw(new Line2D.Double(395, 30, 320, 150));
		
		float[] dashes = {10};
		g2d.setPaint(Color.yellow);
		g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, 
			BasicStroke.JOIN_ROUND, 10, dashes, 0));
		g2d.draw(new Line2D.Double(320, 30, 395, 150));
	}
}