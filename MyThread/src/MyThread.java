class MyRunnable implements Runnable{
	String name;
	int inteval;
	public MyRunnable(String name,int sl) {
		this.name = name;
		inteval = sl;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(inteval);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(name);
		}
	}
	
}

public class MyThread  {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyRunnable("apple", 1000));
		Thread t2 = new Thread(new MyRunnable("banana", 2000));
		t1.start();
		t2.start();
	}

}
