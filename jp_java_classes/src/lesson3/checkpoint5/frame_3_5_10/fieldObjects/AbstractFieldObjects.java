package lesson3.checkpoint5.frame_3_5_10.fieldObjects;

import java.awt.Color;
import java.awt.Graphics;

import lesson3.checkpoint5.frame_3_5_10.service.BattleField;

public abstract class AbstractFieldObjects {
	
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
