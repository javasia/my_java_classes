package lesson3.checkpoint1.frame_3_1_9;

public class Core {

	private int[] testArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public void runMyExpeptionTest() {

		int i = 0;
		while (true) {
			try {
				Checker.testThrowMyException(testArray, i);
				System.out.print(i++);
			}

			catch (MyException e) {
				System.out.println(e.getMessage());
				System.out.println("over!");
				break;
			}
		}
	}

	public void runIndexOutOfBoundTest() {

		int i = 0;
		while (true) {
			try {
				Checker.testThowIndexOutOfBound(testArray, i);
				System.out.print(i++);
			}

			catch (RuntimeException e) {
				e.printStackTrace();
				System.out.println("over!");
				break;
			}
		}
	}
}
