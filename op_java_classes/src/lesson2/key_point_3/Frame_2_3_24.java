
	/**
	 * - TANKS -
	 */


/*
 * Copyright (c) 2014 kademika.com
 */
package lesson2.key_point_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.activation.MimeTypeParameterList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Frame_2_3_24 extends JPanel {

	boolean COLORDED_MODE = true;
	
	int tankX = 0;
	int tankY = 0;
	
	long speed = 50;
	
	String coordinates="a1";

	
	/**
	 * Write your code here.
	 */
	

	
	void runTheGame() throws Exception {
		while (true){
		move(getRandomDirection());
		repaint();
		Thread.sleep(speed);
		}
	}
	
	int getRandomDirection () throws Exception{
		while(true){
		String sTime=String.valueOf(System.currentTimeMillis());
		char chRndNum = sTime.charAt(sTime.length()-1);
		if (chRndNum=='1'||chRndNum=='2'||chRndNum=='3'||chRndNum=='4'){
			return "1234".indexOf(chRndNum)+1;	
			}
		else Thread.sleep(1);
		}
	}
	
	void move(int direction) {
			
		String vQuad=String.valueOf(coordinates.charAt(0));
		String hQuad=String.valueOf(coordinates.charAt(1));
		int vDigQ=vPix(String.valueOf(vQuad))/64;
		int hDigQ=hPix(String.valueOf(hQuad))/64;
		String verbalDirection=null;
		String vLine="abcdefghi";
		String hLine = "123456789";
			
			if (direction==1){
				if (vDigQ>0){
					verbalDirection="up";
					vQuad=String.valueOf(vLine.charAt(vDigQ-1));
					}
				else{verbalDirection="ignored";}
			}
			else if (direction==2){
				if (vDigQ<8){
					verbalDirection="down";
					vQuad=String.valueOf(vLine.charAt(vDigQ+1));
					}
				else{verbalDirection="ignored";}
			}
			else if (direction==3){
				if (hDigQ>0){
					verbalDirection="left";
					hQuad=String.valueOf(hLine.charAt(hDigQ-1));
					}
				else{verbalDirection="ignored";}
			}
			else if (direction==4){
				if (hDigQ<8){
					verbalDirection="right";
					hQuad=String.valueOf(hLine.charAt(hDigQ+1));
					}
				else{verbalDirection="ignored";}
			}
			
		coordinates=vQuad+hQuad;
		tankX=hPix(hQuad);
		tankY=vPix(vQuad);
		System.out.println("Move " + verbalDirection + ". New coordinates: " + coordinates + ".\nVertical pos.: " + tankY 
		+ " px.\n" +  "Horizontal pos.: " + tankX + " px.");
		}
		
	static int vPix(String v){
		int px_sq = 64;
		String vLine = "abcdefghi";
		int vPix=vLine.indexOf(v)*px_sq;
		return vPix;
	}

	static int hPix(String h){
		int px_sq = 64;
		String hLine = "123456789";
		int hPix=hLine.indexOf(h)*px_sq;
		return hPix;
	}


	
	// Magic bellow. Do not worry about this now, you will understand everything in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;
	
	public static void main(String[] args) throws Exception {
		Frame_2_3_24 bf = new Frame_2_3_24();
		bf.runTheGame();
	}

	public Frame_2_3_24() throws Exception {
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

