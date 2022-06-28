package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KMenu extends KContainer{
	public ArrayList<KMenuItem> menuitemList = new ArrayList<>();
	boolean check = false;
	
	public KMenu(String text) {
		super(text);
	}
	
	public void add(KMenuItem c) {
		c.set(x, y+(menuitemList.size()+1)*height, width, height);
		menuitemList.add(c);
		c.setparent(this);
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(text, x, y+15);
		//System.out.println(menuitemList.size());
		for(KMenuItem kc : menuitemList) {
			kc.paint(g);
		}
	}
	
	public void processMouseEvent(ActionEvent e) {	
		if(!check)return;
		
		
		for(KMenuItem kc : menuitemList) {
			if(kc.visible && kc.checked) {
				System.out.println(kc.checked);
				kc.processMouseEvent(e);
				childchange();
				check = false;
				return;
			}
			kc.changevisible();
		}
		
		
	}
	
	public void childchange() {
		for(KMenuItem kc : menuitemList) {
			kc.erase();
		}
	}
	
	@Override
	public boolean contains(int a, int b) {
		for(KMenuItem kc : menuitemList) {
			if(kc.contains(a,b)) {
				return true;
			}
		}
		
		if (a >= x && a <= width + x && b >= y && b <= height + y) {
			if (!check) {
				check = true;
			}
			return true;
		}
		return false;
	}


	
}