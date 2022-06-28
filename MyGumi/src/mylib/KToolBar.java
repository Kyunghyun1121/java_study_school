package mylib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class KToolBar extends KContainer{
	public ArrayList<KButton> buttonList = new ArrayList<>();
	public KToolBar() {
		super();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 40, 800, 30);
		for(KComponent kc : buttonList) {
			kc.paint(g);
		}
	}
	
	public void add(KButton c) {
		c.set(buttonList.size() * 80 + 10, 40, 50, 30);
		buttonList.add(c);
	}
	
	public void processMouseEvent(ActionEvent e) {
		for(KButton kc : buttonList) {
			if(kc.checked) {
				kc.processMouseEvent(e);
				kc.checked = false;
			}
		}
	}
	
	@Override
	public boolean contains(int a, int b) {
		for(KButton kc : buttonList)  {
			if( kc.contains(a,b))return true;
		}
		return false;
	}
}
