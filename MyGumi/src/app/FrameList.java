package app;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import mylib.KFrame;

public class FrameList extends KFrame implements Cloneable{
	boolean fill = false;
	public ArrayList<FrameList> myf = new ArrayList<>();
	public FrameList(FrameList i) {
		x = i.x;
		y = i.y;
		width = i.width;
		height = i.height;
		//mycolor = i.mycolor;
		//myf=i.myf;
	}
	public void erase() {
		myf.clear();
	}

	public FrameList(int a,int b,int w,int h,Color c) {
		x = a;
		y = b;
		width = w;
		height = h;
		mycolor = c;
		//myf = t;
	}
	
	public FrameList clone() throws CloneNotSupportedException{
		FrameList te = (FrameList)super.clone();
		//te.erase();
		//FrameList te = null;
		int x = 0;
		for(FrameList i : myf) {
			FrameList temp = i.clone();
			//te.put(temp);
		}
		return te;
	}


	public void put(FrameList temp) {
		for(FrameList i : temp.myf) {			
			if(i.myf.size()!=0) {
				i.put(temp);
			}
			temp.push(new FrameList(i));
		}
	}
	public FrameList() {
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
	

	public void paint(Graphics g) {
		super.paint(g);
		for(FrameList l : myf) {
			l.paint(g);
			if(l.myf.size() != 0) {
				paintL(g,l.myf);
			}
		}

	}

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
		//System.out.println(f.x+" "+f.y+" "+f.width);
		myf.add(f);
	}
	
	public void paintL(Graphics g,ArrayList<FrameList> c ) {
		super.paint(g);
		for(FrameList i : c) {
			i.paint(g);
			if(i.myf.size() != 0) {
				paintL(g,i.myf);
			}
		}
	}
	
	
	public void in(ArrayList<FrameList> temp) {
		myf = temp;
	}
	
	
	




	public void moves(int x2, int y2) {
		for (FrameList i : myf) {
			i.change(x2,y2);
			i.moves(x2,y2);
		}
	}

	public void change(int x2, int y2) {
		
		x+=x2;
		y+=y2;
		
	}

	public void Fill(Color color) {
		mycolor = color;
		fill=true;
	}
	public FrameList iterator() {
		// TODO Auto-generated method stub
		return this;
	}





}

