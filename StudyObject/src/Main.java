import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjVector myobject = new ObjVector(10);
		Scanner mysc = new Scanner(System.in);
		myobject.add(mysc.nextDouble());
		myobject.add(mysc.nextDouble());
		myobject.add(mysc.nextInt());
		myobject.add(mysc.nextInt());

		System.out.println("Double " + (double) myobject.get(0));
		System.out.println("Double " + (double) myobject.get(1));
		System.out.println("Integer " + (int) myobject.get(2));
		System.out.println("Integer " + (int) myobject.get(3));

	}

}
