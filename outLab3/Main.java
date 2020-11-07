package outLab3;

public class Main {
    public static void main(String[] args) {
        WeightedGraph WeightedGraph = new WeightedGraph(false);
        WeightedNodes zero = new WeightedNodes(0, "0");
        WeightedNodes one = new WeightedNodes(1, "1");
        WeightedNodes two = new WeightedNodes(2, "2");
        WeightedNodes three = new WeightedNodes(3, "3");
        WeightedNodes four = new WeightedNodes(4, "4");
        WeightedNodes five = new WeightedNodes(5, "5");
        WeightedNodes six = new WeightedNodes(6, "6");

        // Our addEdge method automatically adds Nodes as well.
        // The addNode method is only there for unconnected Nodes,
        // if we wish to add any
        WeightedGraph.addEdge(zero, one, 8);
        WeightedGraph.addEdge(zero, two, 11);
        WeightedGraph.addEdge(one, three, 3);
        WeightedGraph.addEdge(one, four, 8);
        WeightedGraph.addEdge(one, two, 7);
        WeightedGraph.addEdge(two, four, 9);
        WeightedGraph.addEdge(three, four, 5);
        WeightedGraph.addEdge(three, five, 2);
        WeightedGraph.addEdge(four, six, 6);
        WeightedGraph.addEdge(five, four, 1);
        WeightedGraph.addEdge(five, six, 8);

        WeightedGraph.DijkstraSP(zero, six);
    }
}
