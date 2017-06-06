package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;

public class Union {


    /**
     * Returns the graph of the union of the two input graphs
     *
     * @param graph1 Input graph
     * @param graph2 Input graph
     * @return the graph of the union of the two input graphs
     */
    public static Graph union(Graph graph1, Graph graph2) {

        CartesianProduct product = new CartesianProduct(graph1, graph2);
        ArrayList<String> unionNodeEnd = product.getUnionFinalState();

        Graph graphresult = product.getNewGraph();

        for (String nodeName : unionNodeEnd) {

            Node node = graphresult.searchNode(nodeName);
            if (node != null) {
                node.setStateEnd(true);
            }
        }

        return graphresult;
    }

}
