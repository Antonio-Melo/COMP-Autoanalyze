package Gui;

import logic.Operations.CartesianProduct;
import logic.Operations.Complement;
import logic.Operations.Union;
import logic.Parser.ParseException;
import logic.Parser.ValidateFile;
import logic.Structure.Edge;
import logic.Structure.Graph;
import logic.Structure.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Autoanalyse {


    private String path;

    private String operation;
    private Graph graph;
    private Graph graph1;

    /**
     * @param args
     */
    public Autoanalyse(String args[]) {


        graph = new Graph();
        graph1 = new Graph();
        String fileRead;
        String fileRead1;
        if (args.length > 1) {
            fileRead = readFile(args[0]);//TODO: atençao ao diretorio
            fileRead1 = readFile(args[1]);//TODO: atençao ao diretorio


            try {

                ValidateFile validateFile = new ValidateFile(new java.io.StringReader(fileRead));
                validateFile.Start(graph);
 

                validateFile.ReInit(new java.io.StringReader(fileRead1));
                validateFile.Start(graph1);

            } catch (Throwable e) {
                System.out.println("Invalid REGEX!\n" + e.getMessage());
                System.exit(1);
            }
        } else {
            fileRead = readFile(args[0]);
            try {

                ValidateFile validateFile = new ValidateFile(new java.io.StringReader(fileRead));
                validateFile.Start(graph);
            } catch (Throwable e) {
                System.out.println("Invalid REGEX!\n" + e.getMessage());
                System.exit(1);
            }
        }
<<<<<<< HEAD
        //ystem.out.println("aaaaaaaaa"+graph1.getNodes().size());

          //CartesianProduct product = new CartesianProduct(graph, graph1);
        //Graph graphresult = product.getNewGraph();


        //Graph graphresult = Union.union(graph, graph1);
        // Graph graphresult = Intersection.intersection(graph, graph1);
        //Graph graphresult = Reversal.reversal(graph);
       // Graph graphresult = Complement.complement(graph1);


        //System.out.println("aaaaaaaaa"+graphresult.getNodes().size());
        //this.outPutResult(graphresult.getNodes(),"output");
        // this.outPutResult(graphresult.getNodes());

=======
>>>>>>> 58318abcb938be0684cd8aa49c6734ee51a45499

    }

    /**
     * @param path Path the read file
     * @return String with content of file
     */
    public String readFile(String path) {

        BufferedReader br = null;
        String result = "";
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while (line != null) {
                result += line;
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
        String[] var = new String[1];
    	var[0] = "dot/test1.dot";
    	Autoanalyse auto = new Autoanalyse(args);
    }

    /**
     * @param fileRead File path to validate grammar
     * @return Return whether the file respects grammar or not
     */
    public boolean validateFile(String fileRead) {

        ValidateFile validateFile = new ValidateFile(new java.io.StringReader(fileRead));

        Graph graph = new Graph();
        try {
            validateFile.Start(graph);
        } catch (ParseException e) {
            System.out.println("This file does not respect the grammar");
            return false;
        }
        return true;


    }

    /**
     * @param result Write in the file of the graph result in the language dot
     */
    public void outPutResult(ArrayList<Node> result, String outputFileName) {

        String filePath = outputFileName + ".dot";
        File file = new File(filePath);
        Path f = Paths.get(filePath);
        List<String> lines = new ArrayList<String>();

        lines.add("digraph OUT {");
        for (Node node : result) {
            ArrayList<Edge> edges = node.getEdges();
            String line = "";

            if (!edges.isEmpty()) {
                for (Edge edge : edges) {
                    line = new String(edge.getSource().getName() + " -> " + edge.getDest().getName());
                    if (edge.getLabel() != null) {
                        line += " [label=" + edge.getLabel() + "];";
                    } else line += ";";
                    lines.add(line);
                }
            }

            if (node.getStateEnd()) {
                line = new String(node.getName() + " [peripheries=2];");
                lines.add(line);
            }
            if (node.getLabel() != null) {
                line = new String(node.getName() + " [label=" + node.getLabel() + "];");
                lines.add(line);
            }
        }
        lines.add("}");

        try {
            Files.write(f, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DotConvert dc = new DotConvert();

        dc.start(f.toString(), "graphOutput.");

    }

    public Graph getGraph() {
        return graph;
    }

    public Graph getGraph1() {
        return graph1;
    }
}


