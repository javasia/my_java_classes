package lesson4.checkpoint4.frame_4_4_4.bf.tanks;

import java.awt.Color;

import lesson4.checkpoint4.frame_4_4_4.ActionField;
import lesson4.checkpoint4.frame_4_4_4.bf.BattleField;


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
