package logic.Operations;
import logic.Structure.Edge;
import logic.Structure.Graph;
import logic.Structure.Node;

import java.util.ArrayList;

/* possível melhoria: aplicar um algoritmo de minimização de estados no final,
 já que o autómato resultante não estará optimizado */

public class Union 
{
	public static Graph union(Graph graph1, Graph graph2)
	{
		Graph graphResult = new Graph();
		
		ArrayList<Edge> edgesG1 = graph1.getEdges();
		ArrayList<Edge> edgesG2 = graph2.getEdges();
		
		for(Edge edge:edgesG1)
		{
			Node nodeSrc= edge.getSource();
			Node nodeDst = edge.getDest();
			
			if(!graphResult.getNodes().contains(nodeSrc))
				graphResult.addNode(nodeSrc);
			else
			{
				if(!graphResult.getEdges().contains(nodeDst))
					nodeSrc.addEdge(nodeDst);
			}
		}
		
		for(Edge edge2:edgesG2)
		{
			Node nodeSrc2= edge2.getSource();
			Node nodeDst2 = edge2.getDest();

			if(!graphResult.getNodes().contains(nodeSrc2))
				graphResult.addNode(nodeSrc2);
			else
			{
				if(!graphResult.getEdges().contains(nodeDst2))
					nodeSrc2.addEdge(nodeDst2);
			}
		}
		return graphResult;
	}
}
