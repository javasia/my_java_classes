package lesson4.checkpoint2.frame_4_2_16;

import java.util.ArrayList;
import java.util.Collections;

public class Launcher {

	public static void main(String[] args) {

		ArrayList<String> myList = Data.returnInitList();
		
		for (String str:myList){
			System.out.println(str);
		}
		
		System.err.println("____________________________________________");
		System.err.println("\nSorted:\n____________________________________________\n ");
		
		Collections.sort(Data.returnInitList(), new MyComparator());
		
		for (String str:myList){
			System.out.println(str);
		}
		
		
	}

}
