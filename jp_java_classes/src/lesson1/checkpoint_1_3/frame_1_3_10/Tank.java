package lesson1.checkpoint_1_3.frame_1_3_10;

public class Tank {

	private int x;
	private int y;
	private int direction;
	private int speed;
	private ActionField af; 
	private BattleField bf; 
	


	public Tank() {
	
	}
		
	public BattleField getBf() {
		return bf;
	}
	
	public int getSpeed() {
		return speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void fire () throws Exception{
		Bullet bullet= new Bullet(x+25,y+25,direction);
		af.processFire(bullet);
	}
	public void move () throws Exception{
		af.processMove(this);
	}
	public void turn (){
		af.processTurn(this);
	}
	public void moveRandom (){
	}
	public void moveToQuadrant (int y, int x){
	}
	
	
}
