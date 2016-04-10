package lesson3.checkpoint5.frame_3_5_10.fieldObjects;

import java.awt.Color;

import lesson3.checkpoint5.frame_3_5_10.interfaces.Destroyable;
import lesson3.checkpoint5.frame_3_5_10.interfaces.Drawable;

public class Eagle extends AbstractFieldObjects implements Drawable, Destroyable {

	public Eagle() {
		color = Color.CYAN;
	}

}
