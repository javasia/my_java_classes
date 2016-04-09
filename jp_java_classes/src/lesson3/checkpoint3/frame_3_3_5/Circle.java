package lesson3.checkpoint3.frame_3_3_5;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends AbstractShape{
	
	public Circle() {

	}
		
	public Circle(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public void draw(Graphics g) {
		changeStroke(g, strokeThickness, color);
		if (strokeThickness!=1){
			g.drawOval(x, y, width, height);
		}else{
			g.fillOval(x, y, width, height);
		}
	}
}
