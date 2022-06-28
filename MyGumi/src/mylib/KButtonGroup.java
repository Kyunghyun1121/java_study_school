package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class KButtonGroup extends KContainer{
	public ArrayList<KAbstractButton> checkList = new ArrayList<>();
	String s = null;
	public KButtonGroup() {
		super();
	}
	
	public void add(KAbstractButton c) {
		checkList.add(c);
	}
	
	public void paint(Graphics g) {
		for(KAbstractButton kc : checkList) {
			kc.paint(g);
		}
	}
	
	public void clear(String s) {
		for (KAbstractButton i : checkList) {
			if (!i.text.equals(s))
				i.checked = false;
		}
	}
	public void processMouseEvent(ActionEvent e) {
		clear(s);
		for(KAbstractButton kc : checkList) {
			if(kc.checked) {
				kc.processMouseEvent(e);
			}
		}
	}
	
	@Override
	public boolean contains(int a, int b) {
		boolean m = false;

		for(KAbstractButton kc : checkList) {
			if(kc.contains(a, b)) {
				m = true;
				s = kc.text;
			}

		}
		
		
		return m;
	}
}
