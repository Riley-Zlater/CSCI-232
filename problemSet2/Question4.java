package problemSet2;

import java.util.ArrayList;

public class Question4 {

	public static void main(String[] args) {
		
		
		//Creative problem 2.3.15: Nuts and Bolts.  
		//You have a mixed pile of n nuts and n bolts and need to quickly find the corresponding pairs of nuts and bolts.  
		//Each nut matches exactly one bolt and each bolt matches exactly one nut.  
		//By fitting a bolt and nut together you can see which is bigger but you cannot directly compare two nuts or two bolts.

		ArrayList<Integer> bolts = new ArrayList<Integer>();
		ArrayList<Integer> nuts = new ArrayList<Integer>();
		
		int[] theBolts = {9, 4, 18, 3, 55};
		int[] theNuts = {55, 18, 9, 4, 3};
		
		for(int j:theBolts) { bolts.add(j);}
		for(int k:theNuts) { nuts.add(k);}
		
		for (int i = 0; i < bolts.size(); i++) {
			
		}

	}

}
