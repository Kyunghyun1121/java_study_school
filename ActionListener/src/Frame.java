import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame {
	JButton btnApple, btnBanana, btnOrange;

	public void AddButtons() {
		Container mainPane = getContentPane();
		mainPane.setBackground(Color.yellow);
		mainPane.setLayout(null); // 여기에 따라
		btnApple = new JButton("Apple");
		btnBanana = new JButton("Banana");
		btnOrange = new JButton("Orange");
		btnApple.setBounds(10, 10, 100, 30);
		btnBanana.setBounds(10, 50, 100, 30);
		btnOrange.setBounds(10, 90, 100, 30);
		btnApple.addActionListener(new MyListener());
		btnBanana.addActionListener(new MyListener());
		btnOrange.addActionListener(new MyListener());
		this.add(btnApple);
		this.add(btnBanana);
		this.add(btnOrange);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Frame() {
		MyListener lst = new MyListener();
		AddButtons();
	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton temp = (JButton) e.getSource();
			System.out.println(temp.getText());
			
		}
	}
	
	public static void main(String[] args) {
		Frame myf = new Frame();
	}
}
