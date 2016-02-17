package lesson1.checkpoint_1_4.frame_1_4_5;

public class Steering {

	private int position;
	private int steeringMaxPosintionGrad = 360;
	private int steeringMinPosintionGrad = 0;

	Steering(int steeringMaxPosintionGrad, int steeringMinPosintionGrad) {
		this.steeringMaxPosintionGrad = steeringMaxPosintionGrad;
		this.steeringMinPosintionGrad = steeringMinPosintionGrad;
		position = steeringMaxPosintionGrad/2;
		System.out.println("Steetring wheel has been created. SteeringMaxPosintionGrad: " + steeringMaxPosintionGrad
				+ ". SteeringMinPosintionGrad: " + steeringMinPosintionGrad + ".");
	}

	public void turn(int grad) {
		if (grad + position >= steeringMinPosintionGrad && grad + position <= steeringMaxPosintionGrad) {
			position += grad;
			System.out.println("New wheel position has been set to: " + position + ".");
		} else {
			System.out.println("Turning limit exceeded! Ignored.");
		}
	}
}
