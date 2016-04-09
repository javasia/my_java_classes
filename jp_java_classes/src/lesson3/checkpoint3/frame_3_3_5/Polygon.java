package lesson3.checkpoint3.frame_3_3_5;

import java.awt.Graphics;

public class Polygon extends AbstractShape {

	public Polygon() {

	}

	public void draw(Graphics g) {
		this.g = g;
		changeStroke(g, strokeThickness, color);
		if (strokeThickness != 1) {
			g.drawPolygon(xPoints, yPoints, points);
		} else {
			g.fillPolygon(xPoints, yPoints, points);
		}
	}
}
