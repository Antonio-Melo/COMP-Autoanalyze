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
 
//TODO **DEALING WITH SYNTACTIC ERRORS: (Describe how the syntactic error recovery of your tool does work. Does it exit after the first error?)
 
//TODO **SEMANTIC ANALYSIS: (Refer the possible semantic rules implemented by your tool.)
A nossa ferramenta respeita as regras de um ficheiro tipo dotyfile, 
como no achamos relevante a utilização de todas as palavras reservadas da gramatica utilizamos apenas as mais importantes.
Tais como, a palavra label para caracterizar uma aresta e um nó, a palavra periferies para representar o estado final de um nó.
A linguagem de ficheiro dotyfiles utilizam palavras reservadas para alterar a espessura a  cor e a forma dos nó mas para a ferramenta que utilizamos não é necessário.
 
//TODO **INTERMEDIATE REPRESENTATIONS (IRs): (for example, when applicable, briefly describe the HLIR (high-level IR) and the LLIR (low-level IR) used, if your tool includes an LLIR with structure different from the HLIR)
 
//TODO **CODE GENERATION: (when applicable, describe how the code generation of your tool works and identify the possible problems your tool has regarding code generation.)
 A nossa ferramenta por cada construção de aresta, alteração do estado final de um nó e por cada alteração de um nome do nó gera uma chamada à função NodeGraph do ficheiro ValidateFile.
 Em cada iteração são utilizadas obrigatóriamente 5 variavéis,podendo algumas destas não serem utilizadas durante a execução da função, dependendo da operação a realizar no nó
 Para além disso, são criadas mais uma ou duas variavéis relativamente ao nó que estamos a tratar, podendo ser dois no caso de se tratar de uma operaçao com arestas ou simplesmente um nos outros caso.
 O principal problema na nossa quantidade de variaveis utilizadas na nossa analise semantica é à chamas recursivamente à nossa função NodeGraph,
 pois em cada nova iteração tratada aumenta o número de variaveis utilizadas, mas quanto a isso não existe forma de controlar a situação pois a unica maneira de guardar a informaçao toda que queremos para a possivel analise
é apenas possivel utilizando esta forma. 
 
 
**OVERVIEW: (refer the approach used in your tool, the main algorithms, the third-party tools and/or packages, etc.)
As a way of representing .dot files in images in order to facilitate the testing process, we decided to use GraphViz, an open source graph visualization
tool. It can read .dot files and convert them to a desired image format, which in our case is .png. However, this is command line based, and as such
in order to integrate it with our Java program we decided to use a simple API by Github user jabbalaci that can be consulted in the following link https://github.com/jabbalaci/graphviz-java-api.
 
**TESTSUITE AND TEST INFRASTRUCTURE: (Describe the content of your testsuite regarding the number of examples, the approach to automate the test, etc.)
 
//TO BE COMPLETED **TASK DISTRIBUTION:
António Melo, 201403053
- Cartesian Product operation
- Interface in swing
-

Lázaro Costa, 201405342
- Intersection operation
- Complement  operation
- parser in javacc

Maria de Abreu, 201306229
- integration with GraphViz API;
- union operation;
- reversal operation
 
**PROS: (Identify the most positive aspects of your tool)
 
**CONS: (Identify the most negative aspects of your tool)