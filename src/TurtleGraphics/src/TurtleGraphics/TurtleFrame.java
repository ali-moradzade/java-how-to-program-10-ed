package TurtleGraphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TurtleFrame extends JFrame implements KeyListener
{
	private final TurtleGraphicsPanel panel;
	private final JTextArea textArea;
	private final JButton pressPenJButton;
	
	private final JButton upJButton;
	private final JButton rightJButton;
	private final JButton downJButton;
	private final JButton leftJButton;
	
	private final Color originalColor;
	private final Color highlightColor;
	
	public TurtleFrame()
	{
		textArea = new JTextArea(4, 20);
		textArea.setEditable(false);

		panel = new TurtleGraphicsPanel(textArea);
		
		pressPenJButton = new JButton("Press Pen");
		pressPenJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					panel.changePen();
				}
			}
		);
		
		upJButton = new JButton("Up");
		upJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					moveToUp();
				}
			}
		);
		
		originalColor = upJButton.getBackground();
		highlightColor = Color.gray;
		
		rightJButton = new JButton("Right");
		rightJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					moveToDown();
				}
			}
		);
		
		leftJButton = new JButton("Left");
		leftJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					moveToLeft();
				}
			}
		);
		
		downJButton = new JButton("Down");
		downJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					moveToDown();
				}
			}
		);
		
		JPanel southJPanel = new JPanel();
		southJPanel.add(textArea);
		southJPanel.add(pressPenJButton);
		
		JPanel buttonsJPanel = new JPanel(new BorderLayout());
		buttonsJPanel.add(upJButton, BorderLayout.NORTH);
		buttonsJPanel.add(rightJButton, BorderLayout.EAST);
		buttonsJPanel.add(downJButton, BorderLayout.SOUTH);
		buttonsJPanel.add(leftJButton, BorderLayout.WEST);
		
		southJPanel.add(buttonsJPanel);
		
		add(panel, BorderLayout.CENTER);
		add(southJPanel, BorderLayout.SOUTH);
		
		textArea.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				upJButton.setBackground(highlightColor);
				moveToUp();
				break;
			case KeyEvent.VK_RIGHT:
				rightJButton.setBackground(highlightColor);
				moveToRight();
				break;
			case KeyEvent.VK_DOWN:
				downJButton.setBackground(highlightColor);
				moveToDown();
				break;
			case KeyEvent.VK_LEFT:
				leftJButton.setBackground(highlightColor);
				moveToLeft();
				break;
			case KeyEvent.VK_SPACE:
				pressPenJButton.setBackground(highlightColor);
				panel.changePen();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				upJButton.setBackground(originalColor);
				break;
			case KeyEvent.VK_RIGHT:
				rightJButton.setBackground(originalColor);
				break;
			case KeyEvent.VK_DOWN:
				downJButton.setBackground(originalColor);
				break;
			case KeyEvent.VK_LEFT:
				leftJButton.setBackground(originalColor);
			case KeyEvent.VK_SPACE:
				pressPenJButton.setBackground(originalColor);
				break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	private void moveToUp()
	{
		panel.changeDirection(TurtleGraphicsPanel.Direction.UP);
		panel.move();
	}
	
	private void moveToRight()
	{
		panel.changeDirection(TurtleGraphicsPanel.Direction.RIGHT);
		panel.move();
	}
	
	private void moveToDown()
	{
		panel.changeDirection(TurtleGraphicsPanel.Direction.DOWN);
		panel.move();
	}
	
	private void moveToLeft()
	{
		panel.changeDirection(TurtleGraphicsPanel.Direction.LEFT);
		panel.move();	
	}
}
