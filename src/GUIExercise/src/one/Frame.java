package one;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	private final JPanel firstJPanel;
	private final JPanel secondJPanel;
	private final JPanel panel;
	
	public Frame()
	{
		super("Align");
		setLayout(new FlowLayout());
		
		firstJPanel = new JPanel(new GridLayout(2, 1));
		firstJPanel.add(new JCheckBox("Snap to Grid"));
		firstJPanel.add(new JCheckBox("Show Grid"));
		
		add(firstJPanel);
		
		secondJPanel = new JPanel(new GridLayout(2, 1, 5, 10));
		
		Box secondTopBox = Box.createHorizontalBox();
		secondTopBox.add(new JLabel("X:  "));	
		secondTopBox.add(new JTextField("8", 10));
		
		Box secondDownBox = Box.createHorizontalBox();
		secondDownBox.add(new JLabel("Y:  "));
		secondDownBox.add(new JTextField("8", 10));
		
		secondJPanel.add(secondTopBox);
		secondJPanel.add(secondDownBox);
		add(secondJPanel);
		
		panel = new JPanel(new GridLayout(3, 1, 5, 5));
		panel.add(new JButton("OK"));
		panel.add(new JButton("Cancel"));
		panel.add(new JButton("Help"));
		
		add(panel);
	}
}
