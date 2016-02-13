package lesson1.checkpoint_1_3.frame_1_3_4;

public class Bullet {
	
	int x;
	int y;
	int speed;
	int direction;

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSpeed() {
		return speed;
	}
	public int getDirection() {
		return direction;
	}
	
	public void updateX (int modifier) {
		x+=modifier;
	}
	public void updateY (int modifier) {
		y+=modifier;
	}
	public void destroy (){
		x=-100;
		y=-100;
	}
}


