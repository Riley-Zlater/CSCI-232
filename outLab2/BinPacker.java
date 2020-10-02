package outLab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

/**
 * This file makes all of the different fits of the bin packing problem
 * and has the main.
 * @author Ara Megerdichian and Riley Slater
 *
 */

public class BinPacker {

	/**
	 * This method does the first fit of the bin packing problem.
	 * It will add to the first bin until capacity would be exceeded,
	 * then creates a new bin and so on.
	 * @param next_input An integer being added to the bin.
	 * @param capacity An integer the total amount the bin can hold.
	 * @param bin_array An array list using bins so we can have a dynamic amount of bins.
	 * @return The current bin or a new bin if one was made.
	 */
    static Bin firstFit(int next_input, int capacity, ArrayList<Bin> bin_array) {
        Bin bin;
        try {
            bin = bin_array.get(bin_array.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            bin_array.add(new Bin(0, capacity, 0));
            bin = bin_array.get(bin_array.size() - 1);
        }
        if (next_input < bin.getRemaining()) {
            bin.setOccupancy(bin.getOccupancy() + next_input);
            bin.setRemaining(bin.getRemaining() - next_input);
            return bin;
        } else {
            Bin new_bin = new Bin();
            new_bin.setBin_number(bin.getBin_number() + 1);
            new_bin.setCapacity(capacity);
            new_bin.setRemaining(capacity - next_input);
            new_bin.setOccupancy(next_input);
            bin_array.add(new_bin);
            return new_bin;
        }
    }

    /**
     * This method performs the best fit of the bin packing problem.
     * It runs the same as first fit the only difference is if
     * a previous bin has enough remaining space to accommodate the 
     * new input it will place it into the existing bin before creating a new one.
     * This method also uses a binary search tree as a data structure to sort the bins
     * based on amount remaining.
     * @param next_input The integer being added to the bins.
     * @param capacity An integer that is the total amount of the bin.
     * @param bin_array A dynamic array list of bins.
     * @return The current bin or a new on if need be.
     */
    static Bin bestFit(int next_input, int capacity, ArrayList<Bin> bin_array) {
        if (bin_array.isEmpty()) {
            bin_array.add(new Bin(0, capacity, 0));
        }
        BinarySearchTree bst = new BinarySearchTree();
        for (Bin bin: bin_array) {
            bst.add(bin);
        }
        ArrayList<Bin> bin_list = bst.traverse();
        for (Bin bin: bin_list) {
            if (bin.getRemaining() >= next_input) {
                bin.setOccupancy(bin.getOccupancy() + next_input);
                bin.setRemaining(bin.getRemaining() - next_input);
                return bin;
            }
        }
        Bin new_bin = new Bin();
        new_bin.setBin_number(bin_array.get(bin_array.size() - 1).getBin_number() + 1);
        new_bin.setCapacity(capacity);
        new_bin.setRemaining(capacity - next_input);
        new_bin.setOccupancy(next_input);
        bin_array.add(new_bin);
        return new_bin;
    }

    /**
     * this method is similar to the best fit but instead it looks to
     * add the new item to the existing bin the has the most amount of remaining
     * space. This also uses a binary search tree and sorts by remaining.
     * @param next_input The integer being added to the bin.
     * @param capacity The total amount the bin can hold.
     * @param bin_array A dynamic array list of bins.
     * @return The current bin or a new on if need be.
     */
    static Bin worstFit(int next_input, int capacity, ArrayList<Bin> bin_array) {
        if (bin_array.isEmpty()) {
            bin_array.add(new Bin(0, capacity, 0));
        }
        BinarySearchTree bst = new BinarySearchTree();
        for (Bin bin: bin_array) {
            bst.add(bin);
        }
        ArrayList<Bin> bin_list = bst.reverseTraverse();
        for (Bin bin: bin_list) {
            if (bin.getRemaining() >= next_input) {
                bin.setOccupancy(bin.getOccupancy() + next_input);
                bin.setRemaining(bin.getRemaining() - next_input);
                return bin;
            }
        }
        Bin new_bin = new Bin();
        new_bin.setBin_number(bin_array.get(bin_array.size() - 1).getBin_number() + 1);
        new_bin.setCapacity(capacity);
        new_bin.setRemaining(capacity - next_input);
        new_bin.setOccupancy(next_input);
        bin_array.add(new_bin);
        return new_bin;
    }

    /**
     * This method writes the information from the bins to the an output file.
     * @param myWriter A writing object.
     * @param printable_list The array list of bins that will be written.
     * @throws IOException
     */
    static void print_list(FileWriter myWriter, ArrayList<Bin> printable_list) throws IOException {
        for (Bin bin: printable_list) {
            myWriter.write(bin.toString());
        }
    }

    /**
     * This is the main method that reads in the data to the bins and calls
     * the methods above. It also writes our conclusions to the output file.
     * @param args The command line arguments given.
     * @throws FileNotFoundException
     */
    public static void main(String [] args) throws FileNotFoundException {
        int capacity = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(new File(args[1]));
        ArrayList<Integer> input_list = new ArrayList<>();
        boolean valid = true;
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input > capacity) {
                System.out.println("\nDetected value larger than capacity.\nClosing program.");
                valid = false;
            } else {
                input_list.add(input);
            }
        }
        scanner.close();
        if (valid) {
            ArrayList<Bin> first_fit_bin_array = new ArrayList<>();
            ArrayList<Bin> best_fit_bin_array = new ArrayList<>();
            ArrayList<Bin> worst_fit_bin_array = new ArrayList<>();
            for (int input: input_list) {
                firstFit(input, capacity, first_fit_bin_array);
                bestFit(input, capacity, best_fit_bin_array);
                worstFit(input, capacity, worst_fit_bin_array);
            }

            File myFile = new File("BinPackerOutput.txt");

            try {
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                } else {
                    System.out.println("File updated: " + myFile.getName());
                }
                FileWriter myWriter = new FileWriter("BinPackerOutput.txt");
                myWriter.write("\nFirst-fit");
                print_list(myWriter, first_fit_bin_array);
                myWriter.write("\nFirst-fit used " + first_fit_bin_array.size() + " bins.\n");
                myWriter.write("\nBest-fit");
                print_list(myWriter, best_fit_bin_array);
                myWriter.write("\nBest-fit used " + best_fit_bin_array.size() + " bins.\n");
                myWriter.write("\nWorst-fit");
                print_list(myWriter, worst_fit_bin_array);
                myWriter.write("\nWorst-fit used " + worst_fit_bin_array.size() + " bins.\n");
                myWriter.write("\nOn average first fit would be the fastest with a run time of O(n)."
                        + "\nWe hope best fit has a run time of about O(n lg n) because it utilizes a Binary Search Tree."
                        + "\nFinally, worst fit should be about the same run time as best fit."
                        + "\nFirst fit and best fit have many different examples that provide efficient cases."
                        + "\nWorst fit on the other hand seems almost useless and like a bad combination of "
                        + "\nfirst fit and best fit.");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("Unexpected Error.");
                e.printStackTrace();
            }
        }
    }
}
