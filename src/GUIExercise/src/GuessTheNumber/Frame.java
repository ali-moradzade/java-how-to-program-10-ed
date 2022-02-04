package GuessTheNumber;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	private final JLabel demo1JLabel;
	private final JPanel centerJPanel;
	private final JLabel demo2JLabel;
	private final JTextField textField;
	private final JLabel instructionJLabel;
	private final JPanel southJPanel;
	private final JButton playAgainJButton;
	private final GuessTheNumber guessTheNumber;
	
	public Frame()
	{
		super("Guess the Number Game");
		
		guessTheNumber = new GuessTheNumber();
		
		demo1JLabel = new JLabel(
			"I have a number between 1 and 1000. Can you guess my number?");
		add(demo1JLabel, BorderLayout.NORTH);
		
		centerJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		demo2JLabel = new JLabel("Please enter your first guess.");
		centerJPanel.add(demo2JLabel);
		
		textField = new JTextField(15);
		centerJPanel.add(textField);
		textField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						int number = Integer.parseInt(textField.getText());
						int result = guessTheNumber.getTheNumber(number);
						
						switch (result)
						{
							case Guess.CORRECT:
								textField.setEditable(false);
								textField.setText("Correct!");
								centerJPanel.setBackground(Color.green);
								instructionJLabel.setText("Correct :)");
								break;
							case Guess.TOO_LOW:
								instructionJLabel.setText("Too Low");
								centerJPanel.setBackground(Color.red);
								break;
							case Guess.TOO_HIGH:
								instructionJLabel.setText("Too High");
								centerJPanel.setBackground(Color.cyan);
								break;
						}
					}
					catch (Exception exception)
					{
						System.err.println(exception);
						exception.printStackTrace(System.err);
					}
				}
			}
		);
		
		instructionJLabel = new JLabel("   ");
		centerJPanel.add(instructionJLabel);
		
		add(centerJPanel);
		
		southJPanel = new JPanel();
		playAgainJButton = new JButton("Play Again");
		playAgainJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					textField.setEditable(true);
					textField.setText("");
					centerJPanel.setBackground(Color.white);
					instructionJLabel.setText("   ");
					guessTheNumber.startNewGame();
				}
			}
		);
		
		southJPanel.add(playAgainJButton);
		add(southJPanel, BorderLayout.SOUTH);
	}
}
