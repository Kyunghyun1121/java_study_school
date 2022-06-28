import java.awt.Graphics;

public class MyButton {
	int x, y, width, height;
	String name;

	public MyButton(String name) {
		this.name = name;
	}

	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean contains(int x, int y) {
		if (x >= this.x && x <= this.width && y + 30 >= this.y && y + 30 <= this.height) {
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		g.drawRect(x, y, width - x, height - y);
		g.drawString(name, x + 20, height);
	}
}
