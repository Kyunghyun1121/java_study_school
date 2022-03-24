class Speakk {

	public void speak() {
		System.out.println("Hello");
	}
}

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Speakk s = new Speakk();
		s.speak();
		//수정
		char[]kk = new char[21];
		System.out.println(kk.length);
		kk[0]='s';
		System.out.println(kk.length);
	}

}
