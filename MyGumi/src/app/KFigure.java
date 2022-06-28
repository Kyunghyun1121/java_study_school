package app;

import java.awt.Color;
import java.awt.Graphics;

import mylib.KComponent;

public class KFigure extends FrameList {
	

	public KFigure(int x, int y, int w, int h,Color c) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.mycolor=c;
	}

	public KFigure(String s, int x, int y) {
		text = s;
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.setColor(getMycolor());
	}


}

class Rect extends KFigure {

	public Rect(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}

	public void paint(Graphics g) {
		super.paint(g);
		if(fill) {
			g.fillRect(x, y, width, height);
		}
		else g.drawRect(x, y, width, height);
	}

}

class Oval extends KFigure {

	public Oval(int x, int y, int w, int h,Color c) {
		super(x, y, w, h, c);
	}

	public void paint(Graphics g) {
		super.paint(g);
		if(fill) {
			g.fillOval(x, y, width, height);
		}
		else g.drawOval(x, y, width, height);
	}

}

class Line extends KFigure {

	public Line(int x, int y, int w, int h,Color c) {
		super(x, y, w, h, c);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(x, y, width+x, height+y);
	}

}

class Text extends KFigure {

	public Text(String s, int x, int y) {
		super(s, x, y);
	}

	public void paint(Graphics g) {
		g.drawString(text, x, y);
	}

}