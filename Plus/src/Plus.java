import java.util.Scanner;

public class Plus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner line = new Scanner(System.in);
		String inn = line.nextLine();
		
		while(line.hasNext()) {
			String les = line.nextLine();
		}
		
		int sum=0;
		Scanner pls = new Scanner(inn);
		
		while(pls.hasNextInt()) {
			sum += pls.nextInt();
		}
		
		System.out.println(sum);
	}

}
