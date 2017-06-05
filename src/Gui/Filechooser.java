package Gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Filechooser  extends JFrame{
	
	private JFileChooser fc = null;
	private String fileName = null;
	
	public Filechooser(){
		setTitle("Filechooser");
		setSize(300,350); // default size is 0,0
		setLocation(300,0); // default is 0,0 (top left corner)
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 500, 1);
		getContentPane().add(desktopPane);
		
		fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Dot files", "dot");
	    fc.setFileFilter(filter);
		fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    int returnVal = fc.showOpenDialog(fc);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       fileName = fc.getSelectedFile().getName();
				       System.out.println("You chose to open this file: " +
				            fc.getSelectedFile().getName());
				    }
			}
		});
		fc.setBounds(12, 0, 278, 301);
		getContentPane().add(fc);
	}
	
	public static void main(String[] args) {
	    JFrame f = new Filechooser();
	    f.show();
	}
	
	public JFileChooser getFileChooser(){
		return fc;
	}
	
	public String getFileName(){
		return fileName;
	}
	
}
