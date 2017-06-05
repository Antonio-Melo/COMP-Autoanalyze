package Gui;

import java.io.File;

public class DotConvert {
    /**
     * Read the DOT source from a file,
     * convert to image and store the image in the file system.
     */
    public void start(String input, String output) {
        GraphViz gv = new GraphViz();
        gv.readSource(input);


        String type = "png";
        //    String type = "dot";
        //    String type = "fig";    // open with xfig
        //    String type = "pdf";
        //    String type = "ps";
        //    String type = "svg";    // open with inkscape
        //    String type = "png";
        //      String type = "plain";


        String representationType = "dot";
        //		String representationType= "neato";
        //		String representationType= "fdp";
        //		String representationType= "sfdp";
        // 		String representationType= "twopi";
        //		String representationType= "circo";


        File out = new File(output + type);   // Windows

        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, representationType), out);

    }
}