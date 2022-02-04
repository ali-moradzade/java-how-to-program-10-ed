package TetrahedronPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

public class TetrahedronPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		GeneralPath tetrahedron = new GeneralPath();
		
		int[] xValues = {110, 150, 50};
		int[] yValues = {90, 130, 130};
		
		int x = 100;
		int y = 40;
		
		tetrahedron.moveTo(xValues[0], yValues[0]);
		
		for ( int i = 0; i < xValues.length; i++ ) 
		{
			tetrahedron.lineTo(x, y); 
			tetrahedron.moveTo(xValues[i], yValues[i]);
			
			int next = (i + 1 < xValues.length) ? i + 1 : 0;
			tetrahedron.lineTo(xValues[next], yValues[next]); 
		}
		
		//tetrahedron.closePath(); 
		g2d.draw(tetrahedron); 
	}
}