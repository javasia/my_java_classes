package lesson1.checkpoint_1_3.frame_1_3_6;

public class BattleField {

	int BF_WIDTH = 576;
	int BF_HEIGHT = 576;
	int CELL_SIZE = 64;
	
	int brickLevel=5;

	public String[][] battleField;

	public BattleField() {
		battleField = initRandomField(brickLevel);
	}

	private String scanQuadrant(int y, int x) {
		return battleField[y][x];
	}

	private void updateQuadrant(int y, int x, String obstacle) {
		battleField[y][x]=obstacle;
	}
	
	private int getDimentionX() {
		return (BF_WIDTH/CELL_SIZE)-1;
	}

	private int getDimentionY() {
		return (BF_HEIGHT/CELL_SIZE)-1;
	}

	private String[][] initRandomField(int brickLevel) {

		String[][] field = new String[9][9];

		for (int i = 0; i <= getDimentionY(); i++) {
			field[i] = new String[] { " ", " ", " ", " ", " ", " ", " ", " ", " " };
		}
		System.out.println("Battle field initialized.");

		if (brickLevel < 0) {
			brickLevel = 0;
		} else if (brickLevel > 100) {
			brickLevel = 100;
		}

		for (int i = 0, j = 0; i <= getDimentionX(); i++) {
			for (int k = 0; k <= brickLevel; k++) {
				j = (int) (Math.random() * 10);
				if (j > getDimentionX()) {
					j = 0;
				}
				field[i][j] = "B";
			}
		}
		System.out.println("Random battle field genetated.");
		return field;
	}
}
