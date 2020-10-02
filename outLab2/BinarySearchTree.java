package outLab2;

import java.util.ArrayList;

/**
 * This class creates a binary search tree of the object bin.
 * @author Riley Slater and Ara Megerdichian
 *
 */

public class BinarySearchTree {

	/**
	 * This class creates the left and right children of the tree.
	 */
    class Node {
        Bin value;
        Node leftChild;
        Node rightChild;

        /**
         * This constructs the left and right children of the tree as a default of null.
         * @param element A bin that is set as the value.
         */
        public Node(Bin element) {
            value = element;
            leftChild = null;
            rightChild = null;
        }
    }

    Node parent;

    /**
     * This constructs a base case binary search tree.
     */
    BinarySearchTree() {
        parent = null;
    }

    /**
     * This method allows us to add to the binary search tree and recursively 
     * sort it into proper order.
     * @param parent A node that represents the current parent node.
     * @param value A bin that we're adding the the tree.
     * @return A node that holds the current bin.
     */
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

    /**
     * This method starts the recursive call of the method above.
     * @param value The bin that's being added to the tree.
     */
    void add(Bin value) {
        parent = addElement(parent, value);
    }

    /**
     * This method recursively goes through the tree starting from the left most position
     * (smallest value) and adds the data to an array list from smallest to largest.
     * @param parent The current parent node.
     * @param treeInOrder The array list that we're adding the sorted data to.
     */
    void traverseTree(Node parent, ArrayList<Bin> treeInOrder) {

        if (parent != null) {
            traverseTree(parent.leftChild, treeInOrder);
            treeInOrder.add(parent.value);
            traverseTree(parent.rightChild, treeInOrder);
        }
    }

    /**
     * This method makes the array list and starts the recursive call of the method above.
     * @return The array list treeInOrder.
     */
    ArrayList<Bin> traverse() {
        ArrayList<Bin> treeInOrder = new ArrayList<>();
        traverseTree(parent, treeInOrder);
        return treeInOrder;
    }

    /**
     * This method is the same as above only it starts at the right most child
     * (largest value) and adds the data to an array list from largest to smallest.
     * @param treeInOrder The array list the sorted data will be added to.
     * @param parent The current parent node.
     */
	void reverseTraverseTree(ArrayList<Bin> treeInOrder, Node parent) {
		
		if (parent != null) {
			reverseTraverseTree(treeInOrder, parent.rightChild);
			treeInOrder.add(parent.value);
			reverseTraverseTree(treeInOrder, parent.leftChild);
		}
	}
	
	/**
	 * This method makes the array list and starts the recursive call of the method above.
	 * @return The array list treeInOrder.
	 */
	ArrayList<Bin> reverseTraverse() {
		ArrayList<Bin> treeInOrder = new ArrayList<>();
		reverseTraverseTree(treeInOrder, parent);
		return treeInOrder;
	}
}
