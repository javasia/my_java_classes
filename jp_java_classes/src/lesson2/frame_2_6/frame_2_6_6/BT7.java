package lesson2.frame_2_6.frame_2_6_6;

public class BT7 extends Tank{
	public BT7(ActionField af, BattleField bf) {
		super(af, bf);
		setColor(Colors.GREEN);
		setCrew(5);
		setSpeed(getSpeed()*2);	
	}
}
