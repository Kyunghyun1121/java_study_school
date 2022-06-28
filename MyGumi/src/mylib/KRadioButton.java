package mylib;

import java.awt.Graphics;

public class KRadioButton  extends KAbstractButton{
	//protected boolean check = false;
	public KRadioButton(String text) {
		super(text);
		width = 20;
		height = 20;
	}
	
	public void paint(Graphics g) {
		if (checked) {
			g.fillRect(x, y, 10, 10);
		} else {
			g.drawRect(x, y, 10, 10);
		}
		g.drawString(text, x + 10, y + 10);
	}
	
	public void change() {
		if(checked)
			checked = false;
	}
	


	
}