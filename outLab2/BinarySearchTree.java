package outLab2;

import java.util.ArrayList;

public class BinarySearchTree {

    public static void binarySearch(ArrayList<Integer> arr, int first, int last, int key){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr.get(mid) < key ){
                first = mid + 1;
            }else if ( arr.get(mid) == key ){
                System.out.println("Bin number: " + (mid + 1) + " contains the key.");
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
    }
}
