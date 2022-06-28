import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	public static void visit(File folder) {
		System.out.println(folder.getName());
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				System.out.println(file.getName());
			} else {
				visit(file);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		File dir = new File(name);

		visit(dir);
	}

}
