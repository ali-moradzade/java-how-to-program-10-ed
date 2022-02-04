package RandomChractersPanel;

import javax.swing.JFrame;

public class RandomCharacters
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Random characters with different fonts and colors");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RandomChractersPanel panel = new RandomChractersPanel();
		
		app.add(panel);
		app.setSize(1920, 1080);
		app.setVisible(true);
	}
}
