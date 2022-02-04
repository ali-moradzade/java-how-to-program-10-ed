package InteractiveDrawingApplication1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private final MyShape[] shapes;
	private int shapeCount;
	private int shapeType;
	private MyShape currentShape;
	private Paint currentPaint;
	private Stroke currentStroke;
	private boolean filledShape;
	private final JLabel statusLabel;
	
	public static final int LINE      = 0;
	public static final int OVAL      = 1;
	public static final int RECTANGLE = 2;

	public DrawPanel(JLabel statusLabel)
	{
		this.statusLabel = statusLabel;
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = LINE;
		currentShape = null;
		currentPaint= Color.black;
		currentStroke = new BasicStroke();
		
		setBackground(Color.white);
		
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	public void setShapeType(int shapeType)
	{
		this.shapeType = shapeType;
	}

	public void setCurrentPaint(Paint currentColor)
	{
		this.currentPaint = currentColor;
	}

	public void setCurrentStroke(Stroke currentStroke)
	{
		this.currentStroke = currentStroke;
	}
	
	public void setFilledShape(boolean filledShape)
	{
		this.filledShape = filledShape;
	}
	
	public void clearLastShape()
	{
		shapeCount--;
		
		shapeCount = (shapeCount < 0 ? 0 : shapeCount);
		
		repaint();
	}
	
	public void clearDrawing()
	{
		shapeCount = 0;
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(currentPaint);
		g2d.setStroke(currentStroke);
		
		for (int i = 0; i < shapeCount; i++)
		{
			shapes[i].draw(g2d);
		}
		
		if (currentShape != null)
			currentShape.draw(g2d);
	}
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			switch (shapeType)
			{
				case LINE:
					currentShape =new MyLine(e.getX(), e.getY(), e.getX(), 
						e.getY(), currentPaint, currentStroke);
					break;
				case OVAL:
					currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(),
						currentPaint, currentStroke, filledShape);
					break;
				case RECTANGLE:
					currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(),
						currentPaint, currentStroke, filledShape);
					break;
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			
			shapes[shapeCount] = currentShape;
			shapeCount++;
			currentShape = null;
			
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
			statusLabel.setText(String.format("(%d,%d)", e.getX(), e.getY()));
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			statusLabel.setText(String.format("(%d,%d)", e.getX(), e.getY()));
			
			repaint();
		}
	}
}
