import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * This class extends JFrame and is our main class that uses to attach all of the 
 * panels into itself.
 * @author 9831058
 */
public class MainFrame extends JFrame
{
	private boolean toggle = true;
	
	/**
	 * constructor builds some panels, menus and ... and attaches them to the frame.
	 */
	public MainFrame()
	{
		super("Insomnia");
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.black);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		JMenu applicationJMenu = new JMenu("Application");
		applicationJMenu.setMnemonic('A');
		JMenuItem optionsJMenuItem = new JMenuItem("Options");
		optionsJMenuItem.setMnemonic('O');
		optionsJMenuItem.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					OptionFrame frame = new OptionFrame();
				}
			}
		);
		
		JMenuItem exitJMenuItem = new JMenuItem("Exit");
		exitJMenuItem.setMnemonic('x');
		exitJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		exitJMenuItem.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			}
		);
		
		applicationJMenu.add(optionsJMenuItem);
		applicationJMenu.add(exitJMenuItem);
		bar.add(applicationJMenu);
		
		JMenu viewJMenu = new JMenu("View");
		viewJMenu.setMnemonic('V');
		JMenuItem toggleFullScreen = new JMenuItem("Toggle Full Screen");
		toggleFullScreen.setMnemonic('F');
		toggleFullScreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.getKeyText(KeyEvent.VK_F11)));
		toggleFullScreen.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						if (toggle)
					{
						MainFrame.this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
						MainFrame.this.setUndecorated(true);
					}
						else
						{
							MainFrame.this.setSize(1000, 300);
							MainFrame.this.setUndecorated(true);
						}
					}
					catch (Exception exception)
					{
					}
					
					toggle = !toggle;
				}
			}
		);
		
		JMenuItem toggleSidebar = new JMenuItem("Toggle Sidebar");
		toggleSidebar.setMnemonic('S');
		
		viewJMenu.add(toggleFullScreen);
		viewJMenu.add(toggleSidebar);
		bar.add(viewJMenu);
		
		JMenu helpJMenu = new JMenu("Help");
		helpJMenu.setMnemonic('H');
		JMenuItem aboutJMenuItem = new JMenuItem("About");
		aboutJMenuItem.setMnemonic('b');
		aboutJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		aboutJMenuItem.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(MainFrame.this, "Ali Moradzade\n9831058");
				}
			}
		);
		
		JMenuItem helpJMenuItem = new JMenuItem("Help");
		helpJMenuItem.setMnemonic('e');
		
		helpJMenu.add(aboutJMenuItem);
		helpJMenu.add(helpJMenuItem);
		bar.add(helpJMenu);
	}
	
	/**
	 * This is a main method that we created for our testing purposes.
	 * @param args arguments from the command line.
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
		
		MainFrame frame = new MainFrame();
		JPanel leftJPanel = new JPanel(new BorderLayout());
		leftJPanel.add(new SlideBarPanel(), BorderLayout.NORTH);
		
		frame.add(leftJPanel, BorderLayout.WEST);
		frame.add(new MakeRequestPanel(), BorderLayout.CENTER);
		frame.add(new ResponsePanel(), BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 500);
		frame.setVisible(true);
	}
}
