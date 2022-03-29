
public class Person {
	public String name;
	public String id; // 주민번호
	// 최대 10개의 계좌 정보를 가지도록 한다.
	private Account[] myA = new Account[10];
	private int coun = 0;

	public Person(String n, String i) {
		name = n;
		id = i;
	}

	public void getAccoun(Account a) {
		myA[coun++] = a;
	}

	public void report() {
		// 이 사람이 가지고 있는 모든 계좌의 정보를 출력한다.
		System.out.println("이름은 " + name + " 주민번호는 " + id);
		System.out.println("가지고 있는 계좌는:");
		for (int a = 0; a < coun; a++) {
			myA[a].report();
		}
	}
}
