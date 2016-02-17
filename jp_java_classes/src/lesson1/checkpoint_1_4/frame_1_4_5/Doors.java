package lesson1.checkpoint_1_4.frame_1_4_5;

public class Doors {
	private DoorPosition doorPos;
	private boolean isOpened;
	private boolean isLocked;
	private Key key;

	Doors(DoorPosition doorPos, Key key) {
		this.doorPos = doorPos;
		this.isOpened = true;
		this.key=key;
		System.out.println("Door has been created. Door position is: "+doorPos+". Doors is closed.");
	}

	public boolean isOpened() {
		return isOpened;
	}
	
	public void open() {
		this.isOpened = true;
		System.out.println("Door has been opened.");
	}
	public void close() {
		this.isOpened = false;
		System.out.println("Door has been closed.");
	}
	
	public void lock(Key key) {
		if (isOpened==true){
			System.out.println("Please close the door before locking!");
		}
		if (this.key.getPassword().equals(key.getPassword())){
			isLocked=true;
			System.out.println("Door has been locked.");
			return;
		}
		System.out.println("Key does not match!");
	}
	public void unlock(Key key) {
		if (this.key.getPassword().equals(key.getPassword())){
			isLocked=false;
			System.out.println("Door has been unlocked.");
			return;
		}
		System.out.println("Key does not match!");
	}
	
}
