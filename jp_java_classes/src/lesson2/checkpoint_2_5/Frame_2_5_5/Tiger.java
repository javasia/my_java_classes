package lesson2.checkpoint_2_5.Frame_2_5_5;

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
	
	public Tiger(ActionField af, BattleField bf, int armor) {
		super(af, bf);
		setColor(Colors.YELLOW);
		setCrew(7);
		this.armor=armor;
	}
}
