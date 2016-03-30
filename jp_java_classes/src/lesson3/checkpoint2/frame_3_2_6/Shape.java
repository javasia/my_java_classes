package lesson3.checkpoint2.frame_3_2_6;

import java.awt.Graphics;

public class Shape {

	protected void draw(Graphics g) {
		throw new IllegalStateException("Shape is unknown. Please override!");
	}

}
