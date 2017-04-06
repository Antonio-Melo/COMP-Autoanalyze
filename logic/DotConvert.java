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
		String input = "c:/Users/Maria/workspace/COMP_proj/src/dot/example2.dot";    // Windows

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
		File out = new File("c:/Users/Maria/Documents/temp/graph2." + type);   // Windows
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, representationType), out );
	}
}