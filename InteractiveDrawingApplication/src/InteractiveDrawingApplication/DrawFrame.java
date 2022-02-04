package InteractiveDrawingApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame
{
	private final JLabel statusLabel;
	private final DrawPanel drawPanel;
	
	private final JButton undoJButton;
	private final JButton clearJButton;
	private final JComboBox<String> colorsJComboBox;
	
	private static final String[] colorNames = {"Black", "Blue", "Cyan",
		"Dark Gray", "Gray", "Green", "Light Gray", "Megenta", "Orange", "Pink", 
		"Red", "White", "Yellow"};
	private static final Color[] colors = {Color.black, Color.blue, Color.cyan, 
		Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta,
		Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
	
	private final JComboBox<String> shapesJComboBox;
	private static final String[] shapeNames = {"Line", "Oval", "Rectangle"};
	
	private final JCheckBox filledJCheckBox;
	
	public DrawFrame()
	{
		super("Java Drawings");
		
		statusLabel = new JLabel("(0,0)");
		drawPanel = new DrawPanel(statusLabel);
		
		undoJButton = new JButton("Undo");
		undoJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					drawPanel.clearLastShape();
				}
			}
		);
		
		clearJButton = new JButton("Clear");
		clearJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					drawPanel.clearDrawing();
				}
			}
		);
		
		colorsJComboBox = new JComboBox<>(colorNames);
		colorsJComboBox.setMaximumRowCount(5);
		colorsJComboBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
						drawPanel.setCurrentColor(
							colors[colorsJComboBox.getSelectedIndex()]);
					}
				}
			}
		);
		
		shapesJComboBox = new JComboBox<>(shapeNames);
		shapesJComboBox.setMaximumRowCount(5);
		shapesJComboBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
						
						drawPanel.setShapeType(shapesJComboBox.getSelectedIndex());
					}
				}
			}
		);
		
		filledJCheckBox = new JCheckBox("Filled", false);
		filledJCheckBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					drawPanel.setFilledShape(filledJCheckBox.isSelected());
				}
			}
		);
		
		JPanel northJPanel = new JPanel();
		northJPanel.add(undoJButton);
		northJPanel.add(clearJButton);
		northJPanel.add(colorsJComboBox);
		northJPanel.add(shapesJComboBox);
		northJPanel.add(filledJCheckBox);
		
		add(northJPanel, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
	}
}
