package lesson3.checkpoint2.frame_3_2_6;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		//g.drawOval(50, 50, 100, 100);	
		g.fillOval(50, 50, 100, 100);
		g.setColor(Color.WHITE);
		g.fillOval(53, 53, 94, 94);
		
		g.setColor(Color.BLACK);
		g.drawOval(50, 200, 100, 100);
	}

}
