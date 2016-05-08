package lesson4.checkpoint4.frame_4_4_4.tanks;

import java.awt.Color;

import lesson4.checkpoint4.frame_4_4_4.enumes.Type;
import lesson4.checkpoint4.frame_4_4_4.service.ActionField;
import lesson4.checkpoint4.frame_4_4_4.service.BattleField;


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
