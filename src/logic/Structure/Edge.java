package logic.Structure;

public class Edge {

    private Node source;
    private Node dest;
    private String field;
    private String charat;


    public Edge(Node source, Node dest, String field, String charat) {
        this.source = source;
        this.dest = dest;
        this.field = field;
        this.charat = charat;
    }

    public Edge(Node source, Node dest) {
        this.source = source;
        this.dest = dest;
        this.field = null;
        this.charat = null;
    }

    public Node getSource() {
        return source;
    }

    public Node getDest() {
        return dest;
    }

    public String getField() {
        return field;
    }

    public String getCharat() {
        return charat;
    }
}