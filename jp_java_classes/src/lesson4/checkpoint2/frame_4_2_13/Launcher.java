package lesson4.checkpoint2.frame_4_2_13;

import java.util.Iterator;

public class Launcher {

	public static void main(String[] args) {

		SimpleLinkedList sll = new SimpleLinkedList();
		
				
		System.out.println("AddFist test:");
		sll.addFirst("testObj 1");
		sll.addFirst("testObj 2");
		sll.printList();
		System.out.println();
		
		Iterator i = sll.iterator();
		
		//System.out.println(i.next());
		//System.out.println(i.next());
		//System.out.println(i.next());
		
		i.remove();
		sll.printList();
		i.remove();
		sll.printList();
		i.remove();
		sll.printList();

	}

}
