package lesson1.checkpoint_1_3.frame_1_3_6;

import java.util.Arrays;

public class Launcher {

	public static void main(String[] args) {

		BattleField bf = new BattleField();
		
		String [][] field = bf.battleField;
		
		for (String[] str: field){
		System.out.println(Arrays.toString(str));
		}
	}

}
