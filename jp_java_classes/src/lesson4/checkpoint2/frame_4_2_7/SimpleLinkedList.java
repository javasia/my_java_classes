package lesson4.checkpoint2.frame_4_2_7;

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

	public void addAfter(Object o, Object prev) {

	}

	public int getSize() {
		return size;
	}

	private class Node {
		Object obj;
		Node node;
	}
}
