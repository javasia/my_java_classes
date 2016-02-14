package lesson1.checkpoint_1_3.frame_1_3_10;

public class Bullet {
	
	private int x;
	private int y;
	private int speed=10;
	private int direction;
	
	Bullet (int x, int y, int direction){
	this.x=x;	
	this.y=y;	
	this.direction=direction;	
	}

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


