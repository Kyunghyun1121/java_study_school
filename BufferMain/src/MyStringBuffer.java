import java.util.Arrays;

public class MyStringBuffer {
	private char[] content;

	public String toString() {
		char[] temp = new char[this.length()];
		for (int num = 0; content[num] != 0 && num < content.length - 1; num++) {
			temp[num] = content[num];
		}
		
		String out = new String(temp);
		return out;
	}

	public MyStringBuffer() {
		// 길이가 21 인 배열을 할당.
		content = new char[21];
	}

	public MyStringBuffer(String s) {
		// 배열에 스트링을 넣어줍니다.
		char[] n = s.toCharArray();
		content = Arrays.copyOf(n, n.length + 16);
	}

	public int length() {
		// 버퍼의 문장의 길이를 돌려줍니다.
		int coun = 0;
		for (int a = 0; a < content.length; a++) {
			if ((int) content[a] >= 32 && (int) content[a] <= 126)
				++coun;
		}

		return coun;
	}

	public int capacity() {
		// 버퍼의 크기를 돌려줍니다.
		return content.length;
	}

	public void append(MyStringBuffer s) {
		// 배열에 버퍼를 추가해서 뒤에 붙여줍니다.
		// System.out.println(s.length() +" "+ this.length());
		if (s.length() + this.length() > content.length) {
			content = Arrays.copyOf(content, content.length + s.content.length + 16);
		}
		int num = 0;
		for (int a = this.length(); a < s.content.length; a++) {
			content[a] = s.content[num++];
		}

	}

	public void append(int n) {
		String s = String.valueOf(n);
		// 버퍼에 스트링을 붙여줍니다.
		MyStringBuffer in = new MyStringBuffer(s);
		append(in);
	}

	public void delete(int start, int len) {
		// 버퍼를 원하는 부분부터 주어진 길이만큼 지웁니다.
		if (start + len > this.length())
			len = this.length() - start;

		int leng = this.length();
		for (int a = start; a < start + len; a++) {
			content[a] = 0;
		}

		for (int a = start + len; a < leng; a++) {
			content[start++] = content[a];
		}

		for (int a = 0; a <= len; a++) {
			content[leng--] = 0;
		}

	}

	public void insert(int start, String s) {
		// 버퍼의 원하는 부분에 스트링을 넣어줍니다.
		if (s.length() + this.length() > content.length) {
			content = Arrays.copyOf(content, content.length + s.length() + 16);
		}

		int leng = this.length() - 1;
		int k = leng + s.length();
		for (int a = leng; a >= start; a--) {
			content[k--] = content[a];
		}

		char[] n = s.toCharArray();
		int nnum = 0;
		for (int a = start; a < n.length; a++) {
			content[a] = n[nnum++];
		}
	}

	public void reverse() {
		// 버퍼를 거꾸로 뒤집습니다.
		int start = 0;
		int end = this.length() - 1;
		while (start < end) {
			char temp = content[end];
			content[end] = content[start];
			content[start] = temp;
			end--;
			start++;
		}

	}

	public void trimToSize() {
		// 버퍼의 크기를 조정해줍니다.
		content = Arrays.copyOf(content, this.length());
	}
}
