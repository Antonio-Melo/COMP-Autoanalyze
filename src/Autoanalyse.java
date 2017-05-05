
import logic.Operations.Complement;
import logic.Operations.Intersection;
import logic.Parser.ValidateFile;
import logic.Structure.Edge;
import logic.Structure.Graph;
import logic.Structure.Node;

import java.io.*;
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
        String fileRead = readFile("../dot/example2.dot");

        try {
            ValidateFile validateFile = new ValidateFile(new java.io.StringReader(fileRead));
            validateFile.Start(graph);

        } catch (Throwable e) {
            System.out.println("Invalid REGEX!\n" + e.getMessage());
            System.exit(1);
        }

        Graph graphResult = Intersection.intersection(graph, graph);

         this.outPutResult(graphResult.getNodes());
    }

    public String readFile(String path){

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
        for(Node node : result){
            ArrayList<Edge> edges =  node.getEdges();
            String line;

            if(!edges.isEmpty()){
                for(Edge edge : edges){
                    line = new String(edge.getSource().getName()+" -> "+ edge.getDest().getName());
                    if(edge.getLabel() != null){
                        line += " [label="+edge.getLabel()+"];";
                    }
                    lines.add(line);
                }
            }
            if(node.getStateEnd()){
                line = new String(node.getName() + " [peripheries=2];");
                lines.add(line);
            }
            if(node.getLabel() != null){
                line = new String(node.getName() + " [label="+ node.getLabel()+"];");
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
    }
}



/* #### NAO APAGAR  ###################################
digraph G3{a -> b [label = hello ];  a -> c [label= hello ]; a[peripheries=2];}

javac Autoanalyse.java
java Autoanalyse
*/