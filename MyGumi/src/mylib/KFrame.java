package mylib;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class KFrame extends KContainer {
	protected KMenuBar theMenuBar;
	protected KToolBar theToolBar;
	protected KContainer contentPane;
	protected KButtonGroup KButton;
	protected JFrame realFrame;
	private int rFramew,rFrameh;

	public void setRealFrame(JFrame jf) {
		realFrame = jf;
		rFramew = jf.getWidth();
		rFrameh = jf.getHeight();
	}

	public void setKcontentPane(KContainer c) {
		add(c);
		contentPane = c;
		c.set(0, theMenuBar.height+theToolBar.height, rFramew, rFrameh);
	}

	public void setKButtonGroup(KButtonGroup mb) {
		// 원래 메뉴바는 frame에 있는게 정상이지만...
		add(mb);
		KButton = mb;
	}

	public void setKMenuBar(KMenuBar mb) {
		// 원래 메뉴바는 frame에 있는게 정상이지만...
		add(mb);
		theMenuBar = mb;
	}

	public void repaint() {
		realFrame.repaint();
	}

	public void setKToolBar(KToolBar mb) {
		// 원래 메뉴바는 frame에 있는게 정상이지만...
		add(mb);
		theToolBar = mb;
	}

	public KFrame() {
	}

	public void processMouseEvent(MouseEvent e) {
		super.processMouseEvent(e);
		// System.out.println("Mouse Event of KFrame");
	}

}
