package lesson3.checkpoint4.frame_3_4_2;

public class Tiger extends AbstractTank {

	final int armor = 1;

	public Tiger(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setColor(Colors.YELLOW);
		setCrew(7);
		setArmor(1);
	}

	@Override
	public void reborn() throws Exception {
		setArmor(armor);
		super.reborn();
	}

}
