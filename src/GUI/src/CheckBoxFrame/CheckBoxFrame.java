package CheckBoxFrame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame
{
	private final JTextField textField;
	private final JCheckBox boldJCheckBox;
	private final JCheckBox italicJCheckBox;
	
	private static final int SIZE = 14;
	private static final String FONT_NAME = "Serif";
	
	public CheckBoxFrame()
	{
		super("JCheckBox Test");
		setLayout(new FlowLayout());
		
		textField = new JTextField("Watch the font syle change", 20);
		textField.setFont(new Font(FONT_NAME, Font.PLAIN, SIZE));
		add(textField);
		
		boldJCheckBox = new JCheckBox("Bold");
		add(boldJCheckBox);
		
		italicJCheckBox = new JCheckBox("Italic");
		add(italicJCheckBox);
		
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);
	}
	
	private class CheckBoxHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{
			int style;
			
			if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
				style = Font.BOLD + Font.ITALIC;
			else if (boldJCheckBox.isSelected())
				style = Font.BOLD;
			else if (italicJCheckBox.isSelected())
				style = Font.ITALIC;
			else
				style = Font.PLAIN;
				
			textField.setFont(new Font(FONT_NAME, style, SIZE));
		}
	}
}
