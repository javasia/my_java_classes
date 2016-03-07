package lesson2.checkpoint_2_5.Frame_2_5_5;

public class BT7 extends Tank{
	public BT7(ActionField af, BattleField bf) {
		super(af, bf);
		setColor(Colors.GREEN);
		setCrew(5);
		setSpeed(getSpeed()*2);	
	}
}
