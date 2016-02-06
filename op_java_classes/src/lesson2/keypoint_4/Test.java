
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

public class Test extends JPanel {

	boolean COLORDED_MODE = true;

	int tankX = 0;
	int tankY = 0;

	long speed = 50;

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {

		long curTime = System.currentTimeMillis();
		String[][] field = initField();

		while (checkField(writeStrField(field)) == false) {
			writeStrFieldToConlose(field);
			moveRandom();
		}

		printTimePassed(curTime);

	}

	String[][] initField() {

		String[][] field = new String[10][10];

		int i = 1;
		while (i <= 9) {
			field[i++] = new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		}

		field[0] = new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		i = 0;
		while (i <= 9) {
			String[] vLine = new String[] { " ", "a", "b", "c", "d", "e", "f", "g", "h", "i" };
			field[i][0] = vLine[i++];
		}

		return field;
	}

	boolean checkField(String[][] field) {

		boolean ready = true;
		int n = 1;
		while (n <= 9) {
			int i = 1;
			while (i <= 9) {
				if (field[n][i++].equals("X") != true) {
					ready = false;
				}
			}
			n++;
		}
		if (ready == true) {
			writeStrFieldToConlose(field);
			System.out.println("DONE!");
		}
		return ready;
	}

	String[][] writeStrField(String[][] field) throws Exception {

		int cellSize = 64;
		int cellX = (tankX / cellSize) + 1;
		int cellY = (tankY / cellSize) + 1;
		field[cellY][cellX] = "X";
		return field;

	}

	void writeStrFieldToConlose(String[][] field) {
		System.out.println("WRITING HYSTORY. 0 - NOT VISITED; X - VISITED");

		int n = 0;
		int i = 0;
		while (n <= 9) {
			i = 0;
			while (i <= 9) {
				System.out.print(field[n][i++]);
			}
			System.out.println("");
			n++;
		}
	}

	void printTimePassed(long curTime) {
		curTime = System.currentTimeMillis() - curTime;
		long hr = curTime / (1000 * 60 * 60);
		long min = curTime / (1000 * 60) % 60;
		long sec = (curTime / 1000) % 60;

		String timePassed = hr + ":" + min + ":" + sec;
		System.out.println("TIME PASSED: " + timePassed);
	}

	void moveRandom() throws Exception {
		//move(getRandomDirection1());
		// ALTERNATIVE1
		// move(getRandomDirection2());
		// ALTERNATIVE2
		move(getRandomDirection3());
		// ALTERNATIVE3
		//move(getRandomDirection4());
	}

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

	// ALTERNATIVE1
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

	// ALTERNATIVE2
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
	
	// ALTERNATIVE3
		int getRandomDirection4() throws Exception {
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
					continue;
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
		Test bf = new Test();
		bf.runTheGame();
	}

	public Test() throws Exception {
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
