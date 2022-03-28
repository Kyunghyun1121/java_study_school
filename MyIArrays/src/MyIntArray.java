import java.util.Arrays;

public class MyIntArray {
	private int[] myi;

	public MyIntArray(int a) {
		myi = new int[a];
	}

	public int len() {
		int coun = 0;
		for (int a = 0; a < myi.length; a++) {
			if (myi[a] != 0)
				coun++;
		}
			
		return coun;
	}

	public void add(int num) {
		
		if (myi.length <= this.len()) {
			myi = Arrays.copyOf(myi, myi.length * 2);
		}
		
		myi[this.len()] = num;
		
	}

	public void add(int wh, int num) {
		
		if (myi.length <= this.len()) {
			myi = Arrays.copyOf(myi, myi.length * 2);
		}
		
		int c = this.len();
		
		for (int i = c; i >= wh; i--) {
			myi[i+1] = myi[i];
		}
		
		myi[wh] = num;
	}

	public void downsort() {
		for (int a = 0; a < this.len(); a++) {
			for (int b = a + 1; b < this.len(); b++) {
				if (myi[a] < myi[b]) {
					int temp = myi[a];
					myi[a] = myi[b];
					myi[b] = temp;
				}
			}
		}
	}

	public void print() {

		System.out.print("크기 " + myi.length + " 사용 " + this.len());
		System.out.print(" 내용 ");
		
		if(this.len()!=0) {
			for (int i = 0; i < this.len(); i++) {
				System.out.print(myi[i]+" " );
			}
		}
		
		System.out.println("끝 ");
	}

	public void delete(int num) {
		int c = myi.length;
		for (int i = num; i < this.len(); i++) {
			myi[i] = myi[i + 1];
		}
		
		myi[c - 1] = 0;
		if (myi.length / 4 >= this.len()) {
			myi = Arrays.copyOf(myi, myi.length / 2);
		}
	}
}
