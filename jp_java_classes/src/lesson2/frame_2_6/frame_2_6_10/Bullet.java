package lesson2.frame_2_6.frame_2_6_10;

public class Bullet {
	
	private int x;
	private int y;
	private int speed=5;
	private int direction;
	private int originId;
	
	Bullet (int x, int y, int direction, int originId){
	this.originId=originId;
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
	
	public int getOriginId() {
		return originId;
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


