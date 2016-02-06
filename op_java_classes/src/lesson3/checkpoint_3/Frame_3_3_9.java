package lesson3.checkpoint_3;

import java.util.Arrays;
import java.util.Random;

public class Frame_3_3_9 {

	public static void main(String[] args) {
		int[] data1 = { 0, -15, -3, 2 };
		int[] data2 = {};
		int[] data3 = { 0, -150, -300, 200 };
		int[] data4 = { 100, -1500, -31, -225 };
		int[] data5 = { 0, 0, 0 };
		int[] data6 = { 0, -1, 2, 3, 5, 6 };
		int[] data7 = generateRandomArray(100);
		int[] data8 = null;

		System.out.println("Interations done data1: " + sort(data1) + "\n" + Arrays.toString(data1) + "\n");
		System.out.println("Interations done data2: " + sort(data2) + "\n" + Arrays.toString(data2) + "\n");
		System.out.println("Interations done data3: " + sort(data3) + "\n" + Arrays.toString(data3) + "\n");
		System.out.println("Interations done data4: " + sort(data4) + "\n" + Arrays.toString(data4) + "\n");
		System.out.println("Interations done data5: " + sort(data5) + "\n" + Arrays.toString(data5) + "\n");
		System.out.println("Interations done data6: " + sort(data6) + "\n" + Arrays.toString(data6) + "\n");
		System.out.println("Interations done rand array: " + sort(data7) + "\n" + Arrays.toString(data7) + "\n");
		System.out.println("Interations done null array: " + sort(data8) + "\n" + Arrays.toString(data8) + "\n");

	}

	static int sort(int[] data) {

		if (data != null && data.length != 0) {

			int sortStartIndex = 0;

			int iterations = 0;

			while (getSortStartIndex(0, data) != data.length - 1) {
				sortStartIndex = getSortStartIndex(sortStartIndex, data);
				iterations = swap(data, sortStartIndex, iterations++);
				if (sortStartIndex == data.length - 1) {
					sortStartIndex = 0;
				}
			}

			return iterations;

		} else {
			System.out.println("Invalid input data!");
			data = null;
			return -1;
		}

	}

	static int getSortStartIndex(int sortStartIndex, int[] data) {

		for (int i = sortStartIndex + 1; i < data.length; i++) {

			if (data[i] < data[i - 1]) {
				return i - 1;
			}
		}
		return data.length - 1;
	}

	static int swap(int[] data, int sortStartIndex, int iterations) {

		if (sortStartIndex + 1 < data.length) {
			int temp = data[sortStartIndex + 1];
			if (data[sortStartIndex] > temp) {
				data[sortStartIndex + 1] = data[sortStartIndex];
				data[sortStartIndex] = temp;
			}
			iterations++;
		}
		return iterations;
	}

	static int[] generateRandomArray(int size) {

		int[] data = new int[size];

		for (int i = size - 1; i > 0; i--) {
			data[i] = (int) (Math.random() * 10);
		}
		return data;
	}

}
