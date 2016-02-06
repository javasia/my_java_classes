
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

public class Frame_2_4_13 extends JPanel {

	boolean COLORDED_MODE = true;

	int tankX = 0;
	int tankY = 0;

	long speed = 50;

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {
		while (true) {
			moveRandom();
		}
	}

	void moveRandom() throws Exception {
		 move(getRandomDirection1());
		// ALTERNATIVE
		// move(getRandomDirection2());		
		// ALTERNATIVE
		// move(getRandomDirection3());
	}

	// ALTERNATIVE
	int getRandomDirection1() throws Exception {
		while (true) {
			String sTime = String.valueOf(System.currentTimeMillis());
			int iRndNum = Integer.parseInt(sTime.substring(sTime.length() - 1));
			if (iRndNum >= 1 && iRndNum <= 4) {
				return iRndNum;
			} else
				Thread.sleep(1);
		}
	}
	// ALTERNATIVE
	int getRandomDirection2() throws Exception {
		while (true) {
			String sTime = String.valueOf(System.currentTimeMillis());
			char chRndNum = sTime.charAt(sTime.length() - 1);
			if (chRndNum == '1' || chRndNum == '2' || chRndNum == '3' || chRndNum == '4') {
				return "1234".indexOf(chRndNum) + 1;
			} else
				Thread.sleep(1);
		}
	}

	int getRandomDirection3() throws Exception {
		while (true) {
			String sTime = String.valueOf(System.currentTimeMillis());
			int iRndNum = Integer.parseInt(sTime.substring(sTime.length() - 1));
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
			} else
				Thread.sleep(1);
		}
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

	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;

	public static void main(String[] args) throws Exception {
		Frame_2_4_13 bf = new Frame_2_4_13();
		bf.runTheGame();
	}

	public Frame_2_4_13() throws Exception {
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
