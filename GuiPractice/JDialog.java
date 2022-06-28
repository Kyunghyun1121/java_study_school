import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame{
	public JDialog mydialog;
	public Main() {
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!mydialog.isVisible()) {
					mydialog.setVisible(true);
				}else {
					mydialog.setVisible(false);
				}
				System.out.println("Clicked");
			}
		});
		setVisible(true);

	}
	
	public void makeGui() {
		mydialog = new JDialog(this, "Stupid dialog", true);
		//true로 하면 눌렀을떄 dialog에서만 인식헤서 Frame의 
		//접근은 먹지않는다. 이것을 module이라 한다.
		//지금하는 interaction만 쓰겠다->module
		//dialog를 보면서 다른 작업을 하ㄱ지만 dialog는 main과 상관없이 계속 
		//떠있게 하겠다.->not module
		//dialog는 대부분 상속을 받아서 사용한다.
	}
	public static void main(String[] args) {
		Main Frame = new Main();
	}
}
