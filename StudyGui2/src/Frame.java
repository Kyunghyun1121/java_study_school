import java.awt.AWTEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame  extends FrameList {
	public void push(FrameList f) {
		//System.out.println(myf.size());
		ArrayList<FrameList> temp = new ArrayList<>();
		ArrayList<FrameList> erase = new ArrayList<>();
		for (int i = 0; i < myf.size(); i++) {
			if (f.contains(myf.get(i))) {
				temp.add(myf.get(i));
				erase.add(myf.get(i));
				//System.out.println(i);
			}
		}
		for (int i = 0; i < erase.size(); i++) {
			myf.remove(erase.get(i));
		}
		f.myf = temp;
		
		myf.add(f);
	}


	public Frame(String string) {
		super(string);
		setSize(800, 500);
		setLocation(0, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void draw(Graphics g) {
		
		for(FrameList l : myf) {
			l.draw(g);
			if(l.myf.size() != 0) {
				drawL(g,l.myf);
			}
		}
	}


	public void moves(int in, int x,int y) {
		myf.get(in).change(x,y);
		myf.get(in).moves(x,y);
	}
	
	public int contain(int x,int y) {
		for (int i = 0; i < myf.size(); i++) {
			if (myf.get(i).contains(x,y)) {
				return i;
			}
		}
		return -1;
	}
	
}