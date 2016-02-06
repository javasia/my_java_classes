package lesson2.keypoint_4;

public class Frame_2_4_7 {

	public static void main(String[] args) {

		start(-1);
		System.out.println(" ----------");
		start(0);
		System.out.println(" ----------");
		start(10);



	}

	static void start(int number) {

		if (number > 0) {
			while (number >= 0) {
				System.out.println(number--);
			}
			System.out.println("Go!");
		} else {
			System.out.println("Start failed!");
		}

	}

}
