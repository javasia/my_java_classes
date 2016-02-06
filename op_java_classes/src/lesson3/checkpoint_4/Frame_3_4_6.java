/*
 * Copyright (c) 2013 midgardabc.com
 */
package lesson3.checkpoint_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 3.1
 */
public class Frame_3_4_6 extends JPanel {

	boolean COLORDED_MODE = false;

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;

	int tankX = 0;
	int tankY = 0;

	int bulletX = -100;
	int bulletY = -100;

	int speed = 10;
	int bulletSpeed = 5;

	int directionUp = 1, directionDown = 2, directionLeft = 3, directionRight = 4;
	int tankDirection = -1;

	String[][] battleField = initField();

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {

		printFieldToConsole();


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

		bulletX = tankX + 25;
		bulletY = tankY + 25;

		int direction = tankDirection;

		int cell = 64;
		int maxPix = cell * 9, minPix = -1 * cell;

		while (bulletX < maxPix && bulletX > minPix && bulletY < maxPix && bulletY > minPix) {
			if (direction == directionUp) {
				bulletY -= 1;

			} else if (direction == directionDown) {
				bulletY += 1;

			} else if (direction == directionLeft) {
				bulletX -= 1;

			} else if (direction == directionRight) {
				bulletX += 1;

			} else {
			}

			repaint();
			Thread.sleep(bulletSpeed);
		}
	}

	void moveToQuadrant(int v, int h) throws Exception {

		int newTankX = getQuadrantQPix(v, h)[0];
		int newTankY = getQuadrantQPix(v, h)[1];

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
		int directionLeft = 3, directionRight = 4;
		if (coord > tankX) {
			return directionRight;
		}
		return directionLeft;

	}

	int getVertDirection(int coord) {
		int directionUp = 1, directionDown = 2;
		if (coord > tankY) {
			return directionDown;
		}
		return directionUp;

	}

	void turnTank(int direction) {
		tankDirection = direction;
		repaint();
	}

	void move(int direction) throws InterruptedException {

		int cell = 64;
		turnTank(direction);
		int maxPix = cell * 8, minPix = 0;
		String verbalDirection = null;

		for (int i = 0; i < cell; i++) {
			if (direction == directionUp && tankY > minPix) {
				verbalDirection = "up";
				tankY -= 1;

			} else if (direction == directionDown && tankY < maxPix) {

				verbalDirection = "down";
				tankY += 1;

			} else if (direction == directionLeft && tankX > minPix) {
				verbalDirection = "left";
				tankX -= 1;

			} else if (direction == directionRight && tankX < maxPix) {
				verbalDirection = "right";
				tankX += 1;

			} else {
				verbalDirection = "ignored";
			}

			repaint();
			Thread.sleep(speed);
		}
		System.out.println(
				"Move " + verbalDirection + ".\nNew coordinates: h" + tankX + "px. / " + "v" + tankY + "px.\n");
	}

	static int[] getQuadrantQPix(int v, int h) {
		int px_sq = 64;
		int[] res = { (h - 1) * px_sq, (v - 1) * px_sq };
		return res;
	}

	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	public static void main(String[] args) throws Exception {
		Frame_3_4_6 bf = new Frame_3_4_6();
		bf.runTheGame();
	}

	public Frame_3_4_6() throws Exception {
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
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				if (battleField[j][k].equals("B")) {
					int x = getQuadrantQPix(j + 1, k + 1)[0];
					int y = getQuadrantQPix(j + 1, k + 1)[1];
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, 64, 64);
				}
			}
		}

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, 64, 64);

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