package lesson1.checkpoint_1_3.frame_1_3_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ActionField {

	final boolean COLORDED_MODE = false;
	final int CELL_SIZE_PIX = 64;
	
	String[][] battleField = ButtleField.initField();
	
	Graphics g;
	

	
	//@Override
	protected void paintComponent(Graphics g) {
	//super.paintComponent(g);

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
		g.fillRect(Tank.tankX, Tank.tankY, CELL_SIZE_PIX, CELL_SIZE_PIX);

		g.setColor(new Color(0, 255, 0));
		if (Tank.tankDirection == 1) {
			g.fillRect(Tank.tankX + 20, Tank.tankY, 24, 34);
		} else if (Tank.tankDirection  == 2) {
			g.fillRect(Tank.tankX + 20, Tank.tankY + 30, 24, 34);
		} else if (Tank.tankDirection  == 3) {
			g.fillRect(Tank.tankX, Tank.tankY + 20, 34, 24);
		} else {
			g.fillRect(Tank.tankX + 30, Tank.tankY + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(Bullet.bulletX, Bullet.bulletY, 14, 14);
	}
	
	
}
