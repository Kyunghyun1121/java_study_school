class Counter {
	private int count;

	public void Bump() {
		count++;
	}

	public void Reset() {
		count = 0;
	}

	public void Show() {
		System.out.println(count);
	}
}

public class Counte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c = new Counter();
		c.Reset();
		c.Bump();
		c.Bump();
		c.Bump();
		c.Bump();
		c.Bump();
		c.Show();
	}

}


