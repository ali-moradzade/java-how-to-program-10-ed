package Calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frame extends JFrame
{
	private final JTextField textField;
	private final JPanel buttonsJPanel;
	private static final String[] names = {"7", "8", "9", "/",
													  "4", "5", "6", "*",
													  "1", "2", "3", "-",
													  "0", ".", "=", "+"};
	private final JButton[] buttons;
	
	public Frame()
	{
		super("Calculator");
		
		textField = new JTextField();
		add(textField, BorderLayout.NORTH);
		
		buttonsJPanel = new JPanel(new GridLayout(4, 4, 5, 5));
		buttons =new JButton[names.length];
		
		for (int count = 0; count < names.length; count++)
		{
			buttons[count] = new JButton(names[count]);
			buttonsJPanel.add(buttons[count]);
		}
		
		add(buttonsJPanel);
	}
}
