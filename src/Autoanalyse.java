import logic.Operations.CartesianProduct;
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
        Graph graph2 = new Graph();
        Graph graph3 = new Graph();
        //String fileRead = readFile("dot/example2.dot");
        String fileRead2 = readFile("dot/test.dot");
        String fileRead3 = readFile("dot/test2.dot");


        try {
            /*ValidateFile validateFile = new ValidateFile(new java.io.StringReader(fileRead));
            validateFile.Start(graph);*/

            System.out.println("VOU LER O PRIMEIRO");
            ValidateFile validateFile2 = new ValidateFile(new java.io.StringReader(fileRead2));
            validateFile2.Start(graph2);
            System.out.println("LI BEM O PRIMEIRO");

            System.out.println("VOU LER O SEGUNDO");
            validateFile2.ReInit(new java.io.StringReader(fileRead3));
            validateFile2.Start(graph3);
            System.out.println("LI BEM O SEGUNDO");

        } catch (Throwable e) {
            System.out.println("Invalid REGEX!\n" + e.getMessage());
            System.exit(1);
        }

        //Graph graphResult = Intersection.intersection(graph, graph);

        CartesianProduct product = new CartesianProduct(graph2, graph3);
        Graph graphResult = product.getNewGraph();

        for(Node node : graphResult.getNodes()){
            node.printNode();
            for(Edge edge: node.getEdges()){
                System.out.println(edge.toString());
            }
        }



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
/*
    public void state() {
        // System.out.println("tokens size" + tokens.size());

        for (ElementGraph elem : tokens) {
            if (elem.getElement2() == null)
                if (elem.getField1().equals("peripheries") && elem.getCharacteristic1().equals("2"))
                    stateEndNode.add(elem.getElement1());
        }

        //for (String node : stateEndNode) {
            //System.out.println(node);
        //}
        this.nodesGraph();
    }
    */
/*
    public void nodesGraph() {

        for (ElementGraph elem : tokens) {


            if (!nodes.contains(elem.getElement1())) {
                nodes.add(elem.getElement1());
            }
            if (elem.getElement2() != null)
                if (!nodes.contains(elem.getElement2())) {
                    nodes.add(elem.getElement2());
                }
        }
       // for (String node : nodes) {
         //   System.out.println("nodes Graph-> " + node);
        //}

    }
    */

/*
    public ArrayList<ElementGraph> complement() {

        ArrayList<ElementGraph> result = new ArrayList<ElementGraph>();

        for (ElementGraph elem : tokens) {
            if (elem.getElement2() != null) {
                result.add(elem);

            } else if (elem.getField1() != null)
                if (!elem.getField1().equals("peripheries") || !elem.getCharacteristic1().equals("2")) {
                    result.add(elem);
                }
        }

        for (String node : nodes) {
            if (!stateEndNode.contains(node))
                result.add(new ElementGraph(node, "peripheries", "2", null, null, null));

        }

        for (ElementGraph node : result) {
            System.out.println("nodes Graph-> " + node);
        }

        return result;
    }
    */

    public void outPutResult(ArrayList<Node> result) {
        Path f = Paths.get("output.dot");
        List<String> lines = new ArrayList<String>();

        lines.add("digraph OUT {");
        for(Node node : result){
            ArrayList<Edge> edges =  node.getEdges();
            String line= new String("");

            if(!edges.isEmpty()){
                System.out.println("Não tenho edges");
                for(Edge edge : edges){
                    line = new String(edge.getSource().getName()+" -> "+ edge.getDest().getName());
                    if(edge.getLabel() != null){
                        line += " [label="+edge.getLabel()+"];";
                    }
                    lines.add(line);
                }
            }else{
                line = new String(node.getName() + ";");
                lines.add(line);
            }

            if(node.getStateEnd()){
                line = new String(node.getName() + " [peripheries=2];");
                lines.add(line);
            }
            if(node.getLabel() != null){
                line = new String(node.getName() + " [label="+ node.getLabel()+"];");
                lines.add(line);
            }
            System.out.print(line);
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