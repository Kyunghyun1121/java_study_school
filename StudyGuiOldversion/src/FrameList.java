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
					System.out.println(f.x+" "+f.y+" "+f.width+" "+f.height);
			System.out.println(x+" "+y+" "+width+" "+height);
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
		for (int i = 0; i < myf.size(); i++) {
			myf.get(i).draw(g);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		//System.out.println(myf.size());
		super.paint(g);
		draw(g);
		for (int i = 0; i < myf.size(); i++) {
			myf.get(i).paint(g);
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