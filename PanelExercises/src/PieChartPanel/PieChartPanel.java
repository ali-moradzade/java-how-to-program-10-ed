package PieChartPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PieChartPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		double firstPoint = Double.parseDouble(
			JOptionPane.showInputDialog(this, "Enter first point"));
		double secondPoint = Double.parseDouble(
			JOptionPane.showInputDialog(this, "Enter second point"));
		
		double width = Double.parseDouble(
			JOptionPane.showInputDialog(this, "Enter width"));
		
		double height = Double.parseDouble(
			JOptionPane.showInputDialog(this, "Enter height"));
		
		double start = Double.parseDouble(
			JOptionPane.showInputDialog(this, "Enter starting degree"));
		
		double sweep = Double.parseDouble(
			JOptionPane.showInputDialog(this, "Enter sweep degree"));
		
		g2d.fill(new Arc2D.Double(
			firstPoint, secondPoint, width, height, start, sweep, Arc2D.PIE));
	}
}
