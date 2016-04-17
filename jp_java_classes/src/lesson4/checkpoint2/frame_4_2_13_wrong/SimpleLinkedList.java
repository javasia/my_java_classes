package lesson4.checkpoint2.frame_4_2_13_wrong;

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

	public void removeObject(Object object) {
		if (object == null) {
			throw new IllegalStateException("Null is not allowed as method's parameter!");
		}
		if (root == null || size == 0) {
			throw new IllegalStateException("Root is null or Size equals 0");
		}

		if (root.obj == object) {
			if (size == 1) {
				root = null;
			} else {
				root = root.node;
			}
			size--;
			return;
		}

		Node cp = root;
		Node prevPoint = new Node();

		while (cp != null) {
			if (cp.obj == object) {
				prevPoint.node = cp.node;
				return;
			}
			prevPoint = cp;
			cp = cp.node;
		}

		if (cp == null) {
			throw new IllegalStateException("No such element!");
		}
	}

	private class Node {
		Object obj;
		Node node;

		@Override
		public String toString() {
			return (String) obj;
		}
	}

	@Override
	public Iterator iterator() {
		return new SSLIterator();
	}

	private class SSLIterator implements Iterator {

		Node cp;

		public SSLIterator() {
			if (root == null) {
				throw new IllegalStateException("List is emty or root is violated!");
			}
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
