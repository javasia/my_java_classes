package lesson1.checkpoint_1_4.frame_1_4_5;

public class Wheels {

	private int number;
	private boolean isOkay; 
	
	Wheels (int number){
		this.number=number;
		isOkay=true;
		System.out.println("Wheel number "+number+" has been created.");
	}

	public boolean isOkay() {
		return isOkay;
	}

	public void updateStatus(boolean isBroken) {
		this.isOkay = !isBroken;
		String status="is okay";
		if (isBroken){
			status="is broken.";
		}
		System.out.println(("Wheel number " + number + status));
	}

}
