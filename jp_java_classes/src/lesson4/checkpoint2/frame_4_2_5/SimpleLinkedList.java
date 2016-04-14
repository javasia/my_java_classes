package lesson4.checkpoint2.frame_4_2_5;

public class SimpleLinkedList {
	Node root;
	int size;
	
	public void addFirst(Object o){
		Node node = new Node();
		node.o=o;
		if (root!=null){
			node.node=root;
		}else{
			node.node=node;
		}
		root=node;
		size++;
	}
	
	public void addLast(Object o){
		
	}
	
	public  void addAfter(Object o, Object prev){
		
	}
	
	public  int getSize(){
		return size;
	}
	
	private class Node {
		Object o;
		Node node;
	}
}
