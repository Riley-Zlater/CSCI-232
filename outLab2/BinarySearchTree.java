package outLab2;

import java.util.ArrayList;

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

	
	void traverseTree(ArrayList<Integer> treeInOrder, Node parent) {
	
		if (parent != null) {
			traverseTree(treeInOrder, parent.leftChild);
			treeInOrder.add(parent.value);
			traverseTree(treeInOrder, parent.rightChild);
		}	
	}
	
	
	ArrayList<Integer> traverse() {
		ArrayList<Integer> treeInOrder = new ArrayList<>();
		traverseTree(treeInOrder, parent);
		return treeInOrder;
	}
}
