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
                String[] nodes = new String[]{nodeg1.getName(),nodeg2.getName()};
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

        //TESTES
        /* for (Node node : newGraph.getNodes()) {
            node.printNode();
        }*/
        //Create Edges teste
        for(String[] node1 : combinednodes){
            for (String[] node2 : combinednodes){
                if(!(node1[0] == node2[0] && node1[1] == node2[1])){
                    if(node1[0].equals(node2[0])){
                        Node oldnode1 = graph2.searchNode(node1[1]);
                        Node oldnode2 = graph2.searchNode(node2[1]);

                        if(oldnode1.haveEdge(oldnode2.getName())) {
                            String label = oldnode1.getLabelEdge(oldnode2.getName());

                            Node nodeg1 = newGraph.searchNode(node1[0]+node1[1]);
                            Node nodeg2 = newGraph.searchNode(node1[0]+node1[1]);
                            if (label != null) {
                                nodeg1.addEdge(nodeg2, label);
                            } else nodeg1.addEdge(nodeg2);
                        }
                    }
                    if(node1[1].equals(node2[1])){
                        Node oldnode1 = graph1.searchNode(node1[0]);
                        Node oldnode2 = graph1.searchNode(node2[0]);

                        if(oldnode2.haveEdge(oldnode1.getName())){
                            String label = oldnode2.getLabelEdge(oldnode1.getName());

                            Node nodeg1 = newGraph.searchNode(node1[0]+node1[1]);
                            Node nodeg2 = newGraph.searchNode(node1[0]+node1[1]);

                            if (label != null) {
                                nodeg2.addEdge(nodeg1, label);
                            } else nodeg2.addEdge(nodeg1);
                        }
                    }
                }
            }
        }
        /*
        //Create Edges
        for (Node node : newGraph.getNodes()) {
            for (Node node2 : newGraph.getNodes()) {
                if (node != node2) {
                    //Tem que ser mudado, só funciona com nodes que tenham como nome uma caracter
                    if (node.getName().charAt(0) == node2.getName().charAt(0)) {
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
        }*/
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
