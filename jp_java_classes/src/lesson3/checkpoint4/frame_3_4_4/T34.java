package lesson3.checkpoint4.frame_3_4_4;

public class T34 extends AbstractTank {

	public T34(ActionField af, BattleField bf) {
		super(af, bf, Type.DEFENDER);
		setColor(Colors.RED);
		setCrew(3);
	}

}
