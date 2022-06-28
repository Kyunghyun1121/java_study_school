package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mylib.*;
//여기는 응용
	



public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KAdapterFrame frame = new KAdapterFrame();
		frame.setSize(800,600);
		frame.setKFrame(new PainterKFrame());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
