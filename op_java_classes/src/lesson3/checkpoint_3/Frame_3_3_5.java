package lesson3.checkpoint_3;

import java.util.Arrays;

public class Frame_3_3_5 {

	public static void main(String[] args) {
		int[] data1 = { 0, -15, -3, 2 };
		int[] data2 = {};
		int[] data3 = { 0, -150, -300, 200 };
		int[] data4 = { 100, -1500, -31, -225 };
		int[] data5 = { 0, 0, 0 };
		int[] data6 = { 0, 1, -3, 2 };
		sort(data1);
		sort(data2);
		sort(data3);
		sort(data4);
		sort(data5);
		sort(data6);
		sort(null);

	}

	static void sort(int[] data) {

		if (data != null && data.length != 0) {
			// after_watching_further_frames
			int iterations = 0;
			for (int i = 0; i < data.length; i++) {
				iterations=swap(data, iterations)+1;
			}
			System.out.println(Arrays.toString(data)+" iterations: "+iterations);
		} else {
			System.out.println("Invalid input data!");

		}

		// intitial_attempt
		// for (int i = 0; i < data.length; i++) {
		// for (int j = 0; j < data.length; j++) {
		// if (j + 1 != data.length && data[j] > data[j + 1]) {
		// int temp = data[j + 1];
		// data[j + 1] = data[j];
		// data[j] = temp;
		// }
		// }
		// }
		// System.out.println(Arrays.toString(data));
		// } else {
		// System.out.println("Invalid input data!");

	}

	static int swap(int[] data, int iterations) {

		for (int i = 1; i < data.length; i++) {
			int temp = data[i];
			if (data[i - 1] > temp) {
				data[i] = data[i - 1];
				data[i - 1] = temp;
			}
			iterations++;
		}
		return iterations;
	}

}
