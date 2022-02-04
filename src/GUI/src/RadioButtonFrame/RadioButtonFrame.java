package RadioButtonFrame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame
{
	private final JTextField textField;
	private final Font plainFont;
	private final Font boldFont;
	private final Font italicFont;
	private final Font boldItalicFont;
	private final JRadioButton plainJRadioButton;
	private final JRadioButton boldJRadioButton;
	private final JRadioButton italicJRadioButton;
	private final JRadioButton boldItalicJRadioButton;
	private final ButtonGroup radionGroup;
	
	public RadioButtonFrame()
	{
		super("RadionButton Test");
		setLayout(new FlowLayout());
		
		textField = new JTextField("Watch the font style change", 25);
		add(textField);
		
		plainJRadioButton = new JRadioButton("Plain", true);
		add(plainJRadioButton);
		
		boldJRadioButton = new JRadioButton("Bold", false);
		add(boldJRadioButton);
		
		italicJRadioButton = new JRadioButton("Italic", false);
		add(italicJRadioButton);
		
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
		add(boldItalicJRadioButton);
		
		radionGroup = new ButtonGroup();
		radionGroup.add(plainJRadioButton);
		radionGroup.add(boldJRadioButton);
		radionGroup.add(italicJRadioButton);
		radionGroup.add(boldItalicJRadioButton);
		
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		textField.setFont(plainFont);
		
		RadioButtonHandler handler = new RadioButtonHandler();
		plainJRadioButton.addItemListener(handler);
		boldJRadioButton.addItemListener(handler);
		italicJRadioButton.addItemListener(handler);
		boldItalicJRadioButton.addItemListener(handler);
	}
	
	private class RadioButtonHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{
			if (event.getSource() == plainJRadioButton)
				textField.setFont(plainFont);
			else if (event.getSource() == boldJRadioButton)
				textField.setFont(boldFont);
			else if (event.getSource() == italicJRadioButton)
				textField.setFont(italicFont);
			else if (event.getSource() == boldItalicJRadioButton)
				textField.setFont(boldItalicFont);
		}
	}
}