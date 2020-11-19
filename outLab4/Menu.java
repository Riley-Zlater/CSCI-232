package outLab4;

import java.util.*;

/**
 * This java class will make the menu for the user to use and fix their spelling mistake.
 * 
 * 
 * @author Ara Megerdichian
 * 
 * @author Riley Slater
 *
 */

public class Menu {

	/**
	 * This constructs the menu for the user. It gives them 3 words that have similar prefixes to the misspelled word
	 * then corrects and overwrites the misspelled word.
	 * 
	 * @param misspelled_word String that is the word found in the file that's not found in the Trie of correct words
	 * @param word1 String that is the first key with prefix result.
	 * @param word2 String that is the second key with prefix result.
	 * @param word3 String that is the third key with prefix result.
	 * @return The corrected word as a String.
	 */
    public String menu(String misspelled_word, String word1, String word2, String word3) {
        int option;
        String new_word = "";
        System.out.printf("\nMisspelled word detected: %s\n%s\n 1. %s\n 2. %s\n 3. %s\n 0. %s\n%s\n",
                misspelled_word, "Did you mean: ", word1, word2, word3, "Something else.",
                "Enter desired option below.");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option) {
            case 1:
                new_word = word1;
                System.out.println("Replacing " + misspelled_word + " with " + new_word + "...");
                break;
            case 2:
                new_word = word2;
                System.out.println("Replacing " + misspelled_word + " with " + new_word + "...");
                break;
            case 3:
                new_word = word3;
                System.out.println("Replacing " + misspelled_word + " with " + new_word + "...");
                break;
            case 0:
                System.out.println("Enter desired word below.");
                new_word = scanner.next();
                System.out.println("Replacing " + misspelled_word + " with " + new_word + "...");
                break;
            default:
                System.out.println("Invalid input detected.");
                new_word = menu(misspelled_word, word1, word2, word3);
                break;
        }
        scanner.close();
        return new_word;   
    }

}
