package logic.Structure;

import java.util.*;

public class Node {
    private String name;
    private String label;
    private ArrayList<Edge> edges;
    private boolean stateEnd = false;

    public Node(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(Node dest, String label) {
        edges.add(new Edge(this, dest, label));
    }

    public void addEdge(Node dest) {
        edges.add(new Edge(this, dest));
    }

    public void setStateEnd(boolean stateEnd) {
        this.stateEnd = stateEnd;
    }

    public void setFieldCharate(String field, String charat) {


        if (field.equals("peripheries") && charat.equals("2"))
            setStateEnd(true);
        else {
            this.label = charat;
        }


    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name != null ? name.equals(node.name) : node.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public boolean getStateEnd() {
        return stateEnd;
    }

    public String getLabel() {
        return label;
    }

    public Node clone(){

        Node  node= new Node(name);
       node.setStateEnd(getStateEnd());
       node.setLabel(getLabel());
        return node;
    }
    public void printNode (){
        System.out.println(this.name);
    }


    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public boolean haveEdge(String node2){
        for(Edge edge: edges){
            if(edge.getDest().getName().equals( node2)) return true;
        }
        return false;
    }

    public String getLabelEdge (String node2){
        for(Edge edge: edges){
            if(edge.getDest().getName().equals( node2)) return edge.getLabel();
        }
        return null;
    }
}
