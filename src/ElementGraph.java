package src;
public class ElementGraph {

    private String element1;
    private String field1;
    private String characteristic1;

    private String element2;
    private String field2;
    private String characteristic2;

    /*

    digraph G2
{
    a -> b [label= hello ];
    a -> c [label="world"];
    c -> d;
    b -> c;
    d -> a;
    b [label=this];
    c [peripheries=2];
}*/

/*
    public ElementGraph(String nameGraph) {
        this.element1 = nameGraph;

        this.element1 = null;
        this.field1 = null;
        this.characteristic1 = null;
        this.element2 = null;
        this.field2 = null;
        this.characteristic2 = null;

    }*/

    public ElementGraph(String el1, String field1, String charact1, String el2, String field2, String charact2) {

        this.element1 = el1;
        this.field1 = field1;
        this.characteristic1 = charact1;

        this.element2 = el2;
        this.field2 = field2;
        this.characteristic2 = charact2;

    }

    public String getElement1() {
        return element1;
    }

    public String getField1() {
        return field1;
    }

    public String getCharacteristic1() {
        return characteristic1;
    }

    public String getElement2() {
        return element2;
    }

    public String getField2() {
        return field2;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    @Override
    public String toString() {
        return "ele1='" + element1 + '\'' +
                ", field1='" + field1 + '\'' +
                ", chara1='" + characteristic1 + '\'' +
                ", ele2='" + element2 + '\'' +
                ", field2='" + field2 + '\'' +
                ", chara2='" + characteristic2;
    }


    public static void main(String args[]) {

    }
    /*
javac ElementGraph.java

 */

}