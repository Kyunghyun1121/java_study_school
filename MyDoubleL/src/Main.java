import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		Scanner myScanner = new Scanner(System.in);

		// MyLinkedList에서는 적절한 예외 처리를 하게 하고,
		// main에서도 try catch를 한다. (실제로 예외는 발생하지 않더라도)

		/*MyLinkedList myList = new MyLinkedList();
		
		while (myScanner.hasNext()) {
			myList.addFront(myScanner.next());
		}

		myList.addBack("xxx");
		myList.addBack("yyy");
		myList.addBack("zzz");

		myList.printForward();
		try {
			System.out.println("Front: " + myList.peekFront());
			System.out.println("Back: " + myList.peekBack());

			myList.removeFront();
			myList.removeBack();
			myList.remove("xxx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myList.printBackward();*/
		MyQueue queue = new MyQueue();
		// scanner는 표준 입력 스캐너
		while (myScanner.hasNext()){
			queue.insert(myScanner.next());
		}
		
		while (!queue.isEmpty()) {
			System.out.println(queue.peek());
			queue.remove();
		}

		queue.insert("aaa");
		queue.insert("bbb");
		queue.addBack("ccc");
		queue.addFront("ddd");

		while (!queue.isEmpty()) {
			System.out.println(queue.peek());
			queue.remove();
		}
	}
}
