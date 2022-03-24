import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddFiles {
	public static void main(String[] args) throws FileNotFoundException {
		int sum = 0;
		for (int a = 0; a < args.length; a++) {
			Scanner sc = new Scanner(new File(args[a]));

			while (sc.hasNextInt()) {
				sum += sc.nextInt();
			}

		}

		System.out.println(sum);

	}
}
