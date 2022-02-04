import javax.swing.JFrame;

public class ContentricCirclesTest
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame();
		ConcentricCirclesPanel panel = new ConcentricCirclesPanel();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
