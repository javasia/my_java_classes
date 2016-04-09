package lesson3.checkpoint3.frame_3_3_5;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ShapesTemplate extends JPanel implements Drawable{
	
	private AbstractShape[] abstractShapes;
	
	public ShapesTemplate(AbstractShape[] shapes) {
		this.abstractShapes = shapes;
		if (shapes == null || shapes.length < 1) {
			this.abstractShapes = new AbstractShape[0];
		}
		
		JFrame frame = new JFrame("DAY 6, 2D Graphics");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		draw(g);
	}
	
	public void draw(Graphics g){
		for (AbstractShape s : abstractShapes) {
			s.draw(g);
		}
	}
}