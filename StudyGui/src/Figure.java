import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Figure extends FrameList {
	Color myc;

	public Figure(int x, int y, int w, int h,Color c) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.myc=c;
	}

	public Figure(String s, int x, int y) {
		text = s;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor(myc);
	}

}

class Rect extends Figure {

	public Rect(int x, int y, int w, int h,Color c) {
		super(x, y, w, h, c);
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawRect(x, y, width, height);
	}

}

class Oval extends Figure {

	public Oval(int x, int y, int w, int h,Color c) {
		super(x, y, w, h, c);
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(x, y, width, height);
	}

}

class Line extends Figure {

	public Line(int x, int y, int w, int h,Color c) {
		super(x, y, w, h, c);
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawLine(x, y, width+x, height+y);
	}

}

class Text extends Figure {

	public Text(String s, int x, int y) {
		super(s, x, y);
	}

	public void draw(Graphics g) {
		g.drawString(text, x, y);
	}

}