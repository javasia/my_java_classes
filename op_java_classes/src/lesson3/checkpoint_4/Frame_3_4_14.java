/*
 * Copyright (c) 2013 midgardabc.com
 */
package lesson3.checkpoint_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 3.0
 */

//getQuadrant reworked to int[]

public class Frame_3_4_14 extends JPanel {

	final boolean COLORDED_MODE = false;

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;

	final int CELL_SIZE_PIX = 64;

	final int SPEED = 10;
	final int BULLET_SPEED = 5;

	final int DIRECTION_UP = 1, DIRECTION_DOWN = 2, DIRECTION_LEFT = 3, DIRECTION_RIGHT = 4;

	int tankX = 0;
	int tankY = 0;
	
	int bulletX = -100;
	int bulletY = -100;
	
	int tankDirection = -1;

	String[][] battleField = initField();

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {

		printFieldToConsole();

		tankX = 64 * 0;
		tankY = 64 * 3;
		System.out.println("Comand: testFire");
		testFire();

		tankX = 64 * 8;
		tankY = 64 * 3;
		System.out.println("Comand: testFire");
		testFire();

		tankX = 64 * 3;
		tankY = 64 * 8;
		System.out.println("Comand: testFire");
		testFire();

		tankX = 64 * 3;
		tankY = 64 * 0;
		System.out.println("Comand: testFire");
		testFire();

		tankX = 64 * 5;
		tankY = 64 * 5;

		while (true) {
			move(getRandomDirection());
			Thread.sleep(500);
			fire();
			Thread.sleep(500);
		}

	}

	String[][] initField() {

		String[][] field = new String[9][9];

		for (int i = 0; i <= 8; i++) {
			field[i] = new String[] { " ", " ", " ", " ", " ", " ", " ", " ", " " };
		}

		for (int i = 0, j = 0; i < 9; i++) {
			for (int k = (int) (Math.random() * 10); k >= 0; k--) {
				j = (int) (Math.random() * 10);
				if (j > 8) {
					j = 0;
				}
				field[i][j] = "B";

			}
		}
		return field;
	}

	void printFieldToConsole() {
		System.out.println("Printing battlefield to console...");
		for (int i = 0; i < battleField.length; i++) {
			System.out.println(Arrays.toString(battleField[i]) + "\n");
		}
	}

	void fire() throws InterruptedException {

		System.out.println("Comand received: \"fire\" \n");

		bulletX = tankX + 25;
		bulletY = tankY + 25;

		int direction = tankDirection;

		int maxPix = CELL_SIZE_PIX * 9, minPix = -1 * CELL_SIZE_PIX;

		while (bulletX < maxPix && bulletX > minPix && bulletY < maxPix && bulletY > minPix && !processInterception()) {

			if (direction == DIRECTION_UP) {
				if (tankY / CELL_SIZE_PIX > 0) {
					bulletY -= 1;
				} else {
					break;
				}

			} else if (direction == DIRECTION_DOWN) {
				if (tankY / CELL_SIZE_PIX < 8) {
					bulletY += 1;
				} else {
					break;
				}

			} else if (direction == DIRECTION_LEFT) {
				if (tankX / CELL_SIZE_PIX > 0) {
					bulletX -= 1;
				} else {
					break;
				}

			} else if (direction == DIRECTION_RIGHT) {
				if (tankX / CELL_SIZE_PIX < 8) {
					bulletX += 1;
				} else {
					break;
				}

			}
			repaint();
			Thread.sleep(BULLET_SPEED);
		}
		bulletX = -100;
		bulletY = -100;
		repaint();
	}

	void testFire() throws Exception {

		turnTank(DIRECTION_UP);
		Thread.sleep(1000);
		fire();
		Thread.sleep(100);
		turnTank(DIRECTION_DOWN);
		Thread.sleep(1000);
		fire();
		Thread.sleep(1000);
		turnTank(DIRECTION_LEFT);
		Thread.sleep(1000);
		fire();
		Thread.sleep(1000);
		turnTank(DIRECTION_RIGHT);
		Thread.sleep(1000);
		fire();
		Thread.sleep(1000);
	}

	boolean processInterception() throws InterruptedException {
		int quadY = getQuadrant(bulletX, bulletY)[0];
		int quadX = getQuadrant(bulletX, bulletY)[1];

		if (battleField[quadY][quadX] == "" || battleField[quadY][quadX] == " " || isTank(quadY, quadX)) {
			return false;
		}

		String temp = battleField[quadY][quadX];

		for (int i = 0; i < 4; i++) {
			battleField[quadY][quadX] = "";
			repaint();
			Thread.sleep(30);
			battleField[quadY][quadX] = temp;
			repaint();
			Thread.sleep(30);
		}

		battleField[quadY][quadX] = "";
		repaint();
		return true;

	}

	int[] getQuadrant(int x, int y) {
		int[] res = { y / CELL_SIZE_PIX, x / CELL_SIZE_PIX };
		return res;
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

	void moveToQuadrant(int v, int h) throws Exception {

		int newTankX = h * CELL_SIZE_PIX;
		int newTankY = v * CELL_SIZE_PIX;

		while (newTankX != tankX || newTankY != tankY) {
			if (newTankX != tankX) {
				move(getHorDirection(newTankX));
			}
			if (newTankY != tankY) {
				move(getVertDirection(newTankY));
			}

		}

	}

	int getHorDirection(int coord) {
		int DIRECTION_LEFT = 3, DIRECTION_RIGHT = 4;
		if (coord > tankX) {
			return DIRECTION_RIGHT;
		}
		return DIRECTION_LEFT;

	}

	int getVertDirection(int coord) {
		int DIRECTION_UP = 1, DIRECTION_DOWN = 2;
		if (coord > tankY) {
			return DIRECTION_DOWN;
		}
		return DIRECTION_UP;

	}

	void turnTank(int direction) {

		System.out.println("Comand received: \"turnTank\" \n");

		tankDirection = direction;
		repaint();
	}

	boolean isTank(int y, int x) {
		int quadX = tankX / CELL_SIZE_PIX;
		int quadY = tankY / CELL_SIZE_PIX;
		if (quadX == x && quadY == y) {
			return true;
		}
		return false;
	}

	void move(int direction) throws InterruptedException {

		turnTank(direction);
		int maxPix = CELL_SIZE_PIX * 8, minPix = 0;
		String verbalDirection = null;

		for (int i = 0; i < CELL_SIZE_PIX; i++) {
			if (direction == DIRECTION_UP && tankY > minPix) {
				verbalDirection = "up";
				tankY -= 1;

			} else if (direction == DIRECTION_DOWN && tankY < maxPix) {

				verbalDirection = "down";
				tankY += 1;

			} else if (direction == DIRECTION_LEFT && tankX > minPix) {
				verbalDirection = "left";
				tankX -= 1;

			} else if (direction == DIRECTION_RIGHT && tankX < maxPix) {
				verbalDirection = "right";
				tankX += 1;

			} else {
				verbalDirection = "ignored";
			}
			repaint();
			Thread.sleep(SPEED);
		}
		System.out.println(
				"Move " + verbalDirection + ".\nNew coordinates: h" + tankX + "px. / " + "v" + tankY + "px.\n");
	}

	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	public static void main(String[] args) throws Exception {
		Frame_3_4_14 bf = new Frame_3_4_14();
		bf.runTheGame();
	}

	public Frame_3_4_14() throws Exception {
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