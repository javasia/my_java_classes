package lesson2.key_point_2;

public class Frame_2_2_10 {

	public static void main(String[] args) {
	
	System.out.println(oldEnough(50));
	System.out.println(oldEnough(21));
	System.out.println(oldEnough(10));

	}
	
	static boolean oldEnough(int age){
		boolean res = false;
		if (age>=21){
		res=true;
		}
		return res;
	}

}