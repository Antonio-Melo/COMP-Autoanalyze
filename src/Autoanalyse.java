import logic.DotConvert;
import logic.Operations.CartesianProduct;
import logic.Operations.Complement;
import logic.Operations.Intersection;
import logic.Operations.Union;
import logic.Parser.ValidateFile;
import logic.Structure.Edge;
import logic.Structure.Graph;
import logic.Structure.Node;

import java.io.BufferedReader;
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

    public Autoanalyse(String args[]) {


      /*  if (args.length != 2) {
            System.out.println("Requerires <path> <opeartion>");
        }
        this.path = args[0];
        this.operation = args[1];
        */


        graph = new Graph();
        Graph graph = new Graph();
        Graph graph1 = new Graph();
        //String fileRead = readFile("dot/example2.dot");
        String fileRead = readFile("../dot/test.dot");//TODO: atenção ao diretorio
        String fileRead1 = readFile("../dot/test1.dot");//TODO: atenção ao diretorio


        try {
            /*ValidateFile validateFile = new ValidateFile(new java.io.StringReader(fileRead));
            validateFile.Start(graph);*/

            System.out.println("VOU LER O PRIMEIRO");
            ValidateFile validateFile2 = new ValidateFile(new java.io.StringReader(fileRead));
            validateFile2.Start(graph);
            System.out.println("LI BEM O PRIMEIRO");

            System.out.println("VOU LER O SEGUNDO");
            validateFile2.ReInit(new java.io.StringReader(fileRead1));
            validateFile2.Start(graph1);
            System.out.println("LI BEM O SEGUNDO");

        } catch (Throwable e) {
            System.out.println("Invalid REGEX!\n" + e.getMessage());
            System.exit(1);
        }


      //  CartesianProduct product = new CartesianProduct(graph, graph1);
        //Graph graphResult = product.getNewGraph();


    /*    for (Node node : graphResult.getNodes()) {
            node.printNode();
            for (Edge edge : node.getEdges()) {
               // System.out.println(edge.toString());
            }
        }*/


      // Graph graphresult = Intersection.intersection(graph, graph1);
       Graph graphresult = Complement.complement(graph);

        this.outPutResult(graphresult.getNodes());
    }

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
        //  System.out.println(result);
        return result;
    }

    public static void main(String args[]) {

        Autoanalyse auto = new Autoanalyse(args);
    }


    public void outPutResult(ArrayList<Node> result) {
        Path f = Paths.get("output.dot");
        List<String> lines = new ArrayList<String>();

        lines.add("digraph OUT {");
        for (Node node : result) {
            ArrayList<Edge> edges = node.getEdges();
            String line = "";

            if (!edges.isEmpty()) {
               // System.out.println("Nao tenho edges");
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

      /*  DotConvert dc = new DotConvert();

        String input = "C:/Users/Maria/workspace/COMP/output.dot";
       // String input = "C:/Users/Acer-PC/workspace/GitHub/COMP-Autoanalyze/dot/example2.dot";

        String out = "C:/Users/Maria/Documents/temp/output.";
        //String out = "C:/Users/Acer-PC/workspace/GitHub/COMP-Autoanalyze/dot/graph2.dot"

        dc.start(input, out);*/

        try {
            Files.write(f, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

