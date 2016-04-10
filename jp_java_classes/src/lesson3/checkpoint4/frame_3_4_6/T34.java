package lesson3.checkpoint4.frame_3_4_6;

import java.awt.Color;

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
