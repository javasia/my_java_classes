package lesson2.checkpoint_2_1.frame_2_1_7;

public class T34 extends Tank {

	public T34(ActionField af, BattleField bf) {
		super(af, bf);
		this.setColor(Colors.RED);
		this.setCrew(3);
		this.setMaxSpeed(70);
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
