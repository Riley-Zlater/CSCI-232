package outLab3;

import java.util.*;

/**
 * This Java file makes an edge weighted graph and implements Dijkstra's algorithm.
 * 
 * @author Ara Megerdichian
 *
 * @author Riley Slater
 */

public class WeightedGraph {
    private Set<WeightedNodes> nodes;
    private boolean directed;

    // Constructor
    /**
     * This constructs a weighted graph as a hash set of nodes.
     * 
     * @param directed Boolean that tells whether the graph is directed or undirected.
     */
    WeightedGraph(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }

    // Methods
    /**
     * This method adds each node to the hash set.
     * 
     * @param n Node that is being added to the hash set.
     */
    public void addNode(WeightedNodes... n) {
        nodes.addAll(Arrays.asList(n));
    }

    /**
     * This method lets us add an edge between two nodes.
     * 
     * @param source Node that we're starting from.
     * @param destination Node that we're going to.
     * @param weight Double the weight of the edge between the source and destination.
     */
    public void addEdge(WeightedNodes source, WeightedNodes destination, double weight) {
        nodes.add(source);
        nodes.add(destination);

        edgeHelper(source, destination, weight);

        if (!directed && source != destination) {
            edgeHelper(destination, source, weight);
        }
    }

    /**
     * This method is a helper method to the addEdge method that makes sure there's no duplicate edges.
     * 
     * @param a Node that will be our source to test for duplicates.
     * @param b Node that will be our destination to test for duplicates.
     * @param weight Double that is the weight of the edge between Nodes a and b.
     */
    private void edgeHelper(WeightedNodes a, WeightedNodes b, double weight) {
        for (WeightedEdges edge : a.edges) {
            if (edge.source == a && edge.destination == b) {
                edge.weight = weight;
                return;
            }
        }
        a.edges.add(new WeightedEdges(a, b, weight));
    }

    /**
     * This method formats and displays the edges between the Nodes.
     */
    public void printEdges() {
        for (WeightedNodes node : nodes) {
            LinkedList<WeightedEdges> edges = node.edges;

            if (edges.isEmpty()) {
                System.out.println("Node " + node.title + " has no edges.");
                continue;
            }
            System.out.print("Node " + node.title + " has edges to: ");

            for (WeightedEdges edge : edges) {
                System.out.print(edge.destination.title + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    /**
     * This method check to see if an edge exists between two Nodes.
     * 
     * @param source Node that we're starting our test for an edge from.
     * @param destination Node we're ending our test for an edge.
     * @return Boolean whether or not there is an edge between the given Nodes.
     */
    public boolean hasEdge(WeightedNodes source, WeightedNodes destination) {
        LinkedList<WeightedEdges> edges = source.edges;
        for (WeightedEdges edge : edges) {
            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }

    /**
     * Setter that sets the visited status of all the Nodes back to false.
     */
    public void resetNodesVisited() {
        for (WeightedNodes node : nodes) {
            node.notVisit();
        }
    }

    /**
     * This method does an iterative search through the Nodes to find a specific Node.
     * 
     * @param target Node that we are looking to find.
     * @return Node that is being searched for.
     */
    public WeightedNodes searchNodes(String target) {
        for (WeightedNodes node: nodes) {
            if (node.title.equals(target)) {
                return node;
            }
        }
        return null;
    }

    /**
     * This method implements the Dijkstra's algorithm.
     * 
     * @param start Node that we begin the shortest path search at.
     * @param end Node that we're looking to find the shortest path to.
     */
    public void DSP(WeightedNodes start, WeightedNodes end) {
        HashMap<WeightedNodes, WeightedNodes> changeSpot = new HashMap<>();
        changeSpot.put(start, null);

        HashMap<WeightedNodes, Double> shortestPath = new HashMap<>();

        for (WeightedNodes node : nodes) {
            if (node == start)
                shortestPath.put(start, 0.0);
            else shortestPath.put(node, Double.POSITIVE_INFINITY);
        }

        for (WeightedEdges edge : start.edges) {
            shortestPath.put(edge.destination, edge.weight);
            changeSpot.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            WeightedNodes currentNode = closestReachableNotVisited(shortestPath);
            
            if (currentNode == null) {
                System.out.println("\nThere isn't a path between " + start.title + " and " + end.title);
                return;
            }

            if (currentNode == end) {
                System.out.println("\nThe path with the smallest weight between "
                        + start.title + " and " + end.title + " is:");

                WeightedNodes child = end;

                String path = end.title;
                while (true) {
                    WeightedNodes parent = changeSpot.get(child);
                    if (parent == null) {
                        break;
                    }

                    path = parent.title + " -> " + path;
                    child = parent;
                }
                System.out.println(path);
                System.out.println("Total distance: " + shortestPath.get(end));
                return;
            }
            currentNode.visit();

            for (WeightedEdges edge : currentNode.edges) {
                if (edge.destination.wasVisited())
                    continue;

                if (shortestPath.get(currentNode)
                        + edge.weight
                        < shortestPath.get(edge.destination)) {
                    shortestPath.put(edge.destination,
                            shortestPath.get(currentNode) + edge.weight);
                    changeSpot.put(edge.destination, currentNode);
                }
            }
        }
    }

    /**
     * This is a helper method for the Dijkstra's algorithm that checks to see which Nodes have
     * edges connected to the current not and of those edges which have not been visited.
     * 
     * @param shortestPath Hash map of the smallest weighted edges of Nodes on our path.
     * @return Node that has not been visited and is the smallest weight.
     */
    private WeightedNodes closestReachableNotVisited(HashMap<WeightedNodes, Double> shortestPath) {

        double shortestDistance = Double.POSITIVE_INFINITY;
        WeightedNodes closestReachableNode = null;
        for (WeightedNodes node : nodes) {
            if (node.wasVisited())
                continue;

            double currentDistance = shortestPath.get(node);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }
        return closestReachableNode;
    }
}
