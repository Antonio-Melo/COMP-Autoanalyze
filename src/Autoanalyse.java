
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Autoanalyse {

    private String path;
    private String operation;
    private ArrayList<ElementGraph> tokens;
    private ArrayList<String> nodes;
    private ArrayList<String> stateEndNode;

    public Autoanalyse(String args[]) {



     /*   if (args.length != 2) {
            System.out.println("Requerires <path> <opeartion>");
        }
        this.path = args[0];
        this.operation = args[1];
        */

        tokens = new ArrayList<>();
        stateEndNode = new ArrayList<>();
        nodes = new ArrayList<>();


        try {
            ValidateFile validateFile = new ValidateFile(System.in);
            validateFile.Start(tokens);

        } catch (Throwable e) {
            System.out.println("Invalid REGEX!\n" + e.getMessage());
            System.exit(1);
        }

        this.state();
        this.nodesGraph();
        this.complement();
    }

    public static void main(String args[]) {

        Autoanalyse auto = new Autoanalyse(args);
    }

    public void state() {
        // System.out.println("tokens size" + tokens.size());

        for (ElementGraph elem : tokens) {
            if (elem.getElement2() == null)
                if (elem.getField1().equals("peripheries") && elem.getCharacteristic1().equals("2"))
                    stateEndNode.add(elem.getElement1());
        }

    /*    for (String node : stateEndNode) {
            System.out.println(node);
        }*/
        this.nodesGraph();
    }

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
       /* for (String node : nodes) {
            System.out.println("nodes Graph-> " + node);
        }
        */
    }


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
}


/* #### NAO APAGAR  ###################################
digraph G3{a -> b [label = hello ];  a -> c [label= hello ]; a[peripheries=2];}

javac Autoanalyse.java
java Autoanalyse
*/