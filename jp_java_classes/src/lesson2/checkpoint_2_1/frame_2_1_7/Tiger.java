package lesson2.checkpoint_2_1.frame_2_1_7;

public class Tiger extends Tank {

	public Tiger(ActionField af, BattleField bf) {
		super(af, bf);
		this.setColor(Colors.YELLOW);
		this.setCrew(7);
		this.setMaxSpeed(30);	
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
