package logic.Operations;

import logic.Structure.Edge;
import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;

public class Intersection {

    public Graph intersection(Graph graph1, Graph graph2) {

        Graph result= new Graph();
        ArrayList<Edge> edgesGraph1 = graph1.getEdges();
        ArrayList<Edge> edgesGraph2 = graph2.getEdges();

        for(Edge edge:edgesGraph1){

            if(edgesGraph2.contains(edge)){
                Node nodeSource= edge.getSource();
                Node nodeDest = edge.getDest();

                if(!result.getNodes().contains(nodeSource)){
                    result.addNode(nodeSource);
                }
                nodeSource.addEdge(nodeDest);
            }
        }

        return result;
    }
}
