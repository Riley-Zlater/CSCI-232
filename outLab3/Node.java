package outLab3;

import java.util.Comparator;

public class Node implements Comparator<Node> {
	public int node;
	public int next;
	
	public Node() {}
	public Node(int node, int next) {
		this.node = node;
		this.next = next;
	}
	
	@Override
	public int compare(Node node1, Node node2) {
		if (node1.next < node2.next) {
			return -1;
		}
		if (node1.next > node2.next) {
			return 1;
		}
		return 0;
	}

}
