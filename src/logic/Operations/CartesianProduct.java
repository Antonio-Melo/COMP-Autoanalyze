package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

public class CartesianProduct {

    public  CartesianProduct(Graph graph1, Graph graph2){
        Graph newGraph = new Graph();

        //Create Nodes
        for(Node nodeg1 : graph1.getNodes()){
            for(Node nodeg2 : graph2.getNodes()){
                newGraph.addNode(new Node(new String(nodeg1.getName()+nodeg2.getName())));
            }
        }

        //Create Edges
        
    }
}
