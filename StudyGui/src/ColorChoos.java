import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class ColorChoos extends JFrame{
    JLabel label = new JLabel("Hello");
    Color selectedColor=null;
    
    ColorChoos(){
        this.setTitle("JColorChooser 예제");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Ravie",Font.ITALIC,30));
        this.add(label, BorderLayout.CENTER);
        createMenu();
        this.setSize(250, 200);
        this.setVisible(true);
    }
    
    void createMenu(){
        JMenuBar mb=new JMenuBar();
        JMenuItem colorMenuItem = new JMenuItem("Color");
        JMenu fileMenu = new JMenu("Text");
        
        colorMenuItem.addActionListener(new MenuActionListener());
        
        fileMenu.add(colorMenuItem);
        mb.add(fileMenu);
        this.setJMenuBar(mb);
    }
    
    class MenuActionListener implements ActionListener{
        JColorChooser chooser=new JColorChooser();
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String cmd=ae.getActionCommand();
            if(cmd.equals("Color")){
                selectedColor=chooser.showDialog(null,"Color",Color.YELLOW);
                if(selectedColor!=null)
                    label.setForeground(selectedColor);
                System.out.println(selectedColor);
                p.Mycolor = selectedColor;
            }
        }
        
    }
    MyPanel p;
	public void set(MyPanel myPanel) {
		p=myPanel;
	}
}

