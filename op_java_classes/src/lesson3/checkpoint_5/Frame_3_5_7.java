package lesson3.checkpoint_5;

public class Frame_3_5_7 {

	public static void main(String[] args) {

		System.out.println(factorial(5));
		System.out.println(factorial(3));
		System.out.println(factorial(1));
		System.out.println(factorial(0));
		System.out.println(factorial(-12));

	}

	static long factorial(int n) {

		if (n < 0) {
			System.out.println("Illegal parameters. Parameter cannot be less than 0.");
			return -1;
		}

		long res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

}
