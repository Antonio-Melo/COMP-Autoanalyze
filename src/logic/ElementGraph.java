public class ElementGraph {

    private String element1;
    private String field1;
    private String characteristic1;

    private String element2;
    private String field2;
    private String characteristic2;

    public ElementGraph(String nameGraph) {
        this.element1 = nameGraph;

        this.element1 = null;
        this.field1 = null;
        this.characteristic1 = null;
        this.element2 = null;
        this.field2 = null;
        this.characteristic2 = null;

    }

    public ElementGraph(String el1, String field1, String charact1, String el2, String field2, String charact2) {

        this.element1 = el1;
        this.field1 = field1;
        this.characteristic1 = charact1;

        this.element2 = el2;
        this.field2 = field2;
        this.characteristic2 = charact2;
    }

}