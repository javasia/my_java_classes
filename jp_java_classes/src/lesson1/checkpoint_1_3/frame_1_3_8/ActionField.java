package lesson1.checkpoint_1_3.frame_1_3_8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ActionField {
	
	final boolean COLORDED_MODE = false;
	final int BLINK_TIMES = 3;

	private Tank tank = new Tank();
	private Bullet bullet = new Bullet(-100, -100, 1);
	private BattleField bf = new BattleField();
			
	public Tank getTank() {
		return tank;
	}
	public void setTank(Tank tank) {
		this.tank = tank;
	}
	public Bullet getBullet() {
		return bullet;
	}
	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}
	public BattleField getBf() {
		return bf;
	}
	public void setBf(BattleField bf) {
		this.bf = bf;
	}
	
	public void processTurn(Tank tank){
		this.tank.setDirection(tank.getDirection());
		repaint();
	}
	
	public void processMove(Tank tank) throws InterruptedException {

		processTurn(tank);
		
		int direction = tank.getDirection();

		int[][] modifier = returnDirModifier();

		for (int i = 0; checkFieldMargins(tank, tank.getY(), tank.getX()) && i <  bf.getCELL_SIZE(); i++) {
			this.tank.setY(modifier[direction - 1][0]);
			this.tank.setX(modifier[direction - 1][1]);
			repaint();
			Thread.sleep(tank.getSpeed());
		}
	}
	
	int[][] returnDirModifier() {
		int[][] dirModifier = new int[4][];
		dirModifier[0] = new int[] { -1, 0 };
		dirModifier[1] = new int[] { 1, 0 };
		dirModifier[2] = new int[] { 0, -1 };
		dirModifier[3] = new int[] { 0, 1 };
		return dirModifier;
	}
	
	void processFire(Bullet bullet) throws Exception {

		this.bullet.updateX(bullet.getX()); 
		this.bullet.updateY(bullet.getY()); 
		
		int tankDirection = tank.getDirection();
		
		int[][] modifier = returnDirModifier();

		while (checkFieldMargins(bullet, this.bullet.getX(), this.bullet.getY()) && !processInterception("B")) {
			this.bullet.updateX(modifier[tankDirection - 1][0]);
			this.bullet.updateY(modifier[tankDirection - 1][1]);
			repaint();
			Thread.sleep(bullet.getSpeed());

		}
		bullet.destroy();
	}
	

	void runTheGame() throws Exception {


	}

	boolean processInterception(String object) throws Exception {

		int quadY = getQuadrant(bullet.getX(), bullet.getY())[0];
		int quadX = getQuadrant(bullet.getX(), bullet.getY())[1];

		if (checkFieldMargins(quadY, quadX)) {
			return false;
		}

		if (bf.getBattleField()[quadY][quadX].equals(object)) {
			blinkOnHit(quadY, quadX, BLINK_TIMES);
			bf.getBattleField()[quadY][quadX] = "";
			repaint();
			return true;
		}
		return false;
	}
	
	boolean checkFieldMargins(int quadY, int quadX) {
		return (quadX > bf.getBF_WIDTH() || quadY > bf.getBF_HEIGHT() || quadX < 0 || quadY < 0);
	}

	boolean checkFieldMargins(Tank tank, int y, int x) {

		if (x <= bf.getBF_WIDTH() * bf.getCELL_SIZE() && x >= 0 && y <= bf.getBF_HEIGHT() * bf.getCELL_SIZE()
				&& y >= 0) {
			return true;
		}
		return false;
	}
	
	boolean checkFieldMargins(Bullet bullet, int y, int x) {

		if (x <= bf.getBF_WIDTH() + bf.getCELL_SIZE() && x >= 0 - bf.getCELL_SIZE() && y <= bf.getBF_HEIGHT()*bf.getCELL_SIZE()
				&& y >= 0 - bf.getCELL_SIZE()) {
			return true;
		}
		return false;
	}
	
	int[] getQuadrant(int x, int y) {
		int[] res = { y / bf.getCELL_SIZE(), x / bf.getCELL_SIZE() };
		return res;
	}

	void blinkOnHit(int quadY, int quadX, int times) throws Exception {
		String temp = bf.getBattleField()[quadY][quadX];

		for (int i = 0; i < times; i++) {
			bf.getBattleField()[quadY][quadX] = "";
			repaint();
			Thread.sleep(30);
			bf.getBattleField()[quadY][quadX] = temp;
			repaint();
			Thread.sleep(30);
		}

	}
	
	public ActionField()  throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(bf.getBF_WIDTH() + 18, bf.getBF_HEIGHT() + 47));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * bf.getCELL_SIZE(), v * bf.getCELL_SIZE(), bf.getCELL_SIZE(), bf.getCELL_SIZE());
			}
		}

		for (int j = 0; j < bf.getBattleField().length; j++) {
			for (int k = 0; k < bf.getBattleField().length; k++) {
				if (bf.getBattleField()[j][k].equals("B")) {
					int y = j * bf.getCELL_SIZE();
					int x = k * bf.getCELL_SIZE();
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, bf.getCELL_SIZE(), bf.getCELL_SIZE());
				}
			}
		}

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tank.x, tank.y, bf.getCELL_SIZE(), bf.getCELL_SIZE());

		g.setColor(new Color(0, 255, 0));
		if (tank.direction == 1) {
			g.fillRect(tank.x + 20, tank.y, 24, 34);
		} else if (tank.direction == 2) {
			g.fillRect(tank.x + 20, tank.y + 30, 24, 34);
		} else if (tank.direction == 3) {
			g.fillRect(tank.x, tank.y + 20, 34, 24);
		} else {
			g.fillRect(tank.x + 30, tank.y + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.x, bullet.y, 14, 14);
	}
	
}
