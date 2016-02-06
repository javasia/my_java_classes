package lesson3.checkpoint_5;

import java.util.Arrays;

public class Frame_3_5_9 {

	public static void main(String[] args) {
		printArray(new String[][] { {}, {} });
		printArray(new String[][] { { "Oleg" }, { "Inna", "Smith", "25" }, { "Irina", "Koval" } });
		printArray(new String[][] { {}, { "Oleg", "Kotov", "16" }, {} });
		printArray(new String[][] { { "Oleg" }, { "Anton" }, null, { "Anna", "25" } });
		printArray(new String[][] { { "Oleg" }, { "Anton" }, { null, "25" } });
		printArray(null);

	}

	static void printArray(String[][] data) {

		for (int i = 0; data != null && i < data.length; i++) {

			if (data[i] == null) {
				continue;
			}

			String end = " ";

			for (int j = 0; j < data[i].length; j++) {

				if (data[i][j] == null) {
					continue;
				}
				if (j == data[i].length - 1) {
					end = "\n";
				}
				System.out.print(data[i][j] + end);
			}
		}
	}
}