package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

public class CartesianProduct {

    private Graph newGraph;


    public  CartesianProduct(Graph graph1, Graph graph2){
        newGraph = new Graph();

        //Create Nodes
        for(Node nodeg1 : graph1.getNodes()){
            for(Node nodeg2 : graph2.getNodes()){
                newGraph.addNode(new Node(new String(nodeg1.getName()+nodeg2.getName())));
            }
        }

        //TESTES
        for(Node node : newGraph.getNodes()){
            node.printNode();
        }
        //Create Edges
        for(Node node : newGraph.getNodes()){
            for(Node node2: newGraph.getNodes()){
                if(node != node2){
                    if(node.getName().charAt(0) ==  node2.getName().charAt(0)){
                        System.out.println("Encontei um com o primeiro igual");
                        System.out.println(new String(node.getName().charAt(1)+""));
                        System.out.println(new String(node2.getName().charAt(1)+""));

                        //Node oldnode = graph1.getNode(new String(node.getName().charAt(0)+""));

                        Node oldnode2 = graph2.searchNode(new String(node.getName().charAt(1)+""));
                        Node oldnode3 = graph2.searchNode(new String(node2.getName().charAt(1)+""));
                        System.out.println(oldnode2.getName());
                        System.out.println(oldnode3.getName());

                        if(oldnode2.haveEdge(oldnode3.getName())){
                            System.out.println("Encontei um com edge adjacentes");
                            node.addEdge(node2);
                        }
                    }

                    if(node.getName().charAt(1) == node2.getName().charAt(1)){
                        Node oldnode2 = graph1.getNode(new String(node.getName().charAt(0)+""));
                        Node oldnode3 = graph1.getNode(new String(node2.getName().charAt(0)+""));

                        if(oldnode2.haveEdge(oldnode3.getName())){
                            node.addEdge(node2);
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
}
