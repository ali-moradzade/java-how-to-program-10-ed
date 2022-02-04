package ScreenSaverPanel2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ScreenSaverPanel extends JPanel implements ActionListener
{
	private final Timer timer;
	private int number;
	private final JTextField textField;
	
	public ScreenSaverPanel(JTextField textField1)
	{
		timer = new Timer(1000, this);
		timer.start();
		
		number = 10;
		textField = textField1;
		textField.addMouseListener(new MouseHandler());
		textField.setText("10");
		textField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						number = Integer.parseInt(textField.getText());
					}
					catch(Exception exception)
					{
						System.err.println(exception);
						exception.printStackTrace(System.err);
					}
					
					timer.start();
				}
			}
		);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();
		
		for (int i = 0; i < number; i++)
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
	public void actionPerformed(ActionEvent event)
	{
		number = Integer.parseInt(textField.getText());
		repaint();
	}
	
	private class MouseHandler extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			timer.stop();
		}
	}
}
