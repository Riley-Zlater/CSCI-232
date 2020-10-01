package outLab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
        BinarySearchTree bst = new BinarySearchTree();
        for (Bin bin: bin_array) {
            bst.add(bin.getCapacity());
        }
        ArrayList<Integer> current_list = bst.traverse();

        return bin_array.get(0);
    }

    public static void main(String [] args) throws FileNotFoundException {
        int capacity = 50;
        Scanner scanner = new Scanner(new File("C:/Users/Riley/eclipse-workspace/CSCI-232/src/outLab2/Test.txt"));
        ArrayList<Integer> input_list = new ArrayList<>();
        while (scanner.hasNextInt()) { input_list.add(scanner.nextInt()); }
        scanner.close();
        int[] dataArray = new int[input_list.size()];
        for (int i=0; i<input_list.size(); i++) { dataArray[i] = input_list.get(i); }
        System.out.println(Arrays.toString(dataArray));
        ArrayList<Bin> bin_array1 = new ArrayList<>();
        ArrayList<Bin> bin_array2 = new ArrayList<>();
        ArrayList<Bin> bin_array3 = new ArrayList<>();
        bin_array1.add(new Bin(0, capacity, 0));
        bin_array2.add(new Bin(0, capacity, 0));
        bin_array3.add(new Bin(0, capacity, 0));
        int counter = 0;
        for (int input: dataArray) {
            System.out.println("\n" + dataArray[counter]);
            System.out.println(firstFit(input, capacity, bin_array1));
            System.out.println("---------------");
            System.out.println(bestFit(input, capacity, bin_array2));
            counter++;
        }
        
        System.out.println();
        System.out.println(bin_array1.size() + " bins used.");
    }
}
