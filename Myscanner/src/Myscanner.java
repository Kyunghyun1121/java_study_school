import java.io.IOException;
/*static 함수인 getNext() 를 만들어 다음과 같이 활용할 수 있게 한다.
 *  getNext 함수는 System.in 응 이용하여 마치 Scanner의 next 함수처럼
 *   하나의 스트링을 반환하는 함수이다.  입력시 스트링은 
 * 빈칸혹은 EOF로 구분되며 스트링이 더이상 없으면 빈 스트링( "" )을 반환하면 된다.
 */
public class Myscanner {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String s;
		s = getNext();
		while (!s.equals("")) {
			System.out.println(s);
			s = getNext();
		}
		System.out.println("END");
	}
	
	public static String getNext() {
		int c;
		
		try {
			c = System.in.read();
			while (Character.isWhitespace(c)) {
				c = System.in.read();
			}
			//System.out.println("빈칸이 아닌 글자: " + c);
			if (c == -1) {
				// EOF
				return "";
			}
			
			String result = "";
			
			while (c != -1 && !Character.isWhitespace(c)) {
				result += (char) c;
				c = System.in.read();
			}
			
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		
	}
}
