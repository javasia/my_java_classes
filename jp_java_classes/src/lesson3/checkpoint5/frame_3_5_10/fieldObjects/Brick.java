package lesson3.checkpoint5.frame_3_5_10.fieldObjects;

import java.awt.Color;

import lesson3.checkpoint5.frame_3_5_10.interfaces.Destroyable;
import lesson3.checkpoint5.frame_3_5_10.interfaces.Drawable;

public class Brick extends AbstractFieldObjects implements Drawable, Destroyable {
	
	public Brick() {
		color = Color.DARK_GRAY;
	}

}
