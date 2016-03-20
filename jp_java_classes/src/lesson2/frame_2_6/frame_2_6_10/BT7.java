package lesson2.frame_2_6.frame_2_6_10;

public class BT7 extends Tank{
	public BT7(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setColor(Colors.GREEN);
		setCrew(5);
		setSpeed(getSpeed()*2);	
	}
}
