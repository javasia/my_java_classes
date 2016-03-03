package lesson2.checkpoint_2_1.frame_2_1_7;

public class Launcher {

	public static void main(String[] args) throws Exception {
		ActionField af = new ActionField();
		
		BattleField bf = new BattleField();
		Tiger tankTiger = new Tiger(af, bf);
		T34 tankT34 = new T34(af, bf);
		BT7 tankBT7 = new BT7(af, bf);
		
		System.out.println("Tiger move: ");
		tankTiger.move();
		System.out.println("Tiger toString: " + tankTiger.toString());
		
		System.out.println();
		
		System.out.println("BT7 move: ");
		tankBT7.move();
		System.out.println("Tiger toString: " + tankBT7.toString());
		
		System.out.println();
		
		System.out.println("Tiger move: ");
		tankT34.move();
		System.out.println("Tiger toString: " + tankT34.toString());
		

	}
}
