

public class Integretest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		Integer sum2=0;
		
		int val1 = 10000;
		Integer val2 = 10000;
		
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for (Integer i = 0; i < val2 ; i++) {
			for (Integer b = 0; b < val2; b++) {
				sum2+=1;
				sum2-=1;
			}
		}
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		double secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("integer 시간차이(m) : " + secDiffTime);
		
		
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for (int i = 0; i < val1; i++) {
			for (int b = 0; b < val1; b++) {
				sum+=1;
				sum-=1;
			}
		}
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("int 시간차이(m) : " + secDiffTime);
		
	}
}
