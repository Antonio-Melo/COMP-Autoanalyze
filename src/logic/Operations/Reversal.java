package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;
import logic.Structure.Edge;

import java.util.ArrayList;

public class Reversal {
    /**
     * @param graph Input graph
     * @return Returns the reverse graph of the input graph
     */
    public static Graph reversal(Graph graph) {
        Graph graphResult = graph.clone();

        for (Edge edge : graphResult.getEdges()) {
            Node dest = edge.getDest();
            Node src = edge.getSource();

            edge.setDest(src);
            edge.setSource(dest);
        }

        Node startStateOld = graphResult.getNodes().get(0);
        //assuming start state is the first state
        startStateOld.setStateEnd(true); //The accepting state for the LR automaton
        //is the start state for the main automaton.

        Node newStartState = new Node("newStart");
        //get all the accepting states from the old automata
        ArrayList<Node> nodes1 = graphResult.getNodes();
        ArrayList<String> nodesAccepting = new ArrayList<String>();

        for (Node n : nodes1) {
            if (n.getStateEnd() && !(n.equals(startStateOld))) {
                n.setStateEnd(false);
                nodesAccepting.add(n.getName());
                newStartState.addEdge(n, "ε");
            }
        }

        graphResult.addNode(newStartState);
        return graphResult;
    }
}
