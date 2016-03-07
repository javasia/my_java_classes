/*
 * Copyright (c) 2013 midgardabc.com
 */
package tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 2.0
 */

public class Tanks_Old extends JPanel {

	final boolean COLORDED_MODE = false;

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;

	final int SPEED = 10;
	final int BULLET_SPEED = 2;

	final int CELL_SIZE_PIX = 64;

	final int MAX_QUADRANTS = 8;
	final int MIN_QUADRANTS = 0;
	
	final int MAX_PIX = CELL_SIZE_PIX * MAX_QUADRANTS;
	final int MIN_PIX = CELL_SIZE_PIX * MIN_QUADRANTS;


	final int DIRECTION_UP = 1, DIRECTION_DOWN = 2, DIRECTION_LEFT = 3, DIRECTION_RIGHT = 4;

	final int BLINK_TIMES = 3; // blink times on hit

	int brickLevel = 5;	// the higher number the more bricks will be randomly
							// added to battle field. Its recommended but not
							// obligatory to use number above 10.

	final String CLEAR_MODE = "ADAPTIVE";	// "ADAPTIVE" CLEAR MODE: FIRE AT SIGHT THAN
									// RUNING TO THE NEAREST BRICK

	//final String CLEAR_MODE = "QUICK";	// QUICK CLEAR MODE: MOVING TO BORDER THAN
									// FIRE AT SITE BY ROWS

	// final String CLEAR_MODE = "QUICK_ADAPTIVE";	// QUICK ADAPTIVE CLEAR MODE: FIRE AT SIGHT THAN RUNING TO THE 
	 											// NEAREST BRICK BUT VERTIVAL AXEL IS LOCKED

	String[][] battleField = initField();

	int tankX = 0;
	int tankY = 0;

	int bulletX = -100;
	int bulletY = -100;

	int tankDirection = getHorDirection(MAX_PIX/2);

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {

		printFieldToConsole();

		setTankInitPos();

		putTankInCenter();// for testing purposes

		clean();

	}

	void clean() throws Exception {

		long time = System.currentTimeMillis();

		if (CLEAR_MODE.compareToIgnoreCase("ADAPTIVE") == 0 || CLEAR_MODE.compareToIgnoreCase("QUICK_ADAPTIVE") == 0) {
			clearAdaptive();
		} else {
			clearQuick();
		}

		System.out.println("Time passed: " + returnTimeToString(time));
		System.out.println("\n --- Game over ---");

	}

	String returnTimeToString(long time) {
		time = System.currentTimeMillis() - time;
		long hr = time / (1000 * 60 * 60);
		long min = time / (1000 * 60) % 60;
		long sec = (time / 1000) % 60;

		return hr + ":" + min + ":" + sec;
	}

	void clearAdaptive() throws Exception {
		while (getBrickQuadrant() != null) {

			int[] getQuad = getQuadrant(tankX, tankY);
			int[] getBrickQuad = getBrickQuadrant();

			if (killNearest("B")) {
				continue;
			}
			if (CLEAR_MODE.equals("QUICK_ADAPTIVE")) {
				goKillNext(getQuad[0], getBrickQuad[1]);
				continue;
			}
			goKillNext(getBrickQuad[0], getBrickQuad[1]);
		}
	}

	void clearQuick() throws Exception {
		int[] tankCoordQuad = getQuadrant(tankX, tankY);
		int y = MAX_QUADRANTS;
		int x = MAX_QUADRANTS;
		int changeLine = -1;

		if (tankCoordQuad[0] < 4) {
			y = MIN_QUADRANTS;
		}
		if (tankCoordQuad[1] < 4) {
			x = MIN_QUADRANTS;
			changeLine = 1;
		}

		while (getBrickQuadrant() != null) {
			if (killNearest("B")) {
				continue;
			}
			moveToQuadrant(y, x);
			x += changeLine;
		}
	}

	boolean killNearest(String object) throws Exception {

		int shotDirection = returnShotDirection(object);

		if (shotDirection == -1) {
			return false;
		}
		turnTank(shotDirection);
		fire();
		return true;
	}

	int returnShotDirection(String object) {

		int y = getQuadrant(tankX, tankY)[0];
		int x = getQuadrant(tankX, tankY)[1];

		int[][] dirModifier = returnDirModifier();

		for (int step = 0; step <= MAX_QUADRANTS; step++) {

			for (int i = 0; i <= 3; i++) {

				int stepY = checkStepBoundary(y, step, dirModifier[i][0]);
				int stepX = checkStepBoundary(x, step, dirModifier[i][1]);

				if (battleField[stepY][stepX].equals(object)) {
					return i + 1;
				}
			}
		}

		return -1;
	}

	int[][] returnDirModifier() {
		int[][] dirModifier = new int[4][];
		dirModifier[0] = new int[] { -1, 0 };
		dirModifier[1] = new int[] { 1, 0 };
		dirModifier[2] = new int[] { 0, -1 };
		dirModifier[3] = new int[] { 0, 1 };
		return dirModifier;
	}

	int checkStepBoundary(int coord, int step, int modifier) {
		int res = coord + (modifier * step);
		if (res < MIN_QUADRANTS) {
			return MIN_QUADRANTS;
		}
		if (res > MAX_QUADRANTS) {
			return MAX_QUADRANTS;
		}
		return res;
	}

	int[] getBrickQuadrant() {

		int[][] brickQuadrants = new int[(MAX_QUADRANTS + 1) * (MAX_QUADRANTS + 1)][];

		if (!returnAllBrickQuadrants(brickQuadrants, "B")) {
			System.out.println(
					"getBrickQuadrant: Null result received from returnAllBrickQuadrants. No more brick left.");
			return null;
		}

		int[] nearestBrickQuad = null;
		int[] curTankQuad = getQuadrant(tankX, tankY);
		int distanceToTankTemp = 100;

		for (int i = 0; brickQuadrants[i] != null && i < brickQuadrants.length; i++) {
			int distanceToTankY = curTankQuad[0] - brickQuadrants[i][0];
			int distanceToTankX = curTankQuad[1] - brickQuadrants[i][1];

			if (distanceToTankY < 0) {
				distanceToTankY *= -1;
			}
			if (distanceToTankX < 0) {
				distanceToTankX *= -1;
			}

			int distanceToTank = distanceToTankX + distanceToTankY;

			if (distanceToTank < distanceToTankTemp) {
				distanceToTankTemp = distanceToTank;
				nearestBrickQuad = brickQuadrants[i];
			}
		}

		System.out.println("nearestBrickQuad:" + Arrays.toString(nearestBrickQuad));
		return nearestBrickQuad;
	}

	boolean returnAllBrickQuadrants(int[][] brickQuadrants, String object) {

		boolean foundFlag = false;

		for (int y = 0, i = 0; y <= MAX_QUADRANTS; y++) {
			for (int x = 0; x <= MAX_QUADRANTS; x++) {
				if (battleField[y][x].equals(object)) {
					foundFlag = true;
					brickQuadrants[i] = new int[2];
					brickQuadrants[i][0] = y;
					brickQuadrants[i][1] = x;
					i++;
				}
			}
		}
		return foundFlag;
	}

	String[][] initField() {

		String[][] field = new String[9][9];

		for (int i = MIN_QUADRANTS; i <= MAX_QUADRANTS; i++) {
			field[i] = new String[] { " ", " ", " ", " ", " ", " ", " ", " ", " " };
		}
		System.out.println("Battle field initialized.");

		if (brickLevel < 0) {
			brickLevel = 0;
		} else if (brickLevel > 100) {
			brickLevel = 100;
		}

		for (int i = MIN_QUADRANTS, j = 0; i <= MAX_QUADRANTS; i++) {
			for (int k = 0; k <= brickLevel; k++) {
				j = (int) (Math.random() * 10);
				if (j > MAX_QUADRANTS) {
					j = 0;
				}
				field[i][j] = "B";
			}
		}
		System.out.println("Random battle field genetated.");
		return field;
	}

	void printFieldToConsole() {
		System.out.println("Printing battlefield to console...");
		for (int i = 0; i < battleField.length; i++) {
			System.out.println(Arrays.toString(battleField[i]) + "\n");
		}
	}

	void fire() throws Exception {

		System.out.println("Comand received: \"fire\"");

		bulletX = tankX + 25;
		bulletY = tankY + 25;
		int[][] modifier = returnDirModifier();

		while (checkFieldMargins("bullet", bulletX, bulletY) && !processInterception("B")) {
			bulletY += modifier[tankDirection - 1][0];
			bulletX += modifier[tankDirection - 1][1];
			repaint();
			Thread.sleep(BULLET_SPEED);

		}
		bulletX = -100;
		bulletY = -100;
		repaint();
	}

	boolean processInterception(String object) throws Exception {

		int quadY = getQuadrant(bulletX, bulletY)[0];
		int quadX = getQuadrant(bulletX, bulletY)[1];

		if (quadX > MAX_QUADRANTS || quadY > MAX_QUADRANTS || quadX < MIN_QUADRANTS || quadY < MIN_QUADRANTS) {
			return false;
		}

		if (battleField[quadY][quadX].equals(object)) {
			blinkOnHit(quadY, quadX);
			battleField[quadY][quadX] = "";
			repaint();
			return true;
		}
		return false;
	}

	void blinkOnHit(int quadY, int quadX) throws Exception {
		String temp = battleField[quadY][quadX];

		for (int i = 0; i < BLINK_TIMES; i++) {
			battleField[quadY][quadX] = "";
			repaint();
			Thread.sleep(30);
			battleField[quadY][quadX] = temp;
			repaint();
			Thread.sleep(30);
		}

	}

	int[] getQuadrant(int x, int y) {
		int[] res = { y / CELL_SIZE_PIX, x / CELL_SIZE_PIX };
		return res;
	}

	void setTankInitPos() {

		for (int i = MAX_QUADRANTS; i >= MIN_QUADRANTS; i--) {
			for (int j = MIN_QUADRANTS; j <= MAX_QUADRANTS; j++) {
				if (battleField[i][j].equals("") || battleField[i][j].equals(" ")) {
					tankY = i * CELL_SIZE_PIX;
					tankX = j * CELL_SIZE_PIX;
					System.out.println("Init tank coordinates set as:" + tankY + ":" + tankX);
					return;
				}
			}
		}
		battleField[MAX_QUADRANTS][MAX_QUADRANTS / 2] = "";
		tankY = MAX_QUADRANTS * CELL_SIZE_PIX;
		tankX = MAX_QUADRANTS / 2 * CELL_SIZE_PIX;
	}

	int[] getRandomQuadrant() {

		int[] rndmQuad = new int[2];

		while (true) {
			int iRnd = (int) (Math.random() * 10);
			if (iRnd >= MIN_QUADRANTS && iRnd <= MAX_QUADRANTS) {
				rndmQuad[0] = iRnd;
				break;
			}
			iRnd = (int) (Math.random() * 10);
			if (iRnd >= MIN_QUADRANTS && iRnd <= MAX_QUADRANTS) {
				rndmQuad[1] = iRnd;
				break;
			}
		}
		return rndmQuad;
	}

	int getRandomDirection() throws Exception {
		while (true) {
			int iRndNum = (int) (Math.random() * 10);
			if (iRndNum >= 1 && iRndNum <= 4) {
				return iRndNum;
			} else if (iRndNum == 5) {
				return 1;
			} else if (iRndNum == 6) {
				return 2;
			} else if (iRndNum == 7) {
				return 3;
			} else if (iRndNum == 8) {
				return 4;
			} else {
				continue;
			}
		}
	}

	void goKillNext(int v, int h) throws Exception {

		int newTankX = h * CELL_SIZE_PIX;
		int newTankY = v * CELL_SIZE_PIX;

		while (newTankX != tankX || newTankY != tankY) { // ZIG-ZAG WAY
			if (newTankX != tankX) {
				if (checkBrick(getHorDirection(newTankX),"B")) {
					turnTank(getHorDirection(newTankX));
					repaint();
					fire();
					return;
				}
				move(getHorDirection(newTankX));
			}
			if (newTankY != tankY) {
				if (checkBrick(getVertDirection(newTankY),"B")) {
					turnTank(getVertDirection(newTankY));
					repaint();
					fire();
					return;
				}
				move(getVertDirection(newTankY));
			}
		}
	}

	void moveToQuadrant(int v, int h) throws Exception {

		int newTankX = h * CELL_SIZE_PIX;
		int newTankY = v * CELL_SIZE_PIX;

		while (newTankX != tankX) {
			if (checkBrick(getHorDirection(newTankX),"B")) {
				turnTank(getHorDirection(newTankX));
				repaint();
				fire();
			}
			move(getHorDirection(newTankX));
		}
		while (newTankY != tankY) {
			if (checkBrick(getVertDirection(newTankY),"B")) {
				turnTank(getVertDirection(newTankY));
				repaint();
				fire();
			}
			move(getVertDirection(newTankY));
		}
	}

	int getHorDirection(int tankCoordXPix) {
		if (tankCoordXPix > tankX) {
			return DIRECTION_RIGHT;
		}
		return DIRECTION_LEFT;
	}

	int getVertDirection(int tankCoordYPix) {
		if (tankCoordYPix > tankY) {
			return DIRECTION_DOWN;
		}
		return DIRECTION_UP;
	}

	void turnTank(int direction) {
		System.out.println("Comand received: \"turnTank " + direction + "\"");
		tankDirection = direction;
		repaint();
	}

	boolean checkBrick(int newDirection, String object) throws Exception {
		int quadX = getQuadrant(tankX, tankY)[1];
		int quadY = getQuadrant(tankX, tankY)[0];

		int[][] modifier = returnDirModifier();

		int horModifier = modifier[newDirection - 1][1];
		int verModifier = modifier[newDirection - 1][0];

		if (battleField[quadY + verModifier][quadX + horModifier].equals(object)) {
			System.out.println("found brick at Y:" + (quadY + verModifier) + "X:" + (quadX + horModifier));
			return true;
		}

		return false;
	}

	void move(int direction) throws InterruptedException {

		turnTank(direction);

		System.out.println("Comand received: move " + direction);

		int[][] modifier = returnDirModifier();

		for (int i = 0; checkFieldMargins("tank", tankX, tankY) && i < CELL_SIZE_PIX; i++) {
			tankY += modifier[direction - 1][0];
			tankX += modifier[direction - 1][1];
			repaint();
			Thread.sleep(SPEED);
		}
	}

	boolean checkFieldMargins(String object, int x, int y) {

		int objModifier = 0;

		if (object.equals("bullet")) {
			objModifier = CELL_SIZE_PIX;
		}

		if (x <= MAX_PIX + objModifier && x >= MIN_PIX - objModifier && y <= MAX_PIX + objModifier
				&& y >= MIN_PIX - objModifier) {
			return true;
		}
		return false;
	}

	void putTankInCenter() {
		battleField[4][4] = "";
		tankX = 4 * CELL_SIZE_PIX;
		tankY = tankX;
	}
	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	public static void main(String[] args) throws Exception {
		Tanks_Old bf = new Tanks_Old();
		bf.runTheGame();
	}

	public Tanks_Old() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(BF_WIDTH + 18, BF_HEIGHT + 47));
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
				g.fillRect(h * CELL_SIZE_PIX, v * CELL_SIZE_PIX, CELL_SIZE_PIX, CELL_SIZE_PIX);
			}
		}

		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				if (battleField[j][k].equals("B")) {
					int y = j * CELL_SIZE_PIX;
					int x = k * CELL_SIZE_PIX;
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, CELL_SIZE_PIX, CELL_SIZE_PIX);
				}
			}
		}

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, CELL_SIZE_PIX, CELL_SIZE_PIX);

		g.setColor(new Color(0, 255, 0));
		if (tankDirection == 1) {
			g.fillRect(tankX + 20, tankY, 24, 34);
		} else if (tankDirection == 2) {
			g.fillRect(tankX + 20, tankY + 30, 24, 34);
		} else if (tankDirection == 3) {
			g.fillRect(tankX, tankY + 20, 34, 24);
		} else {
			g.fillRect(tankX + 30, tankY + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bulletX, bulletY, 14, 14);
	}

}