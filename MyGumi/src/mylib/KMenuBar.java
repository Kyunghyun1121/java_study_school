package mylib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class KMenuBar extends KContainer{
	public ArrayList<KMenu> menuList = new ArrayList<>();

	public KMenuBar() {
		super();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 70, 800, 30);
		for(KComponent kc : menuList) {
			kc.paint(g);
		}
	}
	public void add(KMenu c) {
		c.set(menuList.size() * 60 + 10, 70, 40, 30);
		menuList.add(c);
		
	}
	
	public void processMouseEvent(ActionEvent e) {
		for(KMenu kc : menuList) {
			kc.processMouseEvent(e);
		}
	}
	
	@Override
	public boolean contains(int a, int b) {
		for(KMenu kc : menuList) {
			if( kc.contains(a,b))return true;
		}
		return false;
	}
}
