class Link{
	public String data;  
	public Link next;
	public Link front;
	
	public Link(String data, Link link){
		// 생성자를 이용하자.
		this.data = data;
		
		if(link != null) {
			link.getfront(this);
		}
		
		next = link;
		
	}
	
	public void getfront(Link link) {
		front = link;
	}
}

public class LinkedQ {
	private Link firstlink;
	private Link lastlink;
	
	public LinkedQ() {
		firstlink = new Link(null,null);
	}
	
	public void add(String n){
		
		Link temp = new Link(n,firstlink);
		
		if(this.isEmpty()) {
			lastlink = temp;
		}
		firstlink=temp;
		
	}
	
	public String front() throws Exception { //가장 오래전에 삽입한 항목을 출력	
		if(this.isEmpty()) {
			throw(new Exception("스트링이 비었습니다."));
		}
		
		return lastlink.data;
	}
	
	public void remove() {  //항목 삭제
		lastlink = lastlink.front;
	}
	
	public boolean isEmpty() {
		if(lastlink == null) {
			return true;
		}
		else {
			return false;
		}
	}
}
