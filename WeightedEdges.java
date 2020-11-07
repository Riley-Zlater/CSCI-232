package outLab3;

/**
 * This Java class creates the weighted edges that we will be using in the graph.
 * 
 * @author Ara Megerdichian
 * 
 * @author Riley Slater
 */

public class WeightedEdges {

	// Fields
	
    WeightedNodes source;
    WeightedNodes destination;
    double weight;

    // Constructor
    /**
     * This constructs a weighted edge.
     * 
     * @param s Node that is our starting, root, or source vertex.
     * @param d Node that is our destination or end vertex.
     * @param w Int that is the weight of the edge between the s and d.
     */
    WeightedEdges(WeightedNodes s, WeightedNodes d, double w) {
        source = s;
        destination = d;
        weight = w;
    }

    // Methods
    /**
     * This method overrides the default toString method and helps format the output in a more readable way.
     */
    @Override
    public String toString() {
        return String.format("(%s -> %s, %f)", source.title, destination.title, weight);
    }  
}