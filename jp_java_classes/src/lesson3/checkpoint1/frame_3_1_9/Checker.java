package lesson3.checkpoint1.frame_3_1_9;

public class Checker {

	public static void testThrowMyException(int[] testArray, int i) throws MyException {
		if (i >= testArray.length) {
			throw new MyException("\nIndex is out of bound!");
		} else {
			System.out.println();
		}
	}

	public static void testThowIndexOutOfBound(int[] testArray, int i) throws RuntimeException {

		try {
			int n = testArray[i];
		} finally {
			System.out.println();
		}

	}

}
