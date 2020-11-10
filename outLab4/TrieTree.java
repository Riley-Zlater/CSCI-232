package outLab4;

public class TrieTree {

	static final int WORDS_FILE_SIZE = 10;
	
	static class TrieNodes {
		TrieNodes[] child = new TrieNodes[WORDS_FILE_SIZE];
		
		boolean endWord;
		
		TrieNodes() {
			endWord = false;
			for (int i = 0; i < WORDS_FILE_SIZE; i++) {
				child[i] = null;
			}
		}
		
		static TrieNodes parent;
		
		static void insert(String input) {
			int height;
			int length = input.length();
			int index;
			
			TrieNodes parentShift = parent;
			
			for (height = 0; height < length; height++) {
				index = input.charAt(height) - 'a';
				if (parentShift.child[index] == null)
					parentShift.child[index] = new TrieNodes();
				
				parentShift = parentShift.child[index];
			}
			
			parentShift.endWord = true;
		}
		
		// returns true or false depending on if the input string is found in the trie
		// we want it to return the words similar to the input
		static boolean searchTrie(String input) {
			int height;
			int length = input.length();
			int index;
			TrieNodes parentShift = parent;
			
			for (height = 0; height < length; height++) {
				index = child.charAt(height) - 'a';
				
				if (parentShift.child[index] == null) 
					return false;
				
				parentShift = parentShift.child[index];
			}
			
			return (parentShift != null && parentShift.endWord);
		}
		
	}
	
}
