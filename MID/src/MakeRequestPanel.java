import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * This class extends JPanel and implements the make request of our gui.
 * @author 9831058
 */
public class MakeRequestPanel extends JPanel
{
	private final JTabbedPane tabs;
	private final JPanel bodyJPanel;
	private final JPanel headerJPanel;
	private final JPanel northHeaderJPanel;
	
	/**
	 * constructor initializes our class fields.
	 */
	public MakeRequestPanel()
	{
		setBackground(Color.green);
		setLayout(new BorderLayout());
		setSize(300, 300);
		
		tabs = new JTabbedPane();

		bodyJPanel = new JPanel();
		tabs.addTab("Body", bodyJPanel);
		
		headerJPanel = new JPanel();
		headerJPanel.setLayout(new BoxLayout(headerJPanel, BoxLayout.Y_AXIS));
		
		JPanel northJPanel = new JPanel();
		GridBagLayout northGridBagLayout = new GridBagLayout();
		GridBagConstraints northConstraints = new GridBagConstraints();
		northJPanel.setLayout(northGridBagLayout);
		
		String[] northJComboBoxNames = {"GET", "POST", "PUT", "PATCH", "DELETE", 
			"OPTIONS", "HEAD", "Custom Method"};
		JComboBox<String> northJComboBox = new JComboBox<>(northJComboBoxNames);
		JTextField urlJTextField = new JTextField("https://api.myproduct.com/v1/users");
		JButton sendJButton = new JButton("Send");

		northConstraints.gridwidth = 1;
		addComponent(northJComboBox, northGridBagLayout, northConstraints, northJPanel);
		northConstraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(urlJTextField, northGridBagLayout, northConstraints, northJPanel);
		northConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(sendJButton, northGridBagLayout, northConstraints, northJPanel);

		add(northJPanel, BorderLayout.NORTH);
		
		northHeaderJPanel = new JPanel();
		northHeaderJPanel.setLayout(new BoxLayout(northHeaderJPanel, BoxLayout.Y_AXIS));

		addToNorthHeader();
		addToNorthHeader();
		addToNorthHeader();
		
		JPanel southHeaderJPanel = new JPanel();
		JButton newJButton = new JButton("New");
		southHeaderJPanel.add(newJButton);
		
		headerJPanel.add(northHeaderJPanel);
		headerJPanel.add(Box.createRigidArea(new Dimension(50, 50)));
		headerJPanel.add(Box.createGlue());
		headerJPanel.add(southHeaderJPanel);
		
		tabs.addTab("Header", headerJPanel);
		add(tabs);
		
		/**
		 * This action listener is for newJButton that adds a new section to our panel.
		 */
		newJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					addToNorthHeader();
					MakeRequestPanel.this.repaint();
				}
			}
		);
	}
	
	/**
	 * This method is used to add components with gridbaglayout to the specific panel.
	 * @param component component we want to add.
	 * @param layout the layour we want to add component with it.
	 * @param constraints constraints of the layour.
	 * @param panel panel that we want to add component into it.
	 */
	private void addComponent(Component component, GridBagLayout layout, GridBagConstraints constraints, JPanel panel)
	{
		layout.setConstraints(component, constraints);
		panel.add(component);
	}
	
	/**
	 * add a specific section to the northHeader panel.
	 */
	private void addToNorthHeader()
	{
		JPanel insideHeaderJPanel = new JPanel();
		GridBagLayout headerGridBagLayout = new GridBagLayout();
		GridBagConstraints headerConstraints = new GridBagConstraints();
		insideHeaderJPanel.setLayout(headerGridBagLayout);

		JTextField headerJTextField = new JTextField("Header", 10);
		JTextField valueJTextField = new JTextField("Value", 10); 
		JCheckBox checkBox = new JCheckBox();
		JButton deleteJButton = new JButton("Delete");
		deleteJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					northHeaderJPanel.remove(insideHeaderJPanel);
					MakeRequestPanel.this.repaint();
				}
			}
		);

		headerConstraints.gridwidth = 1;
		addComponent(headerJTextField, headerGridBagLayout, headerConstraints, insideHeaderJPanel);
		headerConstraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(valueJTextField, headerGridBagLayout, headerConstraints, insideHeaderJPanel);
		headerConstraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(checkBox, headerGridBagLayout, headerConstraints, insideHeaderJPanel);
		headerConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(deleteJButton, headerGridBagLayout, headerConstraints, insideHeaderJPanel);

		northHeaderJPanel.add(insideHeaderJPanel);
	}
//	
//	/**
//	 * This is a main method that we created to our testing purposes.
//	 * @param args 
//	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		}
//		catch (Exception e)
//		{
//		}
//		
//		JFrame frame = new JFrame();
//		frame.add(new MakeRequestPanel());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 300);
//		frame.setVisible(true);
//	}
}
