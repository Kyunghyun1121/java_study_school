
public class MyQueue extends MyLinkedList{
	public void insert(String s) {  // 삽입
		super.addBack(s);
	}
	public String peek() throws Exception {// 제일 먼저 빠져나올 항목의 값을 가져온다.
		return peekFront();
	}
	public void remove() throws Exception {
		//  항목 하나를 빼버린다.
		super.removeFront();
	}
	public boolean isEmpty() {
		// 큐가 비었는지 판다.
		return super.isEmpty();
	}
}
