package lesson3.checkpoint2.frame_3_2_6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle  extends Shape{
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		//g.drawPolygon(new int[] {400, 450, 500}, new int[] {150,50,150}, 3);
		g.fillPolygon(new int[] {400, 450, 500}, new int[] {150,50,150}, 3);
		g.setColor(Color.WHITE);
		g.fillPolygon(new int[] {405, 450, 495}, new int[] {147,55,147}, 3);

		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.drawPolygon(new int[] {400, 450, 500}, new int[] {150+150,50+150,150+150}, 3);
		
		
		}
}
