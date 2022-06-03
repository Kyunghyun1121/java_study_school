import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	public Main() {
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);

	}
	public void makeGui() {
		JTabbedPane myTab = new JTabbedPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(new JTextArea(10,20));
		jp2.add(new JTextArea(10,20));
		myTab.addTab("File 1", jp1);
		myTab.addTab("File 2", jp2);
		myTab.setBounds(0, 0, 400, 300);
		add(myTab);
		

	}
	public static void main(String[] args) {
		Main Frame = new Main();
	}
}
