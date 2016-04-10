package lesson3.checkpoint5.frame_3_5_10.tanks;

import java.awt.Color;

import lesson3.checkpoint5.frame_3_5_10.enumes.Type;
import lesson3.checkpoint5.frame_3_5_10.service.ActionField;
import lesson3.checkpoint5.frame_3_5_10.service.BattleField;

public class BT7 extends AbstractTank{
	
	private Color bodyColor = Color.RED;
	private Color towerColor = Color.BLACK;
	
	public BT7(ActionField af, BattleField bf, Type type) {
		super(af, bf, Type.ATTAKER);
		setCrew(5);
		setSpeed(getSpeed()*2);	
		setBodyColor(bodyColor);
		setTowerColor(towerColor);
	}
}
