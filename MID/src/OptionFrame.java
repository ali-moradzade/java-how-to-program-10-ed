import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 * This class extens JFrame and implements our option frame.
 * @author 9831058
 */
public class OptionFrame extends JFrame
{
	/**
	 * our fields consists of layout that is the layout of our frame and 
	 * constraints that is the constraints of the layout.
	 */
	private final GridBagLayout layout;
	private final GridBagConstraints constraints;
	
	/**
	 * constructor initializes our fields.
	 */
	public OptionFrame()
	{
		super("Option");
		layout = new GridBagLayout();
		setLayout(layout);
		
		constraints = new GridBagConstraints();
		
		JCheckBox followRedirectJCheckBox = new JCheckBox("Follow Redirect");
		JRadioButton exitJRadioButton = new JRadioButton("Exit");
		exitJRadioButton.setSelected(true);
		JRadioButton systemTrayJRadioButton = new JRadioButton("System Tray");
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(exitJRadioButton);
		buttonGroup.add(systemTrayJRadioButton);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(followRedirectJCheckBox);
		
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(exitJRadioButton);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(systemTrayJRadioButton);
		
		setSize(300, 100);
		setVisible(true);
	}
	
	/**
	 * This is a utility method and is used to add components to the frame.
	 * @param component component we want to add to the frame.
	 */
	private void addComponent(Component component)
	{
		layout.setConstraints(component, constraints);
		add(component);
	}
	
//	/**
//	 * This is a main method to check this class is working good or not.
//	 * @param args 
//	 */
//	public static void main(String[] args)
//	{
//		OptionFrame frame = new OptionFrame();
//	}
}
