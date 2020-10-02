package outLab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinPacker {

    static Bin firstFit(int next_input, int capacity, ArrayList<Bin> bin_array) {
        Bin bin = bin_array.get(bin_array.size() - 1);
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

    public static void main(String [] args) throws FileNotFoundException {
        int capacity = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(new File(args[1]));
        ArrayList<Integer> input_list = new ArrayList<>();

        while (scanner.hasNextInt()) { 
        	if (scanner.nextInt() > capacity) {
        		System.out.println("Value encountered that is larger than bin capacity.");
        	} else {input_list.add(scanner.nextInt()); }
        }
        scanner.close();

        ArrayList<Bin> first_fit_bin_array = new ArrayList<>();
        ArrayList<Bin> best_fit_bin_array = new ArrayList<>();
        ArrayList<Bin> worst_fit_bin_array = new ArrayList<>();
        for (int input: input_list) {
            firstFit(input, capacity, first_fit_bin_array);
            bestFit(input, capacity, best_fit_bin_array);
            worstFit(input, capacity, worst_fit_bin_array);
        }
        
        File myFile = new File("Output.txt");
        
        try {
			if (myFile.createNewFile()) {
				System.out.println("File created: " + myFile.getName());
			} else { 
				System.out.println("A file with this name already exists.");
			}

			FileWriter myWriter = new FileWriter("Output.txt");
			myWriter.write("\nFirst-fit used " + first_fit_bin_array.size() + " bins. ");
			myWriter.write("\nBest-fit used " + best_fit_bin_array.size() + " bins. ");
			myWriter.write("\nWorst-fit used " + worst_fit_bin_array.size() + " bins. ");
			myWriter.write("\n On average first fit would be the fastest with a run time of O(n)."
					+ " We hope best fit has a run time of about O(nlgn) because it utilizes a Binary Search Tree."
					+ " Finally, worst fit should be about the same run time as best fit."
					+ " First fit and best fit have many different examples that provide efficient cases."
					+ " Worst fit on the other hand seems almost useless and like a bad combination of "
					+ " first fit and best fit.");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("Unexpected Error");
			e.printStackTrace();
		}
    }
}
