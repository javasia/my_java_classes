package lesson3.checkpoint_5;

public class Frame_3_5_1 {

	public static void main(String[] args) {

		double[] numbers = { 1.0, 2.3, 4.5, 6.0, 5.6 };
		double el = 4.5;
		System.out.println("Index of el = "+findElement(numbers, el));
		
		numbers = null;
		el = 4.5;
		System.out.println("Index of el = "+findElement(numbers, el));		
		
		double[] numbers2 = { 1.0, 2.3, 4.5, 6.0, 5.6 };
		el = 10.0;
		System.out.println("Index of el = "+findElement(numbers2, el));		

		double[] numbers3 = new double[0];
		el = 4.5;
		System.out.println("Index of el = "+findElement(numbers3, el));

	}

	static int findElement(double[] numbers, double el) {
		if (numbers != null) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == el) {
					return i;
				}
			}
		} else {
			System.out.println("Illegal parameters!");
		}
		return -1;

	}

}
