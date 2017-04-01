
public class ElementGraph {

    private String element1;
    private String field1;
    private String characteristic1;

    private String element2;
    private String field2;
    private String characteristic2;

    private Boolean finalState = false;
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

        if (field1 != null) {
            if (field1.equals("peripheries")) {
                this.finalState = true;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ElementGraph)
            if(this.getElement1().equals(((ElementGraph) obj).element1))
                return true;
            else
                return  false;
        else
            return  false;
    }

    public void setState(boolean value) {
        this.finalState = value;
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

    public Boolean getFinalState() {
        return finalState;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    public static void main(String args[]) {
        System.out.println("ElementGraph");

    }
/*
javac ElementGraph.java

 */

}