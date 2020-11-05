package outLab3;

import outLab3.EdgeWeightedGraph.Graph;

public class Main {

	public static void main(String[] args) {
		
		int V = 15;
		Graph testGraph = new Graph(V);
		testGraph.newEdge(0,  1, 3);
		testGraph.newEdge(0,  2, 5);
		testGraph.newEdge(1,  3, 7);
		testGraph.newEdge(0,  3, 1);
		testGraph.displayGraph();
	}

}
