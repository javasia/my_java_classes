package lesson3.checkpoint2.frame_3_2_6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		//g.drawOval(50, 50, 100, 100);	
		g.fillOval(50, 50, 100, 100);
		g.setColor(Color.WHITE);
		g.fillOval(53, 53, 94, 94);
		
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.drawRect(50, 200, 100, 100);
	}

}
