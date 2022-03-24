/*StringBuffer 클래스를 사용하는 예시를 Main.java 에 보여주고 있다.
여기에 나오는 StringBuffer를 MyStringBuffer 클래스로 대체하고 (별도 파일에 작성)
동일한 결과가 나오도록 한다.

배열을 복사할 때는 Arrays.copyOf 함수를 사용하면 편리하다. (그냥 for 문으로 복사해도 무관)*/
public class BufferMain {
	static int seq = 1;
	static void debugprint(MyStringBuffer s) {
		System.out.println(seq++ + ". " + s + " len = " + s.length() + " / size = " + s.capacity());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringBuffer s = new MyStringBuffer("Hello");
		MyStringBuffer t = new MyStringBuffer("world");
		debugprint(s); // toString 이 필요하다.
		s.append(t);
		s.append(123);
		debugprint(s); // toString 이 필요하다.
		s.delete(0, 3);
		debugprint(s);
		s.insert(0, "Hel");
		debugprint(s);
		t.reverse();
		debugprint(t);
		s.delete(8, s.length());
		debugprint(s);
		s.trimToSize();
		debugprint(s);
	}
}
