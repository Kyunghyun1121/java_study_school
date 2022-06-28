import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FrameList extends JFrame {
	int x, y, width, height;
	String text;
	
	ArrayList<FrameList> myf = new ArrayList<>();
	ArrayList<MyButton> myb = new ArrayList<>();
	public FrameList() {
	}

	public FrameList(String string) {
		super(string);
		
	}

	public boolean contains(FrameList f) {
	if (f.x >= x && f.width <= width && f.y >= y && f.height <= height) {
			return true;
		}
		return false;
	}
	
	public boolean contains(int a, int b) {

		if (a >= x && a <= width + x && b >= y && b <= height + y) {
			return true;
		}
		return false;
	}
	

	public void draw(Graphics g) {
		
		for(FrameList l : myf) {
			l.draw(g);
			if(l.myf.size() != 0) {
				drawL(g,l.myf);
			}
		}

	}
	
	public void drawL(Graphics g,ArrayList<FrameList> c ) {
		for(FrameList i : c) {
			i.draw(g);
			if(i.myf.size() != 0) {
				drawL(g,i.myf);
			}
		}
	}
	
	
	public void in(ArrayList<FrameList> temp) {
		myf = temp;
	}

	public void moves(int x2, int y2) {
		for (int i = 0; i < myf.size(); i++) {
			myf.get(i).change(x2,y2);
			myf.get(i).moves(x2,y2);
		}
	}

	public void change(int x2, int y2) {
		
		x+=x2;
		y+=y2;
		
	}



}