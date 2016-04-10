package lesson3.checkpoint5.frame_3_5_4;

public class Frame_3_5_4 {

	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			throw new IllegalStateException();
		}finally{
			System.out.println("I want to be printed!");
		}
	}

}
