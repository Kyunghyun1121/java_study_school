
public class MyString {
	private char[] content; // 실제 내용을 담을 배열 변수

	// immutable은 생성자 이외에는 내용물을 설정하는 방법이 없다.
	public MyString() {
		// 길이가 0 인 배열을 할당.
		content = new char[0];
	}

	public MyString(char[] carray) {
		content = new char[carray.length];
		for (int a = 0; a < carray.length; a++) {
			content[a] = carray[a];
		}
	}

	public MyString(String s) {
		char[] temp = s.toCharArray();
		content = new char[temp.length];
		for (int a = 0; a < temp.length; a++) {
			content[a] = temp[a];
		}
	}

	public String toString() {
		// String 클래스의 생성자 중 적당한 것을 찾아서 활용
		// 이 함수가 있어야 println을 사용할 수 있다.
		return new String(content);
	}

	public static MyString add(MyString a, MyString b) {
		char[] temp = new char[a.length() + b.length()];

		for (int d = 0; d < a.length(); d++) {
			temp[d] = a.content[d];
		}
		int c = a.length();
		for (int d = 0; d < b.length(); d++) {
			temp[c++] = b.content[d];
		}
		return new MyString(temp);
	}

	public int length() {
		return content.length;
	}

	public boolean equals(String s) {
		MyString temp = new MyString(s);
		if (this.length() != temp.length())
			return false;

		for (int a = 0; a < temp.length(); a++) {
			if (content[a] != temp.content[a])
				return false;
		}

		return true;
	}

	public boolean equals(MyString s) {
		if (this.length() != s.length())
			return false;

		for (int a = 0; a < s.length(); a++) {
			if (content[a] != s.content[a])
				return false;
		}
		return true;
	}

	public char charAt(int n) {
		// 특정 위치의 char 를 둘려주는 함수
		return content[n];
	}

	public int indexOf(char c) {
		// 문자열에서 문자 c의 위치를 알려준다. 없으면 -1
		for (int a = 0; a < this.length(); a++) {
			if (content[a] == c)
				return a;
		}

		return -1;
	}

	public int indexOf(String s) {
		// s 가 포함되어 있는 경우 위치를 돌려준다.
		// 없으면 -1
		// 아래의 보조 함수 isSubstr을 사용하면 편리하다.
		// 그러면 여기서는 반복문만 돌리면 된다.
		for (int a = 0; a < this.length(); a++) {
			if (isSubstr(a, s))
				return a;
		}

		return -1;
	}

	public boolean isSubstr(int index, String s) {
		// content의 특정 위치부터가 s와 같은지 판별하는 함수
		char[] temp = s.toCharArray();
		for (int a = 0; a < temp.length; a++) {
			if (content[index++] != temp[a])
				return false;
		}
		return true;
	}

	public MyString substring(int begin, int end) {
		// 스트링의 일부를 추출해서 MyString으로 만들어 주는 함수.
		if (begin < 0)
			begin = 0;
		if (end > this.length())
			end = this.length();
		char[] temp = new char[end - begin];
		int z = 0;
		for (int a = begin; a < end; a++) {
			temp[z++] = content[a];
		}
		return new MyString(temp);
	}
}
