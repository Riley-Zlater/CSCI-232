package outLab3;

import java.util.*;

public class DijkstraPQ {
	private int weight[];
	private Set<Integer> placement;
	private PriorityQueue<Node> myPQ;
	private int vertices;
	ArrayList<ArrayList<Node>> adjacency;
	
	private void neighborhood(int u) {
		int edgeWeight = -1;
		int newWeight = -1;
		
		for (int i = 0; i < adjacency.get(u).size(); i++) {
			Node current = adjacency.get(u).get(i);
			
			if (!placement.contains(current.node)) {
				edgeWeight = current.next;
				newWeight = weight[u] + edgeWeight;
				
				if (newWeight < weight[current.node]) {
					weight[current.node]= newWeight;
				}
				myPQ.add(new Node(current.node, weight[current.node]));
			}
		}
	}
	
	public DijkstraPQ(int vertices) {
		this.vertices = vertices;
		weight = new int[vertices];
		placement = new HashSet<Integer>();
		myPQ = new PriorityQueue<Node>(vertices, new Node());
	}
	
	public void dijkstra(ArrayList<ArrayList<Node>> adjancency, int source, int end) {
		
		for (int i = 0; i < vertices; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		
		myPQ.add(new Node(source, 0));
		
		weight[source] = 0;
		while (placement.size() != vertices) {
			int u = myPQ.remove().node;
			placement.add(u);
			neighborhood(u);
		}
	}
}
