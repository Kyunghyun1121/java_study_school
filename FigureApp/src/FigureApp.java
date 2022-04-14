interface Figure {
	public void reSize(double h, double w);

	public void draw();

	public double area();

}

class Triangle implements Figure {
	private double height;
	private double width;

	@Override
	public double area() {
		return height * width / 2;
	}

	@Override
	public void draw() {
		System.out.println("나는 삼각형입니다.");
		System.out.println("높이는 " + height + " 폭은 " + width + "입니다.");
	}

	@Override
	public void reSize(double h, double w) {
		// TODO Auto-generated method stub
		height = h;
		width = w;
	}
}

class Rectangle implements Figure {
	// Triangle 과 마찬가지로 구현한다.
	private double height;
	private double width;

	@Override
	public double area() {
		return height * width;
	}

	@Override
	public void draw() {
		System.out.println("나는 사각형입니다.");
		System.out.println("높이는 " + height + " 폭은 " + width + "입니다.");
	}

	public void reSize(double h, double w) {
		// TODO Auto-generated method stub
		height = h;
		width = w;
	}
}

public class FigureApp {
	public static void main(String[] args) {
		Figure fig[] = new Figure[2];
		fig[0] = new Triangle();
		fig[1] = new Rectangle();
		fig[0].reSize(3.0, 3.0);
		fig[1].reSize(3.0, 3.0);

		for (Figure f : fig) {
			f.draw();
			System.out.println("면적: " + f.area());
		}

	}

}
