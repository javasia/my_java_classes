package lesson3.checkpoint4.frame_3_4_2;

public class T34 extends AbstractTank {

	public T34(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setColor(Colors.RED);
		setCrew(3);
		setMaxSpeed(70);
	}

}
