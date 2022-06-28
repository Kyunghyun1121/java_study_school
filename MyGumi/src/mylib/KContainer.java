package mylib;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KContainer extends KComponent{
	public ArrayList<KComponent> compoList = new ArrayList<>();

	public KContainer(String text) {
		super(text);
	}
	public KContainer() {
	}

	public void add(KComponent mb) {
		compoList.add(mb);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("굴림체", Font.PLAIN, 13));
		for(KComponent kc : compoList) {
			kc.paint(g);
		}

	}
	public void processMouseEvent(MouseEvent e) {
		for (KComponent kc : compoList) {
			if (kc.contains(e.getX(), e.getY())) {
				kc.processMouseEvent(new ActionEvent(kc, MouseEvent.MOUSE_CLICKED, kc.command));
				return;
			}
		}
	}
	

	


	

}