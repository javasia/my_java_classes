/*
 * Copyright (c) 2013 midgardabc.com
 */
package lesson3.checkpoint_5;

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

public class Frame_3_5_17 extends JPanel {

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

	final int MOVE_STYLE = 1;	//for moveToQuadrant: ZIGZAG=1,NORMAL=0

	final String CLEAR_MODE = "ADAPTIVE";	// "ADAPTIVE" CLEAR MODE: FIRE AT SIGHT THAN
									// RUNING TO THE NEAREST BRICK

	//final String CLEAR_MODE = "QUICK";	// QUICK CLEAR MODE: MOVING TO BORDER THAN
									// FIRE AT SITE BY ROWS

	 //final String CLEAR_MODE = "QUICK_ADAPTIVE";	// QUICK ADAPTIVE CLEAR MODE: FIRE AT SIGHT THAN RUNING TO THE 
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

		//putTankInCenter();//for testing purposes

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
		return;

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
			if (killNearest()) {
				continue;
			}
			if (CLEAR_MODE.equals("QUICK_ADAPTIVE")) {
				goKillNext(getQuadrant(tankX, tankY)[0], getBrickQuadrant()[1]);
			} else {
				goKillNext(getBrickQuadrant()[0], getBrickQuadrant()[1]);
			}
		}
	}

	void clearQuick() throws Exception {
		int[] tankCoordQuad = getQuadrant(tankX, tankY);
		int y = -1;
		int x = -1;
		int changeLine = 0;
		if (tankCoordQuad[0] < 4) {
			y = MIN_QUADRANTS;
		} else {
			y = MAX_QUADRANTS;
		}
		if (tankCoordQuad[1] < 4) {
			x = MIN_QUADRANTS;
			changeLine = 1;
		} else {
			x = MAX_QUADRANTS;
			changeLine = -1;
		}

		while (getBrickQuadrant() != null) {
			if (killNearest()) {
				continue;
			}
			moveToQuadrant(y, x);
			x += changeLine;
		}
	}

	boolean killNearest() throws Exception {
		int[][] brickInSight = lookAround();
		int direction = 0;
		int disctanceToBrick = 100;

		for (int i = 0; i < brickInSight.length; i++) {
			if (brickInSight[i][1] != -1 && brickInSight[i][1] < disctanceToBrick) {
				disctanceToBrick = brickInSight[i][1];
				direction = brickInSight[i][0];
			}
		}

		if (direction != 0) {
			turnTank(direction);
			fire();
			return true;
		}

		return false;
	}

	int[][] lookAround() {

		int[][] roundCheck = new int[4][];

		for (int i = 0; i <= 3; i++) {
			roundCheck[i] = new int[2];
			roundCheck[i][0] = i + 1;
			roundCheck[i][1] = checkForward(i + 1);
		}

		System.out.print("Distances to brick per tank directions, quadrants: ");
		for (int i = 0; i < roundCheck.length; i++) {
			System.out.print(Arrays.toString(roundCheck[i]));
		}
		System.out.println();
		return roundCheck;
	}

	int checkForward(int direction) {

		int tankQuadY = getQuadrant(tankX, tankY)[0];
		int tankQuadX = getQuadrant(tankX, tankY)[1];

		if (direction == DIRECTION_UP) {
			for (int y = tankQuadY, i = 0; y >= MIN_QUADRANTS; y--, i++) {
				if (battleField[y][tankQuadX].equals("B")) {
					return i;
				}
			}
		} else if (direction == DIRECTION_DOWN) {
			for (int y = tankQuadY, i = 0; y <= MAX_QUADRANTS; y++, i++) {
				if (battleField[y][tankQuadX].equals("B")) {
					return i;
				}
			}
		} else if (direction == DIRECTION_LEFT) {
			for (int x = tankQuadX, i = 0; x >= MIN_QUADRANTS; x--, i++) {
				if (battleField[tankQuadY][x].equals("B")) {
					return i;
				}
			}
		} else if (direction == DIRECTION_RIGHT) {
			for (int x = tankQuadX, i = 0; x <= MAX_QUADRANTS; x++, i++) {
				if (battleField[tankQuadY][x].equals("B")) {
					return i;
				}
			}
		}

		return -1;
	}

	int[] getBrickQuadrant() {

		int[][] brickQuadrants = new int[(MAX_QUADRANTS + 1) * (MAX_QUADRANTS + 1)][];

		if (!returnAllBrickQuadrants(brickQuadrants)) {
			System.out.println(
					"getBrickQuadrant: Null result received from returnAllBrickQuadrants. No more brick left.");
			return null;
		}

		int[] nearestBrickQuad = null;
		int[] curTankQuad = getQuadrant(tankX, tankY);
		int distanceToTankTemp = 100;

		for (int i = 0; brickQuadrants[i] != null && i < brickQuadrants.length; i++) {
			int distanceToTankY = curTankQuad[0] - brickQuadrants[i][0];
			if (distanceToTankY < 0) {
				distanceToTankY *= -1;
			}
			int distanceToTankX = curTankQuad[1] - brickQuadrants[i][1];
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

	boolean returnAllBrickQuadrants(int[][] brickQuadrants) {

		boolean foundFlag = false;

		for (int y = 0, i = 0; y <= MAX_QUADRANTS; y++) {
			for (int x = 0; x <= MAX_QUADRANTS; x++) {
				if (battleField[y][x].equals("B")) {
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
		}else if (brickLevel>100){
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

		while (checkFieldMargins("bullet", bulletX, bulletY) && !processInterception()) {
			
			repaint();
			Thread.sleep(BULLET_SPEED);

			if (tankDirection == DIRECTION_UP) {
				bulletY -= 1;
				continue;
			} else if (tankDirection == DIRECTION_DOWN) {
				bulletY += 1;
				continue;
			} else if (tankDirection == DIRECTION_LEFT) {
				bulletX -= 1;
				continue;
			}
			bulletX += 1;
		}
		bulletX = -100;
		bulletY = -100;
		repaint();
	}


	boolean processInterception() throws Exception {

		int quadY = getQuadrant(bulletX, bulletY)[0];
		int quadX = getQuadrant(bulletX, bulletY)[1];

		if (quadX > MAX_QUADRANTS || quadY > MAX_QUADRANTS || quadX < MIN_QUADRANTS || quadY < MIN_QUADRANTS) {
			return false;
		}

		if (battleField[quadY][quadX].equals("B")) {
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
				if (checkBrick(getHorDirection(newTankX))) {
					turnTank(getHorDirection(newTankX));
					repaint();
					fire();
					return;
				}
				move(getHorDirection(newTankX));
			}
			if (newTankY != tankY) {
				if (checkBrick(getVertDirection(newTankY))) {
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

		if (MOVE_STYLE == 1) {
			moveToQuadrantZigZag(newTankY, newTankX);
			return;
		}
		moveToQuadrantNormal(newTankY, newTankX);
	}

	void moveToQuadrantZigZag(int newTankY, int newTankX) throws Exception {

		while (newTankX != tankX || newTankY != tankY) { // ZIG-ZAG WAY
			if (newTankX != tankX) {
				if (checkBrick(getHorDirection(newTankX))) {
					turnTank(getHorDirection(newTankX));
					repaint();
					fire();
				}
				move(getHorDirection(newTankX));
			}
			if (newTankY != tankY) {
				if (checkBrick(getVertDirection(newTankY))) {
					turnTank(getVertDirection(newTankY));
					repaint();
					fire();
				}
				move(getVertDirection(newTankY));
			}
		}
	}

	void moveToQuadrantNormal(int newTankY, int newTankX) throws Exception {

		while (newTankX != tankX) {
			if (checkBrick(getHorDirection(newTankX))) {
				turnTank(getHorDirection(newTankX));
				repaint();
				fire();
			}
			move(getHorDirection(newTankX));
		}
		while (newTankY != tankY) {
			if (checkBrick(getVertDirection(newTankY))) {
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

	boolean checkBrick(int newDirection) throws Exception {
		int quadX = getQuadrant(tankX, tankY)[1];
		int quadY = getQuadrant(tankX, tankY)[0];

		int horModifier = 0;
		int vertModifier = 0;

		if (quadX < MAX_QUADRANTS && newDirection == DIRECTION_RIGHT) {
			horModifier = 1;
		} else if (quadX > MIN_QUADRANTS && newDirection == DIRECTION_LEFT) {
			horModifier = -1;
		} else if (quadY < MAX_QUADRANTS && newDirection == DIRECTION_DOWN) {
			vertModifier = 1;
		} else if (quadY > MIN_QUADRANTS && newDirection == DIRECTION_UP) {
			vertModifier = -1;
		}

		if (battleField[quadY + vertModifier][quadX + horModifier].equals("B")) {
			System.out.println("found brick at Y:" + (quadY + vertModifier) + "X:" + (quadX + horModifier));
			return true;
		}

		return false;
	}

	void move(int direction) throws InterruptedException {

		turnTank(direction);

		System.out.println("Comand received: move " + direction);

		for (int i = 0; checkFieldMargins("tank", tankX, tankY) && i < CELL_SIZE_PIX; i++) {

			repaint();
			Thread.sleep(SPEED);

			if (direction == DIRECTION_UP) {
				tankY -= 1;
				continue;

			} else if (direction == DIRECTION_DOWN) {
				tankY += 1;
				continue;

			} else if (direction == DIRECTION_LEFT) {
				tankX -= 1;
				continue;

			}
			tankX += 1;
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
	
	void putTankInCenter(){
		battleField[4][4]="";
		tankX=4*CELL_SIZE_PIX;
		tankY=tankX;
	}
	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	public static void main(String[] args) throws Exception {
		Frame_3_5_17 bf = new Frame_3_5_17();
		bf.runTheGame();
	}

	public Frame_3_5_17() throws Exception {
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