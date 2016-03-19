package lesson2.frame_2_6.frame_2_6_6;

public class Tiger extends Tank {
	
	private int armor;
	

	public int getArmor() {
		return armor;
	}


	public Tiger(ActionField af, BattleField bf) {
		super(af, bf);
		setColor(Colors.YELLOW);
		setCrew(7);
		armor = 1;
		}
	
	
	public Tiger(ActionField af, BattleField bf, int x, int y, int direction) {
		super(af, bf, x, y, direction);
		armor = 1;
	}
}
