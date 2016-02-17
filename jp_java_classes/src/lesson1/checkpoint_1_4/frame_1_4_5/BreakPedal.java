package lesson1.checkpoint_1_4.frame_1_4_5;

public class BreakPedal {
	private boolean isPushed;

	public boolean isPushed() {
		return isPushed;
	}

	public void push() {
		isPushed = true;
		System.out.println("Pedal is pushed");
	}

	public void release() {
		isPushed = false;
		System.out.println("Pedal is released");
	}
}
