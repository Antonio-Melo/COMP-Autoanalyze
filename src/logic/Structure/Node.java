package logic.Structure;

import java.util.*;

public class Node {
    private String name;
    private String field;
    private String charat;
    private ArrayList<Edge> edges;
    private boolean stateEnd = false;

    public Node(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(Node dest, String field, String charat) {
        edges.add(new Edge(this, dest, field, charat));
    }

    public void addEdge(Node dest) {
        edges.add(new Edge(this, dest));
    }

    public void setStateEnd(boolean stateEnd) {
        this.stateEnd = stateEnd;
    }

    public void setFieldCharate(String field, String charat) {

        if(field.equals("peripheries")&& charat.equals("2"))
            setStateEnd(true);
        else {
            this.field = field;
            this.charat = charat;
        }
    }

    public String getName() {
        return name;
    }

    public boolean getStateEnd() {
        return stateEnd;
    }

    public String getField() {
        return field;
    }

    public String getCharat() {
        return charat;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
