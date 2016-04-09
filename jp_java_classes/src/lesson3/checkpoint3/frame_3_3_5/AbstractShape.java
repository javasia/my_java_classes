package lesson3.checkpoint3.frame_3_3_5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class AbstractShape implements Drawable{

	// defaults
	protected int x = 50, y = 50;
	protected int width = 150, height = 150;
	protected int strokeThickness = 1;
	protected Color color = Color.BLACK;
	
	protected Graphics g;
	protected int[] xPoints, yPoints;
	protected int points;

	protected void setStrokeThickness(int strokeThickness) {
		this.strokeThickness = strokeThickness;
	}

	protected void setColor(Color color) {
		this.color = color;
	}

	protected void changeStroke(Graphics g, int thickness, Color color) {
		g.setColor(color);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(thickness));
	}
}
