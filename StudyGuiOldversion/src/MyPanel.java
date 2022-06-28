import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	Frame frame;
	int type = 0;
	int x, y, width, height;
	int move = -1;

	class MyListner implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			check(e.getX(), e.getY());
		}

		public void check(int x, int y) {
			int temp = frame.buttonfind(x, y);
			if (temp != -1) {
				type = temp;

			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			
			move = frame.contain(x, y);
		}

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

		@Override
		public void mouseReleased(MouseEvent e) {
			// check(e.getX(), e.getY());

			width = e.getX() - x;
			height = e.getY() - y;
			if (move != -1) {
				frame.moves(move, width, height);
			}else {
				mydraw(e.getX(), e.getY());
			}

			frame.repaint();

		}

		public void mydraw(int a, int b) {
			if (type == 0) {
				reverse(a, b);
				frame.push(new Rect(x + 7, y + 30, width, height));
			} else if (type == 1) {
				reverse(a, b);
				frame.push(new Oval(x + 7, y + 30, width, height));
			} else if (type == 2) {
				frame.push(new Line(x + 7, y + 30, width, height));
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}

	public MyPanel() {
		frame = new Frame("그림판 클래스");
		frame.setVisible(true);
		frame.setContentPane(this);
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyListner());
		
	}

	// BufferedImage img = null;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	// loadImage();
	// g.drawImage(img, 0, 0, 450,450,null);
	/*
	 * public void loadImage() { try { img = ImageIO.read(new File("duke.png"));
	 * }catch(IOException e) { System.out.println("Cannot open image file."); } }
	 */
}