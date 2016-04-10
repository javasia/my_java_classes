package lesson3.checkpoint4.frame_3_4_6;

public class T34 extends AbstractTank {

	public T34(ActionField af, BattleField bf) {
		super(af, bf, Type.DEFENDER);
		setColor(Colors.RED);
		setCrew(3);
	}

}
