
public class Set extends List {

	public void add(int n) {
		if (!super.includes(n))
			super.add(n);
	}

	public void show() {
		super.show();
	}
}
