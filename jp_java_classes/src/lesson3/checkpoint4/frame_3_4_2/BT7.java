package lesson3.checkpoint4.frame_3_4_2;

public class BT7 extends Tank{
	public BT7(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setColor(Colors.GREEN);
		setCrew(5);
		setSpeed(getSpeed()*2);	
	}
}
