package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;
import java.util.StringJoiner;

public class CartesianProduct {

    private Graph newGraph;

    private ArrayList<String> unionFinalState = new ArrayList<>();
    private ArrayList<String> intersectionFinalState = new ArrayList<>();
    private ArrayList<String[]> combinednodes = new ArrayList<>();

    public CartesianProduct(Graph graph1, Graph graph2) {
        newGraph = new Graph();

        //Create Nodes
        for (Node nodeg1 : graph1.getNodes()) {
            for (Node nodeg2 : graph2.getNodes()) {

                Boolean stateNode1 = nodeg1.getStateEnd();
                Boolean stateNode2 = nodeg2.getStateEnd();

                String produtNodeName = nodeg1.getName() + nodeg2.getName();
                /*String[] nodes = new String[2];
                nodes*/

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

        //TESTES
        /* for (Node node : newGraph.getNodes()) {
            node.printNode();
        }*/

        //Create Edges
        for (Node node : newGraph.getNodes()) {
            for (Node node2 : newGraph.getNodes()) {
                if (node != node2) {
                    if (node.getName().charAt(0) == node2.getName().charAt(0)) { //Tem que ser mudado
                        //System.out.println("Encontei um com o primeiro igual");
                        //System.out.println(new String(node.getName().charAt(1)+""));
                        //System.out.println(new String(node2.getName().charAt(1)+""));

                        //Node oldnode = graph1.getNode(new String(node.getName().charAt(0)+""));

                        Node oldnode2 = graph2.searchNode(new String(node.getName().charAt(1) + ""));
                        Node oldnode3 = graph2.searchNode(new String(node2.getName().charAt(1) + ""));
                        //System.out.println(oldnode2.getName());
                        //System.out.println(oldnode3.getName());

                        if (oldnode2.haveEdge(oldnode3.getName())) {
                            //  System.out.println("Encontei um com edge adjacentes");
                            String label = oldnode2.getLabelEdge(oldnode3.getName());
                            if (label != null) {
                                node.addEdge(node2, label);
                            } else node.addEdge(node2);
                        }
                    }

                    if (node.getName().charAt(1) == node2.getName().charAt(1)) {
                        Node oldnode2 = graph1.searchNode(new String(node.getName().charAt(0) + ""));
                        Node oldnode3 = graph1.searchNode(new String(node2.getName().charAt(0) + ""));

                        if (oldnode3.haveEdge(oldnode2.getName())) {
                            //  System.out.println("Encontei um com edge adjacentes");
                            String label = oldnode3.getLabelEdge(oldnode2.getName());
                            if (label != null) {
                                node.addEdge(node2, label);
                            } else node.addEdge(node2);
                        }
                    }
                }
            }
        }
        System.out.println("ACABEI DE FAZER O PRODUTO");

    }

    public Graph getNewGraph() {
        return newGraph;
    }

    public ArrayList<String> getUnionFinalState() {
        return unionFinalState;
    }

    public ArrayList<String> getIntersectionFinalState() {
        return intersectionFinalState;
    }
}
