package lesson3.checkpoint_3;

import java.util.Arrays;

public class Frame_3_3_14 {

	public static void main(String[] args) {

		int[] data1 = { 1, 2, 3 };
		int[] data2 = { 3, 2, 1, };
		int[] data3 = { 0, 1 };
		int[] data4 = { 3, 2, 1, 0, -1 };
		int[] data5 = {};

		System.out.println(Arrays.toString(union(data1, data2)));
		System.out.println(Arrays.toString(union(data3, data4)));
		System.out.println(Arrays.toString(union(data4, data3)));
		System.out.println(Arrays.toString(union(data1, data5)));
		System.out.println(Arrays.toString(union(null, data2)));
		System.out.println(Arrays.toString(union(data1, null)));

	}

	static int[] union(int[] data1, int[] data2) {
		if (data1 != null && data2 != null) {
			int[] res = new int[data1.length + data2.length];
			for (int i = 0; i < data1.length; i++) {
				res[i] = data1[i];
			}
			for (int i = 0; i < data2.length; i++) {
				res[i + data1.length] = data2[i];
			}

			return res;
		} else {
			System.out.println("Illigal parameters!");
			return null;
		}

	}
}
