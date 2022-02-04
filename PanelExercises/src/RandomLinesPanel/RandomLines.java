package RandomLinesPanel;

import javax.swing.JFrame;

public class RandomLines extends JFrame
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Random lines with random colors and thickness");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RandomLinesPanel randomLinesPanel = new RandomLinesPanel();
		app.add(randomLinesPanel);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}