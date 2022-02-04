import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.util.ArrayList;

/**
 * This class extends jpanel and implements the slidebar of the program and first part in our gui.
 * @author 9831058
 */
public class SlideBarPanel extends JPanel
{
	/**
	 * our fileds consists of our GridBagLayout layout manager and its constraints.
	 */
	private final GridBagLayout layout;
	private final GridBagConstraints constraints;
	
	/**
	 * constructor initializes our class fields.
	 */
	public SlideBarPanel()
	{
		setBackground(Color.cyan);
		
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		
		String[] insomniaNames = {"Workspace Setting", "Share insomnia", 
			"New Workspace", "Preferences", "Import/Export", "Log In", "Upgrade"};
		JComboBox<String> insomniaJComboBox = new JComboBox<>(insomniaNames);
		
		String[] environmentNames = {"No Environment", "Manage Environments"};
		JComboBox<String> environmentsJComboBox = new JComboBox<>(environmentNames);
		
		JButton cookiesJButton = new JButton("Cookies");
		
		JTextField textField = new JTextField("Filter", 15);
		
		String[] newRequestNames = {"New Request", "New Folder"};
		JComboBox<String> newRequestJComboBox = new JComboBox<>(newRequestNames);
		
		ArrayList<String> requestNames = new ArrayList<>();
		requestNames.add("first request");
		requestNames.add("second request");
		requestNames.add("third request");
		
		JComboBox<String>[] requestsJComboBox = new JComboBox[requestNames.size()];
		String[] requestItemNames = {"Duplicate", "Generate Code", "Copy as Curl",
			"Delete", "Settings"};
		
		for (int count = 0; count < requestNames.size(); count++)
		{
			requestsJComboBox[count] = new JComboBox<>(requestItemNames);
		}
		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		
		addComponent(insomniaJComboBox, 0, 0, 3, 1);
		addComponent(environmentsJComboBox, 1, 0, 1, 1);
		addComponent(cookiesJButton, 1, 1, 2, 1);
		addComponent(textField, 2, 0, 2, 1);
		addComponent(newRequestJComboBox, 2, 2, 1, 1);
		
		for (int count = 0; count < requestNames.size(); count++)
		{
			addComponent(requestsJComboBox[count], 3 + count, 0, 3, 1);
		}
	}
	
	/**
	 * This method is our utility method to add components to the panel.
	 * @param component component we want to add to the panel.
	 * @param row row of the component.
	 * @param col col of the component.
	 * @param width width of the component.
	 * @param height height of hte component.
	 */
	private void addComponent(Component component, int row, int col, 
		int width, int height)
	{
		constraints.gridx = col;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
	
	/**
	 * This is a main method that with it we check if our panel is shown right or not.
	 * @param args arguments from command line.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e)
		{
		}
		
		JFrame frame = new JFrame();
		frame.add(new SlideBarPanel(), BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}