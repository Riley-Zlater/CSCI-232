package outLab2;

import java.util.ArrayList;

public class BinarySearchTree {

    class Node {
        Bin value;
        Node leftChild;
        Node rightChild;

        public Node(Bin element) {
            value = element;
            leftChild = null;
            rightChild = null;
        }
    }

    Node parent;

    BinarySearchTree() {
        parent = null;
    }

    Node addElement(Node parent, Bin value) {

        if (parent == null) {
            parent = new Node(value);
            return parent;
        }

        if (value.getRemaining() < parent.value.getRemaining()) {
            parent.leftChild = addElement(parent.leftChild, value);

        } else if (value.getRemaining() > parent.value.getRemaining()) {
            parent.rightChild = addElement(parent.rightChild, value);
        }
        return parent;
    }

    void add(Bin value) {
        parent = addElement(parent, value);
    }

    void traverseTree(Node parent, ArrayList<Bin> treeInOrder) {

        if (parent != null) {
            traverseTree(parent.leftChild, treeInOrder);
            treeInOrder.add(parent.value);
            traverseTree(parent.rightChild, treeInOrder);
        }
    }

    ArrayList<Bin> traverse() {
        ArrayList<Bin> treeInOrder = new ArrayList<>();
        traverseTree(parent, treeInOrder);
        return treeInOrder;
    }

	void reverseTraverseTree(ArrayList<Bin> treeInOrder, Node parent) {
		
		if (parent != null) {
			reverseTraverseTree(treeInOrder, parent.rightChild);
			treeInOrder.add(parent.value);
			reverseTraverseTree(treeInOrder, parent.leftChild);
		}
	}
	
	ArrayList<Bin> reverseTraverse() {
		ArrayList<Bin> treeInOrder = new ArrayList<>();
		reverseTraverseTree(treeInOrder, parent);
		return treeInOrder;
	}
}
