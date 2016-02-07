package lesson1.checkpoint_1_2.frame_1_2_15;

public class Launcher {

	public static void main(String[] args) {
		
		Object obj1 = new Object("obj1");
		Object obj2 = new Object("obj2");
		Object obj3 = new Object("obj3");
		
		obj1.setObj(obj2);
		obj2.setObj(obj3);
		obj3.setObj(obj1);
		
		String refObj1 = obj1.obj.name;
		String refObj2 = obj2.obj.name;
		String refObj3 = obj3.obj.name;
		
		System.out.println("refObj1: "+refObj1);
		System.out.println("refObj2: "+refObj2);
		System.out.println("refObj3: "+refObj3);

	}

}
