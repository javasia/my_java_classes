package lesson2.checkpoint_2_1.frame_2_1_2;

public class Launcher {

	public static void main(String[] args) throws Exception {
		ActionField af = new ActionField();
		BattleField bf = new BattleField();
		Tiger tankTiger = new Tiger(af, bf);
		T34 tankT34 = new T34(af, bf);
		BT7 tankBT7 = new BT7(af, bf);
		
		System.out.println("Tiger maxSpeed: " + tankTiger.getMaxSpeed());
		System.out.println("Tiger crew: " + tankTiger.getCrew());
		System.out.println("Tiger clor: " + tankTiger.getColor());
		
		System.out.println();
		
		System.out.println("BT7 maxSpeed: " + tankBT7.getMaxSpeed());
		System.out.println("BT7 crew: " + tankBT7.getCrew());
		System.out.println("BT7 clor: " + tankBT7.getColor());
		
		System.out.println();
		
		System.out.println("T34 maxSpeed: " + tankT34.getMaxSpeed());
		System.out.println("T34 crew: " + tankT34.getCrew());
		System.out.println("T34 clor: " + tankT34.getColor());
		

	}
}
