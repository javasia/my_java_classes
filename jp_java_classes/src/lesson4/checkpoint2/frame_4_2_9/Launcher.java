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
		
		System.out.print("getSize: ");
		System.out.println(sll.getSize());
		
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

		System.out.println("test addafter with wong prevObjects:");
//		sll.addAfter("addAftaerWrongObj1", null);
//		sll.addAfter("addAftaerWrongObj1", new Integer(10));
//		sll.addAfter("addAftaerWrongObj1", new Node());

		System.out.println("test addafter with equal prevObjects:");
		String str1 = new String("TestEqualObj");
		String str2 = str1;
		sll.addLast(str1);
		sll.addAfter(str2, str1);
		sll.printList();
		System.out.println();

		System.out.println("test empty list behavior:");
		SimpleLinkedList emptyList = new SimpleLinkedList();
//		emptyList.addAfter("addObj1", new Node());
//		emptyList.printList();
		emptyList.addLast("objLastObj");
		emptyList.printList();
		System.out.println();

		System.out.println("test one element behavior:");
		SimpleLinkedList oneElemList = new SimpleLinkedList();
		//oneElemList.addFirst("obj1");
		oneElemList.addLast("addLastObj1");
		oneElemList.addAfter("addAfterObj1", "addLastObj1");
		oneElemList.printList();
		System.out.println();
	}

}
