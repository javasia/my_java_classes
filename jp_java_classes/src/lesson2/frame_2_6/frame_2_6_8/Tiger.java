package lesson2.frame_2_6.frame_2_6_8;

public class Tiger extends Tank {
	
	private int armor;
	

	public int getArmor() {
		return armor;
	}


	public Tiger(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setColor(Colors.YELLOW);
		setCrew(7);
		armor = 1;
		}
	
	
}
