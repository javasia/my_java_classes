package lesson1.checkpoint_1_3.frame_1_3_2;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ButtleField {
	
	
	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;
	final static int MAX_QUADRANTS = 8;
	final static int MIN_QUADRANTS = 0;
	
	static int brickLevel; 
	

	ButtleField() {
		initFrame();			
	}
	
	ButtleField(int bricklevel) {
		initFrame();			
		this.brickLevel=brickLevel;
	}
	
	public void initFrame(){
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(BF_WIDTH + 18, BF_HEIGHT + 47));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//frame.getContentPane().add(object);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static String[][] initField() {

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
}
