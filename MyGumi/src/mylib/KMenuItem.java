package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KMenuItem extends KAbstractButton{
	protected boolean visible = false;
	boolean checked = false;
	public KMenu parent;
	public KMenuItem(String text) {
		super(text);
	}
	
	public void paint(Graphics g) {
		if(visible) {
			g.drawRect(x, y, width, height);
			g.drawString(text, x, y+20);
		}
	}
	
	public void changevisible() {
		
		if(visible==true)visible=false;
		else visible=true;
	}
	public void erase() {
		visible = false;
	}
	
	@Override
	public boolean contains(int a, int b) {
		if(visible) {
			if (a >= x && a <= width + x && b >= y && b <= height + y) {
				checked = true;
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void setparent(KMenu Menu) {
		parent = Menu;
	}
	
	@Override
	public void processMouseEvent(ActionEvent e) {
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			myac.actionPerformed(e);
		}
		checked = false;
	}
}