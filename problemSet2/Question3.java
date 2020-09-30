package problemSet2;

import java.util.Random;
import java.util.Dictionary;
import java.util.Hashtable;

public class Question3 {

	public static void main(String[] args) {
		
		// args[0] = R, integer corresponding to the range of randomness in the integers 0 to R - 1
		// args[1] = N, integer corresponding to the number of random integers that will be generated.
		
		
		Random rand = new Random();
		Dictionary<Integer, Integer> dict = new Hashtable<Integer, Integer>();

		int R = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		
		for (int i = 0; i < N; i++) { 
			dict.put(i, rand.nextInt(R));
		}
		
		System.out.println(dict.size());
		
		// This code will display all the random numbers that are generated.
		//for (int j = 0; j < args[1]; j++) {
		//	System.out.println(dict.get(j));
		//}
		
	}

}
