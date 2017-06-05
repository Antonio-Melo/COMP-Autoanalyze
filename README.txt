**PROJECT TITLE: Autoanalyze

**GROUP: G19
//TODO NAME1: Antonio Melo, NR1: 201403053, GRADE1: <0 to 20 value>, CONTRIBUTION1: <0 to 100 %>;
//TODO NAME2: Lazaro Costa, NR2: 201405342, GRADE2: <0 to 20 value>, CONTRIBUTION2: <0 to 100 %>;
//TODO NAME3: Maria de Abreu, NR3: 201306229, GRADE3: <0 to 20 value>, CONTRIBUTION3: <0 to 100 %>;

 
** SUMMARY: 
Our tool is able to read automata from .dot files and to perform some analysis and also some operations.
The analysis performed consists of reporting the language accepted by the automata (or if the automata only accepts the empty string or set),
and if it accepts if all the words of a given alphabet.
Moreover, our tool also supports operations on automata such as reversal, cartesian product (these only require the input of one automata),
but also intersection, union and complement (these last ones require the input of two automata). 
As it finishes all commands, it writes the output automata (after operations) to another .dot file and displays the automata in an image, in .png format.
 
//TODO ** EXECUTE:

 
**DEALING WITH SYNTACTIC ERRORS: (Describe how the syntactic error recovery of your tool does work. Does it exit after the first error?)
This tool uses specific language of the dot type, and in the syntactic analysis certain tokens are expected specifically, and when they
aren't found, the parser throws an exception where the error ocurred. This exception is treated in the application and displayed to the
user with the corresponding syntactic error message.
 
**SEMANTIC ANALYSIS: (Refer the possible semantic rules implemented by your tool.)
Our tool obeys the semantic rules of a .dot file. 
We didn't find all the reserved grammar words relevant to our project, so we used a few selected ones which we consider the most important, such as "label" in order to identificate an edge and node, "periferies" in order to represent the final/accepting state of an automata by adding an extra circle to the node.
In addition to the words we used, it's possible to modify the thickness, color and shape of nodes for an example but we didn't think these were necessary to our project.
 
**INTERMEDIATE REPRESENTATIONS (IRs): (for example, when applicable, briefly describe the HLIR (high-level IR) and the LLIR (low-level IR) used, if your tool includes an LLIR with structure different from the HLIR)
Our high level intermediate representation consists of the data in a graph-like structure, reading from the dot file and then saving all that
data to nodes, edges and labels. 
As such, a Graph is constituted by its name (a string) and an ArrayList of nodes.
Nodes can have a name, a label, an ArrayList of Edges and a boolean that reveals whether the state is an accepting state or not.
Edges are the connections between nodes and have a label, a source Node and a destination Node, representing the transitions between
states in the automata.

**CODE GENERATION: (when applicable, describe how the code generation of your tool works and identify the possible problems your tool has regarding code generation.)
 Our tool generates a call to the NodeGraph method of the ValidateFile file per each edge that is constructed, per each final state toggling and per node's name alteration.
 In each iteration five variables are mandatorily used, but some of these might not be used during the method's execution, depending on the operation to be performed. In addition to these, more variables will be created related to the current node, two in the case of the operation dealing with edges or simply one new variable for other cases.
 Our main problem regarding the amount of variables used in semantic analysis is related to the recursive calls to the NodeGraph method, since with each iteration the number of variables increases, but it's a necessary evil because it's the only way of saving all the information for the possible analysis.
 
**OVERVIEW: (refer the approach used in your tool, the main algorithms, the third-party tools and/or packages, etc.)
As a way of representing .dot files in images in order to facilitate the testing process, we decided to use GraphViz, an open source graph visualization
tool. It can read .dot files and convert them to a desired image format, which in our case is .png. However, this is command line based, and as such
in order to integrate it with our Java program we decided to use a simple API by Github user jabbalaci that can be consulted in the following link https://github.com/jabbalaci/graphviz-java-api.
 
**TESTSUITE AND TEST INFRASTRUCTURE: (Describe the content of your testsuite regarding the number of examples, the approach to automate the test, etc.)
 
//TO BE COMPLETED **TASK DISTRIBUTION:
Antonio Melo, 201403053
- Cartesian product operation
- Interface in Swing
-

Lazaro Costa, 201405342
- Intersection operation
- Complement  operation
- Parser in javacc

Maria de Abreu, 201306229
- Integration with GraphViz API;
- Union operation;
- Reversal operation
 
**PROS: (Identify the most positive aspects of your tool)
The language used in order to represent the automata is simple and easy to use.
Thanks to the integration of the Swing interface, it's possible to operate on 
the automata easily and in an interactive way, displaying the image results thanks
to the integration with the GraphViz API.


**CONS: (Identify the most negative aspects of your tool)
We didn't think adding colours and different thickness to the node's borders would
be very relevant to our project's main goal (analysing and operating on automata), 
however with large dimension input data the images generated can be a bit illegible.



