package outLab1;

/**
 * This java class provides all the methods needed for the assignment to build and use a max heap.
 * @authors Ara Megerdichian and Riley Slater
 */


public class myMaxHeaper {

	// Fields
	private int[] myHeap;
	private int size;
	private int maxSize;

	// Constructor
	/**
	 * This constructs a max heap of a given size.
	 * @param maxSize The total size of the heap.
	 */
	public myMaxHeaper(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		myHeap = new int[this.maxSize + 1];
		myHeap[0] = Integer.MAX_VALUE;
	}

	// Methods
	/**
	 * This method returns the integers in the parent positions of the heap.
	 * @param position The index in the heap to begin looking for the parent integer.
	 * @return This method returns the parent of the position as an integer.
	 */
	private int getParent(int position) { return position / 2; }
	/**
	 * This method returns the integers in the left child positions of the heap.
	 * @param position The index in the heap to begin looking for the left child integer.
	 * @return This method returns the left child at a certain index in the heap as an integer.
	 */
	private int getLeftChild(int position) { return (2 * position); }
	/**
	 * This method returns the integers in the right child positions of the heap.
	 * @param position The index in the heap to begin looking for the right child integer.
	 * @return This method returns the right child at a certain index in the heap as an integer.
	 */
	private int getRightChild(int position) { return (2 * position) + 1; }
	/**
	 * This method makes sure the heap is properly balanced.
	 * @param position The index of the heap that were testing.
	 * @return This method returns a boolean.
	 */
	private boolean leafTest(int position) {
		if (position >= (size / 2) && position <= size) return true;
		
		return false;
	}

	/**
	 * This method swaps two integers in the heap.
	 * @param firstPosition An integer in the heap.
	 * @param secondPosition An integer in the heap.
	 */
	private void swapper(int firstPosition, int secondPosition) {
		int holder;
		holder = myHeap[firstPosition];
		myHeap[firstPosition] = myHeap[secondPosition];
		myHeap[secondPosition] = holder;
	}

	/**
	 * This method creates the max heap in sorted order.
	 * @param position The index of the heap.
	 */
	private void maxHeaper(int position) {
		if (leafTest(position)) 
			return;
			if (myHeap[position] < myHeap[getLeftChild(position)] 
				|| myHeap[position] < myHeap[getRightChild(position)]) {
				if (myHeap[getLeftChild(position)] > myHeap[getRightChild(position)]) {
					swapper(position, getLeftChild(position));
					maxHeaper(getLeftChild(position));
				} else {
					swapper(position, getRightChild(position));
					maxHeaper(getRightChild(position));
				}
			}
		}

	/**
	 * This method adds an integer to the heap then properly sorts it into order.
	 * @param item The integer being added to the heap.
	 */
	public void add(int item) {
		
		myHeap[++size] = item;
		int placement = size;
		
		while (myHeap[placement] > myHeap[getParent(placement)]) {
			swapper(placement ,getParent(placement));
			placement = getParent(placement);
		}
	}

	/**
	 * This method provides a more digestible display of the heap.
	 */
	public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT: " + myHeap[i]
                             + " LEFT CHILD: " + myHeap[2 * i]
                             + " RIGHT CHILD: " + myHeap[2 * i + 1]);
            System.out.println(); 
        }
    }

	/**
	 * This method removes the max integer or top element in the heap.
	 * @return This method returns the integer at the top of the heap.
	 */
	public int remover() {
		int removed = myHeap[1];
		myHeap[1] = myHeap[size--];
		maxHeaper(1);
		return removed;
	}

	/**
	 * This method returns the integer at the top of the heap.
	 * @return This method returns the integer at the top of the max heap.
	 */
	public int getMax() {
		return myHeap[1];
	}

	/**
	 * This method creates the heap
	 * @param position
	 * @return
	 */
	public int run_heap(int position) {
		int value;
		int right;
		int left;
		int parent = this.getParent(position);
		if(position == 0) {
			value = this.getParent(position);
		} else {
			right = this.getRightChild(position);
			left = this.getLeftChild(position);
			if(right > left) {
				value = right;
			} else {
				value = left;
			}
		}
		return value;
	}

}
