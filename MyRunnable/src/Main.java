interface MyRunnable {
	public void go();
}

class MyThread extends Thread {
	MyRunnable temp;

	public MyThread(ARunnable aRunnable) {
		temp = aRunnable;
	}

	@Override
	public void run() {
		if (temp != null) {
			temp.go();
		}
	}
}

class ARunnable implements MyRunnable {
// go 함수를 override하여 hello 0 부터 hello 9 까지 1초 간격으로
// 출력하게 한다. (THread.sleep(1000); 이용)
	@Override
	public void go() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("hello" + i);
		}
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread t = new MyThread(new ARunnable());
		t.start();
	}

}
