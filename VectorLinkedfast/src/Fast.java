import java.util.LinkedList;
import java.util.Vector;

public class Fast {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> myv = new Vector<>();
		LinkedList<Integer> myi = new LinkedList<>();
		
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for (int a = 0; a < 3000000; a++) {
			myv.add(a);
		}
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		double secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("Vector 삽입 시간(m) : " + secDiffTime);
		
		
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for (int a = 0; a < 3000000; a++) {
			myi.add(a);
		}
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("LikedList 삽입 시간(m) : " + secDiffTime);
		
		
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for (int a = 0; a < 70; a++) {
			myv.remove(5);
			myv.remove(6);
		}
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("Vector 특정 위치의 객체 삭제 시간(m) : " + secDiffTime);
		
		
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for (int a = 0; a < 70; a++) {
			myi.remove(5);
			myi.remove(6);
		}
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("LikedList 특정 위치의 객체 삭제 시간(m) : " + secDiffTime);
		
	}
}
