
import logic.Operations.Complement;
import logic.Parser.ValidateFile;
import logic.Structure.Graph;


public class Autoanalyse {

    private String path;
    private String operation;
    private Graph graph;

    public Autoanalyse(String args[]) {


        if (args.length != 2) {
            System.out.println("Requerires <path> <opeartion>");
        }
        this.path = args[0];
        this.operation = args[1];

        graph = new Graph();


        try {
            ValidateFile validateFile = new ValidateFile(System.in);
            validateFile.Start(graph);

        } catch (Throwable e) {
            System.out.println("Invalid REGEX!\n" + e.getMessage());
            System.exit(1);
        }

        Graph graphResult = Complement.complement(graph);

       // this.outPutResult(this.complement());
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
/*
    public void outPutResult(ArrayList<ElementGraph> result) {
        Path f = Paths.get("output.dot");
        List<String> lines = new ArrayList<String>();

        lines.add("digraph OUT {");
        for (ElementGraph node : result) {
            String line = new String(node.getElement1());
            if (node.getElement2() == null) {
                if (node.getField1() != null && node.getCharacteristic1() != null) {
                    line += " [" + node.getField1() + "=" + node.getCharacteristic1() + "];";
                }
                lines.add(line);
            } else {
                line += " -> " + node.getElement2();
                if (node.getField2() != null && node.getCharacteristic2() != null) {
                    line += " [" + node.getField2() + "=" + node.getCharacteristic2() + "];";
                }
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
            */
   }



/* #### NAO APAGAR  ###################################
digraph G3{a -> b [label = hello ];  a -> c [label= hello ]; a[peripheries=2];}

javac Autoanalyse.java
java Autoanalyse
*/