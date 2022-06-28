package mylib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class KComponent implements Serializable{
	protected Color mycolor;
	protected int mytype=0;
	public int x, y, width, height;
	public String text = null;
	public String command = null;
	KActionListener myac;
	public KComponent(String text2) {
		text = text2;
	}
	public KComponent() {
	}
	public void set(int a,int b,int c,int d) {
		x=a;y=b;width=c;height=d;
	}
	public void addKActionListener(KActionListener kActionListener) {
		myac = kActionListener;
	}
	public void paint(Graphics g) {
		
	}
	public String getText() {
		return text;
	}
	public void processMouseEvent(ActionEvent e) {
		
	}
	
	public boolean contains(int a, int b) {

		if (a >= x && a <= width + x && b >= y && b <= height + y) {
			return true;
		}
		return false;
	}
	public Color getMycolor() {
		return mycolor;
	}
	public int getType() {
		return mytype;
	}
	public KComponent findChild(int x2, int y2) {
		// TODO Auto-generated method stub
		return null;
	}

}
