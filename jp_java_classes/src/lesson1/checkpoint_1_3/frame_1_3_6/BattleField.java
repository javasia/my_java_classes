package lesson1.checkpoint_1_3.frame_1_3_6;

public class BattleField {

	private int BF_WIDTH = 576;
	private int BF_HEIGHT = 576;
	private int CELL_SIZE = 64;

	int brickLevel = 5;

	private String[][] battleField;

	BattleField() {
		battleField = initRandomField(brickLevel);
	}

	BattleField(String[][] battelField) {
		this.battleField = battleField;
	}

	public int getBF_WIDTH() {
		return BF_WIDTH;
	}

	public int getBF_HEIGHT() {
		return BF_HEIGHT;
	}

	private String scanQuadrant(int y, int x) {
		return battleField[y][x];
	}

	private void updateQuadrant(int y, int x, String obstacle) {
		battleField[y][x] = obstacle;
	}

	private int getDimentionX() {
		return battleField[0].length;
	}

	private int getDimentionY() {
		return battleField.length;
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
