package lesson3.checkpoint5.frame_3_5_10.tanks;

import java.awt.Color;

import lesson3.checkpoint5.frame_3_5_10.enumes.Type;
import lesson3.checkpoint5.frame_3_5_10.service.ActionField;
import lesson3.checkpoint5.frame_3_5_10.service.BattleField;

public class T34 extends AbstractTank {

	private Color bodyColor = Color.GREEN;
	private Color towerColor = Color.BLACK;
	
	public T34(ActionField af, BattleField bf) {
		super(af, bf, Type.DEFENDER);
		setCrew(3);
		setBodyColor(bodyColor);
		setTowerColor(towerColor);
	}

}
