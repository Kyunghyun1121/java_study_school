class Link {
	public String data;
	public Link right;
	public Link left;

	public Link(String data, Link link) {
		// 생성자를 이용하자.
		this.data = data;
		right = link;
		left = link;
	}

}

public class MyLinkedList {
	public Link front;// 제일 먼저 넣은거
	public Link back;// 제일 늦게 넣은거

	public MyLinkedList() {
		back = new Link(null, null);
		front = new Link(null, null);
	}

	public void addFront(String n) {

		Link temp = new Link(n, front);
		if (back == null || back.data == null) {
			back = temp;
			back.left = null;
			back.right= null;		}
		Link cur = front;
		cur.right = temp;
		front = temp;
		front.right = null;

	}

	public void addBack(String n) {

		Link temp = new Link(n, back);
		if (front == null || front.data == null) {
			front = temp;
			front.right = null;
			front.left = null;
		}
		Link cur = back;
		cur.left = temp;
		back = temp;
		back.left = null;

	}

	public String peekFront() throws Exception { // front항목을 돌려준다. 없으면 예외를 던진다.
		if (this.isEmpty()) {
			throw (new Exception("스트링이 비었습니다."));
		}

		return front.data;
	}

	public String peekBack() throws Exception { // back에 있는 항목을 돌려준다. 없으면 예외를 던진다.
		if (this.isEmpty()) {
			throw (new Exception("스트링이 비었습니다."));
		}

		return back.data;
	}

	public void removeFront() throws Exception { // front항목을 삭제한다. 없으면 예외를 던진다.
		if (this.isEmpty()) {
			throw (new Exception("스트링이 비었습니다."));
		}
		front = front.left;
		if (front != null)
			front.right = null;
	}

	public void remove(String s) throws Exception { // s와 같은 내용의 스트링이 있으면 리스트에서 뺀다.
		if (this.isEmpty()) {
			throw (new Exception("스트링이 비었습니다."));
		}

		Link a = front;

		while (a != null && a.data != s) {
			if (a.left == null) {
				throw (new Exception("같은 내용의 스트링이 없습니다."));
			}
			a = a.left;
		}

		a.left.right = a.right;
		a.right.left = a.left;

	}

	public void removeBack() throws Exception { // back 항목을 삭제한다. 없으면 예외를 던진다.
		if (this.isEmpty()) {
			throw (new Exception("스트링이 비었습니다."));
		}
		back = back.right;
		if (back != null)
			back.left = null;
	}

	public boolean isEmpty() {
		Link a = front;
		if (a == null || a.data == null) {
			return true;
		} else {
			return false;
		}
	}

	void printForward() { // front 부터 back까지 순서대로 출력
		Link a = front;
		while (a != null) {
			System.out.print(a.data + " ");
			a = a.left;
		}
		System.out.println();
	}

	void printBackward() { // back 부터 front 까지 순서대로 출력
		Link a = back;
		while (a != null) {
			System.out.print(a.data + " ");
			a = a.right;
		}
		System.out.println();
	}

}
