import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	Frame frame;
	int type = 0;
	int x, y, width, height;
	ArrayList<MyButton> myb = new ArrayList<>();
	int move = -1;
	public void reverse(int a, int b) {
		if (a < x) {
			x = a;
			width *= -1;
		}
		if (b < y) {
			y = b;
			height *= -1;
		}
	}

	public void mydraw(int a, int b) {
		if(width+height==0)return;
		if (type == 0) {
			reverse(a, b);
			frame.push(new Rect(x, y, width, height));
		} else if (type == 1) {
			reverse(a, b);
			frame.push(new Oval(x, y, width, height));
		} else if (type == 2) {
			frame.push(new Line(x, y, width, height));
		}
	}

	@Override
	public void processMouseEvent(MouseEvent e) {
		switch (e.getID()) {
		case MouseEvent.MOUSE_PRESSED:
			x = e.getX();
			y = e.getY();
			move = frame.contain(x, y);
		case MouseEvent.MOUSE_RELEASED:
			width = e.getX() - x;
			height = e.getY() - y;
			if (move != -1) {
				frame.moves(move, width, height);
			}else {
				mydraw(e.getX(), e.getY());
			}
			repaint();
		case MouseEvent.MOUSE_CLICKED:
			for (MyButton b : myb) {
				if (b.contains(e.getX(), e.getY())) {
					b.processMouseEvent(new ActionEvent(b, MouseEvent.MOUSE_CLICKED, ""));
				}
			}
		}
	}

	public void plusbutton() {
		MyButton btnRect = new MyButton("사각형");
		MyButton btnOval = new MyButton("타원");
		MyButton btnLine = new MyButton("직선");
		btnRect.setBounds(200, 40, 300, 70); // 위치와 크기를 결정한다. x=10 y=60 width=70, height=25 이다.
		btnOval.setBounds(350, 40, 450, 70);
		btnLine.setBounds(500, 40, 600, 70);
		btnRect.addMyActionListener(new MyActionListenerOne()); // 버튼에 리스너를 추가
		btnOval.addMyActionListener(new MyActionListenerOne()); // 버튼에 리스너를 추가
		btnLine.addMyActionListener(new MyActionListenerOne()); // 버튼에 리스너를 추가
		myb.add(btnRect);
		myb.add(btnOval);
		myb.add(btnLine);
	}

	class MyActionListenerOne implements MyActionListenerI {
		@Override
		public void actionPerformed(ActionEvent e) {
			int count = 0;
			for (MyButton b : myb) {
				if (b == e.getSource()) {
					type = count;
					break;
				}
				count++;
			}
		}
	}

	public MyPanel() {
		frame = new Frame("그림판 클래스");
		frame.setVisible(true);
		frame.setContentPane(this);
		setBackground(new Color(200, 255, 255));
		Font myFont = new Font("굴림체", Font.PLAIN, 25);
		this.setFont(myFont);
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		plusbutton();
		menu();
	}
	public void menu() {
		JMenuBar mMenu = new JMenuBar();
		frame.setJMenuBar(mMenu);
		JMenu fileMenu = new JMenu("File");
		mMenu.add(fileMenu);
		JMenuItem itemNew = new JMenuItem("New");
		//itemNew.addActionListener(new MyActionListenerOne());
		fileMenu.add(itemNew);
		JMenuItem itemSave = new JMenuItem("Save");
		//itemSave.addActionListener(new MyActionListenerOne());
		fileMenu.add(itemSave);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		frame.draw(g);
		for (MyButton b : myb) {
			b.draw(g);
		}

	}

	// loadImage();
	// g.drawImage(img, 0, 0, 450,450,null);
	/*
	 * public void loadImage() { try { img = ImageIO.read(new File("duke.png"));
	 * }catch(IOException e) { System.out.println("Cannot open image file."); } }
	 */
}