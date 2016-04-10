package lesson3.checkpoint5.frame_3_5_2;

public class TryChecker {

	public static void main(String[] args) {

		try {
			return;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			System.out.println("I want to be executed!");
		}

	}

}
