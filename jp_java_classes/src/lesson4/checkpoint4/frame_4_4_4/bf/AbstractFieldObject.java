package lesson4.checkpoint4.frame_4_4_4.bf;

import java.awt.Color;
import java.awt.Graphics;


public abstract class AbstractFieldObject implements BFObject{
	
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
