package lesson1.checkpoint_1_2;

public class Frame_1_2_4 {

	public static void main(String[] args) {
		printTankInfo();
	}

	static void printTankInfo(){
		Tank t = new Tank();
		System.out.println("color: "+t.color);
		System.out.println("crew: "+t.crew);
		System.out.println("maxSpeed: "+t.maxSpeed);
	} 
}
