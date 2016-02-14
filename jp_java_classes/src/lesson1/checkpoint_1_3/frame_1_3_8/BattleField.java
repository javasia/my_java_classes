package lesson1.checkpoint_1_3.frame_1_3_8;

public class BattleField {

	private int BF_WIDTH = 576;
	private int BF_HEIGHT = 576;
	private int CELL_SIZE = 64;
	
	int brickLevel = 5;

	private String[][] battleField;

	public BattleField() {
		battleField = initRandomField(brickLevel);
	}

	public BattleField(String[][] battleField) {
		this.battleField = battleField;
	}
	
	public String[][] getBattleField() {
		return battleField;
	}

	public int getBF_WIDTH() {
		return BF_WIDTH;
	}

	public int getBF_HEIGHT() {
		return BF_HEIGHT;
	}
	
	public int getCELL_SIZE() {
		return CELL_SIZE;
	}

	public String scanQuadrant(int y, int x) {
		return battleField[y][x];
	}

	public void updateQuadrant(int y, int x, String obstacle) {
		battleField[y][x] = obstacle;
	}

	private int getDimentionX() {
		return battleField[0].length;
	}

	private int getDimentionY() {
		return battleField.length;
	}

	private String[][] initRandomField(int brickLevel) {

		String[][] field = new String[BF_HEIGHT/CELL_SIZE][BF_WIDTH/CELL_SIZE];

		for (int i = 0; i < field.length; i++) {
			field[i] = new String[] { " ", " ", " ", " ", " ", " ", " ", " ", " " };
		}
		System.out.println("Battle field initialized.");

		if (brickLevel < 0) {
			brickLevel = 0;
		} else if (brickLevel > 100) {
			brickLevel = 100;
		}

		for (int i = 0, j = 0; i < field.length; i++) {
			for (int k = 0; k <= brickLevel; k++) {
				j = (int) (Math.random() * 10);
				if (j > field[i].length-1) {
					j = 0;
				}
				field[i][j] = "B";
			}
		}
		System.out.println("Random battle field genetated.");
		return field;
	}
}
