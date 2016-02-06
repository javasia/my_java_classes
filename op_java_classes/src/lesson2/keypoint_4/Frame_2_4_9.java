package lesson2.keypoint_4;

public class Frame_2_4_9 {

	public static void main(String[] args) {

		printNumbers(30, 10);

		printNumbers(-100, 10);

		printNumbers(30, 30);

		printNumbers(30, -10);

		printNumbers(0, 10);

		printNumbers(30, 0);

		printNumbers(0, 0);

		printNumbers(-2, -40);

		printNumbers(-20, -4);

	}

	static void printNumbers(int i, int n) {

		while (i < n) {
			n++;
			i += n;
			System.out.println("i=" + i + " n=" + n);
		}
	}

}
