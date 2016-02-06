package lesson2.key_point_2;

public class Frame_2_2_19 {

	public static void main(String[] args) {
		System.out.println(isSpring(1));
		System.out.println(isSpring(3));
		System.out.println(isSpring(4));
		System.out.println(isSpring(5));
		System.out.println(isSpring(-1));
	}
	
	static int isSpring(int month){
		if (month>=1&&month<=12){
			if (month>=3&&month<=5){return 1;}
			else return 0;
		}else return -1;}

}
