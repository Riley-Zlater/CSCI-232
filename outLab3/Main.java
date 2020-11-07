package outLab3;

import java.io.*;
import java.util.*;

public class Main {

    // Laptop: C:\Users\aramj\OneDrive\Java_232_Projects_(OneDrive)\Text_Files\rome99.gr
    // Desktop: C:\Users\Ara\OneDrive\Java_232_Projects_(OneDrive)\Text_Files\rome99.gr

    public static void main(String[] args) throws IOException {

        // Variable initializations
        WeightedGraph graph = new WeightedGraph(false);
        int size;
        String top_string = "";
        String file_directory;
        boolean cont = true;
        Scanner scanner = new Scanner(System.in);

        // Checks number of arguments entered in command prompt
        try {
            file_directory = args[0];
            System.out.println("Inputted directory: " + file_directory);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid arguments entered.");
            file_directory = "null";
        }

        // Reads file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file_directory));
            String line = reader.readLine();
            while (line != null) {
                String[] line_array = line.split(" ");  // splits line into array of individual strings by spaces

                if (line_array[0].equals("p")) {
                    size = Integer.parseInt(line_array[2]);
                    top_string = "\nThe current graph has vertices from 1 to " + size + ".";

                } else if (line_array[0].equals("a")) {
                    int n1 = Integer.parseInt(line_array[1]);   // Pulls n1
                    int n2 = Integer.parseInt(line_array[2]);   // Pulls n2
                    double weight = Integer.parseInt(line_array[3]);    // Pulls weight
                    WeightedNode node_1 = new WeightedNode(n1, line_array[1]);  // Converts n1 to a node
                    WeightedNode node_2 = new WeightedNode(n2, line_array[2]);  // Converts n2 to a node
                    graph.addEdge(node_1, node_2, weight);
                    graph.addEdge(node_2, node_1, weight);
                    //Test print: System.out.println(node_1.toString() + " -> " + node_2.toString());
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        // Test print: graph.printEdges();

        while(cont) {
            // prints ui
            System.out.println(top_string);
            System.out.println("Below are a list of possible functions \n");
            System.out.println(" 1. Find new route \n 2. Terminate program \n");
            System.out.println("Enter number for desired option below. ");

            int input = scanner.nextInt();  // user-inputted option selection
            switch (input) {
                case 1:
                    // runs function
                    System.out.println("Enter source location: ");
                    String input_source = scanner.next();   // input of desired source node name
                    System.out.println("Enter desired destination: ");
                    String input_destination = scanner.next();  // input of desired destination node name
                    System.out.println("User entered " + input_source + " as source and " + input_destination + " as destination.");
                    System.out.println("Finding shortest route from " + input_source + " to " + input_destination + "...");

                    // searches graph for nodes of inputted titles
                    WeightedNode source = graph.search_nodes(input_source);
                    WeightedNode destination = graph.search_nodes(input_destination);
                    // prints if either input doesn't exist
                    if (source == null || destination == null) {
                        System.out.println("No nodes found");
                    }

                    // Runs graph function and calculates time to completion
                    long start_time = System.currentTimeMillis();
                    graph.DijkstraShortestPath(source, destination);
                    long stop_time = System.currentTimeMillis();
                    long total_time = (stop_time - start_time);
                    graph.resetNodesVisited();
                    System.out.println("Time to find: " + total_time + " milliseconds.");
                    break;
                case 2:
                    // terminates program
                    System.out.println("Program terminated");
                    cont = false;
                    break;
                default:
                    // prints invalid input message
                    System.out.println("Invalid input. Rerunning function... ");
            }

        }

    }
}
