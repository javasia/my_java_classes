package lesson1.checkpoint_1_2;

public class Frame_1_2_13 {

	public static void main(String[] args) {
		Tank[] tanks = new Tank[5];
		tanks[0]= new Tank("green", 5, 100);
		tanks[2]= new Tank("blue", 4, 10);
		tanks[3]= new Tank("black", 2, 210);
		tanks[4]= new Tank("red", 1, 110);
		
		printTankInfo(tanks);
	}

	static void printTankInfo(Tank[] tanks) {
		for (Tank tank : tanks) {
			if (tank != null) {
				System.out.print("color: " + tank.getColor()+"; ");
				System.out.print("crew: " + tank.getCrew()+"; ");
				System.out.println("maxSpeed: " + tank.getMaxSpeed()+".");
			} else {
				System.out.println("null");
			}
		}
	}
}
