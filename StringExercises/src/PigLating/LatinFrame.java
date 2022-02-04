package PigLating;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LatinFrame extends JFrame
{
	private final JTextField textField;
	private final JTextArea textArea;
	
	public LatinFrame()
	{
		super("Converting to pig latin");
		
		textField = new JTextField();
		textField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (textArea.getText().equals(""))
						textArea.setText(PigLatin.makePigLatin(textField.getText()));
					else
						textArea.setText(textArea.getText() + "\n" + 
							PigLatin.makePigLatin(textField.getText()));
				}
			}
		);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		add(textField, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
	}
}
