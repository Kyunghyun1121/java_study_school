package mylib;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public abstract class KAbstractButton extends KComponent{
	boolean checked = false;
	
	public KAbstractButton(String string) {
		super(string);
	}
	public KAbstractButton() {
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(text, x, y+20);
	}
	public void setBounds(int i, int j, int k, int l) {
		x = i;
		y = j;
		width = k;
		height = l;
	}
	public void setBounds(int i, int j) {
		x = i;
		y = j;
	}

	public void setActionCommand(String string) {
		command = string;
	}
	
	public void processMouseEvent(ActionEvent e) {
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			myac.actionPerformed(e);
		}
	}
	
	public boolean contains(int a, int b) {

		if (a >= x && a <= width + x && b >= y && b <= height + y) {
			checked = true;
			return true;
		}
		return false;
	}
	


}