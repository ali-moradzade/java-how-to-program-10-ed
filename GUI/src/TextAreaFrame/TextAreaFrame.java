package TextAreaFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame
{
	private final JTextArea textArea1;
	private final JTextArea textArea2;
	private final JButton copyJButton;
	
	public TextAreaFrame()
	{
		super("TextArea Demo");
		Box box = Box.createHorizontalBox();
		
		String demo = String.format("%s%n%s%n%s%n%s%n%s%n",
			"This is a demo string to",
			"illustrate copying text",
			"from one textarea to ",
			"another textarea using an",
			"external event");
		
		textArea1 = new JTextArea(demo, 10, 15);
		box.add(new JScrollPane(textArea1));
		
		copyJButton = new JButton("Copy >>>");
		copyJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					textArea2.setText(textArea1.getSelectedText());
				}
			}
		);
		
		box.add(copyJButton);
		
		textArea2 = new JTextArea(10, 15);
		textArea2.setEditable(false);
		textArea2.setLineWrap(true);
		box.add(new JScrollPane(textArea2));
		
		add(box);
	}
}