package lesson1.checkpoint_1_3.frame_1_3_12;

public class Tank {

	private int x;
	private int y;
	private int direction;
	private int speed = 20;
	private ActionField af;
	private BattleField bf;

	public Tank(ActionField af, BattleField bf) {
		x = 0;
		y = 0;
		direction = 1;
		this.af = af;
		this.bf = bf;
	}

	public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.af = af;
		this.bf = bf;
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

	public void fire() throws Exception {
		Bullet bullet = new Bullet(x + 25, y + 25, direction);
		af.processFire(bullet);
	}

	public void move() throws Exception {
		af.processMove(this);
	}

	public void turn(int direction) {
		this.direction = direction;
		af.processTurn(this);
	}
	
	public void upgradeY (int modifier){
		y += modifier;
	} 
	public void upgradeX (int modifier){
		x += modifier;
	} 

	public void moveRandom() {
	}

	public void moveToQuadrant(int y, int x) {
	}

}
