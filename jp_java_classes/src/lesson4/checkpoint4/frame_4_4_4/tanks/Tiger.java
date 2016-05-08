package lesson4.checkpoint4.frame_4_4_4.tanks;

import lesson4.checkpoint4.frame_4_4_4.enumes.Type;
import lesson4.checkpoint4.frame_4_4_4.service.ActionField;
import lesson4.checkpoint4.frame_4_4_4.service.BattleField;

public class Tiger extends AbstractTank {

	final int armor = 1;

	public Tiger(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setCrew(7);
		setArmor(1);
	}

	@Override
	public void reborn() throws Exception {
		setArmor(armor);
		super.reborn();
	}

}
