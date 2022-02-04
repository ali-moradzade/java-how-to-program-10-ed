package Fractals;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fractal extends JFrame
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 480;
	private static final int MIN_LEVEL = 0;
	private static final int MAX_LEVEL = 15;
	
	public Fractal()
	{
		super("Fractal");
		
		final JLabel levelJLabel = new JLabel("Level: 0");
		
		final FractalJPanel drawSpace = new FractalJPanel(0);
		
		final JPanel controlJPanel = new JPanel();
		
		final JButton changeColorJButton = new JButton("Color");
		controlJPanel.add(changeColorJButton);
		changeColorJButton.addActionListener(
			event -> 
			{
				Color color = JColorChooser.showDialog(
					this, "Choose a color", drawSpace.getColor());
				
				if (color == null)
					color = Color.blue;
				
				drawSpace.setColor(color);
				drawSpace.repaint();
			}
		);
		
		final JButton decreaseLevelJButton = new JButton("Decrease Level");
		controlJPanel.add(decreaseLevelJButton);
		decreaseLevelJButton.addActionListener(
			event ->
			{
				int level = drawSpace.getLevel();
				--level;
				
				if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL))
				{
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		);
		
		final JButton increaseLevelJButton = new JButton("Increase Level");
		controlJPanel.add(increaseLevelJButton);
		increaseLevelJButton.addActionListener(
			event ->
			{
				int level = drawSpace.getLevel();
				++level;
				
				if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL))
				{
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		);
		
		controlJPanel.add(levelJLabel);
		
		final JPanel mainJPanel = new JPanel();
		mainJPanel.add(controlJPanel);
		mainJPanel.add(drawSpace);
		
		add(mainJPanel);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Fractal demo = new Fractal();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
