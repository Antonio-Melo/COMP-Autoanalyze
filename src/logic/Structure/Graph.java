package logic.Structure;


import java.util.ArrayList;

public class Graph {
   public String name;
    private ArrayList<Node> nodes;

    public  Graph(){
        this.nodes=new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Boolean existsNode(Node node) {

        if (nodes.contains(node)) {
            return true;
        } else
            return false;
    }

    public Node getNode(String name) {
        Node node = new Node(name);

        int index = nodes.indexOf(node);
        if (index != -1) {
            return nodes.get(index);
        } else return null;
    }

    public Node searchNode(String name){
        for(Node node : nodes){
            if(node.getName().equals(name)){
                return node;
            }
        }
        return null;
    }

    public ArrayList<Edge> getEdges(){

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

        Graph auto = new Graph();
        Node node = new Node("node");
        //  auto.addNode(node);

        Node node2 = new Node("node");
        if (auto.existsNode(node)) {
            System.out.println("tem");
        }
        if (auto.getNode("asas") == null) {

            System.out.println("null");
        } else
            System.out.println("nao null");
    }

    public ArrayList<Node> getNodes() {
    	return nodes;
    }
}
