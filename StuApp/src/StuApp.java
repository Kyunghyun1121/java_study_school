import java.util.Scanner;

public class StuApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s = new Student[100]; // 주의. s 배열은 전부 null이다.
		Scanner sc = new Scanner(System.in);
		int num = 0;

		while (sc.hasNext()) {
			// s[num] = new Student();
			s[num] = s[num].getStudent(sc);
			if (s[num] == null)
				break;
			num++;
		}

		if (s[num] == null)
			num--;

		while (num >= 0) {
			s[num--].show();
		}
		
		
	}



}
