package lesson1.checkpoint_1_4.frame_1_4_5;

public enum GearBoxTypes {
AUTOMATIC(0), MANUAL_3_GEARS(1), MANUAL_4_GEARS(2), MANUAL_5_GEARS(3), MANUAL_6_GEARS(4), MANUAL_7_GEARS(5);
	int id;
	
	private GearBoxTypes(int id) {
	this.id=id;
	}
}
