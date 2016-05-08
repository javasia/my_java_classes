package lesson4.checkpoint4.frame_4_4_4.tanks;

import java.awt.Color;
import java.awt.Graphics;

import lesson4.checkpoint4.frame_4_4_4.enumes.Type;
import lesson4.checkpoint4.frame_4_4_4.interfaces.Destroyable;
import lesson4.checkpoint4.frame_4_4_4.interfaces.Drawable;
import lesson4.checkpoint4.frame_4_4_4.service.ActionField;
import lesson4.checkpoint4.frame_4_4_4.service.BattleField;
import lesson4.checkpoint4.frame_4_4_4.service.Logic;

public abstract class AbstractTank extends Logic implements Drawable, Destroyable {

	public static int totalTanks;

	protected int x;
	protected int y;
	private int direction;
	private int speed = 15;
	private Type type;
	private int crew;
	private int id;
	private int armor;
	private Color towerColor=Color.DARK_GRAY;
	private Color bodyColor=Color.BLACK;
	protected ActionField af;

	public AbstractTank(ActionField af, BattleField bf, Type type) {
		super(bf);
		totalTanks++;
		id = totalTanks;
		this.type = type;
		abstractTank = this;
		this.af = af;
		af.addTank(this);
		setBodyColor(bodyColor);
		setTowerColor(towerColor);
	}

	public void setTowerColor(Color towerColor) {
		this.towerColor = towerColor;
	}

	public void setBodyColor(Color bodyColor) {
		this.bodyColor = bodyColor;
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

	public void setArmor(int armor) {
		this.armor = armor;
	}


	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getId() {
		return id;
	}

	public void fire() throws Exception {
		Bullet bullet = new Bullet((x + 25), (y + 25), direction, id);
		af.processFire(bullet);
	}

	public void move() throws Exception {
		af.processMove(this);
	}

	public void turn(int direction) {
		this.direction = direction;
		af.processTurn(this);
	}

	public void upgradeY(int modifier) {
		y += modifier;
	}

	public void upgradeX(int modifier) {
		x += modifier;
	}

	public void moveRandom() {
	}

	public void moveToQuadrant(int y, int x) {
	}

	public void clean() throws Exception {

		while (getBrickQuadrant() != null) {
			if (killNearest("B")) {
				continue;
			}
			int[] getBrickQuad = getBrickQuadrant();
			goKillNext(getBrickQuad[0], getBrickQuad[1]);
		}

		System.out.println("Cleaning over.");
	}

	public void setTankInitPos() {

		int maxQuadrantsX = bf.getDimentionX();
		int maxQuadrantsY = bf.getDimentionY();
		int minQuadrantsX = 0;
		int minQuadrantsY = 0;
		int cellSize = bf.getCELL_SIZE();

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
		bf.updateQuadrant(maxQuadrantsY, maxQuadrantsX / 2, "");
		y = maxQuadrantsY * cellSize;
		x = maxQuadrantsX / 2 * cellSize;
	}

	private boolean killNearest(String object) throws Exception {

		int shotDirection = returnShotDirection(object);

		if (shotDirection == -1) {
			return false;
		}
		turn(shotDirection);
		fire();
		return true;
	}

	public void destroy() throws Exception {
		if (armor == 0) {
			y = -100;
			x = -100;
			reborn();
		} else {
			armor--;
		}
	}

	public void reborn() throws Exception {
		Thread.sleep(3000);
		if (getType().equals(Type.ATTAKER)) {
			af.setAggressor(this);
			putTankToRndAttackerPos();
			return;
		} else if (getType().equals(Type.DEFENDER)) {
			af.setDefender(this);
			putTankToRndDefenderPos();
			;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(bodyColor);
		g.fillRect(x, y, bf.getCELL_SIZE(), bf.getCELL_SIZE());

		g.setColor(towerColor);
		if (direction == 1) {
			g.fillRect(x + 20, y, 24, 34);
		} else if (direction == 2) {
			g.fillRect(x + 20, y + 30, 24, 34);
		} else if (direction == 3) {
			g.fillRect(x, y + 20, 34, 24);
		} else {
			g.fillRect(x + 30, y+ 20, 34, 24);
		}
	} 
}
