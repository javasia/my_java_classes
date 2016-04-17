package lesson4.checkpoint2.frame_4_2_11;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable {
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
		while (cp.obj != prev) {
			if (cp.node == null) {
				throw new IllegalStateException("Previous object not found: " + prev + "!");
			}
			cp = cp.node;
		}

		node.node = cp.node;
		cp.node = node;
		size++;
	}

	public int getSize() {
		return size;
	}

	public void printList() {

		if (root == null || size == 0) {
			throw new IllegalStateException("Root is null or Size equals 0");
		}

		System.out.print("{");
		Node cp = root;
		while (cp.node != null) {
			System.out.print(cp.obj + ", ");
			cp = cp.node;
		}
		System.out.println(cp.obj + "}");
	}

	private class Node {
		Object obj;
		Node node;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new SSLIterator();
	}

	private class SSLIterator implements Iterator {

		Node cp;

		public SSLIterator() {
			cp = root;
		}

		@Override
		public boolean hasNext() {
			if (cp != null) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
 
			Object res = cp.obj; 
			cp = cp.node;
			
			return res;
		}
	}
}
