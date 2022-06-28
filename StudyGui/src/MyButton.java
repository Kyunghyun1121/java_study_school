import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class MyButton extends JButton{
	int x, y, width, height;
	String name;
	ArrayList<MyActionListenerI> myL = new ArrayList<>();

	public MyButton(String name) {
		this.name = name;
	}

	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean contains(int x, int y) {
		if (x >= this.x && x <= this.width && y >= this.y && y <= this.height) {
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		g.drawRect(x, y, width - x, height - y);
		g.drawString(name, x + 20, height);
	}

	public void addMyActionListener(MyActionListenerI myActionListenerI) {
		myL.add(myActionListenerI);
	}

	public void processMouseEvent(ActionEvent e) {
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			for (MyActionListenerI i : myL) {
				i.actionPerformed(e);
			}
		}
	}

}
