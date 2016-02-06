package lesson2.key_point_2;

public class Frame_2_2_16 {

	public static void main(String[] args) {
		System.out.println(min(1,2,3));
		System.out.println(min(3,2,1));
		System.out.println(min(3,1,2));
		System.out.println(min(3,1,1));
		System.out.println(min(3,3,1));
		System.out.println(min(3,3,3));

	}
	
	static int min(int a, int b, int c){
		if (b>a)b=a;
		else if (c>a)c=a;
		if (c>b)return b;
		else return c;
	}

}
