import java.util.Vector;

class Figure{
    public void show(){
        System.out.println("Figure 입니다.");
    }
}
class Rect extends Figure{
    @Override public void show(){
        System.out.println("사각형 입니다.");
    }
}
class Oval extends Figure{
    @Override public void show(){
        System.out.println("타원형 입니다.");
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector <Figure> myvec = new Vector<Figure>();
		myvec.add(new Rect());
		myvec.add(new Rect());
		myvec.add(new Oval());
		myvec.add(new Oval());
		for(int a=0;a<4;a++) {
			myvec.get(a).show();
		}
	}

}
