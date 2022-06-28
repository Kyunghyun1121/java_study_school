import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame extends FrameList {

	public void push(FrameList f) {
		
		ArrayList<FrameList> temp = new ArrayList<>();
		ArrayList<FrameList> erase = new ArrayList<>();
		for (int i = 0; i < myf.size(); i++) {
			if (f.contains(myf.get(i))) {
				temp.add(myf.get(i));
				erase.add(myf.get(i));
			}
		}
		
		for(int i = 0; i<erase.size();i++) {
		    myf.remove(erase.get(i));
		}
		
		
		f.in(temp);
		
		myf.add(f);
	}

	public Frame(String string) {
		super(string);
		setSize(800, 500);
		// setLocation(0, 0);
		Font myFont = new Font("굴림체", Font.PLAIN, 25);
		this.setFont(myFont);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyButton btnRect = new MyButton("사각형");
		MyButton btnOval = new MyButton("타원");
		MyButton btnLine = new MyButton("직선");
		btnRect.setBounds(200, 40, 300, 70); // 위치와 크기를 결정한다. x=10 y=60 width=70, height=25 이다.
		btnOval.setBounds(350, 40, 450, 70);
		btnLine.setBounds(500, 40, 600, 70);
		myb.add(btnRect);
		myb.add(btnOval);
		myb.add(btnLine);
		super.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (MyButton b : myb) {
			b.draw(g);
		}
		
	}

	public int buttonfind(int x, int y) {
		int count = 0;
		for (MyButton b : myb) {
			if (b.contains(x, y)) {
				return count;
			}
			count++;
		}
		return -1;
	}
	
	public void moves(int in, int x,int y) {
		myf.get(in).change(x,y);
		myf.get(in).moves(x,y);
	}
	

	
	public int contain(int x,int y) {
		for (int i = 0; i < myf.size(); i++) {
			if (myf.get(i).contains(x,y)) {
				return i;
			}
		}
		return -1;
	}

}