package lesson3.checkpoint_2;

import java.util.Arrays;

public class Frame_3_2_7 {

	public static void main(String[] args) {

		int[] data1 = {};
		int[] data2 = { 0 };
		int[] data3 = { 1, 2, 3, 4, 5 };
		int[] data4 = { 6, 7, 8, 9, 10 };
		int[] data5 = { 11, 12 };
		int[] data6 = { 13 };

		System.out.println(avarage(data1));
		System.out.println(avarage(data2));
		System.out.println(avarage(data3));
		System.out.println(avarage(data4));
		System.out.println(avarage(data5));
		System.out.println(avarage(data6));
		System.out.println(avarage(null));

	}

	static double avarage(int[] data) {

		if (data == null || data.length == 0) {
			return -1;
		}

		double res = 0;

		for (int i : data) {
			res += i;
		}

		return res / data.length;
	}

}
