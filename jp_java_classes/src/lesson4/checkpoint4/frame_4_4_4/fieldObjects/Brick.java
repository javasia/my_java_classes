package lesson4.checkpoint4.frame_4_4_4.fieldObjects;

import java.awt.Color;

import lesson4.checkpoint4.frame_4_4_4.interfaces.Destroyable;
import lesson4.checkpoint4.frame_4_4_4.interfaces.Drawable;

public class Brick extends AbstractFieldObjects implements Drawable, Destroyable {
	
	public Brick() {
		color = Color.DARK_GRAY;
	}

}
