import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class MyLengthComparator implements Comparator<String> {
	public int compare(String a, String b) {
		int ma = a.length();
		int mb = b.length();
		return ma - mb;
	}
}
class MyComparator implements Comparator<String> {
	public int compare(String a, String b) {
		int ma = a.charAt(0);
		int mb = b.charAt(0);
		return ma - mb;
	}
}

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<String>();
		Scanner myScanner = new Scanner(System.in);
		while (myScanner.hasNext()) {
			myList.add(myScanner.next());
		}
		
		myList.sort(new MyComparator());
		for (String s : myList) {
			System.out.println(s);
		}
		
		myList.sort(new MyLengthComparator());
		for (String s : myList) {
			System.out.println(s);
		}
	}

}