package lesson2.checkpoint_2_1.frame_2_1_7;

public class BT7 extends Tank{
	public BT7(ActionField af, BattleField bf) {
		super(af, bf);
		this.setColor(Colors.GREEN);
		this.setCrew(5);
		this.setMaxSpeed(50);
	}
	
	@Override
	public void move() throws Exception {
		System.out.println("Moving...");
	}
	
	@Override
	public String toString() {
		String res = "Tank color: " + getColor() + ". Tank crew: " + getCrew() + ". Tank maxSpeed: " + getMaxSpeed()+ ".";
		return res;
	}
}
