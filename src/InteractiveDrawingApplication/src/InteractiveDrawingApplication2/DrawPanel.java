package InteractiveDrawingApplication2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private MyShape[] shapes;
	private int shapeCount;
	private int shapeType;
	private MyShape currentShape;
	private Color currentColor;
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
		currentColor = Color.black;
		
		setBackground(Color.white);
		
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	public void setShapes(MyShape[] shapes)
	{
		this.shapes = shapes;
	}
	
	public MyShape[] getShapes()
	{
		return shapes;
	}
	
	public void setShapeType(int shapeType)
	{
		this.shapeType = shapeType;
	}

	public void setCurrentColor(Color currentColor)
	{
		this.currentColor = currentColor;
	}

	public void setFilledShape(boolean filledShape)
	{
		this.filledShape = filledShape;
	}
	
	public void setShapeCount(int shapeCount)
	{
		this.shapeCount = shapeCount;
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
		
		for (int i = 0; i < shapeCount; i++)
		{
			shapes[i].draw(g);
		}
		
		if (currentShape != null)
			currentShape.draw(g);
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
						e.getY(), currentColor);
					break;
				case OVAL:
					currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(),
						currentColor, filledShape);
					break;
				case RECTANGLE:
					currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(),
						currentColor, filledShape);
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
