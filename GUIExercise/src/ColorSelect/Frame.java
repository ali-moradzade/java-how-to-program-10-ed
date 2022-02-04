package ColorSelect;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	private final JComboBox<String> colorsJComboBox;
	private static final String[] names = {"RED", "BLUE", "GREEN"};
	private final JPanel middleJPanel;
	private final JPanel buttomJPanel;
	
	public Frame()
	{
		super("ColorSelect");
		
		colorsJComboBox = new JComboBox<>(names);
		add(colorsJComboBox, BorderLayout.NORTH);
		
		middleJPanel = new JPanel();
		middleJPanel.add(new JCheckBox("Background"));
		middleJPanel.add(new JCheckBox("Foreground"));
		add(middleJPanel);
		
		buttomJPanel = new JPanel();
		buttomJPanel.add(new JButton("Ok"));
		buttomJPanel.add(new JButton("Cancel"));
		add(buttomJPanel, BorderLayout.SOUTH);
	}
}
