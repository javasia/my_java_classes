package lesson4.checkpoint2.frame_4_2_16;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		char ch1 = o1.charAt(0);
		char ch2 = o2.charAt(0);

		if (ch1 > ch2) {
			return -1;
		} else if (ch1 < ch2) {
			return 1;
		}
		return 0;
	}

}
