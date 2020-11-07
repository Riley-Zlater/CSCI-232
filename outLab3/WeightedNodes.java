package outLab3;

import java.util.LinkedList;

/**
 * This Java class makes a linked list of the edges and keeps track of which nodes have been visited and which ones haven't.
 * 
 * @author Ara Megerdichian
 *
 * @author Riley Slater
 */

public class WeightedNodes {
	
    // Fields
	
    int n;
    String title;
    private boolean visited;
    LinkedList<WeightedEdges> edges;
    
    // Constructor
    /**
     * This constructs nodes giving them the name of the vertex and an arbitrary title.
     * 
     * @param n Int that is the number for the vertex.
     * @param title String that is the arbitrary title of a specific vertex.
     */
    WeightedNodes(int n, String title) {
        this.n = n;
        this.title = title;
        visited = false;
        edges = new LinkedList<>();
    }

    // Methods
    /**
     * This method is a getter and tells us if a given node has been visited.
     * 
     * @return Returns a boolean.
     */
    boolean wasVisited() {
        return visited;
    }

    /**
     * This method is a setter and will be used to mark if a given vertex or node as been visited.
     */
    void visit() {
        visited = true;
    }

    /**
     * This method is a setter and will be used to mark is a given vertex or node has not been visited.
     */
    void notVisit() {
        visited = false;
    }
}