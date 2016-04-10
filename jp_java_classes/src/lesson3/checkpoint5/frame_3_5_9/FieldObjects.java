package lesson3.checkpoint5.frame_3_5_9;

import java.awt.Color;
import java.awt.Graphics;

public class FieldObjects {
	
	int x;
	int y;
	Color color;
	protected BattleField bf;

	public void destroy() throws Exception {

		y = -100;
		x = -100;

	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, bf.getCELL_SIZE(), bf.getCELL_SIZE());
	}
}
