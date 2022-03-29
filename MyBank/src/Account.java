
public class Account {
	public Person owner;
	private int money = 0;

	public Account(Person p) {
		owner = p;
		owner.getAccoun(this);
	}

	public void deposit(int m) {
		money += m;
	}

	public void report() {
		System.out.println("주인의 이름은 " + owner.name + " 주민번호는 " + owner.id);
		System.out.println("잔액은 " + money);
	}
}
