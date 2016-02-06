package lesson3.checkpoint_1;

public class Frame_3_1_10 {

	public static void main(String[] args) {
		int[] data = { 10, 4, 25, -3 };

		swap(data, 1, 2);
		swap(data, -1, 2);
		swap(data, 100, 2);
		swap(data, 3, 2);
		swap(data, 4, 1);
		swap(null, 0, 3);

	}

	static void swap(int[] data, int i, int k) {

		if (data!=null&&i >= 0 && k >= 0 && i <= data.length - 1 && k <= data.length - 1) {

			System.out.print("Before: ");
			int n = 0;
			while (n <= data.length - 1) {
				System.out.print(data[n++] + " ");
			}
			System.out.println("");

			int temp = data[i];
			data[i] = data[k];
			data[k] = temp;

			n = 0;
			System.out.print("After: ");
			while (n <= data.length - 1) {
				System.out.print(data[n++] + " ");
			}
			System.out.println("");
		} else {
			System.out.println("Illegal parameters!");
		}

	}
}
