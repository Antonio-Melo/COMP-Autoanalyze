package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;

public class Union {
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

    /*    CartesianProduct product = new CartesianProduct(graph1, graph2);
        Graph graphCP = product.getNewGraph();

        //all that needs to be done is adding the final states

        ArrayList<Node> nodes = graphCP.getNodes();

        ArrayList<Node> nodes1 = graph1.getNodes();
        ArrayList<String> nodesFinal1 = new ArrayList<String>();
        ArrayList<Node> nodes2 = graph2.getNodes();
        ArrayList<String> nodesFinal2 = new ArrayList<String>();

        for (Node n : nodes1) {
            if (n.getStateEnd()) {
                nodesFinal1.add(n.getName());
            }
        }

        for (Node n : nodes2) {
            if (n.getStateEnd()) {
                nodesFinal2.add(n.getName());
            }
        }

        for (Node node : nodes) {
            for (int i = 0; i < nodesFinal1.size(); i++) {
                if (node.getName().contains(nodesFinal1.get(i))) {
                    node.setStateEnd(true);
                }
            }

            for (int j = 0; j < nodesFinal2.size(); j++) {
                if (node.getName().contains(nodesFinal2.get(j))) {
                    node.setStateEnd(true);
                }
            }
        }
        return graphCP;
    }*/
}
