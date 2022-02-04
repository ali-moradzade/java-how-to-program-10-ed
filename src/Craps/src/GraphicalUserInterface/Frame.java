package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener
{
	private final JPanel die1JPanel;
	private final JLabel die1JLabel;
	private final JTextField die1JTextField;
	
	private final JPanel die2JPanel;
	private final JLabel die2JLabel;
	private final JTextField die2JTextField;
	
	private final JPanel sumJPanel;
	private final JLabel sumJLabel;
	private final JTextField sumJTextField;
	
	private final JPanel pointJPanel;
	private final JLabel pointJLabel;
	private final JTextField pointJTextField;
	
	private final JButton rollJButton;
	
	private final JPanel centerJPanel;
	private final JPanel southJPanel;
	
	public Frame() 
	{
		super("Craps");
		
		centerJPanel = new JPanel(new GridLayout(4, 1));
		
		die1JPanel = new JPanel();
		die1JLabel = new JLabel("Die1: ");
		die1JTextField = new JTextField(10);
		die1JTextField.setEditable(false);
	
		die1JPanel.add(die1JLabel);
		die1JPanel.add(die1JTextField);
		
		die2JPanel = new JPanel();
		die2JLabel = new JLabel("Die2: ");
		die2JTextField = new JTextField(10);
		die2JTextField.setEditable(false);
		
		die2JPanel.add(die2JLabel);
		die2JPanel.add(die2JTextField);
		
		sumJPanel = new JPanel();
		sumJLabel = new JLabel("Sum: ");
		sumJTextField = new JTextField(10);
		sumJTextField.setEditable(false);
		
		sumJPanel.add(sumJLabel);
		sumJPanel.add(sumJTextField);
		
		pointJPanel = new JPanel();
		pointJLabel = new JLabel("Point: ");
		pointJTextField = new JTextField(10);
		pointJTextField.setEditable(false);
		
		pointJPanel.add(pointJLabel);
		pointJPanel.add(pointJTextField);
		
		centerJPanel.add(die1JPanel);
		centerJPanel.add(die2JPanel);
		centerJPanel.add(sumJPanel);
		centerJPanel.add(pointJPanel);
		
		add(centerJPanel);
		
		southJPanel = new JPanel();
		rollJButton = new JButton("Roll");
		rollJButton.addActionListener(this);
		
		southJPanel.add(rollJButton);
		
		add(southJPanel, BorderLayout.SOUTH);
	}
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	private enum Status {CONTINUE, WON, LOST};
	private enum Time {FIRST_TIME, SECOND_OR_MORE_TIME};
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	private int die1;
	private int die2;
	private int sum;
	private int point = 0;
	
	private Status gameStatus;
	private Time time = Time.FIRST_TIME;
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (time == Time.FIRST_TIME)
		{
			rollDice();

			switch (sum)
			{
				case SEVEN:
				case YO_LEVEN:
					gameStatus = Status.WON;
					break;
				case SNAKE_EYES:
				case TREY:
				case BOX_CARS:
					gameStatus = Status.LOST;
					break;
				default:
					gameStatus = Status.CONTINUE;
					point = sum;
					pointJTextField.setText(Integer.toString(point));
					break;
			}
		}
		
		if (time == Time.SECOND_OR_MORE_TIME)
		{
			rollDice();
			
			if (sum == point)
				gameStatus = Status.WON;
			else if (sum == SEVEN)
				gameStatus = Status.LOST;
		}
		
		if (gameStatus == Status.WON)
		{
			die1JPanel.setBackground(Color.green);
			die2JPanel.setBackground(Color.green);
			sumJPanel.setBackground(Color.green);
			pointJPanel.setBackground(Color.green);
			
			rollJButton.setEnabled(false);
		}
		else if (gameStatus == Status.LOST)
		{
			die1JPanel.setBackground(Color.red);
			die2JPanel.setBackground(Color.red);
			sumJPanel.setBackground(Color.red);
			pointJPanel.setBackground(Color.red);
			
			rollJButton.setEnabled(false);
		}
		else
		{
			die1JPanel.setBackground(Color.cyan);
			die2JPanel.setBackground(Color.cyan);
			sumJPanel.setBackground(Color.cyan);
			pointJPanel.setBackground(Color.cyan);
		}
		
		time = Time.SECOND_OR_MORE_TIME;
	}
	
	public void rollDice()
	{
		die1 = 1 + randomNumbers.nextInt(6);
		die1JTextField.setText(Integer.toString(die1));
		
		die2 = 1 + randomNumbers.nextInt(6);
		die2JTextField.setText(Integer.toString(die2));
		
		sum = die1 + die2;
		sumJTextField.setText(Integer.toString(sum));
	}
}
