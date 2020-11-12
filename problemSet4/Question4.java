package problemSet4;

import java.io.File;

public class Question4 {

	public static void main(String[] args) {
		File input = new File("C:/Users/riley/desktop/TinyEWG.txt");
		In in = new In(input);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		PrimMST MST = new PrimMST(G);
		System.out.println(MST.edges()+"\n");
		
		System.out.println("I used the PrimMST and I'm not sure how to delete a vertex.");
	
	}

}
