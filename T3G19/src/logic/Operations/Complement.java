package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

public class Complement {

    /**
     * Returns the graph of the complement of the graph
     *
     * @param graph Input graph
     * @return The graph of the complement of the graph
     */
    public static Graph complement(Graph graph) {

        Graph graphResult = graph.clone();
        for (Node node : graphResult.getNodes()) {

            Boolean state = node.getStateEnd();
            node.setStateEnd(!state);
        }

        return graphResult;
    }
}

