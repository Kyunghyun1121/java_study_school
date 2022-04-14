
public class Figure{
	// 도형 종류,  너비, 높이 (모두 정수) 순서로 입력한다.
	private int type;
	protected int width;
	protected int height;
	protected int area;
	
	public Figure(int t,int w,int h) {
		type=t;
		width = w;
		height =h;
	}
	public void print() {
		return;
	}
	public int getwidth() {
		return width;
	}
	public int getheight() {
		return height;
	}
	public int getarea() {
		return area;
	}

}
class Rect extends Figure{

	public Rect(int t, int w, int h) {
		super(t, w, h);
		area = width*height;
	}
	public void print() {
		System.out.print("종류: 사각형 ");
		System.out.print(" 너비: "+width);
		System.out.print(" 높이: "+height);
		System.out.println(" 넓이: "+area);
	}
	
}
class Triangle extends Figure{

	public Triangle(int t, int w, int h) {
		super(t, w, h);
		area = (width*height)/2;
	}
	public void print() {
		System.out.print("종류: 삼각형 ");
		System.out.print(" 너비: "+width);
		System.out.print(" 높이: "+height);
		System.out.println(" 넓이: "+area);
		
	}
	
}
