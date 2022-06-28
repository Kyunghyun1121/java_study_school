package app;
//지금 만든 checkbox는 radiobutton이니까 바꾸기
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;

import mylib.KActionListener;
import mylib.KButton;
import mylib.KButtonGroup;
import mylib.KCheckBox;
import mylib.KComponent;
import mylib.KFrame;
import mylib.KMenu;
import mylib.KMenuBar;
import mylib.KMenuItem;
import mylib.KMouseListener;
import mylib.KPanel;
import mylib.KRadioButton;
import mylib.KToolBar;

class PainterKFrame extends FrameList {
	// public ArrayList<FrameList> figList = new ArrayList<>();
	int move = -1;
	boolean delet = false;
	boolean copy = false;

	FileInputStream fis;
	FileOutputStream fos;
	public PainterKFrame() {
		/*
		 * KButton kb = new KButton("testbutton"); kb.setBounds(100, 100, 100, 30);
		 * kb.setActionCommand("select_rect"); add(kb); kb.addKActionListener( new
		 * KActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub System.out.println("Button command " + e.getActionCommand() +
		 * " clicked"); } });
		 */
		/*
		 * 어떤 메뉴를 더할 지, 그것은 여기에서 하면 된다.
		 */

		puttoolbar();
		putmenu();
		putcheckbox();
		setKcontentPane(new KPanel());
		
	}

	/*private void add(ArrayList<KCheckBox> mycbox2) {
		for (KCheckBox i : mycbox2) {
			add(i);
		}
	}*/

	public void puttoolbar() {
		KToolBar mTool = new KToolBar();
		setKToolBar(mTool);
		KButton filecopy = new KButton("복사");
		mTool.add(filecopy);
		filecopy.addKActionListener(new ToolListenerC());
		KButton filedelet = new KButton("삭제");
		mTool.add(filedelet);
		filedelet.addKActionListener(new ToolListenerD());
		KButton fillcoloer = new KButton("채우기");
		mTool.add(fillcoloer);
		fillcoloer.addKActionListener(new ToolListenerColor());
		KButton filerem = new KButton("저장");
		mTool.add(filerem);
		filerem.addKActionListener(new ToolListenerRem());
		KButton filefrom = new KButton("불러오기");
		mTool.add(filefrom);
		filefrom.addKActionListener(new ToolListenerFrom());

	}

	public void putmenu() {
		KMenuBar mMenu = new KMenuBar();
		setKMenuBar(mMenu);
		KMenu filefigure = new KMenu("Figure");
		mMenu.add(filefigure);
		filefigure.addKActionListener(new MyListenerMenu());
		KMenu filecolor = new KMenu("Color");
		mMenu.add(filecolor);
		filecolor.addKActionListener(new MyListenerMenu());

		KMenuItem btnRColor = new KMenuItem("빨간색");
		btnRColor.addKActionListener(new ColorListenerR());
		filecolor.add(btnRColor);
		KMenuItem btnBColor = new KMenuItem("파란색");
		btnBColor.addKActionListener(new ColorListenerB());
		filecolor.add(btnBColor);
		KMenuItem btnGColor = new KMenuItem("초록색");
		btnGColor.addKActionListener(new ColorListenerG());
		filecolor.add(btnGColor);

		KMenuItem btnR = new KMenuItem("사각형");
		btnR.addKActionListener(new TypeListenerR());
		filefigure.add(btnR);
		KMenuItem btnO = new KMenuItem("타원");
		btnO.addKActionListener(new TypeListenerO());
		filefigure.add(btnO);
		KMenuItem btnL = new KMenuItem("선분");
		btnL.addKActionListener(new TypeListenerL());
		filefigure.add(btnL);
	}

	public void putcheckbox() {
		KCheckBox FR = new KCheckBox("사각형");
		FR.setBounds(700, 110);
		FR.addKActionListener(new TypeListenerR());
		add(FR);
		KCheckBox FO = new KCheckBox("타원");
		FO.setBounds(700, 130);
		FO.addKActionListener(new TypeListenerO());
		add(FO);
		KCheckBox FL = new KCheckBox("선분");
		FL.setBounds(700, 150);
		FL.addKActionListener(new TypeListenerL());
		add(FL);
		
		KButtonGroup KCbox = new KButtonGroup();
		setKButtonGroup(KCbox);
		KRadioButton CR = new KRadioButton("빨간색");
		CR.setBounds(700, 170);
		CR.addKActionListener(new ColorListenerR());
		KCbox.add(CR);
		KRadioButton CB = new KRadioButton("초록색");
		CB.setBounds(700, 190);
		CB.addKActionListener(new ColorListenerG());
		KCbox.add(CB);
		KRadioButton CG = new KRadioButton("파란색");
		CG.setBounds(700, 210);
		CG.addKActionListener(new ColorListenerB());
		KCbox.add(CG);

	}

	public void mydraw() {
		if (width + height == 0)
			return;
		if (mytype == 0) {
			push(new Rect(x, y, width, height, mycolor));
		} else if (mytype == 1) {
			push(new Oval(x, y, width, height, mycolor));
		} else if (mytype == 2) {
			push(new Line(x, y, width, height, mycolor));
		}
	}
	public void mydraw(int a,int b,int w,int h,Color c) {
		if (w + h == 0)
			return;
		if (mytype == 0) {
			push(new Rect(a, b, w, h, c));
		} else if (mytype == 1) {
			push(new Oval(a, b, w, h, c));
		} else if (mytype == 2) {
			push(new Line(a, b, w, h, c));
		}
	}
	
	@Override
	public void processMouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getID()) {
		case MouseEvent.MOUSE_PRESSED:
			x = e.getX();
			y = e.getY();
			move = contain(x, y);
		case MouseEvent.MOUSE_RELEASED:
			width = e.getX() - x;
			height = e.getY() - y;
			if (width != 0 && height != 0) {
				if (copy == true) {
					copies(move, width, height);
				} else if (move != -1) {
					moves(move, width, height);
				} else {
					mydraw();
				}
			}
		case MouseEvent.MOUSE_CLICKED:
			//System.out.println(e.getX()+" "+e.getY());
			if (delet == true) {
				delet(move, width, height);
			} else if (fill == true) {
				ColorFill(move);
			} else {
				super.processMouseEvent(e);
			}
		}
	}

	private void ColorFill(int in) {
		if (in < 0)
			return;
		myf.get(in).Fill(mycolor);
		fill = false;
	}
	

	
	public void copies(int in, int x, int y) {
		if (in < 0)
			return;
		
		FrameList temp = null;
		
		try {		
			temp = myf.get(in).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		moves(in, width, height);
		myf.add(temp);
		copy = false;
	}

	public void delet(int in, int x, int y) {
		if (in < 0)
			return;

		myf.remove(in);
		delet = false;
	}

	public void moves(int in, int x, int y) {
		myf.get(in).change(x, y);
		myf.get(in).moves(x, y);
	}

	public int contain(int x, int y) {
		for (int i = 0; i < myf.size(); i++) {
			if (myf.get(i).contains(x, y)) {
				return i;
			}
		}
		return -1;
	}



	class MyListenerMenu implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theMenuBar.processMouseEvent(new ActionEvent(theMenuBar, MouseEvent.MOUSE_CLICKED, ""));
		}
	};

	class ColorListenerR implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mycolor = Color.red;
		}
	};

	class ColorListenerB implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mycolor = Color.blue;
		}
	};

	class ColorListenerG implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mycolor = Color.green;
		}
	};

	

	class ToolListenerColor implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fill = true;
		}
	};

	class ToolListenerRem implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ObjectOutputStream oss = 
						new ObjectOutputStream(new FileOutputStream("remember.ser"));
				
				oss.writeObject(myf);
				oss.close();

			} catch (Exception k) {
				System.out.println("Fail");
			}
		}
	};

	class ToolListenerFrom implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<FrameList> temp ;
				ObjectInputStream instream = 
						new ObjectInputStream(new FileInputStream("remember.ser"));
				temp = (ArrayList<FrameList>) instream.readObject();
				
				myf = temp;
				repaint();
			} catch (Exception k) {
				System.out.println("Fail");
			}
			

			
		}
	};

	class ToolListenerC implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("c");
			copy = true;

		}
	};

	class ToolListenerD implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("d");
			delet = true;

		}
	};

	class TypeListenerL implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mytype = 2;
		}
	};

	class TypeListenerO implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mytype = 1;
		}
	};

	class TypeListenerR implements KActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mytype = 0;
		}
	};

	
}