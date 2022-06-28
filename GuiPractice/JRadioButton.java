import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Main extends JFrame{
	public Main() {
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		makeGui();
		setVisible(true);
	}
	class MyitemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange() == ItemEvent.SELECTED)
			System.out.println(((JRadioButton) e.getSource()).getText());
		}
	}
	MyitemListener listener = new MyitemListener();
	public void makeGui() {
		JRadioButton btnApple = new JRadioButton("Apple");
		JRadioButton btnBanana = new JRadioButton("Banana");
		JRadioButton btnKiwi = new JRadioButton("Kiwi");
		add(btnApple); btnApple.setBounds(0, 0, 100, 25);
		add(btnBanana); btnBanana.setBounds(110, 0, 100, 25);
		add(btnKiwi); btnKiwi.setBounds(230, 0, 100, 25);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(btnApple);
		bg.add(btnBanana);
		bg.add(btnKiwi);
		
		btnApple.addItemListener(listener);
		btnBanana.addItemListener(listener);
		btnKiwi.addItemListener(listener);
	}
	public static void main(String[] args) {
		Main Frame = new Main();
	}
}
