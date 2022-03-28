import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyIntArray myArray = new MyIntArray(4); // 크기 5. 중간에 늘리는 것은 없다.
		Scanner myScan = new Scanner(System.in);
		
		while(myScan.hasNext()) {
			String in = myScan.next();

			if(in.equals("a")) {
				myArray.add(myScan.nextInt());
			}else if(in.equals("i")){
				myArray.add(myScan.nextInt(),myScan.nextInt());
			}else if(in.equals("s")){
				myArray.downsort();
			}else if(in.equals("p")){
				myArray.print();
			}else if(in.equals("x")){
				myArray.delete(myScan.nextInt());
			}
			
		}
	}

}
