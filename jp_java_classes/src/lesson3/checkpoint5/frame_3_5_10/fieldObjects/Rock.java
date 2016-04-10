package lesson3.checkpoint5.frame_3_5_10.fieldObjects;

import java.awt.Color;

import lesson3.checkpoint5.frame_3_5_10.interfaces.Destroyable;
import lesson3.checkpoint5.frame_3_5_10.interfaces.Drawable;

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
