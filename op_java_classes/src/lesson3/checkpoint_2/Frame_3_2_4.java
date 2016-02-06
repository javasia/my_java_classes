package lesson3.checkpoint_2;

public class Frame_3_2_4 {

	public static void main(String[] args) {

		int[] data1 = null;
		int[] data2 = { 1, 2, 3, 4, 5 };
		int[] data3 = { 5, 4, 3 };
		int[] data4 = { 2, 1 };
		int[] data5 = {};
		int[] data6 = { 12, 132, 55, 4, 223, 555, 6, 7 };
		int[] data7 = { 0, 0, 0, 0, 0, 0, 0 };

		System.out.println(oddElementSum(data1));
		System.out.println(oddElementSum(data2));
		System.out.println(oddElementSum(data3));
		System.out.println(oddElementSum(data4));
		System.out.println(oddElementSum(data5));
		System.out.println(oddElementSum(data6));
		System.out.println(oddElementSum(data7));

	}

	static int oddElementSum(int[] data) {
		if (data == null || data.length == 0) {
			return -1;
		}
		int res = 0;
		for (int i = 0; i < data.length; i+=2) {
			res += data[i];
		}
		return res;

	}

}
