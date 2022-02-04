import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * This class extends JPanel and implements a response section for our gui.
 * @author 9831058
 */
public class ResponsePanel extends JPanel
{
	/**
	 * constructor initializes our fields.
	 */
	public ResponsePanel()
	{
		setBackground(Color.red);
		setLayout(new BorderLayout());
		
		JPanel topJPanel = new JPanel(new BorderLayout());
		JPanel insideTopJPanel = new JPanel();
		
		JLabel statusCodeJLabel = new JLabel("200 OK");
		statusCodeJLabel.setBackground(Color.red);
		statusCodeJLabel.setOpaque(true);
		JLabel timeJLabel = new JLabel("6.64 s");
		timeJLabel.setBackground(Color.green);
		timeJLabel.setOpaque(true);
		
		insideTopJPanel.add(statusCodeJLabel);
		insideTopJPanel.add(timeJLabel);
		
		topJPanel.add(insideTopJPanel, BorderLayout.WEST);
		
		String[] topJComboBoxItemNames = {"Delete Current Response", "Clear History"};
		JComboBox<String> topJComboBox = new JComboBox<>(topJComboBoxItemNames);
		
		topJPanel.add(topJComboBox, BorderLayout.EAST);
		add(topJPanel, BorderLayout.NORTH);
		
		JTabbedPane tabs = new JTabbedPane();
		
		tabs.addTab("Raw", new JTextArea());
		
		JPanel insideHeaderJPanel = new JPanel();
		GridBagLayout headerGridBagLayout = new GridBagLayout();
		GridBagConstraints headerConstraints = new GridBagConstraints();
		
		insideHeaderJPanel.setLayout(headerGridBagLayout);
		
		JLabel nameJLabel = new JLabel("Name", SwingConstants.LEFT);
		JLabel valueJLabel = new JLabel("Value", SwingConstants.LEFT);
		
		JTextField headerJTextField = new JTextField("Header", 10);
		headerJTextField.setEditable(false);
		JTextField valueJTextField = new JTextField("Value", 10); 
		valueJTextField.setEditable(false);
		
		headerConstraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(nameJLabel, headerGridBagLayout, headerConstraints, insideHeaderJPanel);
		headerConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(valueJLabel, headerGridBagLayout, headerConstraints, insideHeaderJPanel);
		
		headerConstraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(headerJTextField, headerGridBagLayout, headerConstraints, insideHeaderJPanel);
		headerConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(valueJTextField, headerGridBagLayout, headerConstraints, insideHeaderJPanel);

		JPanel northHeaderJPanel = new JPanel();
		northHeaderJPanel.setLayout(new BoxLayout(northHeaderJPanel, BoxLayout.Y_AXIS));
		
		northHeaderJPanel.add(insideHeaderJPanel);

		JPanel southHeaderJPanel = new JPanel();
		southHeaderJPanel.add(new JButton("Copy to Clipboard"));
		
		JPanel headerJPanel = new JPanel(new BorderLayout());
		headerJPanel.add(northHeaderJPanel, BorderLayout.NORTH);
		headerJPanel.add(southHeaderJPanel, BorderLayout.SOUTH);
		
		tabs.addTab("Header", headerJPanel);
		add(tabs, BorderLayout.CENTER);
	}
	
	/**
	 * This method is a helper method that with it we add components to the panel.
	 * @param component component we want to add.
	 * @param layout the layout with which the component we want to add.
	 * @param constraints constraints of the layout.
	 * @param panel panel that we want to add the component to it.
	 */
	private void addComponent(Component component, GridBagLayout layout, GridBagConstraints constraints, JPanel panel)
	{
		layout.setConstraints(component, constraints);
		panel.add(component);
	}
	
//	/**
//	 * This is a main method for our testing purposes.
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
//		frame.add(new ResponsePanel());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(300, 300);
//		frame.setVisible(true);
//	}
}
