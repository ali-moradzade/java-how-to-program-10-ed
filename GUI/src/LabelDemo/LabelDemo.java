package LabelDemo;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LabelDemo
{
	public static void main(String[] args)
	{
		JLabel northJLabel = new JLabel("North");
		
		ImageIcon labelIcon = new ImageIcon("GUItip.gif");
		JLabel centerJLabel = new JLabel(labelIcon);
		JLabel southJLabel = new JLabel(labelIcon);
		southJLabel.setText("South");
		
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		application.add(northJLabel, BorderLayout.NORTH);
		application.add(centerJLabel, BorderLayout.CENTER);
		application.add(southJLabel, BorderLayout.SOUTH);
		
		application.setSize(300, 300);
		application.setVisible(true);
	}
}
