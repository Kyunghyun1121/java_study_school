class Link{
	public int data;  
	public Link next;
	
	public Link(int data, Link link){
		// 생성자를 이용하자.
		this.data = data;
		next = link;
	}
}

public class Stack{
	private Link firstLink;
	
	public Stack() {
		firstLink = new Link(0, null);
	}
	
	public void add(int num) {   // 삽입

		firstLink = new Link(num, firstLink);
	
	}
	public int top() throws Exception {     // top에 있는 정수 값을 반환
		if(this.isEmpty()) {
			throw(new Exception("스트링이 비었습니다."));
		}
		
		return firstLink.data;
	}
	public boolean isEmpty() {   // 비어있는지 확인하는 함수
		if(firstLink.next == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void pop() {// top에 있는 항목(가장 최근 삽입한)을 삭제하는 함수
		firstLink = firstLink.next;
	}
	
}