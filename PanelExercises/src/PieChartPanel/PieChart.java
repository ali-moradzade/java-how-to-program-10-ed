package PieChartPanel;

import javax.swing.JFrame;

public class PieChart
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Drawing pie charts");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(new PieChartPanel());
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
