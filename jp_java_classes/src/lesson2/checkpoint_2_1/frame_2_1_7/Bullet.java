package lesson2.checkpoint_2_1.frame_2_1_7;

public class Bullet {
	
	private int x;
	private int y;
	private int speed=5;
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


