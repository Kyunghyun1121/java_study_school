interface ListIterator<E> {
	boolean hasNext();

	boolean hasPrevious();

	E next();

	E previous();
}

class Node<E> {
	private Node next;
	private Node front;
	private E data;

	public Node(E d, Node f, Node n) {
		data = d;
		front = f;
		next = n;
	}

	public void mynext(Node n) {
		next = n;
	}

	public Node getnext() {
		return next;
	}

	public Node getfront() {
		return front;
	}

	public String toString() {
		return (String) data;
	}
}

public class MyLinkedList<E> {
	private Node first;
	private Node end;
	private int cn = 0;

	public MyLinkedList() {
		first = null;
		end = null;
	}

	public void add(E next) {
		if (first == null) {
			first = new Node(next, null, null);
			end = first;
		} else if (first == end) {
			Node temp = new Node(next, first, null);
			first.mynext(temp);
			end = temp;
		} else {
			Node temp = new Node(next, end, null);
			end.mynext(temp);
			end = temp;
		}
		++cn;
	}

	public int size() {
		return cn;
	}

	private Node temp;

	public ListIterator listIterator() {
		return new listIterator();
	}

	public ListIterator listIterator(int n) {
		return new listIterator(n);
	}

	class listIterator implements ListIterator<Node> {
		public listIterator() {
			temp = first;
		}

		public listIterator(int n) {
			temp = first;
			for (int a = 0; a < n - 1; a++) {
				temp = temp.getnext();
			}
		}

		@Override
		public boolean hasNext() {
			if (temp != null) {
				return true;
			}
			return false;
		}

		@Override
		public Node next() {
			Node n = temp;
			temp = temp.getnext();
			return n;
		}

		@Override
		public boolean hasPrevious() {
			if (temp != null) {
				return true;
			}
			return false;
		}

		@Override
		public Node previous() {
			Node n = temp;
			temp = temp.getfront();
			return n;
		}

	}

}
