package lesson4.checkpoint2.frame_4_2_13;

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
		return new SSLIterator();
	}

	private class SSLIterator implements Iterator {

		Node curPt;
		Node prevPt;

		public SSLIterator() {
			if (root == null) {
				throw new IllegalStateException("List is emty or root is violated!");
			}
			curPt = root;
		}

		@Override
		public boolean hasNext() {
			if (curPt != null) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {

			Object res = curPt.obj;
			prevPt = curPt;
			if (curPt.node==null){
				
				try {
					throw new IllegalStateException ("Out of bound of the list!");
				}catch (IllegalStateException e){
					e.printStackTrace();
					System.err.println("Action ignored...");
				}
			}else {
				curPt = curPt.node;
			}

			return res;
		}

		@Override
		public void remove() {
			
			
			if (size == 0 || root == null) {
				throw new IllegalStateException("Zero size or root is violated!");
			}

			else if (size == 1) {
				root = null;
			}

			else if (curPt.node == null) {
				prevPt.node = null;
			}

			else if (curPt == root) {
				next();
				root = curPt;
			} else {
				prevPt.node=curPt.node;
			}
		}
	}
}
