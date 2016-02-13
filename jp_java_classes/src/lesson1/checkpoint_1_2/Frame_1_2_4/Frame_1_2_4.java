package lesson1.checkpoint_1_2.Frame_1_2_4;

public class Frame_1_2_4 {

	public static void main(String[] args) {
		printTankInfo();
	}

	static void printTankInfo() {
		Tank t = new Tank("green", 5, 100);
		System.out.println("color: " + t.getColor());
		System.out.println("crew: " + t.getCrew());
		System.out.println("maxSpeed: " + t.getMaxSpeed());
	}
}
