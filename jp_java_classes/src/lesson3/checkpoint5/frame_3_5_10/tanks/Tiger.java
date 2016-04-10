package lesson3.checkpoint5.frame_3_5_10.tanks;

import lesson3.checkpoint5.frame_3_5_10.enumes.Type;
import lesson3.checkpoint5.frame_3_5_10.service.ActionField;
import lesson3.checkpoint5.frame_3_5_10.service.BattleField;

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
