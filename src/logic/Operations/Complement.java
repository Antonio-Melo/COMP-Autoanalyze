package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

public class Complement {

    public static Graph complement(Graph graph) {

        Graph graphResult = graph;

        for (Node node : graphResult.getNodes()) {

            Boolean state = node.getStateEnd();
            node.setStateEnd(!state);
        }

        return graphResult;
    }
}

