import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.ColorModel;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyPanel extends JPanel {
	Frame frame;
	int type = 0;
	int x, y, width, height;
	int move = -1;
	Color Mycolor;
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
			frame.push(new Rect(x, y, width, height, Mycolor));
		} else if (type == 1) {
			reverse(a, b);
			frame.push(new Oval(x, y, width, height, Mycolor));
		} else if (type == 2) {
			frame.push(new Line(x, y, width, height, Mycolor));
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
		}
	}

	
	class MyListener implements ActionListener{
		  @Override public void actionPerformed(ActionEvent e) {
			  JMenuItem temp = (JMenuItem) e.getSource();
			 System.out.println(temp.getText());
			  if(temp.getText().equals("사각형")) {
				  type=0;
			  }else if(temp.getText().equals("타원")) {
				  type=1;
			  }else if(temp.getText().equals("직선")) {
				  type=2;
			  }
		 }
	};
	
	
	class MyListenerCC implements ActionListener{
		  @Override public void actionPerformed(ActionEvent e) {
			  changeColor();
		 }
	};
	
	public void changeColor() {
		  ColorChoos c = new ColorChoos();
		  Mycolor = c.selectedColor;
		  c.set(this);
		  System.out.println(c.selectedColor);
	}

	class ColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem temp = (JMenuItem) e.getSource();
			System.out.println(temp.getText());
			if (temp.getText().equals("빨간색")) {
				Mycolor = Color.red;
			} else if (temp.getText().equals("파란색")) {
				Mycolor = Color.blue;
			} else if (temp.getText().equals("초록색")) {
				Mycolor = Color.green;
			}
		}
	};

	
	public MyPanel() {
		frame = new Frame("그림판 클래스");
		frame.setVisible(true);
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(200, 255, 255));
		Font myFont = new Font("굴림체", Font.PLAIN, 25);
		this.setFont(myFont);
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		menu();

	}
	
	public void menu() {
		JMenuBar mMenu = new JMenuBar();
		frame.setJMenuBar(mMenu);
		JMenu filefigure = new JMenu("Figure");
		mMenu.add(filefigure);
		JMenu filecolor = new JMenu("Color");
		mMenu.add(filecolor);
		
		JMenu btnColor = new JMenu("색깔 입력");
		btnColor.addActionListener(new ColorListener());
		setcolor(btnColor);
		filecolor.add(btnColor);
		
		JMenuItem btnFColor = new JMenuItem("색깔 찾기");
		btnFColor.addActionListener(new MyListenerCC());
		filecolor.add(btnFColor);
		
		setfigure(filefigure);
	}
	public void setfigure(JMenu k) {
		JMenuItem btnRect = new JMenuItem("사각형");
		JMenuItem btnOval = new JMenuItem("타원");
		JMenuItem btnLine = new JMenuItem("직선");
		btnRect.addActionListener(new MyListener()); // 버튼에 리스너를 추가
		btnOval.addActionListener(new MyListener()); // 버튼에 리스너를 추가
		btnLine.addActionListener(new MyListener()); // 버튼에 리스너를 추가
		k.add(btnRect);
		k.add(btnOval);
		k.add(btnLine);
	}
	public void setcolor(JMenu k) {
		JMenuItem R = new JMenuItem("빨간색");
		JMenuItem G = new JMenuItem("파란색");
		JMenuItem B = new JMenuItem("초록색");
		R.addActionListener(new ColorListener()); // 버튼에 리스너를 추가
		G.addActionListener(new ColorListener()); // 버튼에 리스너를 추가
		B.addActionListener(new ColorListener()); // 버튼에 리스너를 추가
		k.add(R);
		k.add(G);
		k.add(B);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		frame.draw(g);
	}
	

	// loadImage();
	// g.drawImage(img, 0, 0, 450,450,null);
	/*
	 * public void loadImage() { try { img = ImageIO.read(new File("duke.png"));
	 * }catch(IOException e) { System.out.println("Cannot open image file."); } }
	 */
}