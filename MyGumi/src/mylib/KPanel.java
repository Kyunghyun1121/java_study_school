package mylib;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KPanel extends KContainer{
	@Override
	public void processMouseEvent(MouseEvent e) {
		e.translatePoint(this.x, - this.y);
		System.out.println(5);
	}
}
