
/**
 * - TANKS -
 */

/*
 * Copyright (c) 2014 kademika.com
 */
package lesson2.keypoint_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.activation.MimeTypeParameterList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Frame_2_4_15 extends JPanel {

	boolean COLORDED_MODE = true;

	int tankX = 0;
	int tankY = 0;

	long speed = 250;

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {

		System.out.println("Move from: a1 -> a9");
		moveToQuadrant("a", "9");
		System.out.println("Move from: a9 -> i9");
		moveToQuadrant("i", "9");
		System.out.println("Move from: i9 -> i1");
		moveToQuadrant("i", "1");
		System.out.println("Move from: i1 -> a1");
		moveToQuadrant("a", "1");
		System.out.println("Move from: a1 -> d5");
		moveToQuadrant("d", "5");
		System.out.println("Cieck: d5 -> d5");
		moveToQuadrant("d", "5");
		System.out.println("Move from: d5 -> d4");
		moveToQuadrant("d", "4");
		System.out.println("Move from: d4 -> d6");
		moveToQuadrant("d", "6");
		System.out.println("Move from: d6 -> e5");
		moveToQuadrant("e", "5");
		System.out.println("Move from: e5 -> c5");
		moveToQuadrant("c", "5");
		System.out.println("Move from: e5 -> d5");
		moveToQuadrant("d", "5");
		System.out.println("END");

	}

	void moveToQuadrant(String v, String h) throws Exception {

		String coordStr = getQuadrant(v, h);
		int newTankX = Integer.parseInt(coordStr.substring(0, coordStr.indexOf("_")));
		int newTankY = Integer.parseInt(coordStr.substring(coordStr.indexOf("_") + 1));

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


	void move(int direction) throws InterruptedException {

		int cell = 64;
		int maxPix = cell * 8, minPix = 0;
		String verbalDirection = null;
		int directionUp = 1, directionDown = 2, directionLeft = 3, directionRight = 4;

		if (direction == directionUp && tankY > minPix) {
			verbalDirection = "up";
			tankY -= cell;

		} else if (direction == directionDown && tankY < maxPix) {

			verbalDirection = "down";
			tankY += cell;

		} else if (direction == directionLeft && tankX > minPix) {
			verbalDirection = "left";
			tankX -= cell;

		} else if (direction == directionRight && tankX < maxPix) {
			verbalDirection = "right";
			tankX += cell;

		} else {
			verbalDirection = "ignored";
		}

		repaint();
		Thread.sleep(speed);
		System.out.println(
				"Move " + verbalDirection + ".\nNew coordinates: h" + tankX + "px. / " + "v" + tankY + "px.\n");
	}

	static String getQuadrant(String v, String h) {
		String res = hPix(h) + "_" + vPix(v);
		return res;
	}

	static int vPix(String v) {
		int px_sq = 64;
		String vLine = "abcdefghi";
		int vPix = vLine.indexOf(v) * px_sq;
		return vPix;
	}

	static int hPix(String h) {
		int px_sq = 64;
		String hLine = "123456789";
		int hPix = hLine.indexOf(h) * px_sq;
		return hPix;
	}

	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;

	public static void main(String[] args) throws Exception {
		Frame_2_4_15 bf = new Frame_2_4_15();
		bf.runTheGame();
	}

	public Frame_2_4_15() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(500, 150);
		frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
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

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, 64, 64);
	}

}
