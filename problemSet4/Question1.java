package problemSet4;

import java.io.File;

public class Question1 {

	public static void main(String[] args) {
		File input = new File("C:/Users/riley/desktop/Tiny.txt");
		In in = new In(input);
		Graph G = new Graph(in);
		System.out.println(G);
		CC dfs = new CC(G);
		System.out.print("The number of components is " + dfs.count());
	}

}
