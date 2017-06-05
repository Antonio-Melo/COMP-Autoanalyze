package logic.Operations;

import logic.Structure.Graph;
import logic.Structure.Node;
import logic.Structure.Edge;

import java.util.ArrayList;

public class LanguageAnalysis 
{
	public static String getRegularExpression(Graph graph) {
        String regExp = "";

        for (Edge edge : graph.getEdges()) {
            Node dest = edge.getDest();
            Node src = edge.getSource();

            edge.setDest(src);
            edge.setSource(dest);
        }
        return regExp;
	}
}
