package lesson1.checkpoint_1_4.frame_1_4_5;

public class Starter {

	public static void main(String[] args) {
		Car car = new Car(Color.AUBERGINE, 8, "Diesel", 600, GearBoxTypes.MANUAL_6_GEARS, 2, 800, "agent777", 360, 0);
		car.createDoor(0, DoorPosition.FRONT_LEFT);
		car.createDoor(1, DoorPosition.FRONT_RIGHT);
		
		car.doors[0].open();
		car.doors[0].close();
		car.doors[0].lock(car.key);
		car.doors[0].unlock(car.key);
		
		car.doors[1].lock(car.key);
		Key key= new Key("ABC");
		car.doors[1].unlock(key);
		
		car.startEngine(key);
		car.startEngine(car.key);
		car.stopEngine();
		
		car.turnLeft(50);
		car.turnLeft(10);
		car.turnRight(180);
		
		car.shiftGearUp();
		car.shiftGearDown();
		car.shiftGearDown();
		
		car.pushGazPedal();
		car.pushBreakPedal();
		car.releaseBreakPedal();
	}

}
