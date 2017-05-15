package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;

public class Intersection {

    public static Graph intersection(Graph graph1, Graph graph2) {

        CartesianProduct product = new CartesianProduct(graph1, graph2);
        ArrayList<String> intersectionNodeEnd = product.getIntersectionFinalState();

        Graph graphresult = product.getNewGraph();

        for (String nodeName : intersectionNodeEnd) {

            Node node = graphresult.searchNode(nodeName);
            if (node != null) {
                node.setStateEnd(true);
            }
        }

        return graphresult;

    }
}
