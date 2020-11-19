package outLab4;

import java.util.*;

public class Menu {

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
