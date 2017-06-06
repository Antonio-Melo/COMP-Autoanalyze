package logic.Structure;


import java.util.ArrayList;

public class Graph {
    private String name;
    private ArrayList<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Boolean existsNode(Node node) {

        return nodes.contains(node);
    }

    public Node getNode(String name) {
        Node node = new Node(name);

        int index = nodes.indexOf(node);
        if (index != -1) {
            return nodes.get(index);
        } else return null;
    }

    public String getName() {
        return name;
    }

    public Node searchNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public Graph clone() {

        Graph cloneGraph = new Graph();

        for (Node node : nodes) {
            Node cloneNode = node.clone();
            cloneGraph.addNode(cloneNode);
        }
        for (Edge edge : getEdges()) {

            String sourceName = edge.getSource().getName();
            String destName = edge.getDest().getName();

            Node nodeSource = cloneGraph.searchNode(sourceName);
            Node nodeDest = cloneGraph.searchNode(destName);

            nodeSource.addEdge(nodeDest, edge.getLabel());
        }

        return cloneGraph;
    }

    public ArrayList<Edge> getEdges() {

        ArrayList<Edge> edgesGraph = new ArrayList<>();

        for (Node node : getNodes()) {
            ArrayList<Edge> edgeNode = node.getEdges();

            for (Edge edge : edgeNode) {
                edgesGraph.add(edge);
            }
        }

        return edgesGraph;
    }

    public static void main(String args[]) {

    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }
}
