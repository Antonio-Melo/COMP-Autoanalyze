

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Autoanalyse {

    private String path;
    private String operation;
    private ArrayList<ElementGraph> tokens;
    private HashMap<String, Boolean> stateElement;
    private HashMap<String, Boolean> stateResult;


    public Autoanalyse(String args[]) {

     /*   if (args.length != 2) {
            System.out.println("Requerires <path> <opeartion>");
        }
        this.path = args[0];
        this.operation = args[1];
        */
        tokens = new ArrayList<ElementGraph>();
        stateElement = new HashMap<>();
        stateResult = new HashMap<>();


       /* try {
            ValidateFile validateFile = new ValidateFile(System.in);
            validateFile.Start(tokens);

        } catch (Throwable e) {
            System.out.println("Invalid REGEX!\n" + e.getMessage());
            System.exit(1);
        }
        */

     /*   ElementGraph E1 = new ElementGraph("name1", null, null, "name2", "label", "bold");
        ElementGraph E2 = new ElementGraph("name2", null, null, "name3", "label", "bold");
        ElementGraph E3 = new ElementGraph("name3", "peripheries", "2", null, null, null);
        ElementGraph E4 = new ElementGraph("name3", null, null, "name2", "label", "bold");


        E1.getFinalState();
        tokens.add(E1);
        tokens.add(E2);
        tokens.add(E3);
        tokens.add(E4);*/


        this.state();

        this.complement();
    }

    public static void main(String args[]) {

        Autoanalyse auto = new Autoanalyse(args);
    }

    public void state() {

        for (ElementGraph elem : tokens) {
            boolean finalState = false;

            for (ElementGraph elemIn : tokens) {

                if (elem.equals(elemIn))
                    finalState = finalState || elemIn.getFinalState();
            }

            elem.setState(finalState);
             System.out.println("result" + elem.getElement1() + finalState);
            stateElement.put(elem.getElement1(), finalState);

        }
        System.out.println(stateElement.size());

    }

    public void complement(){

        Set<String> chaves = stateElement.keySet();
        for (String chave : chaves){

            Boolean result =  ! stateElement.get(chave);
            stateResult.put(chave,result);

            System.out.println("result" + chave +  result);
        }
    }
}

/* #### NAO APAGAR  ###################################

javac Autoanalyse.java
java Autoanalyse
*/