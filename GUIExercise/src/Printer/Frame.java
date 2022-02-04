package Printer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Frame extends JFrame
{
	private final JPanel topJPanel;
	private final JPanel middleJPanel;
	private final JPanel buttomJPanel;
	
	private final JPanel leftJPanel;
	private final JPanel rightJPanel;
	
	private final JLabel printerJLabel;
	private final JLabel selectedPrinterJLabel;
	
	private final JTextArea textArea1;
	private final JTextArea textArea2;
	private final JTextArea textArea3;
	
	public Frame()
	{
		super("Printer");
		setLayout(new FlowLayout());
		
		FlowLayout topLayout = new FlowLayout(FlowLayout.LEFT);
		topJPanel = new JPanel(topLayout);
		
		printerJLabel = new JLabel("Printer: ");
		topJPanel.add(printerJLabel);
		
		selectedPrinterJLabel = new JLabel("MyPrinter");
		topJPanel.add(selectedPrinterJLabel);
		
		middleJPanel = new JPanel(new GridLayout(1, 5));
		
		textArea1 = new JTextArea(5, 5);
		textArea1.setLineWrap(true);
		middleJPanel.add(new JScrollPane(textArea1));
		
		Box buttonBox1 = Box.createVerticalBox();
		buttonBox1.add(new JCheckBox("Image"));
		buttonBox1.add(new JCheckBox("Text"));
		buttonBox1.add(new JCheckBox("Code"));
		
		middleJPanel.add(buttonBox1);
		
		textArea2 = new JTextArea(5, 5);
		textArea2.setLineWrap(true);
		middleJPanel.add(new JScrollPane(textArea2));
		
		Box buttonBox2 = Box.createVerticalBox();
		JRadioButton selectionJRadioButton = new JRadioButton("Selection", false);
		JRadioButton allJRadioButton = new JRadioButton("All", true);
		JRadioButton appletJRadioButton = new JRadioButton("Applet", false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(selectionJRadioButton);
		group.add(allJRadioButton);
		group.add(appletJRadioButton);
		
		buttonBox2.add(selectionJRadioButton);
		buttonBox2.add(allJRadioButton);
		buttonBox2.add(appletJRadioButton);
		middleJPanel.add(buttonBox2);
		
		textArea3 = new JTextArea(5, 5);
		textArea3.setLineWrap(true);
		middleJPanel.add(new JScrollPane(textArea3));
		
		FlowLayout buttomLayout = new FlowLayout(FlowLayout.LEFT);
		buttomJPanel = new JPanel(buttomLayout);
		
		buttomJPanel.add(new JLabel("Print Quality: "));
		
		String[] qualityNames = {"Low", "Medium", "High"};
		JComboBox<String> comboBox = new JComboBox<>(qualityNames);
		buttomJPanel.add(comboBox);
		buttomJPanel.add(new JCheckBox("Print to File"));
		
		rightJPanel = new JPanel(new GridLayout(4, 1));
		rightJPanel.add(new JButton("Ok"));
		rightJPanel.add(new JButton("Cancel"));
		rightJPanel.add(new JButton("Setup..."));
		rightJPanel.add(new JButton("Help"));
		
		leftJPanel = new JPanel(new BorderLayout());
		leftJPanel.add(topJPanel, BorderLayout.NORTH);
		leftJPanel.add(middleJPanel);
		leftJPanel.add(buttomJPanel, BorderLayout.SOUTH);
		
		add(leftJPanel);
		add(rightJPanel);
	}
}
