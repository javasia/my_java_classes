package lesson3.checkpoint2.frame_3_2_8;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Shape{
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.drawRect(200, 200, 100, 100);		
	}

}
