
public class MyStringArray {
	private String[] mys;
	private int coun = 0;
	private int full = 0;

	public MyStringArray(int a) {
		mys = new String[a];
		full = a;
	}

	public void add(String s) throws Exception {
		if (coun >= full)
			throw new Exception("크기초과");
		else
			mys[coun++] = s;
	}

	public int size() {
		return coun;
	}

	public String elementAt(int i) throws Exception {
		if (i >= coun)
			throw new Exception("인덱스 범위 초과");
		return mys[i];
	}

}