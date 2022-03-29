import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Stack stack = new Stack();
		while(sc.hasNextInt()) {
			stack.add(sc.nextInt());
		}
		while ( !stack.isEmpty() ){
		    // top 값을 출력
			try {
				System.out.println(stack.top());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    // pop
			stack.pop();
		}
		
		try {
			System.out.println(stack.top());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 비어 있으므로 예외 처리 메시지가 출력되게 한다.
	}

}
