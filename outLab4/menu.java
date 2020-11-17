import java.util.*;

public class Menu {

    public String menu(String misspelled_word, String word1, String word2, String word3) {
        int option;
        String new_word = "";
        System.out.printf("%s: %s\n 1. %s\n 2. %s\n 3. %s\n 0. %s\n%s\n",
                misspelled_word, "did you mean: ", word1, word2, word3, "Something else.",
                "Enter desired option below.");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option) {
            case 1:
                new_word = word1;
                break;
            case 2:
                new_word = word2;
                break;
            case 3:
                new_word = word3;
                break;
            case 0:
                System.out.println("\nEnter desired word below.");
                new_word = scanner.nextLine();
                // TODO check dictionary
                break;
            default:
                System.out.println("Invalid input detected.");
                new_word = menu(misspelled_word, word1, word2, word3);
                break;
        }
        return new_word;
    }

}
