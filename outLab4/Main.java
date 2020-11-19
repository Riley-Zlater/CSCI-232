package outLab4;

import java.io.*;
import java.util.*;

/**
 * This is the main java driver class.
 * 
 * @author Ara Megerdichian
 * 
 * @author Riley Slater
 *
 */

public class Main {

    public static void main(String[] args) {
        String d_directory;
        String input_directory;
        
        // try and get the input files from the cmd line
        
        try {
            d_directory = args[0];
            input_directory = args[1];
            System.out.println("Inputted dictionary directory: " + d_directory);
            System.out.println("Inputted input file directory: " + input_directory);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid arguments entered.");
            d_directory = "null";
            input_directory = "null";
        }
        System.out.println("\nReading files...");

        // Reads file, in hindsight the file reading and formatting 
        // should've been done in a separate java class.
        
        String out_file_name = "C:\\Users\\Ara\\OneDrive\\Java_232_Projects_(OneDrive)\\Text_Files\\output.txt";
        BufferedReader dictionary_reader;
        BufferedReader input_reader;
        TrieST<String> trie = new TrieST<>();
        try {
            dictionary_reader = new BufferedReader(new FileReader(d_directory));
            String d_word = dictionary_reader.readLine();
            while (d_word != null) {
                trie.put(d_word, d_word);
                d_word = dictionary_reader.readLine();
            }
            dictionary_reader.close();
            input_reader = new BufferedReader(new FileReader(input_directory));
            PrintWriter out_file = new PrintWriter(new FileWriter(out_file_name));
            String line = input_reader.readLine();
            while (line != null) {
                String[] word_array = line.split(" ");
                for (String word : word_array) {
                    word = word.toLowerCase();
                    word = word.replaceAll("[^a-zA-Z ]", "");
                    
                    // Search the Trie only if the word we come across is NOT already in the Trie
                    
                    if(!trie.contains(word)) {
                        ArrayList<String> list = new ArrayList<>();
                        
                        // Use the keys with prefix method to find all the strings in our 
                        // Trie that have similar prefixes to the misspelled word
                        // Then add thi strings with similar prefixes to a list
                        
                        for(String w: trie.keysWithPrefix(word)) {
                            list.add(w);
                        }
                        
                        // if there are at least 3 words with similar prefixes 
                        // get those words and pass all of our information through the menu
                        
                        if (list.size() >= 3) {
                            String misspelled_word = word;
                            String word1 = list.get(0);
                            String word2 = list.get(1);
                            String word3 = list.get(2);
                            Menu menu = new Menu();
                            String new_word = menu.menu(misspelled_word, word1, word2, word3);
                            out_file.printf("%s ", new_word);
                        } else {
                            System.out.println(word + " not recognized. Printing as is...");
                            out_file.printf("%s ", word);
                        }

                    } else {
                        out_file.printf("%s ", word);
                    }
                }
                out_file.printf("\n");
                line = input_reader.readLine();
            }
            input_reader.close();
            out_file.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Input file corrected in output.txt.\nTerminating program...");
    }
}
