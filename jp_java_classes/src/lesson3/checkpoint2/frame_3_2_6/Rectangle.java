package lesson3.checkpoint2.frame_3_2_6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle  extends Shape{
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(200, 50, 150, 100);
		g.setColor(Color.WHITE);
		g.fillRect(205, 55, 140, 90);

		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.drawRect(200, 200, 150, 100);
		
	}
}
