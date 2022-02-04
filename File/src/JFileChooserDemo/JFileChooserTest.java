package JFileChooserDemo;

import java.io.IOException;
import javax.swing.JFrame;

public class JFileChooserTest
{
	public static void main(String[] args) throws IOException
	{
		JFrame app = new JFileChooserDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400, 400);
		app.setVisible(true);
	}
}
