package lesson3.checkpoint2.frame_3_2_6;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle  extends Shape{
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		//g.drawRect(200, 50, 150, 100);
		g.fillRect(200, 50, 150, 100);
		g.setColor(Color.WHITE);
		g.fillRect(205, 55, 140, 90);

		g.setColor(Color.BLACK);
		g.drawRect(200, 200, 150, 100);	
	}
}
