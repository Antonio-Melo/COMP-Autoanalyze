package logic;

import java.io.File;

import Gui.GraphViz;
import Gui.*;

public class DotConvert 
{
	public static void main(String[] args)
	{
		DotConvert dc = new DotConvert();
		dc.start();
	}
	
	/**
	 * Read the DOT source from a file,
	 * convert to image and store the image in the file system.
	 */
	private void start()
	{
		//String dir = "/home/jabba/Dropbox/git.projects/laszlo.own/graphviz-java-api";     // Linux
		//String input = dir + "/sample/simple.dot";
		String input = "C:/Users/Maria/workspace/COMP/output.dot";    // Windows
		//String input = "C:/Users/Acer-PC/workspace/GitHub/COMP-Autoanalyze/dot/example2.dot";

		GraphViz gv = new GraphViz();
		gv.readSource(input);
		System.out.println(gv.getDotSource());

		String type = "png";
		//    String type = "dot";
		//    String type = "fig";    // open with xfig
		//    String type = "pdf";
		//    String type = "ps";
		//    String type = "svg";    // open with inkscape
		//    String type = "png";
		//      String type = "plain";
		
		
		String representationType= "dot";
		//		String representationType= "neato";
		//		String representationType= "fdp";
		//		String representationType= "sfdp";
		// 		String representationType= "twopi";
		//		String representationType= "circo";
		
		//File out = new File("/tmp/simple." + type);   // Linux
		File out = new File("C:/Users/Maria/Documents/temp/output." + type);   // Windows
		//File out = new File("C:/Users/Acer-PC/workspace/GitHub/COMP-Autoanalyze/dot/graph2." + type);
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, representationType), out );
	}
}