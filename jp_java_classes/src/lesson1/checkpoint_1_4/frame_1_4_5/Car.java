package lesson1.checkpoint_1_4.frame_1_4_5;

public class Car {
	
	Color color;
	Wheels[] wheels;
	Engine engine;
	GearBox gearBox;
	GazPedal gazPedal;
	BreakPedal breakPedal;
	GearingPedal gearingPedal;
	Doors[] doors;
	FuelTank fuelTank;
	Key key;
	Steering steering;

	Car(Color color, int numberOfWheels, String engineType, int EngineHorsePower, GearBoxTypes gearboxType,
			int numberOfDoors, int fuelTankCapacity, String keyPassword, int steeringMaxPosintionGrad, int steeringMinPosintionGrad) {
		this.color = color;
		System.out.println("Car color set as: " + color + ".");
		createWheels(numberOfWheels);
		engine = new Engine(engineType, EngineHorsePower);
		gearBox = new GearBox(gearboxType);
		fuelTank = new FuelTank(fuelTankCapacity);
		gazPedal = new GazPedal();
		breakPedal = new BreakPedal();

		if (gearBox.getGearBoxType() != GearBoxTypes.AUTOMATIC) {
			gearingPedal = new GearingPedal();
		}

		key = new Key(keyPassword);
		
		doors = new Doors[numberOfDoors];
		
		steering= new Steering(steeringMaxPosintionGrad, steeringMinPosintionGrad);
	}

	public void createDoor(int doorNumber, DoorPosition doorPosition) {
		if (doorNumber >= 0 && doorNumber < doors.length) {
			doors[doorNumber] = new Doors(doorPosition, key);
			System.out.println("Door has been created. Door postion is: " + doorPosition + ".");
			return;
		}
		System.out.println("Illegal door number!");
	}

	private void createWheels(int wheelsQty) {
		wheels = new Wheels[wheelsQty];
		int i = 0;
		for (Wheels wheel : wheels) {
			wheel = new Wheels(i++);
		}
	}

	public void openDoor(Doors door) {
		door.open();
	}

	public void closeDoor(Doors door) {
		door.close();
	}

	public void startEngine(Key key) {
		if (this.key.getPassword().equals(key.getPassword())){
		engine.start();
		}else{
			System.out.println("Key does not match!");
		}
	}

	public void stopEngine() {
		engine.stop();
	}

	public void pushGazPedal() {
		gazPedal.push();
	}

	public void releaseGazPedal() {
		gazPedal.release();
	}

	public void pushBreakPedal() {
		breakPedal.push();
	}

	public void releaseBreakPedal() {
		breakPedal.release();
	}

	public void pushGearingPedal() {
		gearingPedal.push();
	}

	public void releaseGearingPedal() {
		gearingPedal.release();
	}

	public void shiftGearUp() {
		int curGear=gearBox.getCurGear();
		gearBox.setGeer(curGear+1);
	}

	public void shiftGearDown() {
		int curGear=gearBox.getCurGear();
		gearBox.setGeer(curGear-1);
	}

	public void turnLeft(int grad) {
		steering.turn(grad*-1);
	}

	public void turnRight(int grad) {
		steering.turn(grad);
	}

}
