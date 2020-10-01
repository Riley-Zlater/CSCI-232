package outLab2;

import java.util.ArrayList;

//import java.util.ArrayList;

//public class BinarySearchTree {
//
//    public static int binarySearch(ArrayList<Integer> arr, int first, int last, int key){
//        int mid = (first + last)/2;
//        while( first <= last ){
//            if ( arr.get(mid) < key ){
//                first = mid + 1;
//            }else if ( arr.get(mid) == key ){
//                System.out.println("Bin number: " + (mid + 1) + " contains the key.");
//                break;
//            }else{
//                last = mid - 1;
//            }
//            mid = (first + last)/2;
//        }
//        if ( first > last ){
//            System.out.println("Element is not found!");
//        }
//		return mid;
//    }
//}

public class BinarySearchTree {
	
	class Node {
		int value;
		Node leftChild;
		Node rightChild;
		
		public Node(int element) {
			value = element;
			leftChild = null;
			rightChild = null;
		}
	}
	
	Node parent;
	
	BinarySearchTree() {
		parent = null;
	}
	
	Node addElement(Node parent, int value) {
		
		if (parent == null) {
			parent = new Node(value);
			return parent;
		}
		
		if (value < parent.value) {
			parent.leftChild = addElement(parent.leftChild, value);
			
		} else if (value > parent.value) {
			parent.rightChild = addElement(parent.rightChild, value);
		}
		return parent;
	}
	
	void add(int value) {
		parent = addElement(parent, value);
	}

	
	ArrayList<Integer> traverseTree(Node parent) {
		
		ArrayList<Integer> treeInOrder = new ArrayList<>();
		
		if (parent != null) {
			traverseTree(parent.leftChild);
			treeInOrder.add(parent.value);
			traverseTree(parent.rightChild);
		}	
		return treeInOrder;
	}
	
	
	void traverse() {
		traverseTree(parent);
	}
}
