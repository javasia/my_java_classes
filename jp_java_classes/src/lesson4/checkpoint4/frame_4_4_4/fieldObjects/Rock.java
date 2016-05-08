package lesson4.checkpoint4.frame_4_4_4.fieldObjects;

import java.awt.Color;

import lesson4.checkpoint4.frame_4_4_4.interfaces.Destroyable;
import lesson4.checkpoint4.frame_4_4_4.interfaces.Drawable;

public class Rock extends AbstractFieldObjects implements Drawable, Destroyable {

	public Rock() {
		color = Color.BLACK;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
