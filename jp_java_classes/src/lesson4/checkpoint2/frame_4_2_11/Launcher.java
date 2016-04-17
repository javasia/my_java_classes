package lesson4.checkpoint2.frame_4_2_11;

import java.util.Iterator;

public class Launcher {

	public static void main(String[] args) {

		SimpleLinkedList sll = new SimpleLinkedList();
		
				
		System.out.println("AddFist test:");
		sll.addFirst("testObj 1");
		sll.addFirst("testObj 2");
		sll.addFirst("testObj 3");
		sll.printList();
		System.out.println();
		
		Iterator i = sll.iterator();
		
		while (i.hasNext()){
			System.out.println(i.next());
		}
		
		for (Object o:sll){
			System.out.println(o);
		}
	}

}
