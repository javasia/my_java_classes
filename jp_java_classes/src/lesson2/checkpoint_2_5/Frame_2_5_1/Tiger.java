package lesson2.checkpoint_2_5.Frame_2_5_1;

public class Tiger extends Tank {
	
	int aramor;

	public Tiger(ActionField af, BattleField bf) {
		super(af, bf);
		this.setColor(Colors.YELLOW);
		this.setCrew(7);
		int armor = 1;
		}
}
