package logic.Structure;

import java.util.Objects;

public class Edge {

    private Node source;
    private Node dest;
    private String label;


    public Edge(Node source, Node dest, String label) {
        this.source = source;
        this.dest = dest;
        this.label = label;
    }

    public Edge(Node source, Node dest) {
        this.source = source;
        this.dest = dest;
        this.label = null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;
        String sourceName2 = edge.getSource().getName();
        String destName2 = edge.getDest().getName();
        String charat2 = edge.getLabel();


        if(!source.getName().equals(sourceName2))
            return false;


       if(!dest.getName().equals(destName2)){
           return false;
       }

       if(!label.equals(charat2)){
           return false;

       }
       return true;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (dest != null ? dest.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    public Node getSource() {
        return source;
    }

    public Node getDest() {
        return dest;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source.getName() +
                ", dest=" + dest.getName() +
                ", label='" + label + '\'' +
                '}';
    }
}