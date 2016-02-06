package lesson3.checkpoint_3;

import java.util.Arrays;

public class Frame_3_3_7 {

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

		// create big array
		int[] data1k = new int[1000];
		int i = 1000;
		for (int val : data1k) {
			data1k[--i] = 1000 - i;
		}

		System.out.println(Arrays.toString(data1k));
		sort(data1k);

	}

	static void sort(int[] data) {

		if (data != null && data.length != 0) {
			int iterationsNew = 0;
			int iterationsOld = 0;
			int[] data2 = Arrays.copyOf(data, data.length);
			for (int i = 0; i < data.length; i++) {
				iterationsNew = swapNew(data, i, iterationsNew) + 1;
				iterationsOld = swapOld(data2, iterationsOld) + 1;
			}
			System.out.println(Arrays.toString(data) + " interations by new method: " + iterationsNew);
			System.out.println(Arrays.toString(data2) + " interations by old method: " + iterationsOld);
		} else {
			System.out.println("Invalid input data!");

		}

	}

	static int swapNew(int[] data, int j, int iterations) {

		for (int i = 1; i < data.length - j; i++) {
			int temp = data[i];
			if (data[i - 1] > temp) {
				data[i] = data[i - 1];
				data[i - 1] = temp;
			}
			iterations++;
		}
		return iterations;
	}

	static int swapOld(int[] data, int iterations) {

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
