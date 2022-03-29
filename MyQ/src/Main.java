import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQ queue = new LinkedQ();
		
		Scanner sc = new Scanner (System.in);
		while(sc.hasNext()) {
			queue.add(sc.next());
		}
		
		while ( !queue.isEmpty() ){
		    try {
				System.out.println(queue.front());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //가장 오래전에 삽입한 항목을 출력
		   queue.remove();   //항목 삭제
		}

		try {
			String s = queue.front() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // 없으므로 예외처리를 하게 만든다.
	}

}
