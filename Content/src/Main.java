import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{
	class MyListner implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("DOWN " 
					+ e.getX() + " , " + e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("UP " 
					+ e.getX() + " , " + e.getY());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}

	public MyPanel() {
		setBackground(new Color(200,255,255));
		addMouseListener(new MyListner());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(1,1,50,50);
	}
}
class MyFrame extends JFrame{
	
}

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setContentPane(new MyPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setLocation(0,0);
		frame.setVisible(true);
		
	}
}
