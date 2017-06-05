package Gui;

import javax.swing.*;

import logic.Autoanalyse;
import logic.Operations.CartesianProduct;
import logic.Operations.Complement;
import logic.Operations.Intersection;
import logic.Operations.Reversal;
import logic.Operations.Union;
import logic.Structure.Graph;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.io.File;

class App extends JFrame {
	private JTextField textField;
	private Filechooser Graph1_filechooser;
	private Filechooser Graph2_filechooser;
  public App() {
	setTitle("Autoanalyze");
	setSize(500,650); // default size is 0,0
	setLocation(300,0); // default is 0,0 (top left corner)
	getContentPane().setLayout(null);
	
	JDesktopPane desktopPane = new JDesktopPane();
	desktopPane.setBounds(0, 0, 500, 1);
	getContentPane().add(desktopPane);
	
	JLabel Graph1_label = new JLabel("Graph 1");
	Graph1_label.setBounds(80, 15, 70, 32);
	getContentPane().add(Graph1_label);
	
	JButton Graph1_upload_btn = new JButton("Upload");
	Graph1_upload_btn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Graph1_filechooser = new Filechooser();
			Graph1_filechooser.setVisible(true);
		}
	});
	Graph1_upload_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	Graph1_upload_btn.setBounds(49, 47, 117, 25);
	getContentPane().add(Graph1_upload_btn);
	
	JLabel Graph2_label = new JLabel("Graph 2");
	Graph2_label.setBounds(369, 15, 70, 32);
	getContentPane().add(Graph2_label);
	
	
	JButton Graph2_upload_btn = new JButton("Upload");
	Graph2_upload_btn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Graph2_filechooser = new Filechooser();
			Graph2_filechooser.setVisible(true);
		}
	});
	Graph2_upload_btn.setBounds(339, 47, 117, 25);
	getContentPane().add(Graph2_upload_btn);
	
	JLabel lblOperations = new JLabel("Operations");
	lblOperations.setBounds(200, 81, 103, 15);
	getContentPane().add(lblOperations);
	
	JButton btnComplement = new JButton("Complement");
	btnComplement.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null){
				String[] args = new String[1];
				args[0] = Graph1_filechooser.getFileName();
				Autoanalyse Analyse = new Autoanalyse(args);
				Graph graphresult = Complement.complement(Analyse.getGraph());
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
			}
		}
	});
	btnComplement.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnComplement.setBounds(12, 107, 138, 25);
	getContentPane().add(btnComplement);
	
	JButton btnNewButton = new JButton("Intersection");
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null && Graph2_filechooser.getFileName() != null){
				String[] args = new String[1];
				args[0] = Graph1_filechooser.getFileName();
				args[1] = Graph2_filechooser.getFileName();
				Autoanalyse Analyse = new Autoanalyse(args);
				Graph graphresult = Intersection.intersection(Analyse.getGraph(),Analyse.getGraph1());
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
			}
		}
	});
	btnNewButton.setBounds(188, 108, 138, 25);
	getContentPane().add(btnNewButton);
	
	JButton btnReversal = new JButton("Reversal");
	btnReversal.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null){
				String[] args = new String[1];
				args[0] = Graph1_filechooser.getFileName();
				Autoanalyse Analyse = new Autoanalyse(args);
				Graph graphresult = Reversal.reversal(Analyse.getGraph());
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
			}
		}
	});
	btnReversal.setBounds(80, 144, 136, 25);
	getContentPane().add(btnReversal);
	
	JButton btnUnion = new JButton("Union");
	btnUnion.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null && Graph2_filechooser.getFileName() != null){
				String[] args = new String[1];
				args[0] = Graph1_filechooser.getFileName();
				args[1] = Graph2_filechooser.getFileName();
				Autoanalyse Analyse = new Autoanalyse(args);
				Graph graphresult = Union.union(Analyse.getGraph(),Analyse.getGraph1());
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
			}
		}
	});
	btnUnion.setBounds(356, 107, 117, 25);
	getContentPane().add(btnUnion);
	
	JButton btnCartesianProduct = new JButton("Cartesian Product");
	btnCartesianProduct.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null && Graph2_filechooser.getFileName() != null){
				String[] args = new String[1];
				args[0] = Graph1_filechooser.getFileName();
				args[1] = Graph2_filechooser.getFileName();
				Autoanalyse Analyse = new Autoanalyse(args);
				CartesianProduct product = new CartesianProduct(Analyse.getGraph(),Analyse.getGraph1());
				Graph graphresult = product.getNewGraph();
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
			}
		}
	});
	btnCartesianProduct.setBounds(244, 144, 170, 25);
	getContentPane().add(btnCartesianProduct);
	
	JLabel lblOutPut = new JLabel("Output File Name");
	lblOutPut.setBounds(188, 24, 151, 15);
	getContentPane().add(lblOutPut);
	
	textField = new JTextField();
	textField.setBounds(200, 50, 114, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	Panel panel = new Panel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(36, 184, 437, 407);
	getContentPane().add(panel);
  }

  public static void main(String[] args) {
    JFrame f = new App();
    f.show();
  }
}