package lesson2.frame_2_6.frame_2_6_8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {

	final boolean COLORDED_MODE = false;
	final int BLINK_TIMES = 3;

	private Tank aggressor;
	private Tank defender;
	private Bullet bullet;
	private BattleField bf;
	private Tank[] tanks = new Tank[10];

	public void processTurn(Tank tank) {
		repaint();
	}

	public void processMove(Tank tank) throws Exception {

		int direction = tank.getDirection();
		int[][] modifier = returnDirModifier();

		for (int i = 0; checkFieldMargins(tank, tank.getY(), tank.getX()) && i < bf.getCELL_SIZE(); i++) {
			tank.upgradeY(modifier[direction - 1][0]);
			tank.upgradeX(modifier[direction - 1][1]);
			repaint();
			Thread.sleep(tank.getSpeed());
		}
	}

	private int[][] returnDirModifier() {
		int[][] dirModifier = new int[4][];
		dirModifier[0] = new int[] { -1, 0 };// 1 up
		dirModifier[1] = new int[] { 1, 0 };// 2 down
		dirModifier[2] = new int[] { 0, -1 };// 3 left
		dirModifier[3] = new int[] { 0, 1 };// 4 right
		return dirModifier;
	}

	public void processFire(Bullet bullet) throws Exception {

		this.bullet = bullet;

		int direction = this.bullet.getDirection();

		int[][] modifier = returnDirModifier();

		while (checkFieldMargins(this.bullet, this.bullet.getX(), this.bullet.getY())
				&& !processInterception("B", bullet.getOriginId())) {

			this.bullet.updateY(modifier[direction - 1][0]);
			this.bullet.updateX(modifier[direction - 1][1]);

			repaint();
			Thread.sleep(this.bullet.getSpeed());

		}

		this.bullet.destroy();
		repaint();
	}

	public void runTheGame() throws Exception {

		bf.printFieldToConsole();

		// tank.setTankInitPos();

		defender.putTankInCenter();// for testing purposes

		// tank.clean();

		// tank.destroy();

		aggressor.putTankToRndAttackerPos();

		repaint();

		aggressor.clean();

	}

	private boolean processInterception(String obstacle, int tankId) throws Exception {

		int quadY = getQuadrant(bullet.getX(), bullet.getY())[0];
		int quadX = getQuadrant(bullet.getX(), bullet.getY())[1];

		if (checkFieldMargins(quadY, quadX)) {
			return false;
		}

		if (bf.scanQuadrant(quadY, quadX).equals(obstacle)) {
			blinkOnHit(quadY, quadX, BLINK_TIMES);
			bf.updateQuadrant(quadY, quadX, "");
			repaint();
			return true;
		}
		
		if (tankInterception(tankId, quadY, quadX)){
			bullet.destroy();
			return true;
		}
		
		return false;

	}
	
	private boolean tankInterception(int id, int quadY, int quadX) throws Exception{
		
		for (Tank t:tanks){
			if (t!=null && id != t.getId()){
				int[] tQuanrant = getQuadrant(t.getX(), t.getY());
				if (tQuanrant[0]==quadY && tQuanrant[1]==quadX){
					t.destroy();
					reborn(t.getType());
					return true;
				}
			}
		}
		return false;
	}
	
	private void reborn(Type type) throws Exception{
		Thread.sleep(3000);
		if (type.equals(Type.ATTAKER)){
			aggressor=new Tank(this, bf, type);
			aggressor.putTankToRndAttackerPos();
			return;
		}else if (type.equals(Type.DEFENDER)){
			defender=new Tank (this, bf, type);
			defender.putTankToRndDefenderPos();;
			//defender.putTankInCenter();// for testing only
		}
	}

	private boolean checkFieldMargins(int quadY, int quadX) {
		return (quadX >= bf.getBattleField().length || quadY >= bf.getBattleField().length || quadX < 0 || quadY < 0);
	}

	private boolean checkFieldMargins(Tank tank, int y, int x) {

		if (x <= bf.getBF_WIDTH() && x >= 0 && y <= bf.getBF_HEIGHT() && y >= 0) {
			return true;
		}
		return false;
	}

	private boolean checkFieldMargins(Bullet bullet, int y, int x) {

		if (x <= (bf.getBF_WIDTH() + bf.getCELL_SIZE()) && x >= (0 - bf.getCELL_SIZE())
				&& (y <= bf.getBF_HEIGHT() + bf.getCELL_SIZE()) && (y >= 0 - bf.getCELL_SIZE())) {
			return true;
		}
		return false;
	}

	public int[] getQuadrant(int x, int y) {
		int[] res = { y / bf.getCELL_SIZE(), x / bf.getCELL_SIZE() };
		return res;
	}

	public int[] getQuadrantXY(int x, int y) {
		int[] res = { y * bf.getCELL_SIZE(), x * bf.getCELL_SIZE() };
		return res;
	}

	private void blinkOnHit(int quadY, int quadX, int times) throws Exception {
		String temp = bf.scanQuadrant(quadY, quadX);

		for (int i = 0; i < times; i++) {
			bf.updateQuadrant(quadY, quadX, "");
			repaint();
			Thread.sleep(30);
			bf.updateQuadrant(quadY, quadX, temp);
			repaint();
			Thread.sleep(30);
		}

	}
	
	public void addTank (Tank tank){
		if (tank.getId()<tanks.length){
		tanks[tank.getId()]=tank;
		return;
		}
		increase(tank.getId());
		addTank(tank);
	}
	
	private void increase(int id){
		tanks=Arrays.copyOf(tanks, (int)(id*1.3));
	}

	public ActionField() {

		bf = new BattleField();
		bullet = new Bullet(-100, -100, -1, 0);
		defender = new Tank(this, bf, Type.DEFENDER);
		aggressor = new Tank(this, bf, Type.ATTAKER);

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
				if (bf.scanQuadrant(j, k).equals("B")) {
					int y = j * bf.getCELL_SIZE();
					int x = k * bf.getCELL_SIZE();
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, bf.getCELL_SIZE(), bf.getCELL_SIZE());
				}
			}
		}

		// defender
		g.setColor(new Color(0, 255, 0));
		g.fillRect(defender.getX(), defender.getY(), bf.getCELL_SIZE(), bf.getCELL_SIZE());

		g.setColor(new Color(255, 0, 0));
		if (defender.getDirection() == 1) {
			g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
		} else if (defender.getDirection() == 2) {
			g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
		} else if (defender.getDirection() == 3) {
			g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
		} else {
			g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
		}

		// aggressor
		g.setColor(new Color(255, 0, 0));
		g.fillRect(aggressor.getX(), aggressor.getY(), bf.getCELL_SIZE(), bf.getCELL_SIZE());

		g.setColor(new Color(0, 255, 0));
		if (aggressor.getDirection() == 1) {
			g.fillRect(aggressor.getX() + 20, aggressor.getY(), 24, 34);
		} else if (aggressor.getDirection() == 2) {
			g.fillRect(aggressor.getX() + 20, aggressor.getY() + 30, 24, 34);
		} else if (aggressor.getDirection() == 3) {
			g.fillRect(aggressor.getX(), aggressor.getY() + 20, 34, 24);
		} else {
			g.fillRect(aggressor.getX() + 30, aggressor.getY() + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}

}
