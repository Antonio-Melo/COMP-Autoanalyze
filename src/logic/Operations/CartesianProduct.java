package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;
import java.util.StringJoiner;

public class CartesianProduct {
    /**
     * Graph resulting from Cartesian product.
     */
    private Graph newGraph;

    /**
     * Name of nodes in with final state after the union.
     */
    private ArrayList<String> unionFinalState = new ArrayList<>();

    /**
     * Name of nodes in with final state after the intersection.
     */
    private ArrayList<String> intersectionFinalState = new ArrayList<>();

    /**
     * Name of nodes after combination in cartesian product.
     */
    private ArrayList<String[]> combinednodes = new ArrayList<>();

    /**
     * Configurable constructor with the two graphs for the cartesian product.
     *
     * @param graph1 Input graph
     * @param graph2 Input graph
     */
    public CartesianProduct(Graph graph1, Graph graph2) {
        newGraph = new Graph();

        //Create Nodes
        for (Node nodeg1 : graph1.getNodes()) {
            for (Node nodeg2 : graph2.getNodes()) {

                Boolean stateNode1 = nodeg1.getStateEnd();
                Boolean stateNode2 = nodeg2.getStateEnd();

                String produtNodeName = nodeg1.getName() + nodeg2.getName();
                String[] nodes = new String[]{nodeg1.getName(), nodeg2.getName()};
                combinednodes.add(nodes);

                //  combinednodes.add(new String[2](String)nodeg1.getName(),nodeg2.getName());
                Node newNode = new Node(produtNodeName);

                if (stateNode1 && stateNode2) {
                    intersectionFinalState.add(produtNodeName);
                    newNode.setStateEnd(true);
                }

                if (stateNode1 || stateNode2) {
                    unionFinalState.add(produtNodeName);
                }

                newGraph.addNode(newNode);
            }
        }

        //Create Edges teste
        for (String[] node1 : combinednodes) {
            for (String[] node2 : combinednodes) {
                if (!(node1[0] == node2[0] && node1[1] == node2[1])) {
                    if (node1[0].equals(node2[0])) {
                        Node oldnode1 = graph2.searchNode(node1[1]);
                        Node oldnode2 = graph2.searchNode(node2[1]);

                        if (oldnode1.haveEdge(oldnode2.getName())) {
                            String label = oldnode1.getLabelEdge(oldnode2.getName());

                            Node nodeg1 = newGraph.searchNode(node1[0] + node1[1]);
                            Node nodeg2 = newGraph.searchNode(node1[0] + node1[1]);
                            if (label != null) {
                                nodeg1.addEdge(nodeg2, label);
                            } else nodeg1.addEdge(nodeg2);
                        }
                    }
                    if (node1[1].equals(node2[1])) {
                        Node oldnode1 = graph1.searchNode(node1[0]);
                        Node oldnode2 = graph1.searchNode(node2[0]);

                        if (oldnode2.haveEdge(oldnode1.getName())) {
                            String label = oldnode2.getLabelEdge(oldnode1.getName());

                            Node nodeg1 = newGraph.searchNode(node1[0] + node1[1]);
                            Node nodeg2 = newGraph.searchNode(node1[0] + node1[1]);

                            if (label != null) {
                                nodeg2.addEdge(nodeg1, label);
                            } else nodeg2.addEdge(nodeg1);
                        }
                    }
                }
            }
        }
    }

    /**
     * @return Graph resulting from Cartesian product.
     */
    public Graph getNewGraph() {
        return newGraph;
    }

    /**
     * @return Name of nodes in with final state after the union.
     */
    public ArrayList<String> getUnionFinalState() {
        return unionFinalState;
    }

    /**
     * @return Name of nodes in with final state after the intersection.
     */
    public ArrayList<String> getIntersectionFinalState() {
        return intersectionFinalState;
    }
}
