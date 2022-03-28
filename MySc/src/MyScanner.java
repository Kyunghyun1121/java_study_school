import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MyScanner {
	private InputStream my;
	private int in = 0;
	private boolean minu = false;

	public MyScanner(InputStream i) {
		my = i;
	}

	public boolean hasNextInt() throws IOException {
		while (in != -1) {
			if (in >= 33 && in <= 127) {
				if(in == '-') {
					in = my.read();
					if (in >= '0' && in <= '9') {
						minu = true;
						return true;
					}
					return false;
				}
				if (in >= '0' && in <= '9') {
					return true;
				}
				return false;
			}
			in = my.read();
		}
		return false;
	}

	public int nextInt() throws IOException {
		int c = 10;
		int num = 0;
		while (in != -1 && in >= '0' && in <= '9') {
			num = (num * c) + (in - '0');
			in = my.read();
			//c *= 10;
		}
		if(minu == true) {
			num *= -1;
			minu = false;
		}
		return num;
	}

	public boolean hasNext() throws IOException {
		while (in != -1) {
			if (in >= 33 && in <= 127) {
				return true;
			}
			in = my.read();
		}
		return false;
	}

	public String next() throws IOException {
		int num = 100;
		char[] arr = new char[num];
		int coun = 0;
		while (in >= 33 && in <= 127) {
			if (coun == num) {
				arr = Arrays.copyOf(arr, num * 2);
			}
			arr[coun++] = (char) in;
			in = my.read();
		}
		return new String(arr);
	}
}
