package lesson3.checkpoint2.frame_3_2_8;

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
	
	}
}
