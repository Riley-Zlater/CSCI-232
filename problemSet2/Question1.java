package problemSet2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Question1 {

	public static void main(String[] args) {
		PriorityQueue<Character> myPQ = new PriorityQueue<>(Collections.reverseOrder());
		
		char[] test = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
		
		for(char i: test) { myPQ.add(i);}
		
		System.out.println(myPQ);

	}

}
