package lesson3.checkpoint_3;

public class Frame_3_3_12 {

	public static void main(String[] args) {

		String[][] data = new String[6][];

		data[0] = new String[] { "China", "Beijing", "1354040000" };

		data[1] = new String[] { "India", "New Dehli", "1210569573" };

		data[2] = new String[] { "USA", "Washingtown D.C.", "316305000" };

		data[3] = new String[] { "Indonesia", "Jakarta", "237641326" };

		data[4] = new String[] { "Brazil", "Brasilia", "193946886" };

		data[5] = new String[] { "Pakistan", "Isalamabad", "183748060" };

		System.out.println(getPopulation(data));
		System.out.println(getPopulation(null));

	}

	static long getPopulation(String[][] data) {
		long res = 0;
		int rawNumber = 3; // could be used as method Parameter latter
		int parameterIdx = rawNumber - 1;
		if (data != null && data.length > 0) {
			for (int i = 0; i < data.length; i++) {
				if (data[i].length >= rawNumber && data[i][parameterIdx] != null
						&& data[i][parameterIdx].length() > 0) {
					res += Integer.parseInt(data[i][parameterIdx]);
				} else {
					return -1;
				}
			}
			return res;
		} else {
			return -1;
		}
	}

}
