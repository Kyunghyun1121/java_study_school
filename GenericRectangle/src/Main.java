public class Main {
	public static void main(String[] args) {
	
		Rectangle<Integer> myRectangle = 
                new Rectangle<Integer>(2, 3);
		System.out.println(myRectangle);
		Rectangle<Double> myDoubleRectangle = 
                new Rectangle<Double>(2.5, 3.5);
		System.out.println(myDoubleRectangle);
	}

}

class Rectangle<T>{
	private T height;
	private T width;
	public Rectangle(T i, T j) {
		// TODO Auto-generated constructor stub
		width = i;
		height = j;
	}
	public String toString() {
		return "사각형 밑변 "+width+" 높이 "+height;
	}
	
}