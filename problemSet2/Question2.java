package problemSet2;

import java.util.PriorityQueue;

public class Question2 {

	public static void main(String[] args) {
		

		// Suppose you have a very large data set that contains n numbers (more than can fit into main memory) and you want to find the largest k that are present.  
		// How can you use a min-heap to solve this problem?  Hint: make sure no more than k+1 numbers are in the min-heap at any time.
		
		// int[] m = {9, 8, 7, 6, 5, 4, 3, 2, 1}; // fake data set to test the problem
		int[] n = {55, 22, 453, 432, 453, 41, 34, 665, 767, 7644 ,632, 43, 5, 63}; // fake data set to test the problem
		int k = 4;	// total number present
		
		PriorityQueue<Integer> myPQ = new PriorityQueue<>(); // create the min heap or priority queue
		
		for (int i:n) { // loop through the data set of size n
			myPQ.add(i); // add each element from the data set to the min heap
			if (myPQ.size() > k) { // when the min-heap reaches the largest present (I assume this would be the maximum our memory could hold at once)
				myPQ.poll();	   // before adding the next element from the data set it removes the smallest element keeping our min heap the same size
			}					   // and leaving us with only the largest elements from the data set
		}
		
		System.out.println(myPQ);
		
	}

}
