package lesson2.frame_2_6.frame_2_6_6;

public class Tank {

	private int x;
	private int y;
	private int direction;
	private int speed = 15;
	private ActionField af;
	private BattleField bf;
	private Logic logic;
	private Type type;
	private Colors color;
	private int crew;
	private int maxSpeed;

	public Colors getColor() {
		return color;
	}
	
	public void setColor(Colors color) {
		this.color = color;
	}
	
	public int getCrew() {
		return crew;
	}
	
	public void setCrew(int crew) {
		this.crew = crew;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public Tank(ActionField af, BattleField bf) {
		x = 0;
		y = 0;
		direction = 1;
		this.af = af;
		this.bf = bf;
		logic=new Logic(af, bf, this);
	}

	public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.af = af;
		this.bf = bf;
		logic=new Logic(af, bf, this);
	}
	


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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
		Bullet bullet = new Bullet((x + 25), (y + 25), direction);
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
	
	public void clean() throws Exception {

		while (logic.getBrickQuadrant() != null) {
			if (killNearest("B")) {
				continue;
			}
			int[] getBrickQuad = logic.getBrickQuadrant();
			logic.goKillNext(getBrickQuad[0], getBrickQuad[1]);
		}
		
		System.out.println("Cleaning over.");
	}
	
	
	public void setTankInitPos() {
		
		int maxQuadrantsX=bf.getDimentionX();
		int maxQuadrantsY=bf.getDimentionY();
		int minQuadrantsX=0;
		int minQuadrantsY=0;
		int cellSize=bf.getCELL_SIZE();

		for (int i = maxQuadrantsY; i >= minQuadrantsY; i--) {
			for (int j = minQuadrantsX; j <= maxQuadrantsX; j++) {
				if (bf.scanQuadrant(i, j).equals("") || bf.scanQuadrant(i, j).equals(" ")) {
					y = i * cellSize;
					x = j * cellSize;
					System.out.println("Init tank coordinates set as:" + y + ":" + x);
					return;
				}
			}
		}
		bf.updateQuadrant(maxQuadrantsY, maxQuadrantsX/2, "");
		y = maxQuadrantsY * cellSize;
		x = maxQuadrantsX / 2 * cellSize;
	}

	
	private boolean killNearest(String object) throws Exception {

		int shotDirection = logic.returnShotDirection(object);

		if (shotDirection == -1) {
			return false;
		}
		turn(shotDirection);
		fire();
		return true;
	}
	
	public void destroy(){
		y = -100;
		x = -100;
	}
	
	
	public void putTankToRndAttackerPos(){
		logic.putTankToRndAttackerPos();
	}
	
	public void putTankInCenter(){
		logic.putTankInCenter();
	}



}
