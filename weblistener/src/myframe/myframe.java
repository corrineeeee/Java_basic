package myframe;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class myframe extends JFrame{
	public static void main(String[] args) {
		myframe myframe = new myframe();
		myframe.setBounds(0, 0, 200, 100);
		myframe.setVisible(true);
		myframe.addWindowListener(new MyWindowListener());
	}
}
