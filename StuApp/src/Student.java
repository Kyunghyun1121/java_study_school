import java.util.Scanner;

public class Student {
	String name=null;
	int stunum=0;
	double score=0;
	
	public static Student getStudent(Scanner sc) {
		Student temp = new Student();
		try {
			temp.stunum = sc.nextInt();
			temp.name = sc.next();
			temp.score = sc.nextDouble();
		}catch(Exception e){
			return null;
		}
		
		return temp;
	}
	
	public void show() {
		System.out.println("학번: "+stunum+" "+"이름: "+name+" "+"성적: "+score+" ");
	}






}
