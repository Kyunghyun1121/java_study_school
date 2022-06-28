import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
class MyRunnable implements Runnable{
	String name;
	int inteval;
	public MyRunnable(String name,int sl) {
		this.name = name;
		inteval = sl;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(inteval);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(name);
		}
	}
	
}
public class MainFrame extends JFrame{

	public MainFrame() {
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton b1 = new JButton("apple");
		JButton b2 = new JButton("banana");
		b1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new MyRunnable("apple",1000));
				t.start();
			}
		});
		b2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new MyRunnable("banana",2000));
				t.start();	
			}
		});
		
		add(b1); add(b2);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
	}

}
