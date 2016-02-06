package old.lesson2;

public class Barrel_5 {

	public static void main(String[] args) {
	
	System.out.println(oldEnough(50));
	}
	
	static boolean oldEnough(int age){
		boolean res = false;
		if (age>=21){
		res=true;
		}
		return res;
	}

}