package SelectingShapesPanel1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SelectingShapesPanel extends JPanel 
{
	private final JComboBox<String> comboBox;
	private final Random random;
	private int currentShape;
	
	private static final String[] shapes =
		{"Line", "Rectangel", "Oval", "Arc"};
	
	private static final int LINE = 0;
	private static final int RECTANGLE = 1;
	private static final int OVAL = 2;
	private static final int ARC = 3;
	
	private static final int NUMBER_OF_SHAPES = 20;
	
	public SelectingShapesPanel()
	{
		comboBox = new JComboBox<>(shapes);
		comboBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
						currentShape = comboBox.getSelectedIndex();
						repaint();
					}
				}
			}
		);
		
		random = new Random();
		currentShape = LINE;
		setBackground(Color.white);
	}
	
	public JComboBox<String> getComboBox()
	{
		return comboBox;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < NUMBER_OF_SHAPES; i++)
		{
			BasicStroke basicStroke = new BasicStroke(1.0f + 10 * random.nextFloat());
			g2d.setStroke(basicStroke);

			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), 
				random.nextInt(256)));
			
			int width = getWidth();
			int height = getHeight();

			int x = random.nextInt(width);
			int y = random.nextInt(height);
			boolean filled = random.nextBoolean();

			if (currentShape == LINE)
			{
				int x2 = random.nextInt(width);
				int y2 = random.nextInt(height);

				g2d.draw(new Line2D.Double(x, y, x2, y2));
			}
			else
			{
				int  randomWidth = random.nextInt(width);
				int  randomHeight = random.nextInt(height);

				randomWidth = (randomWidth + x > width) ? width - x - 5: randomWidth;
				randomHeight = (randomHeight + y > height) ? height - y - 5 : randomHeight;

				switch (currentShape)
				{
					case RECTANGLE:

						if (filled)
							g2d.fill(new Rectangle2D.Double(x, y, randomWidth, randomHeight));
						else
							g2d.draw(new Rectangle2D.Double(x, y, randomWidth, randomHeight));
						break;
					case OVAL:

						if (filled)
							g2d.fill(new Ellipse2D.Double(x, y, randomWidth, randomHeight));
						else
							g2d.draw(new Ellipse2D.Double(x, y, randomWidth, randomHeight));
						break;
					case ARC:
						int style = random.nextInt(3);

						int start = random.nextInt(360);
						int sweep = random.nextInt(360);

						if (filled)
							g2d.fill(new Arc2D.Double(x, y, randomWidth, randomWidth,
								start, sweep, style));
						else	
							g2d.draw(new Arc2D.Double(x, y, randomWidth, randomWidth,
								start, sweep, style));
						break;
				}
			}
		}
	}
	
//	private void changeCurrentShape()
//	{
//		switch (random.nextInt(4))
//		{
//			case LINE:
//				currentShape = LINE;
//				break;
//			case RECTANGLE:
//				currentShape = RECTANGLE;
//				break;
//			case OVAL:
//				currentShape = OVAL;
//				break;
//			case ARC:
//				currentShape = ARC;
//				break;
//		}
//	}
}