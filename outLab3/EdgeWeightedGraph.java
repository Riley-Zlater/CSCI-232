package outLab3;

import java.util.*;

public class EdgeWeightedGraph {
	static class Edge {
		int source;
		int end;
		int weight;
		
		public Edge(int source, int end, int weight) {
			this.source = source;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static class Graph {
		int vertices;
		LinkedList<Edge> [] adjacencyList;
		
		Graph(int vertices) {
			this.vertices = vertices;
			adjacencyList = new LinkedList[vertices];
			
			for (int i = 0; i < vertices; i++) {
				adjacencyList[i] = new LinkedList<>();
			}
		}
		
		public void newEdge(int source, int end, int weight) {
			Edge edge = new Edge(source, end, weight);
			adjacencyList[source].addFirst(edge);
		}
		
		public void displayGraph() {
			for (int i = 0; i < vertices; i++) {
				LinkedList<Edge> displayList = adjacencyList[i];
				for (int j = 0; j < displayList.size(); j++) {
					System.out.println("source vertex: " + i + " ---> " + displayList.get(j).end + "   Weight: " + displayList.get(j).weight);
				}
			}
		}
	}

}

