import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel
{
	private static final int	LENGTH_OF_SHAPES = 30;
	private int choice;
	
	public Shapes(int choice)
	{
		this.choice = choice;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (int i = 0; i < LENGTH_OF_SHAPES; i++)
		{
			switch (choice)
			{
				case 1:
					g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
					break;
				case 2:
					g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
					break;
			}
		}
	}
}
