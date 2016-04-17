package lesson4.checkpoint2.frame_4_2_9;

public class Launcher {

	public static void main(String[] args) {

		SimpleLinkedList sll = new SimpleLinkedList();
		
		System.out.println("PrintList test: empty list");
		//sll.printList();
		
		System.out.println("AddFist test:");
		sll.addFirst("testObj 1");
		sll.addFirst("testObj 2");
		sll.addFirst("testObj 3");
		sll.printList();
		System.out.println();
		
		System.out.println("test addLast:");
		sll.addLast("addlast object1");
		sll.addLast("addlast object2");
		sll.addLast("addlast object3");
		sll.printList();
		System.out.println();
		
		System.out.println("test addafter:");
		//sll.addAfter("addFftaerObj1", null);
		sll.addAfter("addFftaerObj1", "testObj 2");
		sll.addAfter("addFftaerObj2", "testObj 2");
		sll.addAfter("addFftaerObj3", "testObj 2");
		sll.printList();
		System.out.println();
		System.out.println();

		System.out.println("test addafter with wong prevObjects:");
//		sll.addAfter("addAftaerWrongObj1", null);
		sll.addAfter("addAftaerWrongObj1", new Integer(10));
//		sll.addAfter("addAftaerWrongObj1", new Node());
		
		System.out.println();
	}

}
