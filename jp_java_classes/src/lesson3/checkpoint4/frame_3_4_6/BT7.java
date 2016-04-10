package lesson3.checkpoint4.frame_3_4_6;

import java.awt.Color;

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
