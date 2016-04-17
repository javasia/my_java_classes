package lesson4.checkpoint2.frame_4_2_9;

public class SimpleLinkedList {
	Node root;
	int size;

	public void addFirst(Object obj) {
		Node node = new Node();
		node.obj = obj;
		if (root != null) {
			node.node = root;
		}
		root = node;
		size++;
	}

	public void addLast(Object obj) {
		if (root == null) {
			addFirst(obj);
			return;
		} else {

			Node node = new Node();
			node.obj = obj;

			Node cp = root;

			while (cp.node != null) {
				cp = cp.node;
			}

			cp.node = node;

			size++;
		}
	}

	public void addAfter(Object obj, Object prev) throws RuntimeException {

		if (size == 0 || root == null) {
			throw new IllegalStateException("The list is empty or root is violated!");
		}

		Node node = new Node();
		node.obj = obj;

		Node cp = root;
		while (!cp.obj.equals(prev)) {
			if (cp.node==null){
				throw new IllegalStateException("Previous object not found!"); 
			}
			cp = cp.node;
		}
		
		node.node=cp.node;
		cp.node = node;
		size++;
	}

	public int getSize() {
		return size;
	}

	private class Node {
		Object obj;
		Node node;
	}
}
