import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class student implements Serializable {
	String name;

	public student(String n) {
		name = n;
	}

	public student() {
	}

	public void speak() {
		System.out.println(name);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<student> mys = new ArrayList<student>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int num = sc.nextInt();
			if (num == 0) {
				mys.add(new student(sc.next()));
			} else if (num == 1) {
				try {
					ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("data.txt"));
					oss.writeObject(mys);
					oss.close();
				} catch (Exception e) {
					System.out.println("Fail");
				}
			} else if (num == 2) {
				try {
					ObjectInputStream instream = new ObjectInputStream(new FileInputStream("data.txt"));
					mys = (ArrayList<student>) instream.readObject();
				} catch (Exception e) {
					System.out.println("Fail");
				}
			} else {
				for(student s : mys) {
					s.speak();
				}
			}
		}

	}
}
