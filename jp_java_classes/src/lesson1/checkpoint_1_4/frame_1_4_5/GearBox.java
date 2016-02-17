package lesson1.checkpoint_1_4.frame_1_4_5;

public class GearBox {

	private GearBoxTypes gearBoxType;
	private int curGear;

	public GearBox(GearBoxTypes gearBoxType) {
		this.gearBoxType = gearBoxType;
		System.out.println(
				"GearBox has been created. GearBoxType is: " + gearBoxType + ". Current gear set to: " + curGear + ".");
	}

	public GearBoxTypes getGearBoxType() {
		return gearBoxType;
	}

	public int getCurGear() {
		return curGear;
	}

	public void setGeer(int gear) {
		if (gear < 0 || gear > gearBoxType.id) {
			return;
		}
		this.curGear = gear;
		System.out.println("Gear set to: " + curGear + ".");
	}
}
