package Gui;

import javax.swing.*;

import logic.Operations.CartesianProduct;
import logic.Operations.Complement;
import logic.Operations.Intersection;
import logic.Operations.Reversal;
import logic.Structure.Graph;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class App extends JFrame {
	private JTextField textField;
	private JPanel panel;
	private Filechooser Graph1_filechooser;
	private Filechooser Graph2_filechooser;
  public App() {
	setTitle("Autoanalyze");
	setSize(541,656); // default size is 0,0
	setLocation(300,0); // default is 0,0 (top left corner)
	getContentPane().setLayout(null);
	
	JDesktopPane desktopPane = new JDesktopPane();
	desktopPane.setBounds(0, 0, 500, 1);
	getContentPane().add(desktopPane);
	
	JLabel Graph1_label = new JLabel("Graph 1");
	Graph1_label.setBounds(96, 12, 70, 32);
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
	Graph2_label.setBounds(384, 12, 70, 32);
	getContentPane().add(Graph2_label);
	
	
	JButton Graph2_upload_btn = new JButton("Upload");
	Graph2_upload_btn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Graph2_filechooser = new Filechooser();
			Graph2_filechooser.setVisible(true);
		}
	});
	Graph2_upload_btn.setBounds(349, 47, 117, 25);
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
				System.out.println("Recibi este path do ficheiro do graph1 "+args[0]);
				Autoanalyse Analyse = new Autoanalyse(args);
				Graph graphresult = Complement.complement(Analyse.getGraph());
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
				ImageIcon image = new ImageIcon("graphOutput.png");
				System.out.println(image.getIconWidth());
				JLabel label = new JLabel("", image, JLabel.CENTER);
				panel.add(label,BorderLayout.CENTER);
				panel.repaint();
				panel.revalidate();
			}
		}
	});
	btnComplement.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnComplement.setBounds(28, 107, 138, 25);
	getContentPane().add(btnComplement);
	
	JButton btnNewButton = new JButton("Intersection");
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null && Graph2_filechooser.getFileName() != null){
				String[] args = new String[2];
				args[0] = Graph1_filechooser.getFileName();
				args[1] = Graph2_filechooser.getFileName();
				Autoanalyse Analyse = new Autoanalyse(args);
				Graph graphresult = Intersection.intersection(Analyse.getGraph(),Analyse.getGraph1());
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
				ImageIcon image = new ImageIcon("graphOutput.png");
				System.out.println(image.getIconWidth());
				JLabel label = new JLabel("", image, JLabel.CENTER);
				panel.add(label,BorderLayout.CENTER);
				panel.repaint();
				panel.revalidate();
			}
		}
	});
	btnNewButton.setBounds(201, 107, 138, 25);
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
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
				ImageIcon image = new ImageIcon("graphOutput.png");
				System.out.println(image.getIconWidth());
				JLabel label = new JLabel("", image, JLabel.CENTER);
				panel.add(label,BorderLayout.CENTER);
				panel.repaint();
				panel.revalidate();
			}
		}
	});
	btnReversal.setBounds(89, 144, 136, 25);
	getContentPane().add(btnReversal);
	
	JButton btnUnion = new JButton("Union");
	btnUnion.setBounds(367, 107, 117, 25);
	getContentPane().add(btnUnion);
	
	JButton btnCartesianProduct = new JButton("Cartesian Product");
	btnCartesianProduct.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnCartesianProduct.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Graph1_filechooser.getFileName() != null && Graph2_filechooser.getFileName() != null){
				String[] args = new String[2];
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
				if(textField.getText() != null){
					Analyse.outPutResult(graphresult.getNodes(),textField.getText());
				}else{
					Analyse.outPutResult(graphresult.getNodes(),"defaultname");
				}
				ImageIcon image = new ImageIcon("graphOutput.png");
				System.out.println(image.getIconWidth());
				JLabel label = new JLabel("", image, JLabel.CENTER);
				panel.add(label,BorderLayout.CENTER);
				panel.repaint();
				panel.revalidate();
			}
		}
	});
	btnCartesianProduct.setBounds(269, 144, 170, 25);
	getContentPane().add(btnCartesianProduct);
	
	JLabel lblOutPut = new JLabel("Output File Name");
	lblOutPut.setBounds(223, 24, 151, 15);
	getContentPane().add(lblOutPut);
	
	textField = new JTextField();
	textField.setBounds(200, 50, 114, 19);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	panel = new JPanel(new BorderLayout());
	panel.setBackground(Color.WHITE);
	panel.setBounds(12, 184, 488, 422);
	getContentPane().add(panel);
  }

  public static void main(String[] args) {
    JFrame f = new App();
    f.show();
  }
}