package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KCheckBox extends KAbstractButton{
	//protected boolean check = false;
	public KCheckBox(String text) {
		super(text);
		width = 20;
		height = 20;
	}
	
	public void paint(Graphics g) {
		if (checked) {
			g.drawString("v",x+2, y+10);
		} 
		g.drawRect(x, y, 10, 10);
		g.drawString(text, x + 10, y + 10);
	}
	
	public void change() {
		if(checked)
			checked = false;
		else 
			checked = true;
	}
	
	public void processMouseEvent(ActionEvent e) {
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			change();
			myac.actionPerformed(e);
		}
	}
	
	public boolean contains(int a, int b) {

		if (a >= x && a <= width + x && b >= y && b <= height + y) {
			return true;
		}
		return false;
	}
	
}
