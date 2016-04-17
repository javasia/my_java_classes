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
		
		
		
		sll.addFirst("ExtraAdd1");
		sll.addFirst("ExtraAdd2");
		sll.addFirst("ExtraAdd3");
		sll.addFirst("ExtraAdd4");
		sll.printList();
		System.out.println("Remooving object: ExtraAdd3");
		sll.removeObject("ExtraAdd3");
		sll.printList();
		System.out.println("Remooving object: testObj 1");
		sll.removeObject("testObj 1");
		sll.printList();
		System.out.println("Remooving object: ExtraAdd4");
		sll.removeObject("ExtraAdd4");
		sll.printList();
	}

}
